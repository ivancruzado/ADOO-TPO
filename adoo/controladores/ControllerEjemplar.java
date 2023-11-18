package controladores;

import java.text.SimpleDateFormat;
import java.util.*;

import factory.ejemplar.FactoryEjemplar;
import modelos.Ejemplar;
import modelos.dtos.EjemplarDTO;

public class ControllerEjemplar {

    private ArrayList <Ejemplar> productos;
    private static ControllerEjemplar instancia;
    private FactoryEjemplar factoryEjemplar;

    private ControllerEjemplar() {
        productos = new ArrayList<Ejemplar>();
        factoryEjemplar = null;
    }

    public static ControllerEjemplar getInstancia() {
        if (instancia == null)
            instancia = new ControllerEjemplar();
        return instancia;
    }

    private void setFactoryEjemplar(FactoryEjemplar factory) {
        this.factoryEjemplar = factory;
    }
  
    public int crearEjemplar(FactoryEjemplar factory, String titulo, String autor, Date fechaPublicacion) {
        this.setFactoryEjemplar(factory);
        Ejemplar ejemplar = factoryEjemplar.crearEjemplar(titulo, autor, fechaPublicacion);
        this.productos.add(ejemplar);
        return ejemplar.getIdEjemplar();
    }

    public Boolean disponible(int idEjemplar) {
        Ejemplar ejemplar = this.buscaEjemplar(idEjemplar);
        return ejemplar.disponible();
    }

    public int tiempoPrestamo(int idEjemplar) {
        Ejemplar ejemplar = this.buscaEjemplar(idEjemplar);
        return ejemplar.getTiempoPrestamo();
    }

    public String categoria(int idEjemplar) {
        Ejemplar ejemplar = this.buscaEjemplar(idEjemplar);
        return ejemplar.getCategoria();
    }

    private Ejemplar buscaEjemplar(int idEjemplar){
        for (Ejemplar ejemplar : this.productos) {
            if (ejemplar.getIdEjemplar() == idEjemplar)
                return ejemplar;
        }
        return null;
    }

    /**
     * @param idEjemplar int 
     * @return
     */
    public String localizarEjemplar(int idEjemplar) {
        return this.buscaEjemplar(idEjemplar).localizar(idEjemplar);
    }

    public ArrayList<EjemplarDTO> listadoEjemplares(){
        ArrayList<EjemplarDTO> ejemplaresDTO = new ArrayList<EjemplarDTO>();
        for (Ejemplar ejemplar : this.productos) {
            ejemplaresDTO.add(ejemplar.toDTO());
        }
        return ejemplaresDTO;
    }

    public String fecha(int idEjemplar) {
        Ejemplar ejemplar = this.buscaEjemplar(idEjemplar);
        if (ejemplar == null)
            return "Ejemplar no encontrado";

        // Formatear la fecha en el formato DD/MM/YYYY
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(ejemplar.getFechaPublicacion());
    }
    
    public String titulo(int idEjemplar) {
        Ejemplar ejemplar = this.buscaEjemplar(idEjemplar);
        if (ejemplar == null)
            return "Ejemplar no encontrado";
        return ejemplar.getTitulo();
    }

    public String autor(int idEjemplar) {
        Ejemplar ejemplar = this.buscaEjemplar(idEjemplar);
        if (ejemplar == null)
            return "Ejemplar no encontrado";
        return ejemplar.getAutor();
    }
}