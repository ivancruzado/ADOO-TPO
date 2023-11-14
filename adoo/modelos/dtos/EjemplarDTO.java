package modelos.dtos;

import java.util.Date;

public class EjemplarDTO {
    
    private int idEjemplar;
    private String titulo;
    private String autor;
    private Date fechaPublicacion;
    private int tiempoPrestamo;
    private Boolean prestado;
    private String categoria;

    public EjemplarDTO(int idEjemplar, String titulo, String autor, Date fechaPublicacion, int tiempoPrestamo, Boolean prestado, String categoria) {
        this.idEjemplar = idEjemplar;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.tiempoPrestamo = tiempoPrestamo;
        this.prestado = prestado;
        this.categoria = categoria;
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

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    
}
