package botones.buscar;

import java.util.Vector;

public class GrupoTextoBuscar{
  /**
  *Lista de botones.
  */
  protected Vector<TextoBuscar> buttons = new Vector<TextoBuscar>();

  public void add(TextoBuscar button){
    buttons.addElement(button);
  }

  public TextoBuscar[] getSelected(){
    Vector<TextoBuscar> seleccionados = new Vector<TextoBuscar>();
    for(TextoBuscar boton : buttons){
      if(boton.getText().isEmpty() == false)
        seleccionados.add(boton);
    }
    return seleccionados.toArray(new TextoBuscar[0]);
  }
}
