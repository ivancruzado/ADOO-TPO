package decorator.busqueda;

import java.util.ArrayList;

import modelos.Busqueda;
import modelos.dtos.EjemplarDTO;

/**
 * 
 */
public class BusquedaCategoria extends Busqueda {

    public BusquedaCategoria(ArrayList<EjemplarDTO> ejemplares) {
        super(ejemplares);
    }    

    //TODO: Deberiamos usar DTO para devolver los ejemplares encontrados
    public ArrayList<EjemplarDTO> buscarEjemplar(Object criterio){
        if (criterio instanceof String) {
            String categoria = (String) criterio;
            ArrayList<EjemplarDTO> ejemplaresEncontrados = new ArrayList<EjemplarDTO>();
            if (categoria.toUpperCase().equals("REVISTA")){
                for (EjemplarDTO ejemplar : this.ejemplares)
                    if (ejemplar.getCategoria().toUpperCase().equals(categoria.toUpperCase()))
                        ejemplaresEncontrados.add(ejemplar);
            }
            else{
                for (EjemplarDTO ejemplar : this.ejemplares)
                    if (ejemplar.getCategoria().toUpperCase().contains(categoria.toUpperCase()))
                        ejemplaresEncontrados.add(ejemplar);
            }                
            
            return ejemplaresEncontrados;
        }else{
            return null;
        }
    }

}