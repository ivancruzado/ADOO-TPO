package controladores;

import java.util.*;

import chain.prestamo.CalcularDuracionPrestamo;
import chain.prestamo.CalcularTiempoPrestamoBuenComportamiento;
import chain.prestamo.CalcularTiempoPrestamoEjemplar;
import chain.prestamo.CalcularTiempoPrestamoPenalizacion;
import modelos.Prestamo;
import modelos.Socio;
import modelos.dtos.NotificadorDTO;
import modelos.dtos.PrestamoDTO;
import modelos.dtos.SocioDTO;
import controladores.ControllerSocio;
import enums.MotivoNotificacion;

public class ControllerPrestamo {

    private ArrayList <Prestamo> prestamos;
    private static ControllerPrestamo instancia;
    
    private CalcularDuracionPrestamo duracionPrestamo;

    public ControllerPrestamo() {
        CalcularDuracionPrestamo buenComportamiento = new CalcularTiempoPrestamoBuenComportamiento(null);
        CalcularDuracionPrestamo ejemplar = new CalcularTiempoPrestamoEjemplar(buenComportamiento);
        CalcularDuracionPrestamo penalizacion = new CalcularTiempoPrestamoPenalizacion(ejemplar);

        duracionPrestamo = penalizacion;
        prestamos = new ArrayList<Prestamo>();
    }

    public static ControllerPrestamo getInstancia() {
        if (instancia == null)
            instancia = new ControllerPrestamo();
        return instancia;
    }

    public void enviarNotificacion(int idPrestamo, String mensaje, Date fecha, MotivoNotificacion motivoNotificacion) {
        Prestamo prestamo = buscaPrestamo(idPrestamo);
        SocioDTO socioDTO = ControllerSocio.getInstancia().getSocioDTO(prestamo.getIdSocio());
        NotificadorDTO notificacion = new NotificadorDTO(mensaje, fecha, motivoNotificacion, socioDTO);
        prestamo.enviarNotificacion(notificacion);
    }

    public int solicitarPrestamo(Date fechaPrestamo, String motivo, int idSocio, int idEjemplar) {
        if (!ControllerSocio.getInstancia().habilitado(idSocio)){
            System.out.println("El socio no esta habilitado para solicitar prestamos");
            return -1;
        }
        int tiempoPrestamoBase = duracionPrestamo.calcularTiempoBase(idSocio, idEjemplar);
        Prestamo prestamo = new Prestamo(tiempoPrestamoBase, fechaPrestamo, motivo, idSocio, idEjemplar);
        prestamos.add(prestamo);
        ControllerSocio.getInstancia().addPrestamo(idSocio, prestamo);
        //TODO Llamar Logger
        return prestamo.getIdPrestamo();
    }

    public void modificarTiempoPrestamo(Prestamo prestamo,int tiempo){
        Prestamo prestamoEncontrado = buscaPrestamo(prestamo.getIdPrestamo());
        if(prestamoEncontrado != null){
            prestamoEncontrado.setTiempoPrestamoBase(tiempo);
        }
    }

    public int encontrarEjemplar(int idEjemplar) {
        for (Prestamo prestamo : this.prestamos) {
            if (prestamo.getIdEjemplar() == idEjemplar)
                return prestamo.getIdPrestamo();
        }
        return -1;
    }

    public int socioPrestamo(int idPrestamo){
        for (Prestamo prestamo : this.prestamos) {
            if (prestamo.getIdPrestamo() == idPrestamo)
                return prestamo.getIdSocio();
        }
        return -1;
    }

    public ArrayList <PrestamoDTO> getPrestamosSocio(int idSocio) {
        ArrayList<PrestamoDTO> prestamosDTO = new ArrayList<PrestamoDTO>();
        for (Prestamo prestamo : this.prestamos) {
            if (prestamo.getIdSocio() == idSocio)
                prestamosDTO.add(prestamo.toDTO());
        }
        return prestamosDTO;
    }


    public int socio(int idPrestamo) {
        Prestamo prestamo = buscaPrestamo(idPrestamo);
        if (prestamo == null)
            return -1;
        return prestamo.getIdSocio();
    }

    private Prestamo buscaPrestamo(int idPrestamo){
        for (Prestamo prestamo : this.prestamos) {
            if (prestamo.getIdPrestamo() == idPrestamo)
                return prestamo;
        }
        return null;
    }

    public void cancelarPrestamo(int idPrestamo) {
        // TODO implement here
    }

}