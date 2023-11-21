package test;

import controladores.ControllerSocio;
import enums.MetodoEnvio;
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
        MetodoEnvio metodoEnvio = ControllerSocio.getInstancia().metodoEnvio(1);
        SocioDTO socio = null;
        for (SocioDTO socioDTO : ControllerSocio.getInstancia().getSociosDTO()) {
            if(socioDTO.getIdSocio() == 1){
                socio = socioDTO;
            }
        }
        NotificadorDTO noti = new NotificadorDTO("prestamo vencido",new Date(),MotivoNotificacion.fechaDeVencimientoProxima,socio);
        EstrategiaNotificador estrategia = new Email();
        estrategia.enviarNotificacion(noti);
        System.out.println(noti);
    }
}
