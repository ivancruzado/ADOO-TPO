package modelos;

import java.util.*;

//import IAutenticacion;
import enums.MetodoEnvio;
import modelos.dtos.SocioDTO;

/**
 * 
 */
public class Socio {
 
    private static int contadorIdSocio = 1; // Autoincremental

    //private Hashmap historial_prestamos;
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

    public Socio(int idSocio, String nombre, String apellido, String dni, String email, String telefono, MetodoEnvio metodoEnvio, Boolean autenticarse, Boolean habilitado, int prestamosPositivos, int penalizadorDiasPrestamo) {
        this.idSocio = contadorIdSocio++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.metodoEnvio = metodoEnvio;
        //this.prestamos = prestamos;       //Se crea sin prestamos
        this.autenticarse = autenticarse;
        this.habilitado = habilitado;
        this.prestamosPositivos = prestamosPositivos;
        this.penalizadorDiasPrestamo = penalizadorDiasPrestamo;
    }
   
    public SocioDTO toDTO() {
        return new SocioDTO(this.idSocio, this.nombre, this.apellido, this.dni, this.email, this.telefono, this.metodoEnvio, this.prestamos, this.autenticarse, this.habilitado, this.prestamosPositivos, this.penalizadorDiasPrestamo);
    }




    public Ejemplar buscarProducto() {
        // TODO implement here
        return null;
    }

    /**
     * @param idProducto int 
     * @return
     */
    public void solicitarPrestamo(int idProducto) {
        // TODO implement here
    }

    /**
     * @param idSocio 
     * @return
     */
    public Boolean autenticarse(int idSocio) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int obtenerModificadorDias() {
        // TODO implement here
        return 0;
    }

    /**
     * 
     */
    public void IniciarSesion() {
        // TODO implement here
    }

    /**
     * 
     */
    public void Registro() {
        // TODO implement here
    }

    /**
     * 
     */
    public void Log() {
        // TODO implement here
    }

}