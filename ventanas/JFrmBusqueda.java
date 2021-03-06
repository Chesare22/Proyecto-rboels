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
         * Sección para personalizar y añadir los botones
         */
        botonBuscar.setForeground(Color.WHITE);
        botonBuscar.setBackground(new Color(53, 153, 0));
        botonCambiarArchivo.setForeground(Color.WHITE);
        botonCambiarArchivo.setBackground(new Color(204, 0, 0));

        //Añadimos los botones a un Panel
        JPanel panelBBuscar = new JPanel();
        panelBBuscar.add(botonBuscar);
        panelBBuscar.add(new JLabel("      "));
        panelBBuscar.add(botonCambiarArchivo);

        //Añadimos el panel de botones al panel principal
        panel.add(panelBBuscar);

        //Añadimos el panel principal a la ventana
        add(panel);
    }

    /**
     * Método main para ejecutar la ventana
     * @param args
     */
    public static void main(String[] args) {

        JFrmBusqueda ventanaBusqueda = new JFrmBusqueda(new MapaSinOrdenar(new ArbolAVL()), new MapaOrdenado(new ArbolAVL()), new MapaSinOrdenar(new ArbolAVL()));

        ventanaBusqueda.setVisible(true);
        ventanaBusqueda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Esta clase sirve para la transición del botón Cambiar Archivo
     */
    private class TransicionCambiarArchivo implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            JFrmInicio frameInicio = new JFrmInicio();

            dispose();
            frameInicio.setVisible(true);
            frameInicio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

    }

    /**
     * Esta clase sirve para la transición del botón Buscar
     */
    private class TransicionBuscar implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            TextoBuscar[] textos = textosBusqueda.getSelected();

            Integer[][] indices = new Integer[textos.length][];

            if (indices.length == 0) {
                //Mostrar mensaje de que no se seleccionó algo para buscar
                JOptionPane.showMessageDialog(null, "No se selecciono nada para buscar");
            } else {
                for (int i = 0; i < textos.length; i++) {
                    indices[i] = textos[i].buscar();
                }
                //Ya teniendo los índices, vamos a llevarlos a la siguiente ventana
                if (indices.length == 1) {
                    //Mandamos el resultado directamente a la tabla
                    Egresado[] egresados = JFrmInicio.obtenerEgresados(indices[0]);
                    String encabezado = "coincidencias con ".concat(textos[0].getText());
                    JFrmResultado ventanaRes = new JFrmResultado(encabezado, egresados);
                    ventanaRes.setVisible(true);
                    ventanaRes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                } else {
                    //Definimos el texto que sirve para ver cómo se van aagrupar los datos
                    String[] textoAgrupamiento = {
                        textos[0].getTextoBusqueda(), textos[1].getTextoBusqueda()
                    };
                    //Los mandamos a agrupar
                    JFrmAgrupar ventanaRes = new JFrmAgrupar(textoAgrupamiento, indices);
                    ventanaRes.setVisible(true);
                    ventanaRes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }
    }

}
