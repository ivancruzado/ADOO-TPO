package adapter.localizador;

import adapter.localizador.ILocalizarEjemplar;
import color.ConsoleColors;

public class AdapterLocalizador implements ILocalizarEjemplar {


    public AdapterLocalizador() {
    }


    public String localizarEjemplar(int idEjemplar) {
        return "Localizando ejemplar " + ConsoleColors.GREEN + idEjemplar + ConsoleColors.RESET ;
    }

}