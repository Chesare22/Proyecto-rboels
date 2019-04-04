package seleccionarFiltro;

public class BotonNombre extends BotonBuscar{
  public BotonNombre(){
    super("Nombre");
  }

  @Override
  public int[] buscar(){
    return new int[0];
  }
}
