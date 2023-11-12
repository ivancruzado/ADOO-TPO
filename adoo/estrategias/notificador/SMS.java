package estrategias.notificador;

import adapter.notificador.sms.IAdapterSMS;
import adapter.notificador.sms.AdapterSMS;
import modelos.dtos.NotificadorDTO;

public class SMS implements EstrategiaNotificador {
    
    private IAdapterSMS adapter;

    public SMS() {
        this.adapter = new AdapterSMS();
    }


    public void enviarNotificacion(NotificadorDTO notificacion) {
        if(adapter != null){
            adapter.enviarNotificacion(notificacion);
        }else{
            System.out.println("No hay un adapter seteado");
        }
    }

}