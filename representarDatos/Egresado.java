package representarDatos;

public class Egresado{
  private String nombre;
  private String profesion;
  private float promedio;

  public Egresado(){}

  public Egresado(String nombre, String profesion, float promedio){
    this.nombre = nombre;
    this.profesion = profesion;
    this.promedio = promedio;
  }

  public String getNombre(){return nombre;}

  public void setNombre(String nombre){this.nombre = nombre;}

  public String getProfesion(){return profesion;}

  public void setProfesion(String profesion){this.profesion = profesion;}

  public float getPromedio(){return promedio;}

  public void setPromedio(float promedio){this.promedio = promedio;}
}
