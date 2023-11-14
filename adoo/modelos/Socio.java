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
    private Boolean autenticarse;
    private Boolean habilitado;
    private int prestamosPositivos;
    private int penalizadorDiasPrestamo = 0;

    public Socio(String nombre, String apellido, String dni, String email, String telefono, MetodoEnvio metodoEnvio, Boolean autenticarse, Boolean habilitado, int prestamosPositivos, int penalizadorDiasPrestamo) {
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
        return new SocioDTO(this.idSocio, this.nombre, this.apellido, this.dni, this.email, this.telefono, this.metodoEnvio, this.prestamosSocio, this.autenticarse, this.habilitado, this.prestamosPositivos, this.penalizadorDiasPrestamo);
    }

    public Boolean autenticarse(int idSocio) {
        return true;
    };

    public int obtenerModificadorDias() {
        return penalizadorDiasPrestamo;
    }

}