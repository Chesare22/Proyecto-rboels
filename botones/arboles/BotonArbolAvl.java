package botones.arboles;

import contenedores.Arbol;
import contenedores.AVL;
import java.util.HashMap;

public class BotonArbolAvl extends BotonArbol{
  public BotonArbolAvl(){
    super("AVL");
  }

  //Falta ser implementado
  @Override
  public Arbol crearArbol(String primerDato, int primerIndice){
    HashMap<String, Double> hash = new HashMap<String, Double>();
    hash.put(primerDato, 0.0);
    return new AVL(0.0,primerIndice);
  }
}
