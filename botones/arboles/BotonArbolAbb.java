package botones.arboles;

import arboles.Arbol;
import arboles.abb.ArbolABB;

public class BotonArbolAbb extends BotonArbol{
  public BotonArbolAbb(){
    super("ABB");
  }

  //Falta ser implementado
  @Override
  public Arbol crearArbol(){
    return new ArbolABB();
  }
}
