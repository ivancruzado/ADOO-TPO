package estrategias.notificador;

import adapter.notificador.email.IAdapterEmail;
import adapter.notificador.email.AdapterEmail;
import modelos.dtos.NotificadorDTO;

public class Email implements EstrategiaNotificador {

    private IAdapterEmail adapter;

    public Email() {
        this.adapter = new AdapterEmail();
    }
    public void enviarNotificacion(NotificadorDTO notificacion) {
        if(adapter!= null){
            adapter.enviarNotificacion(notificacion);
        }else{
            System.out.println("No hay un adapter seteado");
        }
    }

}