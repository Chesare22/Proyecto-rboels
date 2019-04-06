package seleccionarFiltro.arboles;

import javax.swing.JRadioButton;

public abstract class BotonArbol extends JRadioButton{
  public BotonArbol(String text){
    super(text);
  }
  /**
  *Agrupa los datos según el operador lógico seleccionado
  *@param datos Datos a agrupar.
  *@return Indices de los egresados.
  */
  public abstract void crearArbol();
}