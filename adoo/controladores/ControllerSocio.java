package controladores;

import java.util.*;

import enums.MetodoEnvio;
import modelos.Ejemplar;
import modelos.Socio;
import modelos.dtos.SocioDTO;


public class ControllerSocio {

    private static ControllerSocio instancia;
    private List<Socio> socios;

    private ControllerSocio() {
        socios = new ArrayList<>();
    }



    public static synchronized ControllerSocio getInstance() {
        if (instancia == null) {
            instancia = new ControllerSocio();             //1 sola instancia
        }
        return instancia;
    }

    public Socio crearSocio(String nombre, String apellido, String dni, String mail, String telefono, MetodoEnvio metodoEnvio, Boolean autenticarse, Boolean habilitado, int prestamosPositivos, int penalizadorDiasPrestamo) {
        Socio socioNuevo = new Socio(nombre,apellido,dni,mail,telefono, metodoEnvio,autenticarse,habilitado,prestamosPositivos,penalizadorDiasPrestamo);
        socios.add(socioNuevo);
        return socioNuevo;
    }

    public void deshabilitarUsuario(int idSocio) {
        Socio socio = buscaSocio(idSocio);
        socio.setHabilitado(false);
    }

    public void habilitarUsuario(int idSocio) {
        Socio socio = buscaSocio(idSocio);
        socio.setHabilitado(true);
    }

    private Socio buscaSocio(int idSocio){
        for (Socio socio : this.socios) {
            if (socio.getIdSocio() == idSocio)
                return socio;
        }
        return null;
    }

    public void buscarEjemplar(int idEjemplar) {
        // TODO implement here
    }

    public void solicitarPrestamo(int idSocio, int idEjemplar) {
        
    }

    public void aumentarPrestamoPositivo(int idSocio) {
        for (Socio socio : socios) {
            if (socio.toDTO().getIdSocio() == idSocio) {
                socio.toDTO().setPrestamosPositivos(socio.toDTO().getPrestamosPositivos()+1);
            }
        }
    }
}