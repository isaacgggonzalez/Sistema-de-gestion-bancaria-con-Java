
package primer_final;

import java.util.Date;


public class PagoDeTarjeta extends Transaccion{
    private static final String TIPO_TRANSACCION = "Pago de tarjeta";
    private long idPagoTarjeta;
    private String pagoTarjeta = "Pago de Tarjeta";

    private TarjetaDeCredito tarjetaDeCredito;
    
    public PagoDeTarjeta(long idPagoTarjeta, int Id_transaccion, String pagoTarjeta, Date Fecha_transaccion, double monto_transaccion) {
        super(Id_transaccion, Fecha_transaccion, monto_transaccion, TIPO_TRANSACCION);
        
        this.pagoTarjeta = pagoTarjeta;
        this.idPagoTarjeta = idPagoTarjeta;
    }

    public String getPagoTarjeta() {
        return pagoTarjeta;
    }

    public TarjetaDeCredito getTarjetaDeCredito(){
     return  tarjetaDeCredito;
    }
    public void setTarjetaDeCredito(TarjetaDeCredito tarjetaDeCredito){
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

    public void setPagoTarjeta(String pagoTarjeta) {
        this.pagoTarjeta = pagoTarjeta;
    }

    public long getIdPagoTarjeta() {
        return idPagoTarjeta;
    }

    public void setIdPagoTarjeta(long Id_pagoTarjeta) {
        this.idPagoTarjeta = Id_pagoTarjeta;
    }
    
    
}
