package test;

import controladores.ControllerPrestamo;
import controladores.ControllerSocio;
import enums.MetodoEnvio;
import modelos.Logger;
import modelos.Socio;
import modelos.dtos.SocioDTO;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Date;

class UsuarioTest {
    private ControllerSocio controllerSocio;
    private interfaz.ILogger logger;

    @BeforeEach
    public void  inicio(){
        controllerSocio = ControllerSocio.getInstancia();
        logger = new Logger(new ArrayList<>());
    }

    @Test
    public void CrearSocio(){
        int actual = controllerSocio.getTamanioLista();
        controllerSocio.crearSocio("Luis","Jose","123213","Luis@mail.com","231231", MetodoEnvio.Email,logger);
        int nuevo = controllerSocio.getTamanioLista();
        Assertions.assertTrue(nuevo>actual);
    }

    @Test
    public void solicitarPrestamo(){

        int socioId = controllerSocio.crearSocio("Luis","Jose","123213","Luis@mail.com","231231", MetodoEnvio.Email,logger);
        int CantPrestamos =  ControllerPrestamo.getInstancia().getPrestamosSocio(socioId).size();
        //System.out.println(CantPrestamos);
        controllerSocio.solicitarPrestamo(new Date(), "Trabajo", socioId, 1);
        int CantPrestamosNuevos =  ControllerPrestamo.getInstancia().getPrestamosSocio(socioId).size();
        //System.out.println(CantPrestamosNuevos);
        Assertions.assertTrue(CantPrestamos<CantPrestamosNuevos);
    }


    @Test
    public void DesHabilitarUsuario(){
        int socio = controllerSocio.crearSocio("Juan","Cruz","424242","Juan@mail.com","1122121", MetodoEnvio.Whatsapp,logger);
        controllerSocio.deshabilitarUsuario(socio);
        boolean estadoSocioDes = controllerSocio.habilitado(socio);
        Assertions.assertFalse(estadoSocioDes);
        controllerSocio.habilitarUsuario(socio);
        boolean estadoSocioHab = controllerSocio.habilitado(socio);
        Assertions.assertTrue(estadoSocioHab);
    }

    @Test
    public void aumentarPrestamoPos(){
        int prestamoPositivo = controllerSocio.GetPrestamoPositivo(1);
        controllerSocio.aumentarPrestamoPositivo(1);
        int prestamoPositivo2 = controllerSocio.GetPrestamoPositivo(1);
        Assertions.assertTrue(prestamoPositivo<prestamoPositivo2);
    }


}