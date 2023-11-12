package modelos;

import java.util.*;
import modelos.Notificador;
/**
 * 
 */
public class Prestamo {

    /**
     * Default constructor
     */
    public Prestamo() {
    }

    /**
     * 
     */
    private int idPrestamo;

    /**
     * 
     */
    private String tiempoPrestamoBase;

    /**
     * 
     */
    private Date fechaPrestamo;

    /**
     * 
     */
    private Date fechaDevolucion;

    /**
     * 
     */
    private String motivo;

    /**
     * 
     */
    private int idSocio;

    /**
     * 
     */
    private int idEjemplar;

    /**
     * 
     */
    private Notificador notificacion;

}