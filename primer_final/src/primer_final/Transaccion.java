
package primer_final;

public class Transaccion {
    // Atributos
    private int Id_transaccion;
    private int Pin_transaccion;
    private String Tipo_transaccion;
    private String Fecha_transaccion;

    // Constructor
    public Transaccion(int Id_transaccion, int Pin_transaccion, String Tipo_transaccion, String Fecha_transaccion) {
        this.Id_transaccion = Id_transaccion;
        this.Pin_transaccion = Pin_transaccion;
        this.Tipo_transaccion = Tipo_transaccion;
        this.Fecha_transaccion = Fecha_transaccion;
    }

    // Métodos getter y setter para Id_transaccion
    public int get_Idtransaccion() {
        return Id_transaccion;
    }

    public void set_Idtransaccion(int Id_transaccion) {
        this.Id_transaccion = Id_transaccion;
    }

    // Métodos getter y setter para Pin_transaccion
    public int get_Pintransaccion() {
        return Pin_transaccion;
    }

    public void set_Pintransaccion(int Pin_transaccion) {
        this.Pin_transaccion = Pin_transaccion;
    }

    // Método getter para Tipo_transaccion
    public String get_TipoTransaccion() {
        return Tipo_transaccion;
    }

    // Método getter para Fecha_transaccion
    public String get_FechaTransaccion() {
        return Fecha_transaccion;
    }
}
