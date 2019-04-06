package seleccionarFiltro.arboles;

import java.util.Vector;
// Administración de eventos.
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
*Clase que maneja la selección de los BotonArbol especificados.
*/
public class GrupoBotonArbol{
  /**
  *Lista de botones.
  */
  protected Vector<BotonArbol> buttons = new Vector<BotonArbol>();

  /**
  *Añade el botón a la lista de elementos.
  *También le añade un ActionListener para que
  *no haya más de un botón selecionado.
  */
  public void add(BotonArbol button){
    button.addActionListener(new Seleccionado());
    buttons.addElement(button);
  }

  /**
  *Devuelve el botón que se encuentra seleccionado actualmente.
  */
  public BotonArbol getSelection(){
    for(BotonArbol button : buttons){
      if(button.isSelected())
        return button;
    }
    return null;
  }

  public void setSelected(int index){
    buttons.get(index).setSelected(true);
  }

  /**
  *Manejador de eventos.
  *Se debe asociar con cada BotonArbol del grupo.
  *Es el encargado de que no haya más de un botón seleccionado.
  */
  private class Seleccionado implements ActionListener{
    /**
    *Hace que solo se seleccione el botón apretado.
    *
    *@param e El botón que fue apretado.
    */
    @Override
    public void actionPerformed(ActionEvent e){
      for(BotonArbol button : buttons){
        button.setSelected(false);
      }
      ((BotonArbol)e.getSource()).setSelected(true);
    }
  }
}
