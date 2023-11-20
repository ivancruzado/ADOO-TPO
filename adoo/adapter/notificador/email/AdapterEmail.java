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
                "Se ha enviado un mensaje por Email al correo " + ConsoleColors.GREEN_BOLD + notificacion.getDestinatario().getEmail() + ConsoleColors.GREEN
                        + " del Socio " + ConsoleColors.GREEN_BOLD + notificacion.getDestinatario().getNombre() 
                        + " " + notificacion.getDestinatario().getApellido() + ConsoleColors.GREEN + 
                        " en la fecha " + ConsoleColors.GREEN_BOLD + notificacion.getFecha() + ConsoleColors.GREEN + " con el mensaje: " + ConsoleColors.GREEN_BOLD + "\"" + notificacion.getMensaje() + "\"" + ConsoleColors.RESET
        );
    }

}