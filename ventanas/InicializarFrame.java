package ventanas;

//Componentes de swing
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import seleccionarFiltro.arboles.*;

//Layouts
import javax.swing.BoxLayout;

//Para darle forma
import java.awt.Dimension;
import java.awt.Font;


/**
 * Esta clase contiene los metodos de los frames
 */
public final class InicializarFrame extends JFrame {

    protected JTextField cajaTexto;
    protected JButton botonAceptar;
    protected JButton botonCancelar;
    protected GrupoBotonArbol botonesArbol = new GrupoBotonArbol();

    /**
     * Metodo para inicializar el Frame con valores predeterminados
     */
    public InicializarFrame() {
      setSize(500, 200);
      setLocationRelativeTo(null);
      Font fuente = new Font("Ebrima", 3, 20);
      setFont(fuente);
      setTitle("Ingresar Archivo");

      initComponents();
    }

    public void initComponents(){

      //Componentes del primer contenedor
      cajaTexto = new JTextField(20);
      botonAceptar = new JButton("Aceptar");
      botonCancelar = new JButton("Cancelar");

      //Botones de los arboles
      BotonArbolAbb botonABB = new BotonArbolAbb();
      BotonArbolAvl botonAVL = new BotonArbolAvl();
      BotonArbolB botonB = new BotonArbolB();

      //Añado los botones al grupo
      botonesArbol.add(botonABB);
      botonesArbol.add(botonAVL);
      botonesArbol.add(botonB);

      //Añado los botones a un panel
      JPanel botonesArbolPanel = new JPanel();
      botonesArbolPanel.add(botonABB);
      botonesArbolPanel.add(botonAVL);
      botonesArbolPanel.add(botonB);

      JPanel archivoPanel = new JPanel();
      archivoPanel.add(new JLabel("Archivo:"));
      archivoPanel.add(cajaTexto);

      botonesArbol.setSelected(0);

      JPanel espaciosBlancos = new JPanel();
      espaciosBlancos.setLayout(new BoxLayout(espaciosBlancos, BoxLayout.Y_AXIS));
      espaciosBlancos.add(new JLabel (" "));
      espaciosBlancos.add(new JLabel (" "));

      JPanel botones = new JPanel();
      botones.add(botonAceptar);
      botones.add(new JLabel("         "));
      botones.add(botonCancelar);

      //Panel que contiene a los demás paneles
      JPanel panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      //Le meto espacios en blanco
      panel.add(espaciosBlancos);
      panel.add(archivoPanel);
      panel.add(botonesArbolPanel);
      panel.add(botones);

      add(panel);
    }

}
