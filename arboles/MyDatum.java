package arboles;

import java.util.Vector;

public class MyDatum implements Comparable{
  private final double clave;
  private Vector<Integer> indices = new Vector<Integer>();

  public MyDatum(double clave, Integer primerIndice){
    this.clave = clave;
    indices.add(primerIndice);
  }

  public void add(Integer indice){
    indices.add(indice);
  }

  public Integer[] getIndices(){
    return indices.toArray(new Integer[0]);
  }

  public double getClave(){return clave;}

  @Override
  public int compareTo(Object ob){
    MyDatum d = (MyDatum) ob;
    if(clave<d.getClave()){
      return 1;
    }else if(clave>d.getClave()){
      return -1;
    }else{
      return 0;
    }
  }
}
