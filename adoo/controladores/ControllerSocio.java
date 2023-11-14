package controladores;

import java.util.*;

import enums.MetodoEnvio;
import modelos.Socio;
import modelos.dtos.SocioDTO;


public class ControllerSocio {

    private static ControllerSocio SINGLETON;
    private List<Socio> listaSocios;

    private ControllerSocio() {
        listaSocios = new ArrayList<>();
    }



    public static synchronized ControllerSocio getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new ControllerSocio();             //1 sola instancia
        }
        return SINGLETON;
    }

    public Socio crearSocio(String nombre, String apellido, String dni, String mail, String telefono, MetodoEnvio metodoEnvio, Boolean autenticarse, Boolean habilitado, int prestamosPositivos, int penalizadorDiasPrestamo) {
        Socio socioNuevo = new Socio(nombre,apellido,dni,mail,telefono, metodoEnvio,autenticarse,habilitado,prestamosPositivos,penalizadorDiasPrestamo);
        listaSocios.add(socioNuevo);
        return socioNuevo;
    }

    public void deshabilitarUsuario(Socio socio) {
        //int id = 0;
        for (Socio listaSocio : listaSocios) {
            if (listaSocio.toDTO().getIdSocio() == socio.toDTO().getIdSocio()) {
                socio.toDTO().setHabilitado(false);
            }
        }
    }
    public void buscarEjemplar(int idEjemplar) {  //???????
        // TODO implement here
    }

    public void solicitarPrestamo(int idEjemplar) {
        // TODO implement here
    }

    public void aumentarPrestamoPositivo(int idSocio) {
        for (Socio socio : listaSocios) {
            if (socio.toDTO().getIdSocio() == idSocio) {
                socio.toDTO().setPrestamosPositivos(socio.toDTO().getPrestamosPositivos()+1);
            }
        }
    }
}