/**
*Clase que contiene la tabla para visualizar las coincidencias encontradas en ls búsqueda
*/

package ventanas;

//Componentes de swing
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import representarDatos.Egresado;

//Layouts
import javax.swing.BoxLayout;

import java.awt.Font;

public class JFrmResultado extends JFrame{

  private static String[] HEADER = {"Nombre","Profesion","Promedio"};//Sirve para darle nombre a las columnas

  /**
  *Constructor de la Clase que llama al método para iniciar los Componentes
  *@param encabezado Título de la ventanas
  *@param e coincidencias encontradas en la búsqueda de los datos
  */
  public JFrmResultado(String encabezado, Egresado[] e){
    setSize(600, 250);
    setLocationRelativeTo(null);
    Font fuente = new Font("Ebrima", 3, 20);
    setFont(fuente);
    setTitle("Tabla de Resultados");

    initComponents(encabezado,e);
  }

  /**
  *Método para iniciar los Componentes
  *Recibe los mismos parámetros que el constructor
  */
  public void initComponents(String encabezado, Egresado[] egresados){

    //Iniciamos los datos de la Tabla
    JTable table = new JTable(convertirEgresados(egresados),HEADER);

    TableColumn columnas = null;
    for (int i = 0; i < 3; i++) {
      columnas = table.getColumnModel().getColumn(i);
      if(i==2){
        columnas.setPreferredWidth(10);
      }else{
        columnas.setPreferredWidth(200);
      }
    }


    //Panel del encabezado
    JPanel panelEncabezado = new JPanel();
    panelEncabezado.add(new JLabel("Resultado: ".concat(encabezado)));

    //ScrollPane de la tabla
    JScrollPane scrollPane = new JScrollPane(table);

    //Panel principal
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.add(panelEncabezado);
    panel.add(scrollPane);

    add(panel);//Añadimos el panel a la ventana
  }

  /**
  *Método para convertir el arreglo y poder inicializar la tabla
  *@param e arreglo con las coincidencias encontradas
  *@return la matriz para imprimir los datos en la tabla
  */
  public Object[][] convertirEgresados(Egresado[] e){

    Object[][] lista = new Object[e.length][3];
    for(int i = 0; i <e.length;i++){
      lista[i][0] = e[i].getNombre();
      lista[i][1] = e[i].getProfesion();
      lista[i][2] = Double.valueOf(e[i].getPromedio());
    }

    return lista;
  }

  /**
  *Método main
  */
  public static void main(String[] args) {

    Egresado[] e = new Egresado[15];
    e[0] = new Egresado("Juan","Contador",6.9);
    e[1] = new Egresado("Emilio","Licenciado",6.8);
    e[2] = new Egresado("Eduardo","Maestro",120.8);
    e[3] = new Egresado("Juan","Contador",6.9);
    e[4] = new Egresado("Emilio","Licenciado",6.8);
    e[5] = new Egresado("Eduardo","Maestro",120.8);
    e[6] = new Egresado("Juan","Contador",6.9);
    e[7] = new Egresado("Emilio","Licenciado",6.8);
    e[8] = new Egresado("Eduardo","Maestro",120.8);
    e[9] = new Egresado("Juan","Contador",6.9);
    e[10] = new Egresado("Emilio","Licenciado",6.8);
    e[11] = new Egresado("Eduardo","Maestro",120.8);
    e[12] = new Egresado("Juan","Contador",6.9);
    e[13] = new Egresado("Emilio","Licenciado",6.8);
    e[14] = new Egresado("Eduardo","Maestro",120.8);


    JFrmResultado frameTabla = new JFrmResultado("Egresados",e);

    frameTabla.setVisible(true);
    frameTabla.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }
  
}
