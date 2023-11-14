package modelos;

import java.util.*;
import modelos.dtos.EjemplarDTO;

public abstract class Busqueda {

    protected ArrayList<EjemplarDTO> ejemplares;
  
    public Busqueda(ArrayList<EjemplarDTO> ejemplares) {
        this.ejemplares = ejemplares;
    }

    /**
     * @return
     */
    public abstract ArrayList<EjemplarDTO> buscarEjemplar(Object criterio);

}