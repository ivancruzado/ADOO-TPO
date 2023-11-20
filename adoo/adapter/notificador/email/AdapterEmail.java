package adapter.notificador.email;

import modelos.dtos.NotificadorDTO;
import color.ConsoleColors;

public class AdapterEmail implements IAdapterEmail{

    /**
     * Default constructor
     */
    public AdapterEmail() {
    }

    /**
     * @param notificacion NotificadorDTO 
     * @return
     */
    public void enviarNotificacion(NotificadorDTO notificacion) {
        System.out.println(ConsoleColors.GREEN + 
                "Se ha enviado un mensaje por Email al Usuario: " + ConsoleColors.GREEN_BOLD + notificacion.getDestinatario() + ConsoleColors.GREEN
                        + " motivo: " + ConsoleColors.GREEN_BOLD + notificacion.getMotivoNotificacion() +
                " con el mensaje: " + ConsoleColors.GREEN_BOLD + "\"" + notificacion.getMensaje() + "\"" + ConsoleColors.RESET
        );
    }

}