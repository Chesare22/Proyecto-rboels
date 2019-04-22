/**
*Esta interface sirve para ser implementada en las demás estructuras y poder
*aplicar los métodos de inserción y búsqueda de acuerdo al árbol seleccionado
*/

package contenedores;

import arboles.Arbol;
import arboles.MyDatum;

public class ContenedorOrdenado{
  private Arbol arbol;

  public ContenedorOrdenado(Arbol arbol){
    this.arbol = arbol;
  }

  public void add(double dato, int indice){
    if(arbol.contains(dato)){
      MyDatum datos = arbol.buscar(dato);
      datos.add(indice);
    }else{
      arbol.insertar(new MyDatum(dato, indice));
    }
  }
  public Integer[] search(double dato){
    MyDatum datos = arbol.buscar(dato);
    if(datos == null){
      return new Integer[0];
    }else{
      return datos.getIndices();
    }
  }
}
