package modelos;

import java.util.*;

/**
 * 
 */
public abstract class Ejemplar {

    private static int contadorIdEjemplar = 1; // Autoincremental
    
    private int idEjemplar;
    private String titulo;
    private String autor;
    private Date fechaPublicacion;
    private int tiempoPrestamo;
    private Boolean prestado;

    public Ejemplar(String titulo, String autor, Date fechaPublicacion, int tiempoPrestamo) {
        this.idEjemplar = contadorIdEjemplar++;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.tiempoPrestamo = tiempoPrestamo;
        this.prestado = false;
    }

    public int getIdEjemplar() {
        return idEjemplar;
    }

    public int getTiempoPrestamo(){
        return this.tiempoPrestamo;
    }

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