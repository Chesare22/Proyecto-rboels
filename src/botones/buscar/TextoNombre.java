package botones.buscar;

import java.util.HashMap;
import arboles.Arbol;
import arboles.MyDatum;

public class TextoNombre extends TextoBuscar{
  public TextoNombre(Arbol tree, HashMap<String, Double> hash){
    super("Nombre", tree, hash);
  }

  @Override
  public MyDatum buscar(){
    return tree.buscar(hash.get(Double.valueOf(this.getText())));
            //search(hash.get(this.getText()));
  }
}
