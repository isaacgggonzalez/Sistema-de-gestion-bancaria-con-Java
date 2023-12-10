package modelo;

/**
 * Representa un servicio con información como su identificador, nombre y costo.
 */
public class Servicio {
    /**
     * Identificador único del servicio.
     */
    private long idServicio;
    
    /**
     * Nombre del servicio.
     */
    private String nombreServicio;
    
    /**
     * Costo del servicio.
     */
    private double costoServicio;

    /**
     * Constructor de la clase Servicio.
     *
     * @param idServicio      Identificador único del servicio.
     * @param nombreServicio  Nombre del servicio.
     * @param costoServicio   Costo del servicio.
     */
    public Servicio(long idServicio, String nombreServicio, double costoServicio) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.costoServicio = costoServicio;
    }

    /**
     * Obtiene el identificador único del servicio.
     *
     * @return Identificador único del servicio.
     */
    public long get_IdServicio() {
        return idServicio;
    }
    
    /**
     * Establece el identificador único del servicio.
     *
     * @param Id_servicio Nuevo identificador único del servicio.
     */
    public void set_IdServicio(long Id_servicio) {
        this.idServicio = Id_servicio;
    }

    /**
     * Obtiene el nombre del servicio.
     *
     * @return Nombre del servicio.
     */
    public String get_NombreServicio() {
        return nombreServicio;
    }
    
    /**
     * Establece el nombre del servicio.
     *
     * @param Nombre_servicio Nuevo nombre del servicio.
     */
    public void set_NombreServicio(String Nombre_servicio) {
        this.nombreServicio = Nombre_servicio;
    }

    /**
     * Obtiene el costo del servicio.
     *
     * @return Costo del servicio.
     */
    public double get_CostoServicio() {
        return costoServicio;
    }
    
    /**
     * Establece el costo del servicio.
     *
     * @param Costo_servicio Nuevo costo del servicio.
     */
    public void set_CostoServicio(double Costo_servicio) {
        this.costoServicio = Costo_servicio;
    }
}