package factory.ejemplar;

import java.util.*;
import modelos.Ejemplar;

public interface FactoryEjemplar {

    Ejemplar crearEjemplar(String titulo, String autor, Date fechaPublicacion);

    
}