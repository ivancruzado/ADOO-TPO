package chain.prestamo;

import controladores.ControllerEjemplar;

public class CalcularTiempoPrestamoEjemplar extends CalcularDuracionPrestamo {

    public CalcularTiempoPrestamoEjemplar(CalcularDuracionPrestamo siguiente) {
        super(siguiente);
    }

    public int calcularTiempoBase(int idSocio, int idEjemplar) {
        ControllerEjemplar controladorEjemplar = ControllerEjemplar.getInstancia();
        return controladorEjemplar.tiempoPrestamo(idEjemplar);
    }
    //TODO AGREGAR DEFUALT A TODOS VALIDACION NULL
}