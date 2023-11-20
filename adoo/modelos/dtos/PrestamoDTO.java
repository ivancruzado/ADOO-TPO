package modelos.dtos;

import java.util.Calendar;
import java.util.Date;

import modelos.Notificador;

public class PrestamoDTO {
    private int idPrestamo;
    private int tiempoPrestamoBase;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private String motivo;
    private int idSocio;
    private int idEjemplar;
    private Notificador notificacion;

    public PrestamoDTO(int idPrestamo, int tiempoPrestamoBase, Date fechaPrestamo, Date fechaDevolucion, String motivo,
            int idSocio, int idEjemplar, Notificador notificacion) {
        this.idPrestamo = idPrestamo;
        this.tiempoPrestamoBase = tiempoPrestamoBase;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.motivo = motivo;
        this.idSocio = idSocio;
        this.idEjemplar = idEjemplar;
        this.notificacion = notificacion;
    }

    //TODO revisar que tenga sentido
    public Boolean devolvioATiempo() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaPrestamo);
        calendar.add(Calendar.DAY_OF_YEAR, this.tiempoPrestamoBase);
        return this.fechaDevolucion.before(calendar.getTime());
    }

    public int diasRetraso() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaPrestamo);
        calendar.add(Calendar.DAY_OF_YEAR, this.tiempoPrestamoBase);
        //Si fechaDevolucion es null devolver devolver la fecha actual menos calendar.
        if (this.fechaDevolucion == null)
            return (int) ((new Date().getTime() - calendar.getTime().getTime()) / (1000 * 60 * 60 * 24));
        else
            return (int) ((this.fechaDevolucion.getTime() - calendar.getTime().getTime()) / (1000 * 60 * 60 * 24));
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
