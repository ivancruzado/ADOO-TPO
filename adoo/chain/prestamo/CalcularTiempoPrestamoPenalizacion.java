package chain.prestamo;

import java.util.ArrayList;

import controladores.ControllerPrestamo;
import modelos.dtos.PrestamoDTO;

/**
 * 
 */
public class CalcularTiempoPrestamoPenalizacion extends CalcularDuracionPrestamo {

    public CalcularTiempoPrestamoPenalizacion(CalcularDuracionPrestamo siguiente) {
        super(siguiente);
    }

    public int calcularTiempoBase(int idSocio, int idEjemplar) {
        int diasPenalizacion = 0;
        ControllerPrestamo controladorPrestamo = ControllerPrestamo.getInstancia();
        ArrayList<PrestamoDTO> prestamosDTO = new ArrayList<>();
        prestamosDTO = controladorPrestamo.getPrestamosSocio(idSocio);
        for (PrestamoDTO prestamo : prestamosDTO) {
            if (!prestamo.devolvioATiempo()) {
                diasPenalizacion -= prestamo.diasRetraso();
            }
        }
        return diasPenalizacion;
    }

}