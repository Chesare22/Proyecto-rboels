/**
 * Esta interface contiene los 3 métodos principales utilizados para manipular los datos
 */
package arboles;

public interface Arbol {

    /**
     * Este método nos permite saber si el árbol contiene un dato o no
     *
     * @param dato la clave del dato que se desea buscar
     * @return T si el dato pertenece al árbol y F si no pertenece
     */
    public abstract boolean contains(double dato);

    /**
     * Este método busca el dato en el árbol
     *
     * @param dato la clave del dato que se desea buscar
     * @return El dato encontrado
     */
    public abstract MyDatum buscar(double dato);

    /**
     * Este método sirve para insertar datos dentro del árbol
     *
     * @param dato el dato a insertar
     */
    public abstract void insertar(MyDatum dato);
}
