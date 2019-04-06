package ventanas;

import seleccionarFiltro.buscar.*;

//Componentes de swing
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

//Layouts
import javax.swing.BoxLayout;

//Dadores de forma
import java.awt.Font;


public class JFrmBusqueda extends JFrame{

  private GrupoTextoBuscar textosBusqueda = new GrupoTextoBuscar();
  private JButton TextoBuscar = new JButton("Buscar");
  private JButton botonCambiarArchivo = new JButton("Cambiar Archivo");
  private JButton botonModificar = new JButton("Modificar");

  public JFrmBusqueda(){
    setSize(600, 250);
    setLocationRelativeTo(null);
    setTitle("Seleccionar Busqueda");

    initComponents();
  }

  public void initComponents(){

    //Declaracion de los botones de bsuqueda
    TextoNombre bNombre = new TextoNombre();
    TextoPromedio bPromedio = new TextoPromedio();
    TextoProfesion bProfesion = new TextoProfesion();

    //Agrupar los botones
    textosBusqueda.add(bNombre);
    textosBusqueda.add(bPromedio);
    textosBusqueda.add(bProfesion);

    //JPanel de la etiqueta que dice "Buscar: "
    JPanel etiquetaBuscar = new JPanel();
    JLabel eBuscar = new JLabel("Buscar: ");
    eBuscar.setFont(new Font("Verdana", 1, 22));
    etiquetaBuscar.add(eBuscar);

    //Poner los botones en un JPanel
    JPanel panelBotonesBuscar = new JPanel();
    panelBotonesBuscar.add(new JLabel("Nombre:"));
    panelBotonesBuscar.add(bNombre);
    panelBotonesBuscar.add(new JLabel("  Promedio:"));
    panelBotonesBuscar.add(bPromedio);
    panelBotonesBuscar.add(new JLabel("  Profesion:"));
    panelBotonesBuscar.add(bProfesion);

    //Poner los paneles en el panel principal
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.add(new JLabel(" "));
    panel.add(new JLabel(" "));
    panel.add(etiquetaBuscar);
    panel.add(panelBotonesBuscar);

    /**
    Seccion para añadir los botones
    */
      JPanel panelBBuscar = new JPanel();
      panelBBuscar.add(TextoBuscar);
      panelBBuscar.add(new JLabel("      "));
      panelBBuscar.add(botonCambiarArchivo);
      panelBBuscar.add(new JLabel("      "));
      panelBBuscar.add(botonModificar);

      panel.add(panelBBuscar);



    add(panel);
  }


public static void main(String[] args) {
  JFrmBusqueda ventanaBusqueda = new JFrmBusqueda();
  ventanaBusqueda.setVisible(true);

  ventanaBusqueda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}


}
