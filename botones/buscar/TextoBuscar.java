package botones.buscar;

import javax.swing.JTextField;

public abstract class TextoBuscar extends JTextField{

  private static final int SIZE = 10;

  public TextoBuscar(String text){
    super(SIZE);
  }
  /**
  *Obtiene una lista de egresados según el tipo de búsqueda.
  *@return Indices de los egresados en el archivo.
  */
  public abstract int[] buscar();
}
