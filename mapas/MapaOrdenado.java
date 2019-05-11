package mapas;

import arboles.Arbol;
import arboles.MyDatum;

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
  
  
  
  private class ContenedorOrdenado{
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
}
