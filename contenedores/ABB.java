package contenedores;

import arboles.abb.ArbolABB;
import arboles.MyDatum;

public class ABB implements Arbol{
  private ArbolABB arbol;

  public ABB(double dato, int indice){
    arbol = new ArbolABB(dato, indice);
  }

  @Override
  public void add(double dato, int indice){
    if(arbol.contains(dato)){
      MyDatum datos = arbol.buscar(dato);
      datos.add(indice);
    }else{
      arbol.insertar(new MyDatum(dato, indice));
    }
  }

  @Override
  public Integer[] search(double dato){
    MyDatum datos = arbol.buscar(dato);
    if(datos == null){
      return new Integer[0];
    }else{
      return datos.getIndices();
    }
  }
}
