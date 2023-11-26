
package primer_final;

import java.util.Date;


public class PagoDeTarjeta extends Transaccion{
    private long Id_pagoTarjeta;
    private String pago_tarjeta = "Pago de Tarjeta";
    
    public PagoDeTarjeta(long Id_pagoTarjeta, int Id_transaccion,String pago_tarjeta, Date Fecha_transaccion, double monto_transaccion) {
        super(Id_transaccion, Fecha_transaccion, monto_transaccion);
        
        this.pago_tarjeta = pago_tarjeta;
        this.Id_pagoTarjeta = Id_pagoTarjeta;
    }

    public String getPago_tarjeta() {
        return pago_tarjeta;
    }

    public void setPago_tarjeta(String pago_tarjeta) {
        this.pago_tarjeta = pago_tarjeta;
    }

    public long getId_pagoTarjeta() {
        return Id_pagoTarjeta;
    }

    public void setId_pagoTarjeta(long Id_pagoTarjeta) {
        this.Id_pagoTarjeta = Id_pagoTarjeta;
    }
    
    
}
