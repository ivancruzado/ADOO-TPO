package modelos;

import java.util.*;

import adapter.localizador.AdapterLocalizador;
import adapter.localizador.ILocalizarEjemplar;
import modelos.dtos.EjemplarDTO;

/**
 * 
 */
public abstract class Ejemplar {

    private static int contadorIdEjemplar = 1; // Autoincremental
    
    private int idEjemplar = contadorIdEjemplar++;
    private String titulo;
    private String autor;
    private Date fechaPublicacion;
    private int tiempoPrestamo;
    private Boolean prestado = false;
    private String categoria;
    private ILocalizarEjemplar localizador = new AdapterLocalizador();

    public Ejemplar(String titulo, String autor, Date fechaPublicacion, int tiempoPrestamo, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.tiempoPrestamo = tiempoPrestamo;
        this.categoria = categoria;
    }

    public EjemplarDTO toDTO(){
        return new EjemplarDTO(contadorIdEjemplar, titulo, autor, fechaPublicacion, tiempoPrestamo, prestado, categoria);
    }

    public Boolean disponible() {
        return !this.prestado;
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

    public String getCategoria() {
        return categoria;
    }

    public String localizar(int idEjemplar){
        return this.localizador.localizarEjemplar(idEjemplar);
    }

}