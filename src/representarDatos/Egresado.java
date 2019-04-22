/**
*Esta clase es para objetos de tipo Egresado
*/

package representarDatos;

public class Egresado{

  private String nombre;//Nombre completo del egresado
  private String profesion;//Profesión del egresado
  private double promedio;//Promedio del egresado

  public Egresado(){}

  public Egresado(String nombre, String profesion, double promedio){
    this.nombre = nombre;
    this.profesion = profesion;
    this.promedio = promedio;
  }

  public String getNombre(){return nombre;}

  public void setNombre(String nombre){this.nombre = nombre;}

  public String getProfesion(){return profesion;}

  public void setProfesion(String profesion){this.profesion = profesion;}

  public double getPromedio(){return promedio;}

  public void setPromedio(double promedio){this.promedio = promedio;}
}
