package modelos;

import estrategias.notificador.EstrategiaNotificador;
import modelos.dtos.NotificadorDTO;

public class Notificador {

    private EstrategiaNotificador estrategiaNotificador;
    
    public Notificador(EstrategiaNotificador estrategiaNotificador) {
        this.estrategiaNotificador = estrategiaNotificador;
    }

    public void enviarNotificacion(NotificadorDTO notificacion) {
        this.estrategiaNotificador.enviarNotificacion(notificacion);

    }
    
    public void setearEstrategia(EstrategiaNotificador estrategiaNotificador) {
        this.estrategiaNotificador = estrategiaNotificador;
    }

}