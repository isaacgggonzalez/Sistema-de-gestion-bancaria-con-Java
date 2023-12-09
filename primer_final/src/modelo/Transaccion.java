package modelo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Representa una transacción con información como su identificador, monto, fecha y tipo.
 */
public abstract class Transaccion implements Runnable {
    /**
     * Identificador único de la transacción.
     */
    private long idTransaccion;
    /**
     * Monto de la transacción.
     */
    private double montoTransaccion;
    /**
     * Fecha de la transacción.
     */
    private Date fechaTransaccion;
    /**
     * Tipo de la transacción.
     */
    private final String tipoTransaccion;

    public Transaccion(){
        tipoTransaccion = "";
    }

    /**
     * Constructor de la clase Transaccion.
     *
     * @param fechaTransaccion Fecha de la transacción.
     * @param montoTransaccion Monto de la transacción.
     * @param tipoTransaccion  Tipo de la transacción.
     */
    public Transaccion(Date fechaTransaccion, double montoTransaccion, String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.montoTransaccion = montoTransaccion;
    }
    /**
     * Constructor de la clase Transaccion con identificador adicional.
     *
     * @param idTransaccion    Identificador único de la transacción.
     * @param fechaTransaccion Fecha de la transacción.
     * @param montoTransaccion Monto de la transacción.
     * @param tipoTransaccion  Tipo de la transacción.
     */
    public Transaccion(long idTransaccion,
                       Date fechaTransaccion, double montoTransaccion, String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
        this.idTransaccion = idTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.montoTransaccion = montoTransaccion;
    }

    /**
     * Obtiene el mensaje de confirmación de la transacción.
     *
     * @return Mensaje de confirmación.
     */
    public String mensajeConfirmacion(){return "";}
    
    /**
     * Obtiene el identificador único de la transacción.
     *
     * @return Identificador único de la transacción.
     */
    public long getIdTransaccion() {
        return idTransaccion;
    }
    /**
     * Obtiene el tipo de la transacción.
     *
     * @return Tipo de la transacción.
     */
    public String getTipoTransaccion() {
        return tipoTransaccion;
    }
    /**
     * Establece el identificador único de la transacción.
     *
     * @param Id_transaccion Nuevo identificador único de la transacción.
     */
    public void setIdTransaccion(int Id_transaccion) {
        this.idTransaccion = Id_transaccion;
    }
    /**
     * Establece la fecha de la transacción como la fecha actual.
     */
    public void set_fecha_transaccion(Date fecha) {
        this.fechaTransaccion =  new Timestamp(System.currentTimeMillis());
    }
    /**
     * Obtiene la fecha de la transacción.
     *
     * @return Fecha de la transacción.
     */
    public Date get_fecha_transaccion() {
        return fechaTransaccion;
    }
    /**
     * Obtiene el monto de la transacción.
     *
     * @return Monto de la transacción.
     */
    public double getMontoTransaccion() {
        return montoTransaccion;
    }
    /**
     * Establece el monto de la transacción.
     *
     * @param montoTransaccion Nuevo monto de la transacción.
     */
    public void setMontoTransaccion(double montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }  
}
