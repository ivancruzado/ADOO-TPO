package modelos.dtos;

import java.util.*;
import enums.MotivoNotificacion;
/**
 * 
 */
public class NotificadorDTO {

    private int socioDTO;
    private String mensaje;
    private Date fecha;
    private MotivoNotificacion motivoNotificacion;

    public NotificadorDTO(String mensaje, Date fecha, MotivoNotificacion motivoNotificacion, int socioDTO) {
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.motivoNotificacion = motivoNotificacion;
        this.socioDTO = socioDTO;
    }

    public int getDestinatario() {
        return socioDTO;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public MotivoNotificacion getMotivoNotificacion() {
        return motivoNotificacion;
    }

    /*public void setDestinatario(SocioDTO socioDTO) {
        this.socioDTO = socioDTO;
    }*/

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setMotivoNotificacion(MotivoNotificacion motivoNotificacion) {
        this.motivoNotificacion = motivoNotificacion;
    }

}