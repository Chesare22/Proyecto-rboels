/**
*
*Esta clase crea un nuevo tipo de dato <MyDatum>
*con el cual podemos manipular con mayor facilidad
*los datos que se desean encontrar de los que ya han
*sido recuperados de los archivos.
*
*/

package arboles;

import java.util.Vector;

public class MyDatum implements Comparable{
  private final double clave;
  private Vector<Integer> indices = new Vector<>();

  /**
  *Constructor de la clase
  *@param clave es el valor que tiene la cadena encontrada
  *@param primerIndice cuando se encuentra 1 dato por primera vez, se añade el
  *índice que tiene en el archivo al arreglo que almacena los índices de todos
  *los resultados que coinciden con la búsqueda
  */
  public MyDatum(double clave, Integer primerIndice){
    this.clave = clave;
    indices.add(primerIndice);
  }

  /**
  *Este método añade los índices al Vector de índices
  * @param indice Es el valor que representa la ubicación de la cadena
  *en el archivo de entrada
  */
  public void add(Integer indice){
    indices.add(indice);
  }

  /**
  *@return arreglo con todos los índices de las coincidencias
  *de la búsqueda
  */
  public Integer[] getIndices(){
    return indices.toArray(new Integer[0]);
  }

  public double getClave(){return clave;}

  /**
  *Este método que extiende de la clase Comparable sirve para comparar
  *y ordenar los datos de mayor a menor
  *@return 1, -1, 0 , de acuerdo a si es menor, mayor o igual
  */
  @Override
  public int compareTo(Object ob){
    MyDatum d = (MyDatum) ob;
    if(clave<d.getClave()){
      return 1;
    }else if(clave>d.getClave()){
      return -1;
    }else{
      return 0;
    }
  }
}
