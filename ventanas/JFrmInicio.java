/**
*Esta clase es de la ventana de Inicio
*/

package ventanas;

//Componentes de swing
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import botones.arboles.*;

//Layouts
import javax.swing.BoxLayout;

//Para darle formato y personalizar
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

public class JFrmInicio extends JFrame{

  protected JTextField cajaTexto;//Caja de texto para ingresar el nombre del archivo
  protected JButton botonAceptar;//Botón para aceptar
  protected JButton botonCancelar;//Botón para cancelar
  protected GrupoBotonArbol botonesArbol = new GrupoBotonArbol();//Grupo de radioButtons de los árboles

  /**
  *Inicializamos los componentes básicos de la ventana
  *y llamamos al método para inicializar los componentes
  */
  public JFrmInicio(){
    setSize(500, 200);
    setLocationRelativeTo(null);
    Font fuente = new Font("Ebrima", 3, 20);
    setFont(fuente);
    setTitle("Ingresar Archivo");

    initComponents();
  }

  /**
  *Método para iniciar los componentes
  *(botones, caja de texto, etc)
  */
  public void initComponents(){

    //Componentes del primer contenedor
    cajaTexto = new JTextField(20);
    botonAceptar = new JButton("Aceptar");
    botonCancelar = new JButton("Cancelar");

    //personalización de los botones
    botonAceptar.setForeground(Color.WHITE);
    botonAceptar.setBackground(new Color(53,153,0));
    botonCancelar.setForeground(Color.WHITE);
    botonCancelar.setBackground(new Color(204,0,0));

    //Botones de los arboles
    BotonArbolAbb botonABB = new BotonArbolAbb();
    BotonArbolAvl botonAVL = new BotonArbolAvl();
    BotonArbolB botonB = new BotonArbolB();

    //Añadimos los botones al grupo
    botonesArbol.add(botonABB);
    botonesArbol.add(botonAVL);
    botonesArbol.add(botonB);

    //Añadimos los botones a un panel
    JPanel botonesArbolPanel = new JPanel();
    botonesArbolPanel.add(botonABB);
    botonesArbolPanel.add(botonAVL);
    botonesArbolPanel.add(botonB);

    //Añadimos la caja de texto con su etiqueta a un panel
    JPanel archivoPanel = new JPanel();
    archivoPanel.add(new JLabel("Archivo:"));
    archivoPanel.add(cajaTexto);

    //ponemos que por default uno de los radioButtons esté seleccionado
    botonesArbol.setSelected(0);

    //Usamos un panel con espacios en blanco sólo para darle formato a la ventana
    JPanel espaciosBlancos = new JPanel();
    espaciosBlancos.setLayout(new BoxLayout(espaciosBlancos, BoxLayout.Y_AXIS));
    espaciosBlancos.add(new JLabel (" "));
    espaciosBlancos.add(new JLabel (" "));

    //Añadimos los botones a un panel
    JPanel botones = new JPanel();
    botones.add(botonAceptar);
    botones.add(new JLabel("         "));
    botones.add(botonCancelar);

    //Panel Principal que contiene a los demás paneles
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    //Le meto espacios en blanco
    panel.add(espaciosBlancos);
    panel.add(archivoPanel);
    panel.add(botonesArbolPanel);
    panel.add(botones);

    add(panel);
  }

  /**
  *Método main para inicializar la ventana
  */
  public static void main(String[] args) {

      JFrmInicio frameInicio = new JFrmInicio();

      frameInicio.setVisible(true);
      frameInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

}//Fin de la clase main
