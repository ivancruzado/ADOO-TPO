package chain.prestamo;

import java.util.ArrayList;

import controladores.ControllerPrestamo;
import modelos.dtos.PrestamoDTO;

public class CalcularTiempoPrestamoBuenComportamiento extends CalcularDuracionPrestamo {

    public int calcularTiempoBase(int idSocio, int idEjemplar) {
        int prestamosCorrectos = 0;
        ControllerPrestamo controladorPrestamo = ControllerPrestamo.getInstancia();
        ArrayList<PrestamoDTO> prestamosDTO = new ArrayList<>();
        prestamosDTO = controladorPrestamo.getPrestamosSocio(idSocio);
        for (PrestamoDTO prestamo : prestamosDTO) {
            if (prestamo.devolvioATiempo()) {
                prestamosCorrectos++;
            }
        }
        return prestamosCorrectos/5;
    }

}