package ventanas;

import seleccionarFiltro.*;

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

  private GrupoBotonAgrupar botonesAgruparLogicos = new GrupoBotonAgrupar();
  private GrupoBotonBuscar botonesBusqueda = new GrupoBotonBuscar();
  private JButton botonBuscar = new JButton("Buscar");
  private JButton botonCambiarArchivo = new JButton("Cambiar Archivo");
  private JButton botonModificar = new JButton("Modificar");

  public JFrmBusqueda(){
    setSize(600, 250);
    setLocationRelativeTo(null);
    Font fuente = new Font("Ebrima", 3, 20);
    setFont(fuente);
    setTitle("Seleccionar Busqueda");

    initComponents();
  }

  public void initComponents(){

    //Declaracion de los botones de bsuqueda
    BotonNombre bNombre = new BotonNombre();
    BotonPromedio bPromedio = new BotonPromedio();
    BotonProfesion bProfesion = new BotonProfesion();

    //Declaración de los botones para agrupar con operadores lógicos
    BotonOR bOR = new BotonOR();
    BotonAND bAND = new BotonAND();

    //Agrupar los botones
    botonesBusqueda.add(bNombre);
    botonesBusqueda.add(bPromedio);
    botonesBusqueda.add(bProfesion);

    botonesAgruparLogicos.add(bOR);
    botonesAgruparLogicos.add(bAND);

    //Poner los botones en un JPanel
    JPanel panelBotonesBuscar = new JPanel();
    panelBotonesBuscar.add(new JLabel("Seleccione los campos que quiere encontrar:  "));
    panelBotonesBuscar.add(bNombre);
    panelBotonesBuscar.add(bPromedio);
    panelBotonesBuscar.add(bProfesion);

    JPanel panelBotonesAgrupar = new JPanel();
    panelBotonesAgrupar.add(new JLabel("Seleccione un metodo de agrupamiento:  "));
    panelBotonesAgrupar.add(bOR);
    panelBotonesAgrupar.add(bAND);

    //Poner los paneles en el panel principal
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.add(new JLabel(" "));
    panel.add(panelBotonesBuscar);
    panel.add(panelBotonesAgrupar);

    /**
    Seccion para añadir los botones
    */
      JPanel panelBBuscar = new JPanel();
      panelBBuscar.add(botonBuscar);
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
