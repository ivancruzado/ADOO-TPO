package modelos;

import java.util.*;

import adapter.autenticador.IAdapterAutenticador;
import enums.MetodoEnvio;
import modelos.dtos.SocioDTO;

public class Socio implements IAdapterAutenticador {


    private static int contadorIdSocio = 1; // Autoincremental
    private int idSocio;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private MetodoEnvio metodoEnvio;
    private List<Prestamo> prestamosSocio;
    private Boolean autenticarse = false;
    private Boolean habilitado;
    private int prestamosPositivos = 0;
    private int penalizadorDiasPrestamo = 0;
    private interfaz.ILogger logger;

    public Socio(String nombre, String apellido, String dni, String email, String telefono, MetodoEnvio metodoEnvio, interfaz.ILogger logger) {
        this.idSocio = contadorIdSocio++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.metodoEnvio = metodoEnvio;
        this.logger = logger;
        this.habilitado = true;
        prestamosSocio = new ArrayList<>();
        //this.prestamos = prestamos;       //Se crea sin prestamos
    }

    public SocioDTO toDTO() {
        return new SocioDTO(this.idSocio, this.nombre, this.apellido, this.dni, this.email, this.telefono, this.metodoEnvio, this.prestamosSocio, this.autenticarse, this.habilitado, this.prestamosPositivos, this.penalizadorDiasPrestamo);
    }

    public Boolean autenticarse(int idSocio) {
        return true;
    };

    public int obtenerModificadorDias() {
        return penalizadorDiasPrestamo;
    }

    public static int getContadorIdSocio() {
        return contadorIdSocio;
    }

    public static void setContadorIdSocio(int contadorIdSocio) {
        Socio.contadorIdSocio = contadorIdSocio;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
        logger.loguearCambios("idSocio", Integer.toString(idSocio));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        logger.loguearCambios("nombre", nombre);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
        logger.loguearCambios("apellido", apellido);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
        logger.loguearCambios("dni", dni);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        logger.loguearCambios("email", email);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
        logger.loguearCambios("telefono", telefono);
    }

    public MetodoEnvio getMetodoEnvio() {
        return metodoEnvio;
    }

    public void setMetodoEnvio(MetodoEnvio metodoEnvio) {
        this.metodoEnvio = metodoEnvio;
        logger.loguearCambios("metodoEnvio", String.valueOf(metodoEnvio));
    }

    public List<Prestamo> getPrestamosSocio() {
        return prestamosSocio;
    }

    public void setPrestamosSocio(List<Prestamo> prestamosSocio) {
        this.prestamosSocio = prestamosSocio;
        logger.loguearCambios("prestamosSocio", prestamosSocio.toString());
    }

    public void addPrestamo(Prestamo prestamo){
        prestamosSocio.add((prestamo));
    }

    public Boolean getAutenticarse() {
        return autenticarse;
    }

    public void setAutenticarse(Boolean autenticarse) {
        this.autenticarse = autenticarse;
        logger.loguearCambios("autenticarse", autenticarse.toString());
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
        logger.loguearCambios("habilitado", habilitado.toString());
    }

    public int getPrestamosPositivos() {
        return prestamosPositivos;
    }

    public void setPrestamosPositivos(int prestamosPositivos) {
        this.prestamosPositivos = prestamosPositivos;
        logger.loguearCambios("prestamosPositivos", Integer.toString(prestamosPositivos));
    }

    public int getPenalizadorDiasPrestamo() {
        return penalizadorDiasPrestamo;
    }

    public void setPenalizadorDiasPrestamo(int penalizadorDiasPrestamo) {
        this.penalizadorDiasPrestamo = penalizadorDiasPrestamo;
        logger.loguearCambios("penalizadorDiasPrestamo", Integer.toString(penalizadorDiasPrestamo));
    }

    

}