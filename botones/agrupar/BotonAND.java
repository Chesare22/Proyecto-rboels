package botones.agrupar;

import utilidades.Agrupa;

public class BotonAND extends BotonAgrupar{
  public BotonAND(){
    super("AND");
  }

  //Falta ser implementado
  @Override
  public Integer[] agrupar(Integer[][] datos){
    return Agrupa.and(datos);
  }
}
