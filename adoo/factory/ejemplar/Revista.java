package factory.ejemplar;

import java.util.*;
import modelos.Ejemplar;

public class Revista extends Ejemplar {
    
    public Revista(String titulo, String autor, Date fechaPublicacion, int tiempoPrestamo) {
        super(titulo, autor, fechaPublicacion, tiempoPrestamo, "Revista");
    }
}