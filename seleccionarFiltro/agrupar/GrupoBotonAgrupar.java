package seleccionarFiltro.agrupar;

import java.util.Vector;
// Administración de eventos.
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
*Clase que maneja la selección de los BotonAgrupar especificados.
*/
public class GrupoBotonAgrupar{
  /**
  *Lista de botones.
  */
  protected Vector<BotonAgrupar> buttons = new Vector<BotonAgrupar>();

  /**
  *Añade el botón a la lista de elementos.
  *También le añade un ActionListener para que
  *no haya más de un botón selecionado.
  */
  public void add(BotonAgrupar button){
    button.addActionListener(new Seleccionado());
    buttons.addElement(button);
  }

  /**
  *Devuelve el botón que se encuentra seleccionado actualmente.
  */
  public BotonAgrupar getSelection(){
    for(BotonAgrupar button : buttons){
      if(button.isSelected())
        return button;
    }
    return null;
  }

  /**
  *Manejador de eventos.
  *Se debe asociar con cada BotonAgrupar del grupo.
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
      for(BotonAgrupar button : buttons){
        button.setSelected(false);
      }
      ((BotonAgrupar)e.getSource()).setSelected(true);
    }
  }
}
