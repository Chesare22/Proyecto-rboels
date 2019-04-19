package botones.buscar;

import java.util.HashMap;
import contenedores.Arbol;

public class TextoProfesion extends TextoBuscar{
  public TextoProfesion(Arbol tree, HashMap<String, Double> hash){
    super("Profesion",tree, hash);
  }

  @Override
  public Integer[] buscar(){
    return tree.search(hash.get(this.getText()));
  }
}
