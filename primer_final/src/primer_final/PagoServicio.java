
package primer_final;

public class PagoServicio extends Transaccion {
    // Atributos adicionales para la clase PagoServicio
    private int Id_pago;
    private double Monto_pago;
    private Cuenta cuenta_abonante;
    private TarjetaDeCredito Tarjeta_abonante;

    // Constructor
    public PagoServicio(int Id_pago, int Id_transaccion, int Pin_transaccion, String Tipo_transaccion, String Fecha_transaccion,
                        double Monto_pago, Cuenta cuenta_abonante, TarjetaDeCredito Tarjeta_abonante) {
        // Llamada al constructor de la clase base (Transaccion)
        super(Id_transaccion, Pin_transaccion, Tipo_transaccion, Fecha_transaccion);

        this.Id_pago = Id_pago;
        this.Monto_pago = Monto_pago;
        this.cuenta_abonante = cuenta_abonante;
        this.Tarjeta_abonante = Tarjeta_abonante;
    }

    // Métodos getter y setter para Id_pago
    public int get_Idpago() {
        return Id_pago;
    }

    public void set_Idpago(int Id_pago) {
        this.Id_pago = Id_pago;
    }

    // Métodos getter y setter para Monto_pago
    public double get_montopago() {
        return Monto_pago;
    }

    public void set_montopago(double Monto_pago) {
        this.Monto_pago = Monto_pago;
    }
}
