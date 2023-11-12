package controladores;

import java.util.*;

import modelos.Ejemplar;

public class ControllerEjemplar {

    private ArrayList <Ejemplar> Productos;
    private static ControllerEjemplar instancia;
    /**
     * Default constructor
     */
    public static ControllerEjemplar getInstancia() {
        if (instancia == null)
            instancia = new ControllerEjemplar();
        return instancia;
    }

    private ControllerEjemplar() {
        Productos = new ArrayList<>();
    }
  
    public int crearEjemplar(String titulo, String autor, String fechaPublicacion, String tipo) {
        // TODO implement here
        return 0;
    }

    /**
     * @param idEjemplar int 
     * @return
     */
    public String localizarEjemplar(int idEjemplar) {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public void buscarEjemplar() {
        // TODO implement here
    }

}