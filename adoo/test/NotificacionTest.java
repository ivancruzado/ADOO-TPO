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

    }


}