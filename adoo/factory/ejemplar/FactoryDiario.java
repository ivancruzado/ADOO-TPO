package factory.ejemplar;

import java.util.*;
import modelos.Ejemplar;

public class FactoryDiario implements FactoryEjemplar {
    private int tiempoPrestamo = 5;

    public Ejemplar crearEjemplar(String titulo, String autor, Date fechaPublicacion) {
        return new Diario(titulo, autor, fechaPublicacion, this.tiempoPrestamo);
    }

    public String setTiempoPrestamo(int tiempoPrestamo) {
        this.tiempoPrestamo = tiempoPrestamo;
        return "Diario";
    }
}