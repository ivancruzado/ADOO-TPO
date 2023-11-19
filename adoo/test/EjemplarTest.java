package test;

import controladores.ControllerEjemplar;
import factory.ejemplar.FactoryDiario;
import factory.ejemplar.FactoryLibro;
import factory.ejemplar.FactoryRevista;
import factory.ejemplar.FactoryRevistaEspecializada;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

class EjemplarTest {

    private ControllerEjemplar controladorEjemplar;

    @BeforeEach
    public void inicio(){
        controladorEjemplar = ControllerEjemplar.getInstancia();
    }

    @Test
    public void crearEjemplar(){
        controladorEjemplar.crearEjemplar(new FactoryRevista(), "National Geographic", "National Geographic Society", new Date());
        controladorEjemplar.crearEjemplar(new FactoryRevista(), "Time", "Time Inc.", new Date());
        controladorEjemplar.crearEjemplar(new FactoryRevista(), "The New Yorker", "Condé Nast", new Date());
        controladorEjemplar.crearEjemplar(new FactoryRevista(), "Scientific American", "Nature Publishing Group", new Date());
        controladorEjemplar.crearEjemplar(new FactoryRevista(), "Vogue", "Condé Nast", new Date());

        controladorEjemplar.crearEjemplar(new FactoryDiario(), "The New York Times", "The New York Times Company", new Date());
        controladorEjemplar.crearEjemplar(new FactoryDiario(), "The Guardian", "Guardian Media Group", new Date());
        controladorEjemplar.crearEjemplar(new FactoryDiario(), "Le Monde", "Groupe Le Monde", new Date());
        controladorEjemplar.crearEjemplar(new FactoryDiario(), "El País", "Grupo PRISA", new Date());
        controladorEjemplar.crearEjemplar(new FactoryDiario(), "Asahi Shimbun", "The Asahi Shimbun Company", new Date());

        controladorEjemplar.crearEjemplar(new FactoryLibro(), "Cien años de soledad", "Gabriel García Márquez", new Date());
        controladorEjemplar.crearEjemplar(new FactoryLibro(), "1984", "George Orwell", new Date());
        controladorEjemplar.crearEjemplar(new FactoryLibro(), "Don Quijote de la Mancha", "Miguel de Cervantes", new Date());
        controladorEjemplar.crearEjemplar(new FactoryLibro(), "Harry Potter y la piedra filosofal", "J.K. Rowling", new Date());
        controladorEjemplar.crearEjemplar(new FactoryLibro(), "Orgullo y prejuicio", "Jane Austen", new Date());

        controladorEjemplar.crearEjemplar(new FactoryRevistaEspecializada(), "Nature", "Nature Publishing Group", new Date());
        controladorEjemplar.crearEjemplar(new FactoryRevistaEspecializada(), "Science", "American Association for the Advancement of Science", new Date());
        controladorEjemplar.crearEjemplar(new FactoryRevistaEspecializada(), "The Lancet", "Elsevier", new Date());
        controladorEjemplar.crearEjemplar(new FactoryRevistaEspecializada(), "IEEE Spectrum", "Institute of Electrical and Electronics Engineers", new Date());
        controladorEjemplar.crearEjemplar(new FactoryRevistaEspecializada(), "Journal of the American Medical Association (JAMA)", "American Medical Association", new Date());

        Assertions.assertEquals(20,controladorEjemplar.getTamanioListaEjemplar());
    }

    @Test
    public void EjemplarDevuelto(){
        Boolean estado = controladorEjemplar.estadoEjemplar(1);
        //System.out.println(estado);
        controladorEjemplar.cambiarEstado(1);
        Assertions.assertFalse(estado);

    }




}