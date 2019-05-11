package botones.buscar;

import java.util.Vector;

public class GrupoTextoBuscar{
  /**
  *Lista de botones.
  */
  protected Vector<TextoBuscar> buttons = new Vector<>();

  /**
   * Método que añade cajas de texto
   * @param button La caja de texto
   */
  public void add(TextoBuscar button){
    buttons.addElement(button);
  }

  /**
   * Método para obtener cuáles son los TextFields seleccionados
   * @return Los campos que fueron seleccionados
   */
  public TextoBuscar[] getSelected(){
    Vector<TextoBuscar> seleccionados = new Vector<>();
    for(TextoBuscar boton : buttons){
      if(boton.getText().isEmpty() == false)
        seleccionados.add(boton);
    }
    return seleccionados.toArray(new TextoBuscar[0]);
  }
}
