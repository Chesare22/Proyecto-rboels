/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.b;

import arboles.Arbol;
import java.io.IOException;

/**
 *
 * @author César UwU
 */
public class ArbolB implements Arbol{
    private NodoB raiz = new NodoB();
    private final int nivel;
    
    public ArbolB(int nivel){
        this.nivel = nivel;
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
}
