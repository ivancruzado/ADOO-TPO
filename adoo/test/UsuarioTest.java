package test;

import controladores.ControllerPrestamo;
import controladores.ControllerSocio;
import enums.MetodoEnvio;
import modelos.Logger;
import modelos.Socio;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Date;

class UsuarioTest {
    private ControllerSocio controllerSocio;
    private interfaz.ILogger logger;
    private int IdSocio;

    @BeforeEach
    public void  inicio(){
        controllerSocio = ControllerSocio.getInstancia();
        logger = new Logger(new ArrayList<>());
    }

    @Test
    public void CrearSocio(){
        int nuevoSocio = controllerSocio.crearSocio("Luis","Jose","123213","Luis@mail.com","231231", MetodoEnvio.Email,logger);
        Socio esperado = controllerSocio.buscaSocio(nuevoSocio);

        Socio resultado = controllerSocio.buscaSocio(controllerSocio.getLista().size());
        Assertions.assertEquals(esperado,resultado);
    }


    @Test
    public void HabilitarUsuario(){
        int socio = controllerSocio.crearSocio("Juan","Cruz","424242","Juan@mail.com","1122121", MetodoEnvio.Whatsapp,logger);
        controllerSocio.buscaSocio(socio).setHabilitado(false);
        controllerSocio.habilitarUsuario(socio);
        boolean estadoSocio = controllerSocio.habilitado(1);
        Assertions.assertTrue(estadoSocio);
    }

    @Test
    public void DeshabilitarUsuario(){
        controllerSocio.deshabilitarUsuario(2);
        boolean estadoSocio = controllerSocio.habilitado(2);
        Assertions.assertFalse(estadoSocio);
    }


    @Test
    public void aumentarPrestamoPos(){
        int prestamoPos = controllerSocio.buscaSocio(1).getPrestamosPositivos();
        controllerSocio.aumentarPrestamoPositivo(1);
        int prestamoPosNuevo = controllerSocio.buscaSocio(1).getPrestamosPositivos();
        Assertions.assertTrue(prestamoPosNuevo>prestamoPos);

    }

    @Test
    public void solicitarPrestamo(){

        int CantPrestamos =  ControllerPrestamo.getInstancia().getPrestamosSocio(1).size();
        System.out.println(CantPrestamos);
        controllerSocio.solicitarPrestamo(new Date(), "Trabajo", 1, 1);
        int CantPrestamosNew =  ControllerPrestamo.getInstancia().getPrestamosSocio(1).size();
        System.out.println(CantPrestamosNew);
        Assertions.assertTrue(CantPrestamos<CantPrestamosNew);

    }


}