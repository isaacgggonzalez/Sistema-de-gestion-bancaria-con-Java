
package primer_final;

import controlador.ProcesosControlador;

import java.util.Date;

/**
 * Representa una transacción de pago de tarjeta.
 * Extiende la clase base Transaccion e incluye información específica de pago de tarjeta.
 */
public class PagoDeTarjeta extends Transaccion{
    /**
     * Tipo de transacción para pago de tarjeta.
     */
    private static final String TIPO_TRANSACCION = "Pago de tarjeta";
    /**
     * Identificador único del pago de tarjeta.
     */
    private long idPagoTarjeta;
    /**
    * Número de cuenta asociado al pago.
    */
    private long numeroCuenta;
    /**
    * Tarjeta de crédito asociada a la transacción de pago.
    */
    private TarjetaDeCredito tarjetaDeCredito;
    /**
    * Constructor de la clase PagoDeTarjeta.
    *
    * @param idPagoTarjeta     Identificador único del pago de tarjeta.
    * @param Id_transaccion    Identificador único de la transacción.
    * @param tarjetaDeCredito  Tarjeta de crédito asociada al pago.
    * @param Fecha_transaccion Fecha de la transacción.
    * @param monto_transaccion Monto de la transacción.
    */
    public PagoDeTarjeta(long idPagoTarjeta, int Id_transaccion, TarjetaDeCredito tarjetaDeCredito, Date Fecha_transaccion, double monto_transaccion) {
        super(Id_transaccion, Fecha_transaccion, monto_transaccion, TIPO_TRANSACCION);
        this.tarjetaDeCredito = tarjetaDeCredito;
        this.idPagoTarjeta = idPagoTarjeta;
    }
    /**
     * Constructor de la clase PagoDeTarjeta sin identificador adicional.
     *
     * @param Fecha_transaccion Fecha de la transacción.
     * @param tarjetaDeCredito  Tarjeta de crédito asociada al pago.
     * @param monto_transaccion Monto de la transacción.
     */
    public PagoDeTarjeta(Date Fecha_transaccion, TarjetaDeCredito tarjetaDeCredito, double monto_transaccion) {
        super(Fecha_transaccion, monto_transaccion, TIPO_TRANSACCION);
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

    /**
     * Obtiene el número de cuenta asociado al pago de tarjeta.
     *
     * @return Número de cuenta asociado al pago de tarjeta.
     */
    public long getNumeroCuenta() {
        return numeroCuenta;
    }
    /**
     * Establece el número de cuenta asociado al pago de tarjeta.
     *
     * @param numeroCuenta Nuevo número de cuenta asociado al pago de tarjeta.
     */
    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    /**
     * Obtiene la tarjeta de crédito asociada al pago.
     *
     * @return Tarjeta de crédito asociada al pago.
     */
    public TarjetaDeCredito getTarjetaDeCredito(){
     return  tarjetaDeCredito;
    }
    
    /**
     * Establece la tarjeta de crédito asociada al pago.
     *
     * @param tarjetaDeCredito Nueva tarjeta de crédito asociada al pago.
     */
    public void setTarjetaDeCredito(TarjetaDeCredito tarjetaDeCredito){
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

    /**
     * Obtiene el identificador único del pago de tarjeta.
     *
     * @return Identificador único del pago de tarjeta.
     */
    public long getIdPagoTarjeta() {
        return idPagoTarjeta;
    }
    
    /**
     * Establece el identificador único del pago de tarjeta.
     *
     * @param Id_pagoTarjeta Nuevo identificador único del pago de tarjeta.
     */
    public void setIdPagoTarjeta(long Id_pagoTarjeta) {
        this.idPagoTarjeta = Id_pagoTarjeta;
    }

    
    /**
     * Obtiene un mensaje de confirmación para la transacción de pago de tarjeta.
     *
     * @return Mensaje de confirmación.
     */
    @Override
    public String mensajeConfirmacion(){
        return "Pago de la tarjeta Nro "+tarjetaDeCredito.getNro_tarjeta()+" ha sido exitosa";
    }


    /**
     * Realiza la transacción de pago de tarjeta.
     */
    @Override
    public void run() {
        ProcesosControlador.realizarPagoTarjeta(this);
    }
}
