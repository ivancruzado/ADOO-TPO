package modelos;

import java.util.*;

import modelos.dtos.PrestamoDTO;

public class Prestamo {
    private static int contadorIdPrestamo = 1; // Autoincremental

    private int idPrestamo;
    private int tiempoPrestamoBase;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private String motivo;
    private int idSocio;
    private int idEjemplar;
    private Notificador notificacion;
    private interfaz.IStatePrestamo estadoPrestamo;
    
    public Prestamo(int tiempoPrestamoBase, Date fechaPrestamo, String motivo, int idSocio, int idEjemplar) {
        this.idPrestamo = contadorIdPrestamo++;
        this.tiempoPrestamoBase = tiempoPrestamoBase;
        this.fechaPrestamo = fechaPrestamo;
        this.motivo = motivo;
        this.idSocio = idSocio;
        this.idEjemplar = idEjemplar;
        //this.notificacion = new Notificador();
    }

    public PrestamoDTO toDTO() {
        return new PrestamoDTO(this.idPrestamo, this.tiempoPrestamoBase, this.fechaPrestamo, this.fechaDevolucion, this.motivo, this.idSocio, this.idEjemplar, this.notificacion);
    }

    public int crearPrestamo(int tiempoPrestamoBase, Date fechaPrestamo, String motivo, int idSocio, int idEjemplar) {
        Prestamo prestamo = new Prestamo(tiempoPrestamoBase, fechaPrestamo, motivo, idSocio, idEjemplar);
        return prestamo.idPrestamo;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getTiempoPrestamoBase() {
        return tiempoPrestamoBase;
    }

    public void setTiempoPrestamoBase(int tiempoPrestamoBase) {
        this.tiempoPrestamoBase = tiempoPrestamoBase;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public int getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(int idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public Notificador getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(Notificador notificacion) {
        this.notificacion = notificacion;
    }

    
    

}