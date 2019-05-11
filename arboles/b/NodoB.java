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
    
    public double[] getClaves(){
        double[] datos = new double[claves.size()];
        for(int i = 0;i<datos.length;i++){
            datos[i] = claves.get(i).getClave();
        }
        return datos;
    }
    
    public boolean isEmpty(){return claves.isEmpty();}
    
    public boolean esHoja(){return ramas.isEmpty();}
    
    public NodoB ramaByIndex(int index){return ramas.get(index);}
}
