package factory.ejemplar;

import java.util.*;
import modelos.Ejemplar;


public class Diario extends Ejemplar {
    
    public Diario(String titulo, String autor, Date fechaPublicacion, int tiempoPrestamo) {
        super(titulo, autor, fechaPublicacion, tiempoPrestamo);
    }

}