package contenedores;

import arboles.Arbol;
import arboles.MyDatum;
import java.util.HashMap;

public class ContenedorSinOrdenar{
  private Arbol arbol;
  private HashMap<String,Double> hash = new HashMap<String,Double>();
  private double key = 0;

  public ContenedorSinOrdenar(Arbol arbol){
    this.arbol = arbol;
  }

  public void add(String dato, int indice){
    if(hash.containsKey(dato)){
      MyDatum datos = arbol.buscar(hash.get(dato));
      datos.add(indice);
    }else{
      key+=0.1;
      hash.put(dato, key);
      arbol.insertar(new MyDatum(key, indice));
    }
  }

  public Integer[] search(String dato){
    MyDatum datos = arbol.buscar(hash.get(dato));
    if(datos == null){
      return new Integer[0];
    }else{
      return datos.getIndices();
    }
  }

}
