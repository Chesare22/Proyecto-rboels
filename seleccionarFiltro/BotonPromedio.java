package seleccionarFiltro;

public class BotonPromedio extends BotonBuscar{
  public BotonPromedio(){
    super("Promedio");
  }

  @Override
  public int[] buscar(){
    return new int[0];
  }
}
