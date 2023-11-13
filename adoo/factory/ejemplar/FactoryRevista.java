package factory.ejemplar;

import java.util.*;
import modelos.Ejemplar;

public class FactoryRevista implements FactoryEjemplar {

    private int tiempoPrestamo = 5;

    public Ejemplar crearEjemplar(String titulo, String autor, Date fechaPublicacion) {
        return new Revista(titulo, autor, fechaPublicacion, this.tiempoPrestamo);
    }

}