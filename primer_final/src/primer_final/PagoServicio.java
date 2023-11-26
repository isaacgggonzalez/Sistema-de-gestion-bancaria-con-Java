
package primer_final;

import java.sql.Timestamp;
import java.util.Date;

public class PagoServicio extends Transaccion {
    private TarjetaDeCredito tarjeta_abonante; 
    private String Tipo_transaccion = "Pago de Servicio";
    
    // Constructor
    public PagoServicio(int Id_pago, int Id_transaccion, int Pin_transaccion, 
            Date Fecha_transaccion, String Tipo_transaccion, 
            Cuenta cuenta_abonante, TarjetaDeCredito tarjeta_abonante, double monto_transaccion) {
        // Llamada al constructor de la clase base (Transaccion)
        super(Id_transaccion, Fecha_transaccion, monto_transaccion);
        
        this.Tipo_transaccion = Tipo_transaccion;
        this.tarjeta_abonante = tarjeta_abonante;
    }
    
    // Métodos getter y setter para origen_transferencia
    public String get_tipo_transaccion() {
        return Tipo_transaccion;
    }
    
    
    // Métodos getter y setter para tarjeta_abonante
    public TarjetaDeCredito getTarjeta_abonante() {
        return tarjeta_abonante;
    }
    
    public void setTarjeta_abonante(TarjetaDeCredito tarjeta_abonante) {
        this.tarjeta_abonante = tarjeta_abonante;
    }
}
