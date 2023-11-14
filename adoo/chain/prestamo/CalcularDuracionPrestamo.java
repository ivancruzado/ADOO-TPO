package chain.prestamo;

public abstract class CalcularDuracionPrestamo {
    protected CalcularDuracionPrestamo siguiente;
    
    public abstract int calcularTiempoBase(int idSocio, int idEjemplar);

    public void setSiguiente(CalcularDuracionPrestamo siguiente) {
        this.siguiente = siguiente;
    }

}