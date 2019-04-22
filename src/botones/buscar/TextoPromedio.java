package botones.buscar;

import java.util.HashMap;
import java.lang.NumberFormatException;
import arboles.Arbol;
import arboles.MyDatum;

public class TextoPromedio extends TextoBuscar{
  
  public TextoPromedio(Arbol tree){
    super("Promedio", tree, new HashMap<String, Double>());
  }

  @Override
  public MyDatum buscar(){
    return tree.buscar(Double.valueOf(this.getText()));
            //search(Double.valueOf(this.getText()));
  }

  @Override
  public void addDatum(String dato, int indice){
    try{
      tree.insertar(new MyDatum(Double.valueOf(dato),indice));
              //add(Double.valueOf(dato),indice);
    }catch(NumberFormatException num){}
  }
}
