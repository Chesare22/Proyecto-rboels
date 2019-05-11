package botones.arboles;

import arboles.Arbol;
import arboles.b.ArbolB;

public class BotonArbolB extends BotonArbol{
  public BotonArbolB(){
    super("B");
  }

  @Override
  public Arbol crearArbol(){
    return new ArbolB();
  }
}
