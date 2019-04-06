package seleccionarFiltro.buscar;

public class TextoNombre extends TextoBuscar{
  public TextoNombre(){
    super("Nombre");
  }

  @Override
  public int[] buscar(){
    return new int[0];
  }
}
