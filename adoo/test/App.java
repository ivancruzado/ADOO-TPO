package test;

import java.util.*;

import color.ConsoleColors;

import java.lang.reflect.Array;
import java.time.Duration;
import controladores.*;
import modelos.dtos.*;
import modelos.*;
import singleton.Escaner;
import factory.ejemplar.FactoryDiario;
import factory.ejemplar.FactoryLibro;
import factory.ejemplar.FactoryRevista;
import factory.ejemplar.FactoryRevistaEspecializada;
import decorator.busqueda.*;

public class App {

    public static void main(String[] args) throws Exception {

        ControllerEjemplar controladorEjemplar = ControllerEjemplar.getInstancia();
        
        // Crea un ejemplar de Revista
        int revista = controladorEjemplar.crearEjemplar(new FactoryRevista(), "Revista A", "Autor Revista", new Date());
            // Crea un ejemplar de Diario
        int diario = controladorEjemplar.crearEjemplar(new FactoryDiario(), "Diario A", "Autor Diario", new Date());

        int libro = controladorEjemplar.crearEjemplar(new FactoryLibro(), "Libro A", "Autor Libro", new Date());

        controladorEjemplar.crearEjemplar(new FactoryLibro(), "Libro B", "Autor LibroB", new Date());

        int tiempoPrestamoRevista = controladorEjemplar.tiempoPrestamo(revista);
        int tiempoPrestamoDiario = controladorEjemplar.tiempoPrestamo(diario);
        int tiempoPrestamoLibro = controladorEjemplar.tiempoPrestamo(libro);

        System.out.println("Tiempo de préstamo de la Revista: " + tiempoPrestamoRevista + " días");
        System.out.println("Tiempo de préstamo del Diario: " + tiempoPrestamoDiario + " días");
        System.out.println("Tiempo de préstamo del Libro: " + tiempoPrestamoLibro + " días");

        System.out.println("Categoría de la Revista: " + controladorEjemplar.categoria(revista));
        System.out.println("Categoría del Diario: " + controladorEjemplar.categoria(diario));
        System.out.println("Categoría del Libro: " + controladorEjemplar.categoria(libro));


        Busqueda buscarAutor = new BusquedaAutor(controladorEjemplar.listadoEjemplares());
        ArrayList<EjemplarDTO> ejemplaresEncontrados = buscarAutor.buscarEjemplar("Autor Diario");

        System.out.println("Ejemplares encontrados: ");
        for (EjemplarDTO ejemplarDTO : ejemplaresEncontrados) {
            System.out.println(ejemplarDTO.getTitulo());
        }

        Busqueda buscarTitulo = new BusquedaTitulo(controladorEjemplar.listadoEjemplares());
        ejemplaresEncontrados = buscarTitulo.buscarEjemplar("Libro A");

        System.out.println("Ejemplares encontrados: ");
        for (EjemplarDTO ejemplarDTO : ejemplaresEncontrados) {
            System.out.println(ejemplarDTO.getTitulo());
        }

        Busqueda buscarCategoria = new BusquedaCategoria(controladorEjemplar.listadoEjemplares());
        ejemplaresEncontrados = buscarCategoria.buscarEjemplar("Libro");

        System.out.println("Ejemplares encontrados: ");
        for (EjemplarDTO ejemplarDTO : ejemplaresEncontrados) {
            System.out.println(ejemplarDTO.getTitulo());
        }


    }
}
