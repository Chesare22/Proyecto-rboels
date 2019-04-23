/**
*Clase de la ventana en donde se selecciona
*cómo se van a agrupar los datos
*/

package ventanas;

import botones.agrupar.*;

//Componentes de swing
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

//personalización de botonesAgruparLogicos
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

//Layouts
import javax.swing.BoxLayout;
import utilidades.Egresado;

public class JFrmAgrupar extends JFrame{

  private String[] busquedas;//label con el encabezado de la ventana
  private GrupoBotonAgrupar botonesAgruparLogicos = new GrupoBotonAgrupar();//Grupo de los botones lógicos
  private JButton botonAceptar;//Botón de aceptar
  private JButton botonCancelar;//Botón de cancelar
  private final Integer[][] indices;

  /**
  *Constructor de la clase que llama al método para iniciar los componentes
  *@param busquedas opciones de búsqueda que tiene el usuario
  */
  public JFrmAgrupar(String[] busquedas, Integer[][] indices){
    setSize(600, 250);
    setLocationRelativeTo(null);
    setTitle("Seleccionar Operador L\u00f3gico");
    this.indices = indices;
    this.busquedas = busquedas;

    initComponents();
  }

  /**
  *Método para iniciar los Componentes
  *@param busquedas opciones de búsqueda que tiene el usuario
  */
  public void initComponents(){
    String e = "";
    for(int i = 0; i < busquedas.length-1;i++){
      e = e.concat(busquedas[i]).concat(" __ ");
    }
    JLabel encabezado = new JLabel(e.concat(busquedas[busquedas.length-1]));

    //Panel para añadir el jLabel
    JPanel panel1 = new JPanel();
    panel1.add(new JLabel("Buscar Por:"));

    //JPanel del encabezado
    JPanel encabezadoPanel = new JPanel();
    encabezadoPanel.add(encabezado);

    //Declaración de los botones para agrupar con operadores lógicos
    BotonOR bOR = new BotonOR();
    BotonAND bAND = new BotonAND();

    //Declaración de los botones aceptar y cancelar
    botonAceptar = new JButton("Aceptar");
    botonCancelar = new JButton("Cancelar");

    //personalización de los botones
    botonAceptar.setForeground(Color.WHITE);
    botonAceptar.setBackground(new Color(51, 153, 0));
    botonAceptar.addMouseListener(new Transicion());
    botonCancelar.setForeground(Color.WHITE);
    botonCancelar.setBackground(new Color(204,0,0));
    botonCancelar.addMouseListener(new Cancelar());

    //Agrupo los botones
    botonesAgruparLogicos.add(bOR);
    botonesAgruparLogicos.add(bAND);

    JPanel panelBotonesAgrupar = new JPanel();
    panelBotonesAgrupar.add(new JLabel("Seleccione un metodo de agrupamiento:  "));
    panelBotonesAgrupar.add(bOR);
    panelBotonesAgrupar.add(bAND);

    //JPanel de los botones aceptar y cancelar
    JPanel panelBotonesAC = new JPanel();
    panelBotonesAC.add(botonAceptar);
    panelBotonesAC.add(new JLabel("   "));
    panelBotonesAC.add(botonCancelar);

    botonesAgruparLogicos.setSelected(0);//Se deja seleccionado un botón por default

    //Se agregan los paneles al panel principal
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.add(new JLabel(" "));
    panel.add(panel1);
    panel.add(encabezadoPanel);
    panel.add(panelBotonesAgrupar);
    panel.add(panelBotonesAC);

    add(panel);//Se agrega el panel prinicpal a la ventana
  }

  /**
  *Método main que inicia la ventana
  */
  public static void main(String[] args) {
/*
    String[] datos = new String[3];
    datos[0] = "Nombre";
    datos[1] = "Profesion";
    datos[2] = "Promedio";

    JFrmAgrupar ventanaBusqueda = new JFrmAgrupar(datos);
    ventanaBusqueda.setVisible(true);

    ventanaBusqueda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
  }

  private class Transicion implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e){
      Integer[] indicesResultado = botonesAgruparLogicos.getSelection().agrupar(indices);
      Egresado[] egresados = JFrmInicio.obtenerEgresados(indicesResultado);
      String resultado = "";
      
      for(int i = 0;i<busquedas.length-1;i++){
          resultado = resultado.concat(busquedas[i]).concat(" y ");
      }
      resultado = resultado.concat(busquedas[busquedas.length-1]);
      
      JFrmResultado ventanaRes = new JFrmResultado(resultado, egresados);
      ventanaRes.setVisible(true);
      ventanaRes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      dispose();
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
  
  private class Cancelar implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e){
      dispose();
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
