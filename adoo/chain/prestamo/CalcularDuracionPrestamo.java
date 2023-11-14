package chain.prestamo;

public abstract class CalcularDuracionPrestamo {
    protected CalcularDuracionPrestamo siguiente;
    
    public CalcularDuracionPrestamo(CalcularDuracionPrestamo siguiente) {
        this.siguiente = siguiente;
    }

    public abstract int calcularTiempoBase(int idSocio, int idEjemplar);
}