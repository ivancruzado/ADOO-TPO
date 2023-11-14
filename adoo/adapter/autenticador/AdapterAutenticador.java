package adapter.autenticador;


/**
 * 
 */
public class AdapterAutenticador implements IAdapterAutenticador{

    public AdapterAutenticador() {
    }
    @Override
    public Boolean autenticarse(int idSocio) {
        return true;
    }
}