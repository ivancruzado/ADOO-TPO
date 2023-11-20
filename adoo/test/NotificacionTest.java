package test;

import controladores.ControllerSocio;
import enums.MetodoEnvio;
import enums.MotivoNotificacion;
import estrategias.notificador.Email;
import estrategias.notificador.EstrategiaNotificador;
import estrategias.notificador.SMS;
import estrategias.notificador.Whatsapp;
import modelos.Logger;
import modelos.dtos.NotificadorDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class NotificacionTest {

    private ControllerSocio controllerSocio;
    private interfaz.ILogger logger;
    @Test
    public void enviarNoti(){
        controllerSocio = ControllerSocio.getInstancia();
        logger = new Logger(new ArrayList<>());
        int IdSocio = controllerSocio.crearSocio("Luis","Jose","123213","Luis@mail.com","231231", MetodoEnvio.Email,logger);
        MetodoEnvio metodoEnvio = ControllerSocio.getInstancia().metodoEnvio(IdSocio);
        NotificadorDTO noti = new NotificadorDTO("Prestamo proximo a vencer",new Date(), MotivoNotificacion.fechaDeVencimientoProxima,IdSocio);
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
        }
    }

    @Test
    public void hilo(){
        HiloNotificacion h1 = new HiloNotificacion();
    }


}