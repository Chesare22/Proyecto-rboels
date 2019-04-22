package arboles;

public interface Arbol{
  public abstract boolean contains(double dato);
  public abstract MyDatum buscar(double dato);//¿No debería de ser Integer[] el retorno?
  public abstract void insertar(MyDatum dato);
}
