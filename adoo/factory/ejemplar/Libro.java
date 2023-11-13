package factory.ejemplar;

import java.util.*;
import modelos.Ejemplar;

public class Libro extends Ejemplar {

    public Libro(String titulo, String autor, Date fechaPublicacion, int tiempoPrestamo) {
        super(titulo, autor, fechaPublicacion, tiempoPrestamo);
    }
}