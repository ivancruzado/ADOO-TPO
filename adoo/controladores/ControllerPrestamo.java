package controladores;

import java.util.*;

import chain.prestamo.CalcularDuracionPrestamo;
import chain.prestamo.CalcularTiempoPrestamoBuenComportamiento;
import chain.prestamo.CalcularTiempoPrestamoEjemplar;
import chain.prestamo.CalcularTiempoPrestamoPenalizacion;
import modelos.Prestamo;
import modelos.dtos.PrestamoDTO;
import controladores.ControllerSocio;

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