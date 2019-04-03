package seleccionarFiltro;

import javax.swing.JCheckBox;
import representarDatos.Egresados;

public abstract class BotonBuscar extends JCheckBox{
  public BotonBuscar(String text){
    super(text);
  }
  public abstract Egresados buscar();
}
