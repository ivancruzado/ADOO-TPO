package factory.ejemplar;

import java.util.*;
import modelos.Ejemplar;

public class RevistaEspecializada extends Ejemplar {

    public RevistaEspecializada(String titulo, String autor, Date fechaPublicacion, int tiempoPrestamo) {
        super(titulo, autor, fechaPublicacion, tiempoPrestamo, "Revista Especializada");
    }
}