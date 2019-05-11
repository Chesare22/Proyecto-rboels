package botones.arboles;

import arboles.Arbol;
import arboles.avl.ArbolAVL;

public class BotonArbolAvl extends BotonArbol{
  public BotonArbolAvl(){
    super("AVL");
  }

  @Override
  public Arbol crearArbol(){
    return new ArbolAVL();
  }
}
