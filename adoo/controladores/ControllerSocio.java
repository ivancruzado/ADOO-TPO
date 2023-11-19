package controladores;

import java.util.*;

import color.ConsoleColors;
import enums.MetodoEnvio;
import modelos.Ejemplar;
import modelos.Logger;
import modelos.Socio;
import modelos.dtos.SocioDTO;


public class ControllerSocio {


    private static ControllerSocio instancia;
    private static List<Socio> socios;

    private ControllerSocio() {
        socios = new ArrayList<>();
    }

    public static ControllerSocio getInstancia() {
        if (instancia == null) {
            instancia = new ControllerSocio();//1 sola instancia
        }
        return instancia;
    }



    public int crearSocio(String nombre, String apellido, String dni, String mail, String telefono, MetodoEnvio metodoEnvio, interfaz.ILogger logger) {
        Socio socioNuevo = new Socio(nombre,apellido,dni,mail,telefono, metodoEnvio, logger);
        socios.add(socioNuevo);
        return socioNuevo.getIdSocio();
    }

    public void deshabilitarUsuario(int idSocio) {
        Socio socio = buscaSocio(idSocio);
        socio.setHabilitado(false);
    }

    public void habilitarUsuario(int idSocio) {
        Socio socio = buscaSocio(idSocio);
        socio.setHabilitado(true);
    }



    public int getTamanioLista(){
        return socios.size();
    }

    public void estadoSocio(int idSocio){
        Socio socio = buscaSocio(idSocio);
        if (socio.getHabilitado())
            System.out.println("El socio está " + ConsoleColors.GREEN_BOLD + "HABILITADO" + ConsoleColors.RESET);
        else
            System.out.println("El socio está " + ConsoleColors.RED_BOLD + "DESHABILITADO" + ConsoleColors.RESET);
    }

    public Boolean habilitado(int idSocio) {
        Socio socio = buscaSocio(idSocio);
        return socio.getHabilitado();
    }

    private Socio buscaSocio(int idSocio){
        for (Socio socio : socios) {
            if (socio.getIdSocio() == idSocio)
                return socio;
        }
        return null;
    }

    public void buscarEjemplar(int idEjemplar) {
        // TODO implement here
    }


    public String nombre(int idSocio) {
        Socio socio = buscaSocio(idSocio);
        if (socio == null)
            return "No existe el socio";
        return socio.getNombre();
    }

    public void aumentarPrestamoPositivo(int idSocio) {
        for (Socio socio : socios) {
            if (socio.getIdSocio() == idSocio) {
                socio.setPrestamosPositivos(socio.getPrestamosPositivos()+1);
            }
        }
    }

    public int GetPrestamoPositivo(int idSocio) {
        for (Socio socio : socios) {
            if (socio.getIdSocio() == idSocio) {
                return buscaSocio(idSocio).getPrestamosPositivos();
            }
        }
        return -1;
    }


    
    public int solicitarPrestamo(Date fechaPrestamo, String motivo, int idSocio, int idEjemplar) {
        return ControllerPrestamo.getInstancia().solicitarPrestamo(fechaPrestamo, motivo, idSocio, idEjemplar);
    }
}