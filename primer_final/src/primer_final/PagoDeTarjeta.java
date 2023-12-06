
package primer_final;

import controlador.ProcesosControlador;

import java.util.Date;


public class PagoDeTarjeta extends Transaccion{
    private static final String TIPO_TRANSACCION = "Pago de tarjeta";
    private long idPagoTarjeta;

    private long numeroCuenta;

    private TarjetaDeCredito tarjetaDeCredito;

    public PagoDeTarjeta(long idPagoTarjeta, int Id_transaccion, TarjetaDeCredito tarjetaDeCredito, Date Fecha_transaccion, double monto_transaccion) {
        super(Id_transaccion, Fecha_transaccion, monto_transaccion, TIPO_TRANSACCION);
        this.tarjetaDeCredito = tarjetaDeCredito;
        this.idPagoTarjeta = idPagoTarjeta;
    }

    public PagoDeTarjeta(Date Fecha_transaccion, TarjetaDeCredito tarjetaDeCredito, double monto_transaccion) {
        super(Fecha_transaccion, monto_transaccion, TIPO_TRANSACCION);
        this.tarjetaDeCredito = tarjetaDeCredito;
    }


    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public TarjetaDeCredito getTarjetaDeCredito(){
     return  tarjetaDeCredito;
    }
    public void setTarjetaDeCredito(TarjetaDeCredito tarjetaDeCredito){
        this.tarjetaDeCredito = tarjetaDeCredito;
    }


    public long getIdPagoTarjeta() {
        return idPagoTarjeta;
    }

    public void setIdPagoTarjeta(long Id_pagoTarjeta) {
        this.idPagoTarjeta = Id_pagoTarjeta;
    }

    @Override
    public void realizarTransaccion(){
        ProcesosControlador.realizarPagoTarjeta(this);
    }

    @Override
    public String mensajeConfirmacion(){
        return "Pago de la tarjeta Nro "+tarjetaDeCredito.getNro_tarjeta()+" ha sido exitosa";
    }

    
}
