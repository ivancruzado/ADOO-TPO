package estrategias.notificador;

import modelos.dtos.NotificadorDTO;

public interface EstrategiaNotificador {

    /**
     * @param notificacion 
     * @return void
     */
    public void enviarNotificacion(NotificadorDTO notificacion);

}