package test;

import java.util.*;
import java.util.ResourceBundle.Control;

import color.ConsoleColors;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;

import controladores.*;
import enums.MotivoNotificacion;
import estrategias.notificador.Email;
import estrategias.notificador.EstrategiaNotificador;
import estrategias.notificador.SMS;
import estrategias.notificador.Whatsapp;
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
        FactoryRevista revista = new FactoryRevista();
        ControllerEjemplar controladorEjemplar = ControllerEjemplar.getInstancia();
        ControllerPrestamo controladorPrestamo = ControllerPrestamo.getInstancia();
        ControllerSocio controladorSocio = ControllerSocio.getInstancia();
        Escaner controladorScanner = Escaner.getInstancia();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setLenient(false);
        ArrayList<Integer> ejemplares = new ArrayList<>();
        String input, modo;
        

        System.out.println("Utilizar modo ejemplo? (S/N)");
        while(!(modo = controladorScanner.proxLinea().toUpperCase()).equals("S") && !modo.equals("N")){ 
            System.out.println("Utilizar modo ejemplo? (S/N)");
        }

        // Crear ejemplares
        cargarEjemplares(controladorEjemplar, controladorScanner, formatoFecha, ejemplares, revista);
        crearHistorialPrestamos(controladorEjemplar, controladorSocio, formatoFecha);
        //Modificar tiempo para Revistas

        controladorEjemplar.modificarTiempoEjemplar(revista, 50);

        System.out.println(controladorEjemplar.tiempoPrestamo(1));

        System.out.println(controladorEjemplar.tiempoPrestamo(controladorEjemplar.crearEjemplar(revista, "National Geographic", "National Geographic Society", formatoFecha.parse("01/01/2018"))));

        /////////////

        busqueda(controladorEjemplar, controladorScanner, formatoFecha, modo);

        visualizarHistorial(controladorSocio, controladorScanner);
        
        
        // Crea un socio
        int socio = controladorSocio.crearSocio("Manuel", "Vidal", "12345678", "manvidal@uade.edu.ar", "12345678", MetodoEnvio.Email, new Logger(new ArrayList<>()));

        controladorSocio.estadoSocio(socio);

        int prestamo = controladorSocio.solicitarPrestamo(new Date(), "Tengo un motivo", socio, ejemplares.get(0));

        System.out.println("El prestamo es de: " + controladorSocio.nombre(controladorPrestamo.socio(prestamo)));
        
        System.out.println(controladorEjemplar.localizarEjemplar(ejemplares.get(0)));

        //Quién tiene el ejemplar
        System.out.println(controladorSocio.nombre(controladorPrestamo.socio(controladorPrestamo.encontrarEjemplar(ejemplares.get(0)))));

        //System.out.println("Fecha revista: " + controladorEjemplar.fecha(revista));


        //enviar notificacion segun metodo elegido por el socio
        enviarNotificacion(2,"Prestamo proximo a vencer",MotivoNotificacion.fechaDeVencimientoProxima);
        
        
    }









    public static void cargarEjemplares(ControllerEjemplar controladorEjemplar, Escaner controladorScanner, SimpleDateFormat formatoFecha, ArrayList<Integer> ejemplares, FactoryRevista revista) throws Exception{
        ejemplares.add(controladorEjemplar.crearEjemplar(revista, "National Geographic", "National Geographic Society", formatoFecha.parse("01/01/2018")));
        ejemplares.add(controladorEjemplar.crearEjemplar(revista, "Time", "Time Inc.", formatoFecha.parse("01/01/2019")));
        ejemplares.add(controladorEjemplar.crearEjemplar(revista, "The New Yorker", "Condé Nast", formatoFecha.parse("01/01/2020")));
        ejemplares.add(controladorEjemplar.crearEjemplar(revista, "Scientific American", "Nature Publishing Group", formatoFecha.parse("01/01/2021")));
        ejemplares.add(controladorEjemplar.crearEjemplar(revista, "Vogue", "Condé Nast", formatoFecha.parse("01/01/2022")));

        FactoryDiario diario= new FactoryDiario();
        ejemplares.add(controladorEjemplar.crearEjemplar(diario, "The New York Times", "The New York Times Company", formatoFecha.parse("02/02/2018")));
        ejemplares.add(controladorEjemplar.crearEjemplar(diario, "The Guardian", "Guardian Media Group", formatoFecha.parse("02/02/2019")));
        ejemplares.add(controladorEjemplar.crearEjemplar(diario, "Le Monde", "Groupe Le Monde", formatoFecha.parse("02/02/2020")));
        ejemplares.add(controladorEjemplar.crearEjemplar(diario, "El País", "Grupo PRISA", formatoFecha.parse("02/02/2021")));
        ejemplares.add(controladorEjemplar.crearEjemplar(diario, "Asahi Shimbun", "The Asahi Shimbun Company", formatoFecha.parse("02/02/2022")));

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

        
        System.out.println(ConsoleColors.BLUE_BOLD + "---------------------Listado de ejemplares---------------------" + ConsoleColors.RESET);
        controladorScanner.proxLinea();
        for (Integer ejemplar : ejemplares) {
            System.out.println(controladorEjemplar.titulo(ejemplar) + " de " + controladorEjemplar.autor(ejemplar) + ". Este ejemplar es un/a: " + controladorEjemplar.categoria(ejemplar) + " y su tiempo de prestamo es de " + controladorEjemplar.tiempoPrestamo(ejemplar) + " días." + "\n");
        }
    }


    public static void crearHistorialPrestamos(ControllerEjemplar controllerEjemplar, ControllerSocio controllerSocio, SimpleDateFormat formatoFecha) throws Exception {

        int e1 = controllerEjemplar.crearEjemplar(new FactoryLibro(), "Cien años de soledad", "Gabriel García Márquez", formatoFecha.parse("02/02/2018"));
        int e2 = controllerEjemplar.crearEjemplar(new FactoryLibro(), "1984", "George Orwell", formatoFecha.parse("02/02/2019"));
        int e3 = controllerEjemplar.crearEjemplar(new FactoryLibro(), "Don Quijote de la Mancha", "Miguel de Cervantes", formatoFecha.parse("02/02/2020"));


        int id_socio = controllerSocio.crearSocio("aa", "as", "123", "a@a.com", "123", MetodoEnvio.Email, new Logger(new ArrayList<>()));
        controllerSocio.solicitarPrestamo(new Date(), "motivo 1", id_socio, e1);
        controllerSocio.solicitarPrestamo(new Date(), "motivo 2", id_socio, e2);
        controllerSocio.solicitarPrestamo(new Date(), "motivo 3", id_socio, e3);

    }


    public static void busqueda(ControllerEjemplar controladorEjemplar, Escaner controladorScanner, SimpleDateFormat formatoFecha, String modo) throws Exception{
        String input;
        ArrayList<EjemplarDTO> ejemplaresEncontrados;
        System.out.println(ConsoleColors.BLUE_BOLD + "---------------------Busqueda por Autor---------------------" + ConsoleColors.RESET);
        System.out.println("Ingrese el autor a buscar: ");
        input = controladorScanner.proxLinea();
        
        if(modo.equals("S")){
            System.out.println("Ejemplo: Miguel");
            input = "Miguel";
        }
            

        Busqueda buscarAutor = new BusquedaAutor(controladorEjemplar.listadoEjemplares());
        ejemplaresEncontrados = buscarAutor.buscarEjemplar(input);

        System.out.println("Ejemplares encontrados: ");
        for (EjemplarDTO ejemplarDTO : ejemplaresEncontrados) {
            System.out.println(ejemplarDTO.getTitulo());
        }

        
        System.out.println(ConsoleColors.BLUE_BOLD + "---------------------Busqueda por Titulo---------------------" + ConsoleColors.RESET);
        System.out.println("Ingrese el titulo a buscar: ");
        input = controladorScanner.proxLinea();
        
        if(modo.equals("S")){
            System.out.println("Ejemplo: " + ConsoleColors.GREEN + "la" + ConsoleColors.RESET);
            input = "la";
        }
        
        Busqueda buscarTitulo = new BusquedaTitulo(controladorEjemplar.listadoEjemplares());
        ejemplaresEncontrados = buscarTitulo.buscarEjemplar(input);

        System.out.println("Ejemplares encontrados: ");
        for (EjemplarDTO ejemplarDTO : ejemplaresEncontrados) {
            System.out.println(ConsoleColors.GREEN_BOLD + ejemplarDTO.getTitulo() + ConsoleColors.RESET);
        }

        System.out.println(ConsoleColors.BLUE_BOLD + "---------------------Busqueda por Categoria---------------------" + ConsoleColors.RESET);
        System.out.println("Ingrese la categoria a buscar: Diario / Libro / Revista / Revista Especializada");
        input = controladorScanner.proxLinea();
        
        if(modo.equals("S")){
            System.out.println("Ejemplo: " + ConsoleColors.GREEN_BOLD + "Revista" + ConsoleColors.RESET);
            input = "Revista Esp";
        }        

        Busqueda buscarCategoria = new BusquedaCategoria(controladorEjemplar.listadoEjemplares());
        ejemplaresEncontrados = buscarCategoria.buscarEjemplar(input);

        System.out.println("Busqueda por Categoria: Ejemplares encontrados: ");
        for (EjemplarDTO ejemplarDTO : ejemplaresEncontrados) {
            System.out.println(ConsoleColors.GREEN_BOLD + ejemplarDTO.getTitulo() + ConsoleColors.RESET);
        }

        System.out.println(ConsoleColors.BLUE_BOLD + "---------------------Busqueda por Fecha---------------------" + ConsoleColors.RESET);
        System.out.println("Ingrese la fecha a buscar: formato dd/mm/yyyy");
        input = controladorScanner.proxLinea();
        
        if(modo.equals("S")){
            System.out.println("Ejemplo: " + ConsoleColors.GREEN_BOLD + "01/01/2018" + ConsoleColors.RESET);
            input = "01/01/2018";
        }

        Busqueda buscarFechaPublicacion = new BusquedaFechaPublicacion(controladorEjemplar.listadoEjemplares());
        ejemplaresEncontrados = buscarFechaPublicacion.buscarEjemplar(formatoFecha.parse(input));

        System.out.println("Busqueda por Fecha de Publicacion: Ejemplares encontrados: ");
        for (EjemplarDTO ejemplarDTO : ejemplaresEncontrados) {
            System.out.println(ejemplarDTO.getTitulo());
        }
    }






    public static void visualizarHistorial(ControllerSocio controllerSocio, Escaner controladorScanner) throws Exception{
        System.out.println(ConsoleColors.BLUE_BOLD + "---------------------Historial de Prestamos---------------------" + ConsoleColors.RESET);
        System.out.println("Ingrese el id del socio: ");
        String id = controladorScanner.proxLinea();
        int idSocio = Integer.parseInt(id);
        List<Prestamo> prestamos = controllerSocio.getHistorialPrestamos(idSocio);
        for (Prestamo prestamo : prestamos) {
            System.out.println("El usuario tiene: " + prestamos.size() + " Prestamos. " + "Fecha prestamo: " + prestamo.getFechaPrestamo() + " - Fecha devolucion: "+  prestamo.getFechaDevolucion());
        }

    }

    public static void enviarNotificacion(int IdSocio,String mensaje,MotivoNotificacion motivo){

        SocioDTO socio = null;
        for (SocioDTO socioDTO : ControllerSocio.getInstancia().getSociosDTO()) {
            if(socioDTO.getIdSocio() == IdSocio){
                socio = socioDTO;
            }
        }
        if(socio != null){
            MetodoEnvio metodoEnvio = ControllerSocio.getInstancia().metodoEnvio(IdSocio);
            NotificadorDTO noti = new NotificadorDTO(mensaje,new Date(), motivo,socio);
            if(metodoEnvio == MetodoEnvio.SMS ){
                EstrategiaNotificador estrategia = new SMS();
                estrategia.enviarNotificacion(noti);
            }
            else if(metodoEnvio == MetodoEnvio.Email ){
                EstrategiaNotificador estrategia = new Email();
                estrategia.enviarNotificacion(noti);
            }
            else if(metodoEnvio == MetodoEnvio.Whatsapp ){
                EstrategiaNotificador estrategia = new Whatsapp();
                estrategia.enviarNotificacion(noti);
        }}
        else{
            System.out.println("No se puede enviar. El usuario no existe");
        }

    }
}
