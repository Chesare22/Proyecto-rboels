package botones.buscar;

import java.util.HashMap;
import contenedores.Arbol;

public class TextoNombre extends TextoBuscar{
  public TextoNombre(Arbol tree, HashMap<String, Double> hash){
    super("Nombre", tree, hash);
  }

  @Override
  public Integer[] buscar(){
    return tree.search(hash.get(this.getText()));
  }
}
