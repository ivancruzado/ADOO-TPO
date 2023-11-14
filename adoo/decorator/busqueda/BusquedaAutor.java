package decorator.busqueda;


import java.util.ArrayList;

import modelos.Busqueda;
import modelos.dtos.EjemplarDTO;

/**
 * 
 */
public class BusquedaAutor extends Busqueda {

    public BusquedaAutor(ArrayList<EjemplarDTO> ejemplares) {
        super(ejemplares);
    }    

    //TODO: Deberiamos usar DTO para devolver los ejemplares encontrados
    public ArrayList<EjemplarDTO> buscarEjemplar(Object criterio){
        if (criterio instanceof String) {
            String autor = (String) criterio;
            ArrayList<EjemplarDTO> ejemplaresEncontrados = new ArrayList<EjemplarDTO>();
            for (EjemplarDTO ejemplar : this.ejemplares) {
                if (ejemplar.getAutor().equals(autor)) {
                    ejemplaresEncontrados.add(ejemplar);
                }
            }
            return ejemplaresEncontrados;
        }else{
            return null;
        }
    }


}