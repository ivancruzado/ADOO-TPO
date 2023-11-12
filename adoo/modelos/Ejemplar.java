package modelos;

import java.util.*;

/**
 * 
 */
public abstract class Ejemplar {

    /**
     * Default constructor
     */
    public Ejemplar() {
    }

    private int idEjemplar;
    private String titulo;
    private String autor;
    private Date fechaPublicacion;
    private int tiempoPrestamo;
    private Boolean prestado;

    /**
     * @param variable Tipo 
     * @return
     */
    public Ejemplar buscarProducto() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Ejemplar crearProducto() {
        // TODO implement here
        return null;
    }

    /**
     * @param idProducto int 
     * @return
     */
    public String localizarProducto(int idProducto) {
        // TODO implement here
        return "";
    }

    /**
     * @param idProducto int 
     * @return
     */
    public void solicitarPrestamo(int idProducto) {
        // TODO implement here
    }

    /**
     * 
     */
    public void buscarPorParametros() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void buscarEjemplar() {
        // TODO implement here
    }

}