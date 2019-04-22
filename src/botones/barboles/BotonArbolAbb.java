package botones.barboles;

import java.util.HashMap;
import arboles.Arbol;
import arboles.abb.ArbolABB;

public class BotonArbolAbb extends BotonArbol{
  public BotonArbolAbb(){
    super("ABB");
  }

  //Falta ser implementado
  @Override
  public Arbol crearArbol(String primerDato, int primerIndice){
    HashMap<String, Double> hash = new HashMap<>();
    hash.put(primerDato, 0.0);
    return new ArbolABB(0.0,primerIndice);
  }
}
