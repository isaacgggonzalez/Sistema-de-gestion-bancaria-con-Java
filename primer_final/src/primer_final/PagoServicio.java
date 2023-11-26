
package primer_final;

import java.util.Date;

public class PagoServicio extends Transaccion {
    private static final String TIPO_TRANSACCION = "Pago de Servicio";
    private TarjetaDeCredito tarjetaAbonante;

    private Servicio servicio;


    public PagoServicio(int Id_pago, int Pin_transaccion,
                        Date Fecha_transaccion, String tipoTransaccion,
                        Cuenta cuenta_abonante, TarjetaDeCredito tarjetaAbonante, double monto_transaccion) {
        // Llamada al constructor de la clase base (Transaccion)
        super(Fecha_transaccion, monto_transaccion, TIPO_TRANSACCION);
        this.tarjetaAbonante = tarjetaAbonante;
    }


    // Constructor
    public PagoServicio(int Id_pago, int Id_transaccion, int Pin_transaccion,
                        Date Fecha_transaccion, String tipoTransaccion,
                        Cuenta cuenta_abonante, TarjetaDeCredito tarjetaAbonante, double monto_transaccion) {
        // Llamada al constructor de la clase base (Transaccion)
        super(Id_transaccion, Fecha_transaccion, monto_transaccion, TIPO_TRANSACCION);

        this.tarjetaAbonante = tarjetaAbonante;
    }
    
    // Métodos getter y setter para origen_transferencia

    // Métodos getter y setter para tarjeta_abonante
    public TarjetaDeCredito getTarjetaAbonante() {
        return tarjetaAbonante;
    }
    
    public void setTarjetaAbonante(TarjetaDeCredito tarjetaAbonante) {
        this.tarjetaAbonante = tarjetaAbonante;
    }
}
