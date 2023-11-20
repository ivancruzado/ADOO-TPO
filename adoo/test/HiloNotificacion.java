package test;

import controladores.ControllerSocio;
import enums.MotivoNotificacion;
import estrategias.notificador.Email;
import estrategias.notificador.EstrategiaNotificador;
import estrategias.notificador.Whatsapp;
import modelos.Notificador;
import modelos.dtos.NotificadorDTO;
import modelos.dtos.SocioDTO;

import java.util.Date;

class HiloNotificacion extends Thread {
    @Override
    public void run(){
        NotificadorDTO noti = new NotificadorDTO("prestamo vencido",new Date(),MotivoNotificacion.fechaDeVencimientoProxima,1);
        EstrategiaNotificador estrategia = new Email();
        estrategia.enviarNotificacion(noti);
        System.out.println(noti);
    }
}
