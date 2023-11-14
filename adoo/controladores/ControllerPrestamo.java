package controladores;

import java.sql.Array;
import java.util.*;

import chain.prestamo.CalcularDuracionPrestamo;
import chain.prestamo.CalcularTiempoPrestamoBuenComportamiento;
import chain.prestamo.CalcularTiempoPrestamoEjemplar;
import chain.prestamo.CalcularTiempoPrestamoPenalizacion;
import modelos.Ejemplar;
import modelos.Prestamo;
import modelos.dtos.PrestamoDTO;


public class ControllerPrestamo {

    private ArrayList <Prestamo> prestamos;
    private static ControllerPrestamo instancia;
    
    private CalcularDuracionPrestamo duracionPrestamo;

    public ControllerPrestamo() {
        CalcularTiempoPrestamoBuenComportamiento buenComportamiento = new CalcularTiempoPrestamoBuenComportamiento();
        CalcularTiempoPrestamoEjemplar ejemplar = new CalcularTiempoPrestamoEjemplar();
        CalcularTiempoPrestamoPenalizacion penalizacion = new CalcularTiempoPrestamoPenalizacion();

        buenComportamiento.setSiguiente(ejemplar);
        ejemplar.setSiguiente(penalizacion);

        duracionPrestamo = buenComportamiento;
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