package seleccionarFiltro;

import javax.swing.JCheckBox;

public abstract class BotonBuscar extends JCheckBox{
  public BotonBuscar(String text){
    super(text);
  }
  /**
  *Obtiene una lista de egresados según el tipo de búsqueda.
  *@return Indices de los egresados en el archivo.
  */
  public abstract int[] buscar();
}
