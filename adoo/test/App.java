package test;

import java.util.*;

import color.ConsoleColors;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;

import controladores.*;
import modelos.dtos.*;
import modelos.*;
import singleton.Escaner;
import factory.ejemplar.FactoryDiario;
import factory.ejemplar.FactoryLibro;
import factory.ejemplar.FactoryRevista;
import factory.ejemplar.FactoryRevistaEspecializada;
import decorator.busqueda.*;
import enums.MetodoEnvio;

public class App {

    public static void main(String[] args) throws Exception {

        ControllerEjemplar controladorEjemplar = ControllerEjemplar.getInstancia();

        ControllerPrestamo controladorPrestamo = ControllerPrestamo.getInstancia();

        ControllerSocio controladorSocio = ControllerSocio.getInstancia();
        
        // Crea un ejemplar de Revista
        // int revista = controladorEjemplar.crearEjemplar(new FactoryRevista(), "Revista A", "Autor Revista", new Date());
        //     // Crea un ejemplar de Diario
        // int diario = controladorEjemplar.crearEjemplar(new FactoryDiario(), "Diario A", "Autor Diario", new Date());

        // int libro = controladorEjemplar.crearEjemplar(new FactoryLibro(), "Libro A", "Autor Libro", new Date());

        // int revistaEspecializada = controladorEjemplar.crearEjemplar(new FactoryRevistaEspecializada(), "Revista Especializada A", "Autor Revista Especializada", new Date());

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        ArrayList<Integer> ejemplares = new ArrayList<>();

            // Crear ejemplares de libros y revistas reales
        ejemplares.add(controladorEjemplar.crearEjemplar(new FactoryRevista(), "National Geographic", "National Geographic Society", formatoFecha.parse("01/01/2018")));
        ejemplares.add(controladorEjemplar.crearEjemplar(new FactoryRevista(), "Time", "Time Inc.", formatoFecha.parse("01/01/2019")));
        ejemplares.add(controladorEjemplar.crearEjemplar(new FactoryRevista(), "The New Yorker", "Condé Nast", formatoFecha.parse("01/01/2020")));
        ejemplares.add(controladorEjemplar.crearEjemplar(new FactoryRevista(), "Scientific American", "Nature Publishing Group", formatoFecha.parse("01/01/2021")));
        ejemplares.add(controladorEjemplar.crearEjemplar(new FactoryRevista(), "Vogue", "Condé Nast", formatoFecha.parse("01/01/2022")));

        ejemplares.add(controladorEjemplar.crearEjemplar(new FactoryDiario(), "The New York Times", "The New York Times Company", formatoFecha.parse("02/02/2018")));
        ejemplares.add(controladorEjemplar.crearEjemplar(new FactoryDiario(), "The Guardian", "Guardian Media Group", formatoFecha.parse("02/02/2019")));
        ejemplares.add(controladorEjemplar.crearEjemplar(new FactoryDiario(), "Le Monde", "Groupe Le Monde", formatoFecha.parse("02/02/2020")));
        ejemplares.add(controladorEjemplar.crearEjemplar(new FactoryDiario(), "El País", "Grupo PRISA", formatoFecha.parse("02/02/2021")));
        ejemplares.add(controladorEjemplar.crearEjemplar(new FactoryDiario(), "Asahi Shimbun", "The Asahi Shimbun Company", formatoFecha.parse("02/02/2022")));

        ejemplares.add(controladorEjemplar.crearEjemplar(new FactoryLibro(), "Cien años de soledad", "Gabriel García Márquez", formatoFecha.parse("03/03/2018")));
        ejemplares.add(controladorEjemplar.crearEjemplar(new FactoryLibro(), "1984", "George Orwell", formatoFecha.parse("03/03/2019")));
        ejemplares.add(controladorEjemplar.crearEjemplar(new FactoryLibro(), "Don Quijote de la Mancha", "Miguel de Cervantes", formatoFecha.parse("03/03/2020")));
        ejemplares.add(controladorEjemplar.crearEjemplar(new FactoryLibro(), "Harry Potter y la piedra filosofal", "J.K. Rowling", formatoFecha.parse("03/03/2021")));
        ejemplares.add(controladorEjemplar.crearEjemplar(new FactoryLibro(), "Orgullo y prejuicio", "Jane Austen", formatoFecha.parse("03/03/2022")));

        ejemplares.add(controladorEjemplar.crearEjemplar(new FactoryRevistaEspecializada(), "Nature", "Nature Publishing Group", formatoFecha.parse("04/04/2018")));
        ejemplares.add(controladorEjemplar.crearEjemplar(new FactoryRevistaEspecializada(), "Science", "American Association for the Advancement of Science", formatoFecha.parse("04/04/2019")));
        ejemplares.add(controladorEjemplar.crearEjemplar(new FactoryRevistaEspecializada(), "The Lancet", "Elsevier", formatoFecha.parse("04/04/2020")));
        ejemplares.add(controladorEjemplar.crearEjemplar(new FactoryRevistaEspecializada(), "IEEE Spectrum", "Institute of Electrical and Electronics Engineers", formatoFecha.parse("04/04/2021")));
        ejemplares.add(controladorEjemplar.crearEjemplar(new FactoryRevistaEspecializada(), "Journal of the American Medical Association (JAMA)", "American Medical Association", formatoFecha.parse("04/04/2022")));

        controladorEjemplar.crearEjemplar(new FactoryLibro(), "Libro B", "Autor LibroB", new Date());

        for (Integer ejemplar : ejemplares) {
            System.out.println(controladorEjemplar.titulo(ejemplar) + " de " + controladorEjemplar.autor(ejemplar) + ". Este ejemplar es un/a: " + controladorEjemplar.categoria(ejemplar) + " y su tiempo de prestamo es de " + controladorEjemplar.tiempoPrestamo(ejemplar) + " días." + "\n");
        }


        Busqueda buscarAutor = new BusquedaAutor(controladorEjemplar.listadoEjemplares());
        ArrayList<EjemplarDTO> ejemplaresEncontrados = buscarAutor.buscarEjemplar("Miguel");

        System.out.println("\nBusqueda por Autor: Ejemplares encontrados: ");
        for (EjemplarDTO ejemplarDTO : ejemplaresEncontrados) {
            System.out.println(ejemplarDTO.getTitulo());
        }

        Busqueda buscarTitulo = new BusquedaTitulo(controladorEjemplar.listadoEjemplares());
        ejemplaresEncontrados = buscarTitulo.buscarEjemplar("la");

        System.out.println("\nBusqueda por Titulo: Ejemplares encontrados: ");
        for (EjemplarDTO ejemplarDTO : ejemplaresEncontrados) {
            System.out.println(ejemplarDTO.getTitulo());
        }

        Busqueda buscarCategoria = new BusquedaCategoria(controladorEjemplar.listadoEjemplares());
        ejemplaresEncontrados = buscarCategoria.buscarEjemplar("Revista");

        System.out.println("\nBusqueda por Categoria: Ejemplares encontrados: ");
        for (EjemplarDTO ejemplarDTO : ejemplaresEncontrados) {
            System.out.println(ejemplarDTO.getTitulo());
        }

        Busqueda buscarFechaPublicacion = new BusquedaFechaPublicacion(controladorEjemplar.listadoEjemplares());
        ejemplaresEncontrados = buscarFechaPublicacion.buscarEjemplar(formatoFecha.parse("01/01/2018"));

        System.out.println("\nBusqueda por Fecha de Publicacion: Ejemplares encontrados: ");
        for (EjemplarDTO ejemplarDTO : ejemplaresEncontrados) {
            System.out.println(ejemplarDTO.getTitulo());
        }

        // Crea un socio
        int socio = controladorSocio.crearSocio("Manuel", "Vidal", "12345678", "manvidal@uade.edu.ar", "12345678", MetodoEnvio.Email);

        controladorSocio.estadoSocio(socio);

        int prestamo = controladorSocio.solicitarPrestamo(new Date(), "Tengo un motivo", socio, ejemplares.get(0));

        System.out.println("El prestamo es de: " + controladorSocio.nombre(controladorPrestamo.socio(prestamo)));
        



        //System.out.println("Fecha revista: " + controladorEjemplar.fecha(revista));        

    }
}
