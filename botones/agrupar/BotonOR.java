package botones.agrupar;

import utilidades.Agrupa;

public class BotonOR extends BotonAgrupar{
  public BotonOR(){
    super("OR");
  }

  //Falta ser implementado
  @Override
  public Integer[] agrupar(Integer[][] datos){
    return Agrupa.or(datos);
  }
}
