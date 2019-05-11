package botones.buscar;

import javax.swing.JTextField;
import mapas.Mapa;

public class TextoBuscar extends JTextField{

  private static final int SIZE = 10;
  protected Mapa mapa;

  public TextoBuscar(Mapa mapa){
    super(SIZE);
    this.mapa = mapa;
  }
  
  /**
  *Obtiene una lista de egresados según el tipo de búsqueda.
  *@return Indices de los egresados en el archivo.
  */
  public Integer[] buscar(){
      return mapa.search(this.getText());
  }
  
  /**
   * Este método sirve para obtener el texto ingresado en el textField
   * @return el texto ingresado
   */
  public String getTextoBusqueda(){
      return this.getText();
  }
}
