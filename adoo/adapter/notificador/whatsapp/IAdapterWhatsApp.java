package adapter.notificador.whatsapp;

import modelos.dtos.NotificadorDTO;

public interface IAdapterWhatsApp {

    public void enviarNotificacion(NotificadorDTO notificacion);
}
