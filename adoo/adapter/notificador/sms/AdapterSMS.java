package adapter.notificador.sms;

import modelos.dtos.NotificadorDTO;
import color.ConsoleColors;
/**
 * 
 */
public class AdapterSMS implements IAdapterSMS{

    public AdapterSMS() {
    }

    public void enviarNotificacion(NotificadorDTO notificacion) {
        System.out.println(ConsoleColors.GREEN + 
                "Se ha enviado un mensaje por SMS al numero " + ConsoleColors.GREEN_BOLD + notificacion.getDestinatario().getTelefono() + ConsoleColors.GREEN 
                        + " del Socio " + ConsoleColors.GREEN_BOLD + notificacion.getDestinatario().getNombre()
                        + " " + notificacion.getDestinatario().getApellido() + ConsoleColors.GREEN +
                        " en la fecha " + ConsoleColors.GREEN_BOLD + notificacion.getFecha() + ConsoleColors.GREEN + " con el mensaje: " + ConsoleColors.GREEN_BOLD + "\"" + notificacion.getMensaje() + "\"" + ConsoleColors.RESET
        );
    }

}