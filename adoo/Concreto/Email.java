package Concreto;

import java.util.*;

/**
 * 
 */
public class Email extends Notificador {

    private NotificadorEmail adapter;
    public Email(NotificadorEmail adapter) {
        this.adapter = adapter;
    }
    public void enviarNotificacion(notificacion NotificadorDTO) {
        if(adapter!= null){
            adapter.enviarNotificacion(notificacion);
        }else{
            System.out.println("No hay un adapter seteado");
        }
    }

}