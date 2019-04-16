package arboles.arbolesBTrails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DemostracionArbolBinarioBusqueda {

    public static void main(String[] args) {
        new DemostracionArbolBinarioBusqueda();
    }

    public DemostracionArbolBinarioBusqueda() {
//Inicializamos el árbol binario de búsqueda
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        int iOpcion = 0, iDato;
//Desplegar las instrucciones
        System.out.println("DEMOSTRACION ARBOL DE BUSQUEDA BINARIA ");
        instrucciones();
        do {
            iOpcion = Entrada.leerInt(" Opcion: ");
            switch (iOpcion) {
                case 1: //Insertar un dato
                    iDato = Entrada.leerInt("Introduce el dato a insertar: ");
                    arbol.insertar(iDato);
                    arbol.imprimir();
                    break;
                case 2: //Eliminar un dato
                    iDato = Entrada.leerInt("Introduce el dato a eliminar: ");
                    arbol.eliminar(iDato);
                    arbol.imprimir();
                    break;
                case 3: //Buscar un dato
                    iDato = Entrada.leerInt("Introduce el dato a buscar: ");
                    arbol.buscar(iDato);
                    break;
                case 4: //Recorrido preorden
                    arbol.recorridoPreorden();
                    break;
                case 5: //Recorrido inorden
                    arbol.recorridoInorden();
                    break;
                case 6: //Recorrido postorden
                    arbol.recorridoPostorden();
                    break;
                case 7: //Vaciar el árbol
                    arbol.vaciar();
                    arbol.imprimir();
            }
        } while (iOpcion != 8);
    }

    private void instrucciones() {
        System.out.println("\n\n\tElige una opcion "
                + "\n1 para insertar un dato "
                + "\n2 para eliminar un dato "
                + "\n3 para buscar un dato "
                + "\n4 para imprimir el recorrido preorden "
                + "\n5 para imprimir el recorrido inorden o simetrico "
                + "\n6 para imprimir el recorrido postorden "
                + "\n7 para vaciar el arbol "
                + "\n8 para salir del programa ");
    }

    private static class Entrada {

        private static int leerInt(String texto) {
            System.out.println(texto);
            int leerInt = 0;
            BufferedReader h = new BufferedReader(new InputStreamReader(System.in));
            try {
                leerInt = Integer.parseInt(h.readLine());
            } catch (IOException ex) {
                Logger.getLogger(DemostracionArbolBinarioBusqueda.class.getName()).log(Level.SEVERE, null, ex);
            }
            return leerInt;

// throw new UnsupportedOperationException("Not yet implemented");
        }

        public Entrada() {
        }
    }
}
