
package primer_final;

public class Transaccion {
    // Atributos
    private int Id_transaccion;
    private int Pin_transaccion;
    private String Tipo_transaccion;
    private String Fecha_transaccion;

    // Constructor
    public Transaccion(int Id_transaccion, int Pin_transaccion, 
            String Tipo_transaccion, String Fecha_transaccion) {
        this.Id_transaccion = Id_transaccion;
        this.Pin_transaccion = Pin_transaccion;
        this.Tipo_transaccion = Tipo_transaccion;
        this.Fecha_transaccion = Fecha_transaccion;
    }

    public int getId_transaccion() {
        return Id_transaccion;
    }

    public void setId_transaccion(int Id_transaccion) {
        this.Id_transaccion = Id_transaccion;
    }

    public int getPin_transaccion() {
        return Pin_transaccion;
    }

    public void setPin_transaccion(int Pin_transaccion) {
        this.Pin_transaccion = Pin_transaccion;
    }

    public String getTipo_transaccion() {
        return Tipo_transaccion;
    }

    public void setTipo_transaccion(String Tipo_transaccion) {
        this.Tipo_transaccion = Tipo_transaccion;
    }

    public String getFecha_transaccion() {
        return Fecha_transaccion;
    }

    public void setFecha_transaccion(String Fecha_transaccion) {
        this.Fecha_transaccion = Fecha_transaccion;
    }

    
    
    
}
