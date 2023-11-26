package primer_final;


public class Cliente {
    private int idCliente;
    private int ciCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String nacimientoCliente;

    // Constructor
    public Cliente(int idCliente, int ciCliente, String nombreCliente,
                   String apellidoCliente, String nacimientoCliente) {
        
        this.idCliente = idCliente;
        this.ciCliente = ciCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.nacimientoCliente = nacimientoCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getCiCliente() {
        return ciCliente;
    }

    public void setCiCliente(int ciCliente) {
        this.ciCliente = ciCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getNacimientoCliente() {
        return nacimientoCliente;
    }

    public void setNacimientoCliente(String nacimientoCliente) {
        this.nacimientoCliente = nacimientoCliente;
    }

  
}
