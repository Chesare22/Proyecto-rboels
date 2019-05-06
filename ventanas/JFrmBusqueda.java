/**
 *Esta es la clase de la ventana en donde se especifican
 *los detalles para realizar la búsqueda de los datos
 */
package ventanas;

import arboles.avl.ArbolAVL;
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
//actionPerformed
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//import arboles.AVL;
//Para las transiciones
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import mapas.Mapa;
import mapas.MapaOrdenado;
import mapas.MapaSinOrdenar;
import utilidades.Egresado;

public class JFrmBusqueda extends JFrame {

    private final GrupoTextoBuscar textosBusqueda = new GrupoTextoBuscar();//Grupo de cajas para buscar
    private final JButton botonBuscar = new JButton("Buscar");//Botón para Buscar
    private final JButton botonCambiarArchivo = new JButton("Cambiar Archivo");//Botón para regresar y cambiar de archivo
    private final JButton botonModificar = new JButton("Modificar");//Botón para modificar los datos

    /**
     * Constructor de la clase que llama al método para iniciar los componentes
     */
    public JFrmBusqueda(Mapa tNombre, Mapa tPromedio, Mapa tProfesion) {

        setSize(600, 250);
        setLocationRelativeTo(null);
        setTitle("Seleccionar Busqueda");

        initComponents(new TextoBuscar(tNombre), new TextoBuscar(tPromedio), new TextoBuscar(tProfesion));
    }

    /**
     * Método que inicia los componentes
     */
    public void initComponents(TextoBuscar tNombre, TextoBuscar tPromedio, TextoBuscar tProfesion) {

        //Añado los actionListener
        botonCambiarArchivo.addMouseListener(new TransicionCambiarArchivo());
        botonBuscar.addMouseListener(new TransicionBuscar());

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

