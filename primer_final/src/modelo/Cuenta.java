package modelo;

/**
 * Representa una cuenta con información esencial.
 * Esta clase proporciona métodos para obtener y establecer detalles de la cuenta.
 */
public class Cuenta{
    /**
     * Identificador único de la cuenta.
     */
    private long idCuenta;
    /**
     * PIN de la cuenta.
     */
    private long pinCuenta;
    /**
     * Saldo actual de la cuenta.
     */
    private double saldoCuenta;
    /**
     * Identificador único del cliente.
     */
    private long idCliente;
    /**
     * PIN de transacción asociado a la cuenta.
     */
    private int pinTransaccion;
    /**
     * Número único de la cuenta.
     */
    private long numeroCuenta;

    // Constructor
    /**
     * Constructor de la clase Cuenta.
     *
     * @param idCuenta        Identificador único de la cuenta.
     * @param numeroCuenta    Número único de la cuenta.
     * @param pinCuenta       PIN de la cuenta.
     * @param saldoCuenta     Saldo actual de la cuenta.
     * @param idCliente       Número de identificación del cliente asociado a la cuenta.
     * @param pinTransaccion  PIN de transacción asociado a la cuenta.
     */
    public Cuenta(long idCuenta, long numeroCuenta, long pinCuenta, double saldoCuenta, long idCliente, int pinTransaccion) {
        this.idCuenta = idCuenta;
        this.numeroCuenta = numeroCuenta;
        this.idCliente = idCliente;
        this.pinCuenta = pinCuenta;
        this.saldoCuenta = saldoCuenta;
        this.pinTransaccion = pinTransaccion;
    }

    /**
     * Obtiene el identificador único de la cuenta.
     *
     * @return Identificador único de la cuenta.
     */
    public long getIdCuenta() {
        return idCuenta;
    }
    /**
     * Establece el identificador único de la cuenta.
     *
     * @param idCuenta Nuevo identificador único de la cuenta.
     */
    public void setIdCuenta(long idCuenta) {
        this.idCuenta = idCuenta;
    }
    
    /**
     * Obtiene el número único de la cuenta.
     *
     * @return Número único de la cuenta.
     */
    public long getNumeroCuenta() {
        return numeroCuenta;
    }
    /**
     * Establece el número único de la cuenta.
     *
     * @param numeroCuenta Nuevo número único de la cuenta.
     */
    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    
    /**
     * Obtiene el PIN de la cuenta.
     *
     * @return PIN de la cuenta.
     */
    public long getPinCuenta() {
        return pinCuenta;
    }
    /**
     * Establece el PIN de la cuenta.
     *
     * @param pinCuenta Nuevo PIN de la cuenta.
     */
    public void setPinCuenta(long pinCuenta) {
        this.pinCuenta = pinCuenta;
    }
    /**
     * Obtiene el saldo actual de la cuenta.
     *
     * @return Saldo actual de la cuenta.
     */
    public double getSaldoCuenta() {   
        return saldoCuenta;
    }
    /**
     * Establece el saldo actual de la cuenta.
     *
     * @param saldoCuenta Nuevo saldo actual de la cuenta.
     */
    public void setSaldoCuenta(double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }
    /**
     * Obtiene el número de identificación del cliente asociado a la cuenta.
     *
     * @return Número de identificación del cliente asociado a la cuenta.
     */
    public long getIdCliente() {
        return idCliente;
    }
    /**
     * Establece el número de identificación del cliente asociado a la cuenta.
     *
     * @param idCliente Nuevo número de identificación del cliente asociado a la cuenta.
     */
    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
    /**
     * Obtiene el PIN de transacción asociado a la cuenta.
     *
     * @return PIN de transacción asociado a la cuenta.
     */
    public int getPinTransaccion() {
        return pinTransaccion;
    }
    /**
     * Establece el PIN de transacción asociado a la cuenta.
     *
     * @param pinTransaccion Nuevo PIN de transacción asociado a la cuenta.
     */
    public void setPinTransaccion(int Pin_transaccion) {
        this.pinTransaccion = Pin_transaccion;
    }
    

}
