/**
*Esta clase maneja un Vector de Egresados para manipular los datos con mayor facilidad
*/

package representarDatos;

import java.util.Vector;

public class Egresados{
  private Vector<Egresado> egresados = new Vector<Egresado>();

  public Egresados(){}

  public Egresados(Egresado e){
    egresados.add(e);
  }

  public Egresados(Vector<Egresado> egresados){
    this.egresados = egresados;
  }

  public void add(Egresado e){
    egresados.add(e);
  }

  public void add(String nombre, String profesion, float promedio){
    egresados.add(new Egresado(nombre, profesion, promedio));
  }

  public Egresado get(int index){
    return egresados.get(index);
  }

  public Egresado remove(int index){
    return egresados.remove(index);
  }
}
