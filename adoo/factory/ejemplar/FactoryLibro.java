package factory.ejemplar;

import java.util.*;
import modelos.Ejemplar;

public class FactoryLibro implements FactoryEjemplar {

    private int tiempoPrestamo = 10;

    public Ejemplar crearEjemplar(String titulo, String autor, Date fechaPublicacion) {
        return new Libro(titulo, autor, fechaPublicacion, this.tiempoPrestamo);
    }

}