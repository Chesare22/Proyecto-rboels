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

import botones.barboles.*;

//Layouts
import javax.swing.BoxLayout;

//Para darle formato y personalizar
import java.awt.Font;
import java.awt.Color;

//Para hacer la transición entre ventanas
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import botones.buscar.*;

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

    botonAceptar.addMouseListener(new Transicion());

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

  private class Transicion implements MouseListener{

    private TextoNombre tNombre;
    private TextoPromedio tPromedio;
    private TextoProfesion tProfesion;

    @Override
    public void mouseClicked(MouseEvent e){
      /*
      Lo que debería hacer es leer el archivo, y si tiene el formato válido, crea
      las instancias de los botones para la ventana principal.
      Posteriormente se llenan esas instancias con datos del archivo.
      */

      //Para propósitos de prueba: Vamos a llenar los árboles con valores predefinidos.
      iniciarJTexts();
      meterDatos();



      dispose();
      JFrmBusqueda ventanaBusqueda = new JFrmBusqueda(tNombre, tPromedio, tProfesion);
      ventanaBusqueda.setVisible(true);
      ventanaBusqueda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void iniciarJTexts(){
      BotonArbol ar = botonesArbol.getSelection();

      tNombre = ar.crearArbol();

      tNombre = new TextoNombre(treeNom, hashNom);
      tPromedio = new TextoPromedio(treeProm);
      tProfesion = new TextoProfesion(treeProf, hashProf);
    }

    private void meterDatos(){
      meterDatosPrueba(tNombre);
      meterDatosPrueba(tProfesion);
      tPromedio.addDatum("9.2",10);
      tPromedio.addDatum("0.01",5);
      tPromedio.addDatum("2.9",6);
      tPromedio.addDatum("9.9",9);
      tPromedio.addDatum("10.01",7);

    }

    private void meterDatosPrueba(TextoBuscar text){
      text.addDatum("hola",10);
      text.addDatum("popup",5);
      text.addDatum("sun",6);
      text.addDatum("summer",9);
      text.addDatum("popup",7);
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

  /**
  *Método main para inicializar la ventana
  */
  public static void main(String[] args) {

      JFrmInicio frameInicio = new JFrmInicio();

      frameInicio.setVisible(true);
      frameInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

}//Fin de la clase main
