package seleccionarFiltro;

import javax.swing.JRadioButton;
import representarDatos.Egresados;

public abstract class BotonAgrupar extends JRadioButton{
  public BotonAgrupar(String text){
    super(text);
  }
  public abstract Egresados agrupar(Egresados[] e);
}
