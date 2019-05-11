/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.b;

import arboles.Arbol;
import arboles.MyDatum;
import java.io.IOException;

/**
 *
 * @author César UwU
 */
public class ArbolB implements Arbol{
    //El padre de la raíz siempre va a ser nulo.
    private final NodoB raiz = new NodoB();
    private final int nivel;
    
    public ArbolB(int nivel){
        this.nivel = nivel;
    }
    
    public ArbolB(){
        this(10);
    }
    
    //Esto no devuelve el nodo en el que está, sino el que debería de tenerlo
    //Si el dato existe, devuelve una excepción
    //Siempre va a devolver un nodo hoja
    private NodoB searchNodo(double dato) throws IOException{
      return searchNodo(dato, raiz);
    }
    
    private NodoB searchNodo(double dato, NodoB nodo) throws IOException{
    if(nodo.esHoja()){
      return nodo;
    }else{
      double[] claves = nodo.getClaves();
      for(int i = 0;i<claves.length;i++){
        if(claves[i] == dato){
          throw new IOException("Dato repetido");
        }else{
          if(claves[i]<dato){
            return nodo.ramaByIndex(i);
          }
        }
      }
      return nodo.ramaByIndex(claves.length);
    }
  }
    
    @Override
    public boolean contains(double dato){
        try{
            searchNodo(dato);
            return false;
        }catch(IOException io){
            return true;
        }
    }
    
    @Override
    public MyDatum buscar(double dato){
        return searchDatum(dato, raiz);
    }
    
    
    private MyDatum searchDatum(double dato, NodoB nodo){
        double[] claves = nodo.getClaves();
        for(int i = 0;i<claves.length;i++){
            if(claves[i] == dato){
                return nodo.datumAt(i);
            }else if(dato<claves[i]){
                return searchDatum(dato,nodo.ramaByIndex(i));
            }
        }
        return searchDatum(dato, nodo.ramaByIndex(claves.length));
    }
    
    @Override
    public void insertar(MyDatum dato){
        try{
            NodoB nodoInserta = searchNodo(dato.getClave());
            insertar(dato,nodoInserta);
        }catch(IOException io){
            MyDatum existente = buscar(dato.getClave());
            existente.add(dato.getIndices()[0]);
        }
    }
    
    private void insertar(MyDatum dato, NodoB nodo){
        //Primero se añade y luego se parte
        nodo.insertaOrdenado(dato);
        
        while(nodo.size()>nivel){
            nodo = nodo.separar(nivel/2);
        }
    }
}
