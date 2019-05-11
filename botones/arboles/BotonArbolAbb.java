package botones.arboles;

import arboles.Arbol;
import arboles.abb.ArbolABB;

public class BotonArbolAbb extends BotonArbol{
  public BotonArbolAbb(){
    super("ABB");
  }

  @Override
  public Arbol crearArbol(){
    return new ArbolABB();
  }
}
