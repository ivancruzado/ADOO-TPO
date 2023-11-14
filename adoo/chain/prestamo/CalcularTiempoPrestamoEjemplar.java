package chain.prestamo;

import controladores.ControllerEjemplar;

public class CalcularTiempoPrestamoEjemplar extends CalcularDuracionPrestamo {

    public int calcularTiempoBase(int idSocio, int idEjemplar) {
        ControllerEjemplar controladorEjemplar = ControllerEjemplar.getInstancia();
        return controladorEjemplar.tiempoPrestamo(idEjemplar);
    }

}