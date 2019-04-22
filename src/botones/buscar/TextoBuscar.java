package botones.buscar;

import javax.swing.JTextField;
import arboles.Arbol;
import arboles.MyDatum;
import java.util.HashMap;

public abstract class TextoBuscar extends JTextField{

  private static final int SIZE = 10;
  protected Arbol tree;
  protected HashMap<String, Double> hash;
  protected double clave = 0.1;

  public TextoBuscar(String text, Arbol tree, HashMap<String, Double> hash){
    super(SIZE);
    this.tree = tree;
    this.hash = hash;
  }

  public void addDatum(String dato, int indice){
    if(hash.containsKey(dato)){
      tree.insertar(new MyDatum(hash.get(dato),indice));
    }else{
      hash.put(dato,clave);
      tree.insertar(new MyDatum(clave,indice));
      clave+=0.1;
    }
  }

  /**
  *Obtiene una lista de egresados según el tipo de búsqueda.
  *@return Indices de los egresados en el archivo.
  */
  public abstract MyDatum buscar();
}
