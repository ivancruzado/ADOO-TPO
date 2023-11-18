package test;

import enums.MetodoEnvio;
import modelos.Logger;
import modelos.Socio;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {

    @org.junit.jupiter.api.Test
    void loguearCambios() {
        interfaz.ILogger logger = new Logger(new ArrayList<>());
        Socio socio = new Socio("aa","as","123","a@a.com","123",MetodoEnvio.Email, logger);
        socio.setApellido("aaa");
        socio.setNombre("abc");
        socio.setMetodoEnvio(MetodoEnvio.SMS);
        assertEquals(3, logger.getCambios().size());
    }
}