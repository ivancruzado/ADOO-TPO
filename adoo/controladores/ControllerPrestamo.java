package controladores;

import java.util.*;

import chain.prestamo.CalcularDuracionPrestamo;
import chain.prestamo.CalcularTiempoPrestamoBuenComportamiento;
import chain.prestamo.CalcularTiempoPrestamoEjemplar;
import chain.prestamo.CalcularTiempoPrestamoPenalizacion;
import modelos.Prestamo;
import modelos.dtos.PrestamoDTO;


public class ControllerPrestamo {

    private ArrayList <Prestamo> prestamos;
    private static ControllerPrestamo instancia;
    
    private CalcularDuracionPrestamo duracionPrestamo;

    public ControllerPrestamo() {
        CalcularDuracionPrestamo buenComportamiento = new CalcularTiempoPrestamoBuenComportamiento(null);
        CalcularDuracionPrestamo ejemplar = new CalcularTiempoPrestamoEjemplar(buenComportamiento);
        CalcularDuracionPrestamo penalizacion = new CalcularTiempoPrestamoPenalizacion(ejemplar);

        duracionPrestamo = penalizacion;
    }

    public static ControllerPrestamo getInstancia() {
        if (instancia == null)
            instancia = new ControllerPrestamo();
        return instancia;
    }

    public int solicitarPrestamo(Date fechaPrestamo, String motivo, int idSocio, int idEjemplar) {
        int tiempoPrestamoBase = duracionPrestamo.calcularTiempoBase(idSocio, idEjemplar);
        Prestamo prestamo = new Prestamo(tiempoPrestamoBase, fechaPrestamo, motivo, idSocio, idEjemplar);
        prestamos.add(prestamo);
        return prestamo.getIdPrestamo();
    }

    public ArrayList <PrestamoDTO> getPrestamosSocio(int idSocio) {
        ArrayList<PrestamoDTO> prestamosDTO = new ArrayList<PrestamoDTO>();
        for (Prestamo prestamo : this.prestamos) {
            if (prestamo.getIdSocio() == idSocio)
                prestamosDTO.add(prestamo.toDTO());
        }
        return prestamosDTO;
    }

    public void cancelarPrestamo(int idPrestamo) {
        // TODO implement here
    }

}