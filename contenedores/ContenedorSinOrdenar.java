package contenedores;

public class ContenedorSinOrdenar{
  private ContenedorOrdenado contiene;
  private HashMap<String,Double> hash;
  private double key = 0;

  public ContenedorSinOrdenar(ContenedorOrdenado contiene, HashMap<String,Double> hash){
    this.contiene = contiene;
    this.hash = hash;
  }

  public void add(String dato, int indice){
    key+=0.1;
    hash.put(dato, key);
    contiene.add(key, indice);
  }

  public Integer[] search(String dato){
    return contiene.search(hash.get(dato));
  }

}
