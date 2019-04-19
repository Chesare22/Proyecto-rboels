/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.abb;

import arboles.MyDatum;

/**
 *
 * @author jorge.reyes
 */
public class ArbolABB {
  protected NodoBin raiz;

  public ArbolABB(double dato, int indice){
    this(new MyDatum(dato, indice));
  }

  public ArbolABB(MyDatum o){
    raiz = new NodoBin(o);
  }

  public ArbolABB(NodoBin raiz){
    this.raiz = raiz;
  }

  public ArbolABB(){
    raiz = new NodoBin();
  }

  public void inOrden(){
    if(raiz!=null)
        raiz.inOrden();
  }

  public void posOrden(){
    if(raiz!=null)
        raiz.posOrden();
  }

  public void preOrden(){
    if(raiz!=null)
        raiz.preOrden();
  }

  public void insertar(MyDatum o){
    if(raiz.getDato() == null){
      raiz.setDato(o);
    }else{
      insertarOrdenado(raiz,o);

    }

  }

  public void borrar(MyDatum o){
    borrar(raiz,o);
  }

  private NodoBin borrar(NodoBin n, MyDatum o) throws ItemNotFoundException{
    if (n==null)
        throw new ItemNotFoundException("Elemento no encontrado");
    else{
      if (o.getClave() > n.getDato().getClave())
        n.setDer(borrar(n.getDer(),o));
      else
         if(o.getClave() < n.getDato().getClave())
            n.setIzq(borrar(n.getIzq(),o));
         else{//Ya encontré el elemento a eliminar!!
           if (n.getDer()!=null && n.getIzq()!=null)//Aquí aplicamos los criterios cuando hay 2 hijos
           //Aplicamos el criterio del hijo más izquierdo del lado derecho
           {
           NodoBin minimo = buscarMin(n.getDer());
           n.setDato(minimo.getDato());
           n.setDer(borrarMin(n.getDer()));
           }
           else //Los criterios cuando se tienen 1 de los 2 hijos o es hoja
             n = (n.getIzq()!= null)? n.getIzq() : n.getDer();
         }
    }
   return n;
  }

  private NodoBin buscarMin(NodoBin n){
     while(n.getIzq()!=null)
         n = n.getIzq();
     return n;
  }

  private NodoBin borrarMin(NodoBin n){
    if (n.getIzq()!= null){
      n.setIzq(borrarMin(n.getIzq()));
      return n;
    }
    else
       return n.getDer();
  }

  private void insertarOrdenado(NodoBin n, MyDatum o){
  if (o.getClave()<n.getDato().getClave()){
     if (n.getIzq()==null)
         n.setIzq(new NodoBin(o));
     else
         insertarOrdenado(n.getIzq(),o);
     }
  else{
  if(o.getClave()>n.getDato().getClave()){
    if (n.getDer()==null)
       n.setDer(new NodoBin(o));
    else
       insertarOrdenado(n.getDer(),o);
     }
     }
  }

  public boolean contains(double dato){
    if(buscar(dato) == null){
      return false;
    }else{
      return true;
    }
  }

  public MyDatum buscar(double o){
    return buscar(raiz,o);
  }

  private MyDatum buscar(NodoBin n, double o){
  if (o<n.getDato().getClave()){
     if (n.getIzq()==null)
         return null;
     else
        return buscar(n.getIzq(),o);
     }
  else{
  if(o>n.getDato().getClave()){
    if (n.getDer()==null)
       return null;
    else
       return buscar(n.getDer(),o);
     }
  else
     return n.getDato();
     }
  }
    /**
     * @return the raiz
     */
    public MyDatum getRaiz() {
        return raiz.getDato();
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(NodoBin raiz) {
        this.raiz = raiz;
    }

    /*public static void main(String[] args) {
      ArbolABB arbol = new ArbolABB(25);
//      arbol.insertar(73);
//      arbol.insertar(48);
//      arbol.insertar(1);
//      arbol.insertar(67);
//      arbol.insertar(5);
//      arbol.insertar(99);
//      arbol.insertar(7);
//      arbol.insertar(44);
//      arbol.insertar(91);
//      arbol.insertar(70);
//      arbol.insertar(6);

      arbol.insertar(3);
      arbol.insertar(4);
      arbol.insertar(1);
      arbol.insertar(6);
      arbol.insertar(5);
      arbol.insertar(9);
      arbol.insertar(7);
      arbol.insertar(10);
      arbol.insertar(2);
      arbol.insertar(0);
      arbol.insertar(8);

      System.out.println("RECORRIDO EN INORDEN");
//      arbol.inOrden();
      arbol.preOrden();

        System.out.println("\nRAIZ: " + arbol.getRaiz());

      /*System.out.println("RECORRIDO EN PREORDEN");
      arbol.preOrden();
      System.out.println("RECORRIDO EN POSORDEN");
      arbol.posOrden();
      System.out.println("Buscando datos...");
      try{
         arbol.buscar(105);
        }
      catch(ItemNotFoundException e){
          System.out.println("Error: " + e.getMessage());
      }
      int eliminado = 48;
      System.out.println("Eliminando el elemento: " + eliminado);
      try{
         arbol.borrar(eliminado);
         arbol.inOrden();
      }
      catch (ItemNotFoundException e){
          System.out.println("Error: " + e.getMessage());
      }
    }*/
}
