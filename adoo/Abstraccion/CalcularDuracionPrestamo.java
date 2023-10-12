package Abstraccion;

import java.util.*;

import Concreto.Prestamo;

/**
 * 
 */
public abstract class CalcularDuracionPrestamo {

    /**
     * Default constructor
     */
    public CalcularDuracionPrestamo() {
    }

    /**
     * @param prestamo 
     * @return
     */
    public abstract Prestamo calcularTiempo(Prestamo prestamo);

}