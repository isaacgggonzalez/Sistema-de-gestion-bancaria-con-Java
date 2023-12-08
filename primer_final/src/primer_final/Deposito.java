package primer_final;

import controlador.ProcesosControlador;

import java.util.Date;
/**
 * Representa una transacción de depósito en una cuenta.
 * Extiende la clase base Transaccion e incluye información específica de depósito.
 */
public class Deposito extends Transaccion {
    /**
     * Tipo de transacción para depósito.
     */
    private static final String TIPO_TRANSACCION = "Deposito";
   
    /**
     * Cuenta de destino del depósito.
     */
    private Cuenta cuentaDestino;
    /**
     * Constructor de la clase Deposito.
     *
     * @param Pin_transaccion    PIN de la transacción.
     * @param tipoTransaccion    Tipo de transacción.
     * @param Fecha_transaccion  Fecha de la transacción.
     * @param cuentaDestino      Cuenta de destino del depósito.
     * @param monto_transaccion  Monto de la transacción.
     */
    public Deposito(int Pin_transaccion, String tipoTransaccion,
                    Date Fecha_transaccion, Cuenta cuentaDestino, double monto_transaccion) {
        // Llamada al constructor de la clase base (Transaccion)
        super(Fecha_transaccion, monto_transaccion, TIPO_TRANSACCION);

        this.cuentaDestino = cuentaDestino;
    }

    // Constructor
    /**
     * Constructor de la clase Deposito con identificador adicional.
     *
     * @param Id_transaccion     Identificador único de la transacción.
     * @param Pin_transaccion    PIN de la transacción.
     * @param Fecha_transaccion  Fecha de la transacción.
     * @param cuentaDestino      Cuenta de destino del depósito.
     * @param monto_transaccion  Monto de la transacción.
     */
    public Deposito(int Id_transaccion, int Pin_transaccion,
                    Date Fecha_transaccion, Cuenta cuentaDestino, double monto_transaccion) {
        // Llamada al constructor de la clase base (Transaccion)
        super(Id_transaccion, Fecha_transaccion, monto_transaccion, TIPO_TRANSACCION);

        this.cuentaDestino = cuentaDestino;
    }
    /**
     * Constructor de la clase Deposito sin identificador adicional.
     *
     * @param Fecha_transaccion  Fecha de la transacción.
     * @param cuentaDestino      Cuenta de destino del depósito.
     * @param monto_transaccion  Monto de la transacción.
     */
    public Deposito(Date Fecha_transaccion, Cuenta cuentaDestino, double monto_transaccion) {
        // Llamada al constructor de la clase base (Transaccion)
        super(Fecha_transaccion, monto_transaccion, TIPO_TRANSACCION);
        this.cuentaDestino = cuentaDestino;
    }

    /**
     * Obtiene la cuenta de destino del depósito.
     *
     * @return Cuenta de destino del depósito.
     */
    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }
    /**
     * Establece la cuenta de destino del depósito.
     *
     * @param cuentaDestino Nueva cuenta de destino del depósito.
     */
    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }
    
    /**
     * Realiza la transacción de depósito.
     */
    @Override
    public void realizarTransaccion(){
        ProcesosControlador.realizarDeposito(this);
    }
    /**
     * Obtiene un mensaje de confirmación para la transacción de depósito.
     *
     * @return Mensaje de confirmación.
     */
    @Override
    public String mensajeConfirmacion(){return "El deposito a la cuenta "+cuentaDestino.getNumeroCuenta()+" con monto "+getMontoTransaccion()+
            " Gs ha sido exitosa";}
}
