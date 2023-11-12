package factory.ejemplar;


public abstract class Factory {

    /**
     * Default constructor
     */
    public Factory() {
    }

    /**
     * @return
     */
    public abstract Object crearEjemplar();

}