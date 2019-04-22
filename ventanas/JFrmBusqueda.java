/**
*Esta es la clase de la ventana en donde se especifican
*los detalles para realizar la búsqueda de los datos
*/

package ventanas;

import arboles.avl.ArbolAVL;
import botones.buscar.*;
import java.util.HashMap;

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
import java.util.Random;
//actionPerformed
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//import arboles.AVL;

//Para las transiciones
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import mapas.Mapa;
import mapas.MapaOrdenado;
import mapas.MapaSinOrdenar;


public class JFrmBusqueda extends JFrame{

  private final GrupoTextoBuscar textosBusqueda = new GrupoTextoBuscar();//Grupo de cajas para buscar
  private final JButton botonBuscar = new JButton("Buscar");//Botón para Buscar
  private final JButton botonCambiarArchivo = new JButton("Cambiar Archivo");//Botón para regresar y cambiar de archivo
  private final JButton botonModificar = new JButton("Modificar");//Botón para modificar los datos

  /**
  *Constructor de la clase que llama al método para iniciar los componentes
  */
  public JFrmBusqueda(Mapa tNombre, Mapa tPromedio, Mapa tProfesion){

    setSize(600, 250);
    setLocationRelativeTo(null);
    setTitle("Seleccionar Busqueda");

    initComponents(new TextoBuscar(tNombre), new TextoBuscar(tPromedio), new TextoBuscar(tProfesion));
  }

  /**
  *Método que inicia los componentes
  */
  public void initComponents(TextoBuscar tNombre, TextoBuscar tPromedio, TextoBuscar tProfesion){

    botonCambiarArchivo.addMouseListener(new Transicion());

    //Declaracion de los botones de bsuqueda
    tNombre.addActionListener(new Probar());
    tProfesion.addActionListener(new Probar());
    tPromedio.addActionListener(new Probar());


    //Agrupar los botones
    textosBusqueda.add(tNombre);
    textosBusqueda.add(tPromedio);
    textosBusqueda.add(tProfesion);

    //JPanel de la etiqueta que dice "Buscar: "
    JPanel etiquetaBuscar = new JPanel();
    JLabel eBuscar = new JLabel("Buscar: ");
    eBuscar.setFont(new Font("Verdana", 1, 22));
    etiquetaBuscar.add(eBuscar);

    //Poner los botones en un JPanel
    JPanel panelBotonesBuscar = new JPanel();
    panelBotonesBuscar.add(new JLabel("Nombre:"));
    panelBotonesBuscar.add(tNombre);
    panelBotonesBuscar.add(new JLabel("  Promedio:"));
    panelBotonesBuscar.add(tPromedio);
    panelBotonesBuscar.add(new JLabel("  Profesion:"));
    panelBotonesBuscar.add(tProfesion);

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
  * @param args
  */
  public static void main(String[] args) {
  
    JFrmBusqueda ventanaBusqueda = new JFrmBusqueda(new MapaSinOrdenar(new ArbolAVL()), new MapaOrdenado(new ArbolAVL()), new MapaSinOrdenar(new ArbolAVL()));

    ventanaBusqueda.setVisible(true);
    ventanaBusqueda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }



  private void imprimirDatos(TextoBuscar text){
    for(Integer i : text.buscar()){
      System.out.print(i + " || ");
    }
    System.out.println("");
  }

  private class Probar implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      TextoBuscar text = (TextoBuscar) e.getSource();
      imprimirDatos(text);
    }
  }

  private class Transicion implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e){
      JFrmInicio frameInicio = new JFrmInicio();

      dispose();
      frameInicio.setVisible(true);
      frameInicio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}

    @Override
    public void mousePressed(MouseEvent e){}

    @Override
    public void mouseReleased(MouseEvent e){}

  }

}
