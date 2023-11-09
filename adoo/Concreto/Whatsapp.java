package Concreto;

import java.util.*;

/**
 * 
 */
public class Whatsapp extends Notificador {

    private NotificadorWhatsapp adapter;
    public Whatsapp(NotificadorWhatsapp adapter) {
        this.adapter = adapter;
    }

    public void enviarNotificacion(notificacion NotificadorDTO) {
        if(adapter != null){
            adapter.enviarNotificacion(notificacion);
        }else{
            System.out.println("No hay un adapter seteado");
        }

}