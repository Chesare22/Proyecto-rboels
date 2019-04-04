
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Esta clase contiene los metodos de los frames
 */
public final class InicializarFrame extends JFrame {
    
    protected JTextField cajaTexto = new JTextField(15);

    /**
     * Metodo para inicializar el Frame con valores predeterminados
     */
    public InicializarFrame() {
        setSize(500, 300);
        setLocationRelativeTo(null);
        Font fuente = new Font("Ebrima", 3, 20);
        setFont(fuente);
        setTitle("Sistema de Busqueda y Ordenamiento");
        
        initComponents();

    }
    
    public void initComponents(){
        
        //cajaTexto.setLocation(1,1);
        add(cajaTexto);
    }

}
