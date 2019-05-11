/**
 * Esta interface sirve para mapear los datos dentro de los árboles;
 * Así mismo, añade y busca los datos contenidos dentro de los árboles
 */
package mapas;

public interface Mapa {

    /**
     * Este método sirve para añadir datos
     * @param dato Datos del alumno
     * @param indice Ubicación del alumno dentro del documento
     */
    public abstract void add(String dato, int indice);

    /**
     * Este método sirve para buscar un dato dentro del árbol
     * @param dato Datos que se desea buscar del alumno
     * @return arreglo con los índices que coinciden con la búsqueda
     */
    public abstract Integer[] search(String dato);
}
