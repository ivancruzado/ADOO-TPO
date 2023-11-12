package modelos.dtos;

import java.util.ArrayList;

import enums.MetodoEnvio;
import modelos.Prestamo;

public class SocioDTO {
    private int idSocio;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private MetodoEnvio metodoEnvio;
    private ArrayList<Prestamo> prestamos;
    private Boolean autenticarse;
    //TODO: Autenticarse que funcion cumple?
    private Boolean habilitado;
    private int prestamosPositivos;
    private int penalizadorDiasPrestamo = 0;

    public SocioDTO(int idSocio, String nombre, String apellido, String dni, String email, String telefono, MetodoEnvio metodoEnvio, ArrayList<Prestamo> prestamos, Boolean autenticarse, Boolean habilitado, int prestamosPositivos, int penalizadorDiasPrestamo) {
        this.idSocio = idSocio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.metodoEnvio = metodoEnvio;
        this.prestamos = prestamos;       //Se crea sin prestamos
        this.autenticarse = autenticarse;
        this.habilitado = habilitado;
        this.prestamosPositivos = prestamosPositivos;
        this.penalizadorDiasPrestamo = penalizadorDiasPrestamo;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public MetodoEnvio getMetodoEnvio() {
        return metodoEnvio;
    }

    public void setMetodoEnvio(MetodoEnvio metodoEnvio) {
        this.metodoEnvio = metodoEnvio;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public Boolean getAutenticarse() {
        return autenticarse;
    }

    public void setAutenticarse(Boolean autenticarse) {
        this.autenticarse = autenticarse;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public int getPrestamosPositivos() {
        return prestamosPositivos;
    }

    public void setPrestamosPositivos(int prestamosPositivos) {
        this.prestamosPositivos = prestamosPositivos;
    }

    public int getPenalizadorDiasPrestamo() {
        return penalizadorDiasPrestamo;
    }

    public void setPenalizadorDiasPrestamo(int penalizadorDiasPrestamo) {
        this.penalizadorDiasPrestamo = penalizadorDiasPrestamo;
    }

}
