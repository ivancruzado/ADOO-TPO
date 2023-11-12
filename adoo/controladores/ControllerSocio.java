package controladores;

import java.util.*;
import modelos.Socio;
import modelos.dtos.SocioDTO;
/**
 * 
 */
public class ControllerSocio {

    /**
     * Default constructor
     */
    public ControllerSocio() {
    }

    /**
     * 
     */
    private ControllerSocio instance;

    /**
     * 
     */
    private ArrayList<Socio> socios;

    /**
     * @return
     */
    public ControllerSocio getInstance() {
        // TODO implement here
        return null;
    }

    /**
     * @param nombre 
     * @param apellido 
     * @param dni 
     * @param mail 
     * @param telefono 
     * @return
     */
    public int crearSocio(String nombre, String apellido, String dni, String mail, String telefono) {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public void deshabilitarUsuario() {
        // TODO implement here
    }

    /**
     * @param variable Tipo 
     * @return
     */
    public void buscarEjemplar() {
        // TODO implement here
    }

    /**
     * @param idEjemplar int 
     * @return
     */
    public void solicitarPrestamo(int idEjemplar) {
        // TODO implement here
    }

    /**
     * @param idSocio 
     * @return
     */
    public void aumentarPrestamoPositivo(int idSocio) {
        // TODO implement here
    }

}