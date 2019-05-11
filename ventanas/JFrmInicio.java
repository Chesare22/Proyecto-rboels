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
import java.awt.Font;
import java.awt.Color;

//Para hacer la transición entre ventanas
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import csv.CSVRead;
import csv.ReadCSV;
import javax.swing.JOptionPane;
import mapas.Mapa;
import mapas.MapaOrdenado;
import mapas.MapaSinOrdenar;
import utilidades.Egresado;

public class JFrmInicio extends JFrame{

  protected JTextField cajaTexto;//Caja de texto para ingresar el nombre del archivo
  protected JButton botonAceptar;//Botón para aceptar
  protected JButton botonCancelar;//Botón para cancelar
  protected GrupoBotonArbol botonesArbol = new GrupoBotonArbol();//Grupo de radioButtons de los árboles
  static String[][] alumnos;

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
   * Este método sirve para obtener los datos de los egresados
   * @param indices del archivode los alumnos que se desean encontrar
   * @return los datos de los egresados
   */
  public static Egresado[] obtenerEgresados(Integer[] indices){
        Egresado[] egresados = new Egresado[indices.length];
        for(int i = 0;i<indices.length;i++){
            egresados[i] = new Egresado(alumnos[indices[i]][0],Double.valueOf(alumnos[indices[i]][1]),alumnos[indices[i]][2]);
        }
        return egresados;
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

    private Mapa mNombre;
    private Mapa mPromedio;
    private Mapa mProfesion;

    @Override
    public void mouseClicked(MouseEvent e){
      /*
      Lo que debería hacer es leer el archivo, y si tiene el formato válido, crea
      las instancias de los botones para la ventana principal.
      Posteriormente se llenan esas instancias con datos del archivo.
      */

      iniciarMapas();
      meterDatos();
      
      //Solo por propósitos de prueba
      for(Integer i : mPromedio.search("22.8")){
          System.out.println(i);
      }
      
      dispose();
      JFrmBusqueda ventanaBusqueda = new JFrmBusqueda(mNombre, mPromedio, mProfesion);
      ventanaBusqueda.setVisible(true);
      ventanaBusqueda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Este método es para crear los arboles e iniciar los mapas que encapsulan a los mismos
     */
    private void iniciarMapas(){
      BotonArbol ar = botonesArbol.getSelection();

      mNombre = new MapaSinOrdenar(ar.crearArbol());
      mPromedio = new MapaOrdenado(ar.crearArbol());
      mProfesion = new MapaSinOrdenar(ar.crearArbol());
    }

    /**
     * Este método sirve para meter los datos a los mapas
     */
    private void meterDatos(){
      String path = cajaTexto.getText();
      ReadCSV leerArchivo = new CSVRead();
      
      alumnos = leerArchivo.read(path, 3);
      
      if(alumnos.length == 0){
          //Imprimir mensaje de error
          JOptionPane.showMessageDialog(null, "El archivo no tiene el formato requerido");
      }else{
          //Metemos los datos
          for(int i = 0; i<alumnos.length;i++){
          mNombre.add(alumnos[i][0],i);
          mPromedio.add(alumnos[i][1],i);
          mProfesion.add(alumnos[i][2],i);
          }
      }
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
  * @param args
  */
  public static void main(String[] args) {

      JFrmInicio frameInicio = new JFrmInicio();

      frameInicio.setVisible(true);
      frameInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

}//Fin de la clase main
