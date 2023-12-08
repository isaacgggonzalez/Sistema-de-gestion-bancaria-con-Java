package modelo;

import primer_final.Cuenta;
import primer_final.Transaccion;
import java.util.Date;

/**
 * Representa un movimiento financiero asociado a una cuenta.
 * Extiende la clase base Transaccion e incluye información específica de un movimiento.
 */
public class Movimiento extends Transaccion {
    /**
     * Cuenta asociada al movimiento.
     */
    private Cuenta cuenta;

    /**
     * Constructor de la clase Movimiento.
     *
     * @param fechaTransaccion Fecha de la transacción.
     * @param montoTransaccion Monto de la transacción.
     * @param tipoTransaccion  Tipo de la transacción.
     */
    public Movimiento(Date fechaTransaccion, double montoTransaccion, String tipoTransaccion) {
        super(fechaTransaccion, montoTransaccion, tipoTransaccion);
    }
    
    /**
     * Constructor de la clase Movimiento con identificador adicional.
     *
     * @param idTransaccion    Identificador único de la transacción.
     * @param fechaTransaccion Fecha de la transacción.
     * @param montoTransaccion Monto de la transacción.
     * @param tipoTransaccion  Tipo de la transacción.
     */
    public Movimiento(long idTransaccion, Date fechaTransaccion, double montoTransaccion, String tipoTransaccion) {
        super(idTransaccion, fechaTransaccion, montoTransaccion, tipoTransaccion);
    }

    /**
     * Obtiene la cuenta asociada al movimiento.
     *
     * @return Cuenta asociada al movimiento.
     */
    public Cuenta getCuenta() {
        return cuenta;
    }
    /**
     * Establece la cuenta asociada al movimiento.
     *
     * @param cuenta Nueva cuenta asociada al movimiento.
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
