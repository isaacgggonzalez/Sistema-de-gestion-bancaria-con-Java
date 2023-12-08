package primer_final;

/**
 * Representa un cliente con información esencial.
 * Esta clase proporciona métodos para obtener y establecer detalles del cliente.
 */
public class Cliente {
    /**
     * Identificador único del cliente.
     */
    private long idCliente;
    /**
     * Número de identificación del cliente.
     */
    private int ciCliente;
    /**
     * Nombre del cliente.
     */
    private String nombreCliente;
    /**
     * Apellido del cliente.
     */
    private String apellidoCliente;
    /**
     * Fecha de nacimiento del cliente.
     */
    private String nacimientoCliente;
    
    // Constructor
    /**
     * Constructor de la clase Cliente.
     *
     * @param idCliente        Identificador único del cliente.
     * @param ciCliente        Número de identificación del cliente.
     * @param nombreCliente    Nombre del cliente.
     * @param apellidoCliente  Apellido del cliente.
     * @param nacimientoCliente Fecha de nacimiento del cliente.
     */
    public Cliente(int idCliente, int ciCliente, String nombreCliente,
                   String apellidoCliente, String nacimientoCliente) {
        
        this.idCliente = idCliente;
        this.ciCliente = ciCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.nacimientoCliente = nacimientoCliente;
    }
    
    /**
     * Obtiene el identificador único del cliente.
     *
     * @return Identificador único del cliente.
     */
    public long getIdCliente() {
        return idCliente;
    }
    /**
     * Establece el identificador único del cliente.
     *
     * @param idCliente Nuevo identificador único del cliente.
     */
    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
    /**
     * Obtiene el número de identificación del cliente.
     *
     * @return Número de identificación del cliente.
     */
    public int getCiCliente() {
        return ciCliente;
    }
    /**
     * Establece el número de identificación del cliente.
     *
     * @param ciCliente Nuevo número de identificación del cliente.
     */
    public void setCiCliente(int ciCliente) {
        this.ciCliente = ciCliente;
    }
    /**
     * Obtiene el nombre del cliente.
     *
     * @return Nombre del cliente.
     */
    public String getNombreCliente() {
        return nombreCliente;
    }
    /**
     * Establece el nombre del cliente.
     *
     * @param nombreCliente Nuevo nombre del cliente.
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    /**
     * Obtiene el apellido del cliente.
     *
     * @return Apellido del cliente.
     */
    public String getApellidoCliente() {
        return apellidoCliente;
    }
    /**
     * Establece el apellido del cliente.
     *
     * @param apellidoCliente Nuevo apellido del cliente.
     */
    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }
    /**
     * Obtiene la fecha de nacimiento del cliente.
     *
     * @return Fecha de nacimiento del cliente.
     */
    public String getNacimientoCliente() {
        return nacimientoCliente;
    }
    /**
     * Establece la fecha de nacimiento del cliente.
     *
     * @param nacimientoCliente Nueva fecha de nacimiento del cliente.
     */
    public void setNacimientoCliente(String nacimientoCliente) {
        this.nacimientoCliente = nacimientoCliente;
    }

  
}
