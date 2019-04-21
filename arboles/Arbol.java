package arboles;

public interface Arbol{
  public abstract boolean contains(double dato);
  public abstract MyDatum buscar(double dato);
  public abstract void insertar(MyDatum dato);
}
