package adapter.notificador.email;

import modelos.dtos.NotificadorDTO;

public interface IAdapterEmail {
  
  public void enviarNotificacion(NotificadorDTO notificacion);

}
