package chain.prestamo;


import modelos.Prestamo;

/**
 * 
 */
public abstract class CalcularDuracionPrestamo {

    /**
     * Default constructor
     */
    public CalcularDuracionPrestamo() {
    }

    /**
     * @param prestamo 
     * @return
     */
    public abstract Prestamo calcularTiempo(Prestamo prestamo);

}