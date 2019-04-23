package botones.agrupar;

import javax.swing.JRadioButton;

public abstract class BotonAgrupar extends JRadioButton{
  public BotonAgrupar(String text){
    super(text);
  }
  /**
  *Agrupa los datos según el operador lógico seleccionado
  *@param datos Datos a agrupar.
  *@return Indices de los egresados.
  */
  public abstract Integer[] agrupar(Integer[][] datos);
}
