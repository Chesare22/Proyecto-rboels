package mapas;

public interface Mapa{
  public abstract void add(String dato,int indice);
  public abstract Integer[] search(String dato);
}
