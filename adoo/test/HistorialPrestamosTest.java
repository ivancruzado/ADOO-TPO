package test;

import controladores.ControllerEjemplar;
import controladores.ControllerSocio;
import enums.MetodoEnvio;
import factory.ejemplar.FactoryLibro;
import modelos.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class HistorialPrestamosTest {

    @Test
    void getHistorialPrestamos() {
        ControllerEjemplar controllerEjemplar =  ControllerEjemplar.getInstancia();
        int e1 = controllerEjemplar.crearEjemplar(new FactoryLibro(), "Cien años de soledad", "Gabriel García Márquez", new Date());
        int e2 = controllerEjemplar.crearEjemplar(new FactoryLibro(), "1984", "George Orwell", new Date());
        int e3 = controllerEjemplar.crearEjemplar(new FactoryLibro(), "Don Quijote de la Mancha", "Miguel de Cervantes", new Date());

        ControllerSocio controllerSocio = ControllerSocio.getInstancia();
        int id_socio = controllerSocio.crearSocio("aa","as","123","a@a.com","123", MetodoEnvio.Email, new Logger(new ArrayList<>()));
        controllerSocio.solicitarPrestamo(new Date(),"motivo 1",id_socio,e1);
        controllerSocio.solicitarPrestamo(new Date(),"motivo 2",id_socio,e2);
        controllerSocio.solicitarPrestamo(new Date(),"motivo 3",id_socio,e3);

        assertEquals(3, controllerSocio.getHistorialPrestamos(id_socio).size());
    }
}