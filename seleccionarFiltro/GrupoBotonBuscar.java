package seleccionarFiltro;

import java.util.Vector;

public class GrupoBotonBuscar{
  /**
  *Lista de botones.
  */
  protected Vector<BotonBuscar> buttons = new Vector<BotonBuscar>();

  public void add(BotonBuscar button){
    buttons.addElement(button);
  }

  public BotonBuscar[] getSelected(){
    Vector<BotonBuscar> seleccionados = new Vector<BotonBuscar>();
    for(BotonBuscar boton : buttons){
      if(boton.isSelected())
        seleccionados.add(boton);
    }
    return seleccionados.toArray(new BotonBuscar[0]);
  }
}
