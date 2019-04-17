/**
*Esta es la clase de la ventana en donde se especifican
*los detalles para realizar la búsqueda de los datos
*/

package ventanas;

import botones.buscar.*;

//Componentes de swing
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

//Layouts
import javax.swing.BoxLayout;

//Para dar formato y personalizar
import java.awt.Font;
import java.awt.Color;


public class JFrmBusqueda extends JFrame{

  private GrupoTextoBuscar textosBusqueda = new GrupoTextoBuscar();//Grupo de cajas para buscar
  private JButton botonBuscar = new JButton("Buscar");//Botón para Buscar
  private JButton botonCambiarArchivo = new JButton("Cambiar Archivo");//Botón para regresar y cambiar de archivo
  private JButton botonModificar = new JButton("Modificar");//Botón para modificar los datos

  /**
  *Constructor de la clase que llama al método para iniciar los componentes
  */
  public JFrmBusqueda(){
    
    setSize(600, 250);
    setLocationRelativeTo(null);
    setTitle("Seleccionar Busqueda");

    initComponents();
  }

  /**
  *Método que inicia los componentes
  */
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

    //colocamos los paneles en el panel PRINCIPAL
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.add(new JLabel(" "));
    panel.add(new JLabel(" "));
    panel.add(etiquetaBuscar);
    panel.add(panelBotonesBuscar);

    /**
    *Sección para personalizar y añadir los botones
    */
    botonBuscar.setForeground(Color.WHITE);
    botonBuscar.setBackground(new Color(53,153,0));
    botonCambiarArchivo.setForeground(Color.WHITE);
    botonCambiarArchivo.setBackground(new Color(204,0,0));
    botonModificar.setForeground(Color.WHITE);
    botonModificar.setBackground(new Color(0,51,153));

    //Añadimos los botones a un Panel
    JPanel panelBBuscar = new JPanel();
    panelBBuscar.add(botonBuscar);
    panelBBuscar.add(new JLabel("      "));
    panelBBuscar.add(botonCambiarArchivo);
    panelBBuscar.add(new JLabel("      "));
    panelBBuscar.add(botonModificar);

    //Añadimos el panel de botones al panel principal
    panel.add(panelBBuscar);

    //Añadimos el panel principal a la ventana
    add(panel);
  }

  /**
  *Método main para ejecutar la ventana
  */
  public static void main(String[] args) {

    JFrmBusqueda ventanaBusqueda = new JFrmBusqueda();

    ventanaBusqueda.setVisible(true);
    ventanaBusqueda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }


}
