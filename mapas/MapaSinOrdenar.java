package mapas;

import arboles.Arbol;
import arboles.MyDatum;
import java.util.HashMap;

public class MapaSinOrdenar implements Mapa{
  private final Arbol arbol;
  private final HashMap<String,Double> hash = new HashMap<>();
  private double key = 0;

  public MapaSinOrdenar(Arbol arbol){
    this.arbol = arbol;
  }

  @Override
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

  @Override
  public Integer[] search(String dato){
    if(hash.containsKey(dato)){
        MyDatum datos = arbol.buscar(hash.get(dato));
        if(datos == null){
          return new Integer[0];
        }else{
          return datos.getIndices();
        }
    }else{
        return new Integer[0];
    }
  }
}
