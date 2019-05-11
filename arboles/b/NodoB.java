/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.b;

import arboles.MyDatum;
import java.util.LinkedList;

/**
 *
 * @author César UwU
 */
public class NodoB {
    private LinkedList<MyDatum> claves = new LinkedList<>();
    private LinkedList<NodoB> ramas = new LinkedList<>();
    private NodoB padre;
    
    public NodoB(NodoB padre){
        setPadre(padre);
    }
    
    public NodoB(){
        padre = null;
    }
    
    public int size(){return claves.size();}
    
    public NodoB getPadre(){return padre;}
    
    public void setPadre(NodoB padre){this.padre = padre;}
    
    public void addRama(NodoB rama){ramas.add(rama);}
    
    public void setRamas(LinkedList<NodoB> ramas){this.ramas = ramas;}
    
    public double[] getClaves(){
        double[] datos = new double[claves.size()];
        for(int i = 0;i<datos.length;i++){
            datos[i] = claves.get(i).getClave();
        }
        return datos;
    }
    
    public void setClaves(LinkedList<MyDatum> claves){this.claves = claves;}
    
    public MyDatum datumAt(int index){return claves.get(index);}
    
    public boolean isEmpty(){return claves.isEmpty();}
    
    public boolean esHoja(){return ramas.isEmpty();}
    
    public NodoB ramaByIndex(int index){return ramas.get(index);}
    
    public void addAt(MyDatum dato, int index){claves.add(index, dato);}
    
    public void add(MyDatum dato){claves.add(dato);}
    
    public double primerDato(){return claves.getFirst().getClave();}
    
    //Este método solo se aplica si no tiene hijos
    public void insertaOrdenado(MyDatum dato){
        boolean anadir = true;
        for(int i = 0;i<claves.size();i++){
            if(dato.getClave()<claves.get(i).getClave()){
                claves.add(i, dato);
                anadir = false;
                break;
            }
        }
        if(anadir)
            claves.addLast(dato);
    }
    
    //Devuelve el padre actualizado
    //Lo que hace es dividir sus datos en 2 y mandarle uno al padre
    public NodoB separar(int tamanoNuevosNodos){
        //Primero dividimos el nodo en 3 partes:
        // · 2 Nodos de igual tamaño
        // · El dato que está entre esos nodos
        NodoB menor = new NodoB(padre), mayor = new NodoB(padre);
        for(int i =0;i<tamanoNuevosNodos;i++){
            menor.add(claves.removeFirst());
        }
        MyDatum datoIntermedio = claves.removeFirst();
        while(!claves.isEmpty()){
            mayor.add(claves.removeFirst());
        }
        if(!esHoja()){
            //Si no es hoja, también le pongo las ramas a los nuevos nodos
            for(int i = 0;i<=tamanoNuevosNodos;i++){
                menor.addRama(ramas.removeFirst());
            }
            while(!ramas.isEmpty()){
                mayor.addRama(ramas.removeFirst());
        }
        }
        if(padre.isEmpty()){
            //En caso de que sea el nodo raíz, se crea un nuevo nodo raíz
            this.nuevaRaiz(menor, mayor, datoIntermedio);
        }else{
            padre.addSubArbol(menor, mayor, datoIntermedio, this);
        }
        return padre;
    }
    
    private void nuevaRaiz(NodoB menor,NodoB mayor, MyDatum dato){
        claves.add(dato);
        ramas.add(menor);
        ramas.add(mayor);
    }

    private void addSubArbol(NodoB menor, NodoB mayor, MyDatum datoIntermedio, NodoB nodoViejo) {
        int posicionViejo = ramas.indexOf(nodoViejo);
        ramas.remove(posicionViejo);
        ramas.add(posicionViejo, mayor);
        ramas.add(posicionViejo, menor);
        claves.add(posicionViejo,datoIntermedio);
    }
}
