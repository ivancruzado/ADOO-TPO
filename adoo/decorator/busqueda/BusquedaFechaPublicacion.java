package decorator.busqueda;

import java.util.*;

import modelos.Busqueda;
import modelos.dtos.EjemplarDTO;
/**
 * 
 */
public class BusquedaFechaPublicacion extends Busqueda {

    public BusquedaFechaPublicacion(ArrayList<EjemplarDTO> ejemplares) {
        super(ejemplares);
    }    

    public ArrayList<EjemplarDTO> buscarEjemplar(Object criterio){
        if (criterio instanceof Date) {
            Date fecha = (Date) criterio;
            ArrayList<EjemplarDTO> ejemplaresEncontrados = new ArrayList<EjemplarDTO>();
            for (EjemplarDTO ejemplar : this.ejemplares) {
                if (ejemplar.getFechaPublicacion().equals(fecha)) {
                    ejemplaresEncontrados.add(ejemplar);
                }
            }
            return ejemplaresEncontrados;
        }else{
            return null;
        }
    }

}