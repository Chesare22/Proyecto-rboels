package ventanas;

import botones.agrupar.*;

//Componentes de swing
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

//personalización de botonesAgruparLogicos
import java.awt.Color;

//Layouts
import javax.swing.BoxLayout;

public class JFrmAgrupar extends JFrame{

  private JLabel encabezado;
  private GrupoBotonAgrupar botonesAgruparLogicos = new GrupoBotonAgrupar();
  private JButton botonAceptar;
  private JButton botonCancelar;

  public JFrmAgrupar(String[] busquedas){
    setSize(600, 250);
    setLocationRelativeTo(null);
    setTitle("Seleccionar Operador L\u00f3gico");

    initComponents(busquedas);
  }

  public void initComponents(String[] busquedas){
    String e = "";
    for(int i = 0; i < busquedas.length-1;i++){
      e = e.concat(busquedas[i]).concat(" __ ");
    }
    encabezado = new JLabel(e.concat(busquedas[busquedas.length-1]));

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
    botonCancelar.setForeground(Color.WHITE);
    botonCancelar.setBackground(new Color(204,0,0));

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

    botonesAgruparLogicos.setSelected(0);

    //Panel principal
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.add(new JLabel(" "));
    panel.add(panel1);
    panel.add(encabezadoPanel);
    panel.add(panelBotonesAgrupar);
    panel.add(panelBotonesAC);

    add(panel);
  }

  public static void main(String[] args) {
    String[] datos = new String[3];
    datos[0] = "Nombre";
    datos[1] = "Profesion";
    datos[2] = "Promedio";

    JFrmAgrupar ventanaBusqueda = new JFrmAgrupar(datos);
    ventanaBusqueda.setVisible(true);

    ventanaBusqueda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
