package Concreto;

import java.util.*;

public abstract class Notificador {

    private StrategyNotificador estrategiaNotificador;
    public Notificador() {
    }

    public void enviarNotificacion(notificacion NotificadorDTO) {
        if(estrategiaNotificador != null){
            estrategiaNotificador.enviarNotificacion(notificacion);
        }else{
            System.out.println("No se setio una estrategia de notificacion");
        }

    }
    public void setearEstrategia(estrategiaNotificacion EstrategiaNotificador) {
        this.estrategiaNotificador = estrategiaNotificador;
    }

}