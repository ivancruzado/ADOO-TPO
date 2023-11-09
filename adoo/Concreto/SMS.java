package Concreto;

import java.util.*;

public class SMS extends Notificador {
    private NotificadorSMS adapter;
    public SMS(NotificadorSMS adapter) {
        this.adapter = adapter;
    }


    public void enviarNotificacion(notificacion NotificadorDTO) {

        if(adapter != null){
            adapter.enviarNotificacion(notificacion);
        }else{
            System.out.println("No hay un adapter seteado");
        }
    }

}