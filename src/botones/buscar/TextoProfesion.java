package botones.buscar;

import java.util.HashMap;
import arboles.Arbol;
import arboles.MyDatum;

public class TextoProfesion extends TextoBuscar{
  public TextoProfesion(Arbol tree, HashMap<String, Double> hash){
    super("Profesion",tree, hash);
  }

  @Override
  public MyDatum buscar(){
    return tree.buscar(hash.get(Double.valueOf(this.getText())));
           // search(hash.get(this.getText()));
  }
}
