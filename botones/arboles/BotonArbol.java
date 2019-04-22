package botones.arboles;

import javax.swing.JRadioButton;
import arboles.Arbol;

public abstract class BotonArbol extends JRadioButton{

  public BotonArbol(String text){
    super(text);
  }
  /**
  *Agrupa los datos según el operador lógico seleccionado
  *@param datos Datos a agrupar.
  *@return Indices de los egresados.
  */
  public abstract Arbol crearArbol();
}
