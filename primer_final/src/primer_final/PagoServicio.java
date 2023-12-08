package primer_final;

import controlador.ProcesosControlador;
import java.util.Date;

/**
 * Representa una transacción de pago de servicio.
 * Extiende la clase base Transaccion e incluye información específica de pago de servicio.
 */
public class PagoServicio extends Transaccion {
    
    /**
     * Tipo de transacción para pago de servicio.
     */
    private static final String TIPO_TRANSACCION = "Pago de Servicio";
    
    /**
     * Tarjeta de crédito asociada al pago de servicio.
     */
    private TarjetaDeCredito tarjetaAbonante;

    /**
     * Cuenta abonante asociada al pago de servicio.
     */
    private Cuenta cuenta;

    /**
     * Servicio al que se realiza el pago.
     */
    private Servicio servicio;

    /**
     * Constructor de la clase PagoServicio.
     *
     * @param Fecha_transaccion    Fecha de la transacción.
     * @param cuenta_abonante     Cuenta abonante asociada al pago de servicio.
     * @param tarjetaAbonante     Tarjeta de crédito asociada al pago de servicio.
     * @param monto_transaccion   Monto de la transacción.
     */
    public PagoServicio(Date Fecha_transaccion, Cuenta cuenta_abonante, 
                        TarjetaDeCredito tarjetaAbonante, double monto_transaccion) {
        // Llamada al constructor de la clase base (Transaccion)
        super(Fecha_transaccion, monto_transaccion, TIPO_TRANSACCION);
        this.cuenta = cuenta_abonante;
        this.tarjetaAbonante = tarjetaAbonante;
    }

    /**
     * Constructor de la clase PagoServicio con identificador adicional.
     *
     * @param Id_pago              Identificador único del pago de servicio.
     * @param Id_transaccion       Identificador único de la transacción.
     * @param Pin_transaccion      PIN de la transacción.
     * @param Fecha_transaccion    Fecha de la transacción.
     * @param tipoTransaccion      Tipo de transacción.
     * @param cuenta_abonante      Cuenta abonante asociada al pago de servicio.
     * @param tarjetaAbonante      Tarjeta de crédito asociada al pago de servicio.
     * @param monto_transaccion    Monto de la transacción.
     */
    public PagoServicio(int Id_pago, int Id_transaccion, int Pin_transaccion,
                        Date Fecha_transaccion, String tipoTransaccion,
                        Cuenta cuenta_abonante, TarjetaDeCredito tarjetaAbonante, double monto_transaccion) {
        // Llamada al constructor de la clase base (Transaccion)
        super(Id_transaccion, Fecha_transaccion, monto_transaccion, TIPO_TRANSACCION);

        this.tarjetaAbonante = tarjetaAbonante;
    }

    /**
     * Obtiene la tarjeta de crédito asociada al pago de servicio.
     *
     * @return Tarjeta de crédito asociada al pago de servicio.
     */
    public TarjetaDeCredito getTarjetaAbonante() {
        return tarjetaAbonante;
    }

    /**
     * Establece la tarjeta de crédito asociada al pago de servicio.
     *
     * @param tarjetaAbonante Nueva tarjeta de crédito asociada al pago de servicio.
     */
    public void setTarjetaAbonante(TarjetaDeCredito tarjetaAbonante) {
        this.tarjetaAbonante = tarjetaAbonante;
    }

    /**
     * Obtiene la cuenta abonante asociada al pago de servicio.
     *
     * @return Cuenta abonante asociada al pago de servicio.
     */
    public Cuenta getCuenta() {
        return cuenta;
    }

    /**
     * Establece la cuenta abonante asociada al pago de servicio.
     *
     * @param cuenta Nueva cuenta abonante asociada al pago de servicio.
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Obtiene el servicio al que se realiza el pago.
     *
     * @return Servicio al que se realiza el pago.
     */
    public Servicio getServicio() {
        return servicio;
    }

    /**
     * Establece el servicio al que se realiza el pago.
     *
     * @param servicio Nuevo servicio al que se realiza el pago.
     */
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    /**
     * Realiza la transacción de pago de servicio.
     */
    @Override
    public void realizarTransaccion() {
        ProcesosControlador.realizarPagoServicio(this);
    }

    /**
     * Obtiene un mensaje de confirmación para la transacción de pago de servicio.
     *
     * @return Mensaje de confirmación.
     */
    @Override
    public String mensajeConfirmacion() {
        return "Pago del servicio " + this.servicio.get_NombreServicio() + 
               " con monto " + getMontoTransaccion() + " ha sido exitoso";
    }
}
