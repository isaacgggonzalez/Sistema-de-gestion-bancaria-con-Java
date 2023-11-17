package primer_final;


public class Cliente {
    private int id_cliente;
    private int ci_cliente;
    private String nombre_cliente;
    private String apellido_cliente;
    private String nacimiento_cliente;

    // Constructor
    public Cliente(int id_cliente, int ci_cliente, String nombre_cliente, 
            String apellido_cliente, String nacimiento_cliente) {
        
        this.id_cliente = id_cliente;
        this.ci_cliente = ci_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.nacimiento_cliente = nacimiento_cliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getCi_cliente() {
        return ci_cliente;
    }

    public void setCi_cliente(int ci_cliente) {
        this.ci_cliente = ci_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    public String getNacimiento_cliente() {
        return nacimiento_cliente;
    }

    public void setNacimiento_cliente(String nacimiento_cliente) {
        this.nacimiento_cliente = nacimiento_cliente;
    }

  
}
