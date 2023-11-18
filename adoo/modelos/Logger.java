package modelos;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 */
public class Logger implements interfaz.ILogger {
    private ArrayList<String> cambios;
    /**
     * Default constructor
     */
    public Logger(ArrayList<String> cambios) {
        this.cambios = cambios;
    }

    public ArrayList<String> getCambios() {
        return cambios;
    }

    /**
     * @return
     */
    public void loguearCambios(String field, String data) {
        // TODO implement here
        String cambio = field + ";" + data + ";" + new Date();
        cambios.add(cambio);
        System.out.println(cambio);
    }


}