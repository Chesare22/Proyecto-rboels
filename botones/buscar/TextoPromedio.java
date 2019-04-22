package botones.buscar;

import java.util.HashMap;
import java.lang.NumberFormatException;
import arboles.Arbol;

public class TextoPromedio extends TextoBuscar{
  public TextoPromedio(Arbol tree){
    super("Promedio", tree, new HashMap<String, Double>());
  }

  @Override
  public Integer[] buscar(){
    return tree.search(Double.valueOf(this.getText()));
  }

  @Override
  public void addDatum(String dato, int indice){
    try{
      tree.add(Double.valueOf(dato),indice);
    }catch(NumberFormatException num){}
  }
}
