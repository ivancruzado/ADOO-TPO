package test;

import controladores.ControllerSocio;
import enums.MetodoEnvio;
import modelos.Logger;
import modelos.Socio;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {

    @org.junit.jupiter.api.Test
    void loguearCambios() {
        interfaz.ILogger logger = new Logger(new ArrayList<>());
        ControllerSocio controllerSocio = ControllerSocio.getInstancia();
        int id_socio = controllerSocio.crearSocio("aa","as","123","a@a.com","123",MetodoEnvio.Email, logger);
        controllerSocio.modificarTelefonoSocio(id_socio, "1111111111");
        controllerSocio.modificarMailSocio(id_socio, "b@a.com");
        controllerSocio.modificarMetodoEnvioSocio(id_socio, MetodoEnvio.SMS);
        assertEquals(3, logger.getCambios().size());
        System.out.print(logger.getCambios());
    }
}