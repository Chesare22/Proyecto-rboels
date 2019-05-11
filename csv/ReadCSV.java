/**
 * Esta interface sirve para ser implementada en la lectura de archivos
 */
package csv;

public interface ReadCSV {

    /**
     * Método para leer el archivo
     *
     * @param archivo nombre del archivo
     * @param campos tamaño de la matriz
     * @return matriz con los datos encontrados
     */
    String[][] read(String archivo, int campos);
}
