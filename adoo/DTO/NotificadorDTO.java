
import java.util.*;

public class NotificadorDTO {
    private String mensaje;
    private Date fecha;
    private MotivoNotificacion motivoNotificacion;
    public NotificadorDTO(String mensaje, Date fecha, MotivoNotificacion motivoNotificacion) {
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.motivoNotificacion = motivoNotificacion;
    }

}