
package primer_final;

public class Servicio extends PagoServicio {
    // Atributos adicionales para la clase Servicio
    private int Id_servicio;
    private String Nombre_servicio;
    private double Costo_servicio;

    // Constructor
    public Servicio(int Id_servicio, String Nombre_servicio, double Costo_servicio,
                    int Id_pago, int Id_transaccion, int Pin_transaccion, String Tipo_transaccion, String Fecha_transaccion,
                    double Monto_pago, Cuenta cuenta_abonante, TarjetaDeCredito Tarjeta_abonante) {
        // Llamada al constructor de la clase base (PagoServicio)
        super(Id_pago, Id_transaccion, Pin_transaccion, Tipo_transaccion, Fecha_transaccion,
                Monto_pago, cuenta_abonante, Tarjeta_abonante);

        this.Id_servicio = Id_servicio;
        this.Nombre_servicio = Nombre_servicio;
        this.Costo_servicio = Costo_servicio;
    }

    // Métodos getter y setter para Id_servicio
    public int get_IdServicio() {
        return Id_servicio;
    }

    public void set_IdServicio(int Id_servicio) {
        this.Id_servicio = Id_servicio;
    }

    // Métodos getter y setter para Nombre_servicio
    public String get_NombreServicio() {
        return Nombre_servicio;
    }

    public void set_NombreServicio(String Nombre_servicio) {
        this.Nombre_servicio = Nombre_servicio;
    }

    // Métodos getter y setter para Costo_servicio
    public double get_CostoServicio() {
        return Costo_servicio;
    }

    public void set_CostoServicio(double Costo_servicio) {
        this.Costo_servicio = Costo_servicio;
    }
}
