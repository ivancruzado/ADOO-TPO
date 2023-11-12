package adapter.notificador.sms;

import modelos.dtos.NotificadorDTO;

public interface IAdapterSMS {

    public void enviarNotificacion(NotificadorDTO notificacion);
    
}
