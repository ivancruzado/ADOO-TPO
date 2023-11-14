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

    public Boolean disponible() {
        return !this.prestado;
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



    public static int getContadorIdEjemplar() {
        return contadorIdEjemplar;
    }



    public static void setContadorIdEjemplar(int contadorIdEjemplar) {
        Ejemplar.contadorIdEjemplar = contadorIdEjemplar;
    }



    public int getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(int idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getTiempoPrestamo() {
        return tiempoPrestamo;
    }

    public void setTiempoPrestamo(int tiempoPrestamo) {
        this.tiempoPrestamo = tiempoPrestamo;
    }

    public Boolean getPrestado() {
        return prestado;
    }

    public void setPrestado(Boolean prestado) {
        this.prestado = prestado;
    }

}