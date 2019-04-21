package mapas;

import contenedores.ContenedorOrdenado;
import arboles.Arbol;
import java.lang.NumberFormatException;

public class MapaOrdenado implements Mapa{
  protected ContenedorOrdenado contenedor;

  public MapaOrdenado(Arbol arbol){
    contenedor = new ContenedorOrdenado(arbol);
  }

  @Override
  public void add(String dato, int indice){
    try{
      contenedor.add(Double.valueOf(dato), indice);
    }catch(NumberFormatException num){}
  }


  /*
  Cuando hagamos todo el asunto de buscar por intervalos
  va a ser esta cosa la que modifiquemos
  */
  @Override
  public Integer[] search(String dato){
    try{
      return contenedor.search(Double.valueOf(dato));
    }catch(NumberFormatException num){return new Integer[0];}
  }
}
