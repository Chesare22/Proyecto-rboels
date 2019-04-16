package contenedores;

import arboles.avl.ArbolAVL;
import arboles.abb.ArbolABB;
import arboles.MyDatum;

public class AVL implements Arbol{

  private ArbolAVL arbol = new ArbolAVL();

  public AVL(double dato,int indice){
    arbol = new ArbolAVL(new MyDatum(dato,indice));
  }

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
