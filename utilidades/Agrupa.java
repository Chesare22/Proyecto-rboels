/**
 * Esta clase contiene los métodos para agrupar los datos
 * con dos tipos de operadores lógicos: AND y OR
 */
package utilidades;

import java.util.Vector;

public class Agrupa {

    /**
     * Este método agrupa los datos si coinciden con las dos entradas
     * @param datosOrdenados los índices de los egresados
     * @return los índices en donde se encuentran los datos en el documento
     */
    public static Integer[] and(Integer[][] datosOrdenados) {
        int numeroDeLinea = 1;
        Integer[] itera = datosOrdenados[0];
        Vector<Integer> resultados = new Vector<>();
        while (numeroDeLinea < datosOrdenados.length) {
            for (int i = 0; i < itera.length; i++) {
                if (busquedaBinaria(datosOrdenados[numeroDeLinea], itera[i]) != -1) {
                    //O sea, si el dato está tanto en "itera" como en la línea de datosOrdenados
                    resultados.add(itera[i]);
                }
            }
            numeroDeLinea++;
            itera = resultados.toArray(new Integer[0]);
            resultados.clear();
        }
        return itera;
    }

    /**
     * Este método agrupa los datos por las dos opciones ingresadas
     * @param datos los índices de los egresados
     * @return los índices en donde se encuentran los datos en el documento
     */
    public static Integer[] or(Integer[][] datos) {
        int numeroDeLinea = 1;
        Vector<Integer> coincidencias = new Vector<>();
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[i].length; j++) {
                if (coincidencias.contains(datos[i][j]) == false) {
                    coincidencias.add(datos[i][j]);
                }
            }
        }
        return coincidencias.toArray(new Integer[0]);
    }

    private static int busquedaBinaria(Comparable[] datos, Comparable buscar) {
        int l = 0, r = datos.length, comparacion = 0, m;

        while (l <= r) {
            m = (l + r) / 2;
            try {
                comparacion = datos[m].compareTo(buscar);
            } catch (ArrayIndexOutOfBoundsException arr) {
                return -1;
            }
            if (comparacion < 0) {
                l = m + 1;
            } else if (comparacion > 0) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
