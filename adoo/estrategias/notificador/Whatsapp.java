package estrategias.notificador;

import adapter.notificador.whatsapp.IAdapterWhatsApp;
import adapter.notificador.whatsapp.AdapterWhatsApp;
import modelos.dtos.NotificadorDTO;

public class Whatsapp implements EstrategiaNotificador {

    private IAdapterWhatsApp adapter;

    public Whatsapp() {
        this.adapter = new AdapterWhatsApp();
    }

    public void enviarNotificacion(NotificadorDTO notificacion) {
        if(adapter != null){
            adapter.enviarNotificacion(notificacion);
        }else{
            System.out.println("No hay un adapter seteado");
        }
    }
}