/**
*Esta clase implementa la interface Arbol para poder manipular los datos
*y sirve para obtener y devolver arreglos o datos en general
*/

package contenedores;

import arboles.avl.ArbolAVL;
import arboles.abb.ArbolABB;
import arboles.MyDatum;

public class ContenedorAVL implements ContenedorOrdenado{

  private ArbolAVL arbol = new ArbolAVL();//Variable de tipo Arbol AVL con la que se manipularán los datos

  /**
  *Constructor de la clase
  *@param dato Es el valor (en double) de la cadena que se encontró en el archivo
  *@param indice Es el renglón en el que se encuentra el dato en el archivo
  */
  public ContenedorAVL(double dato,int indice){
    arbol = new ArbolAVL(new MyDatum(dato,indice));
  }

  /**
  *Método de la interface que añade el índice del dato especificado
  *Si el dato está repetido, se le agrega el índice del elemento repetido
  *@param dato valor de la cadena ingresada al árbol
  *@param indice renglón del archivo en el que se encuentra el dato
  */
  @Override
  public void add(double dato, int indice){
    ArbolABB arbolito = arbol.toABB();
    if(arbolito.contains(dato)){
      MyDatum datos = arbolito.buscar(dato);
      datos.add(indice);
    }else{
      arbolito.insertar(new MyDatum(dato,indice));
    }
  }

  /**
  *Método de la interface que busca y devuelve datos
  *@return arreglo con los índices en el archivo especificado
  */
  @Override
  public Integer[] search(double dato){
    ArbolABB arbolito = arbol.toABB();
    MyDatum datos = arbolito.buscar(dato);
    if(datos == null){
      return new Integer[0];
    }else{
      return datos.getIndices();
    }
  }
}
