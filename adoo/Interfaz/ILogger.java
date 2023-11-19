package interfaz;

import java.util.List;

/**
 * 
 */
public interface ILogger {
    /**
     * @return
     */
    public void loguearCambios(String field, String data);
    public List<String> getCambios();
}