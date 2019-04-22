package botones.arboles;

import arboles.Arbol;
import arboles.avl.ArbolAVL;

public class BotonArbolB extends BotonArbol{
  public BotonArbolB(){
    super("B");
  }

  //Falta ser implementado
  @Override
  public Arbol crearArbol(){
    return new ArbolAVL();
  }
}
