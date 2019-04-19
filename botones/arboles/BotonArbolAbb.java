package botones.arboles;

import contenedores.Arbol;
import contenedores.ABB;
import java.util.HashMap;

public class BotonArbolAbb extends BotonArbol{
  public BotonArbolAbb(){
    super("ABB");
  }

  //Falta ser implementado
  @Override
  public Arbol crearArbol(String primerDato, int primerIndice){
    HashMap<String, Double> hash = new HashMap<String, Double>();
    hash.put(primerDato, 0.0);
    return new ABB(0.0,primerIndice);
  }
}
