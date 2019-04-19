/**
*Esta interface sirve para ser implementada en las demás estructuras y poder
*aplicar los métodos de inserción y búsqueda de acuerdo al árbol seleccionado
*/

package contenedores;

public interface ContenedorOrdenado{
  public abstract void add(double dato, int indice);
  public abstract Integer[] search(double dato);
}
