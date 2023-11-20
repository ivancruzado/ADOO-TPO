package factory.ejemplar;

import java.util.*;
import modelos.Ejemplar;

public class FactoryRevistaEspecializada implements FactoryEjemplar {

    private int tiempoPrestamo = 5;

    public Ejemplar crearEjemplar(String titulo, String autor, Date fechaPublicacion) {
        return new RevistaEspecializada(titulo, autor, fechaPublicacion, this.tiempoPrestamo);
    }

    public String setTiempoPrestamo(int tiempoPrestamo) {
        this.tiempoPrestamo = tiempoPrestamo;
        return "Revista Especializada";
    }
}