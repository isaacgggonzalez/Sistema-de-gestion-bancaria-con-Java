package modelo;

import controlador.ProcesosControlador;

import java.util.Date;
/**
 * Representa una transacción de transferencia entre cuentas.
 * Extiende la clase base Transaccion e incluye información específica de la transferencia.
 */
public class Transferencia extends Transaccion {
    /**
     * Tipo de transacción para transferencia.
     */
    private static final String TIPO_TRANSACCION = "Transferencia";
    /**
     * Cuenta de origen de la transferencia.
     */
    private long origenTransferencia;
    /**
     * Cuenta de destino de la transferencia.
     */
    private long destinoTransferencia;

    /**
     * Constructor de la clase Transferencia.
     *
     * @param Fecha_transaccion      Fecha de la transacción.
     * @param origenTransferencia    Cuenta de origen de la transferencia.
     * @param destinoTransferencia   Cuenta de destino de la transferencia.
     * @param Monto_transferencia    Monto de la transferencia.
     */
    public Transferencia(Date Fecha_transaccion, long origenTransferencia, long destinoTransferencia,
                         double Monto_transferencia) {
        // Llamada al constructor de la clase base (Transaccion)
        super(Fecha_transaccion, Monto_transferencia, TIPO_TRANSACCION);
        this.origenTransferencia = origenTransferencia;
        this.destinoTransferencia = destinoTransferencia;
    }

    /**
     * Constructor de la clase Transferencia con identificador adicional.
     *
     * @param Id_transaccion         Identificador único de la transacción.
     * @param Fecha_transaccion      Fecha de la transacción.
     * @param Tipo_transaccion       Tipo de transacción.
     * @param origenTransferencia    Cuenta de origen de la transferencia.
     * @param destinoTransferencia   Cuenta de destino de la transferencia.
     * @param Monto_transferencia    Monto de la transferencia.
     */
    public Transferencia(int Id_transaccion,
                         Date Fecha_transaccion, String Tipo_transaccion , long origenTransferencia, long destinoTransferencia,
                         double Monto_transferencia) {
        // Llamada al constructor de la clase base (Transaccion)
        super(Id_transaccion, Fecha_transaccion, Monto_transferencia, TIPO_TRANSACCION);
        
       
        this.origenTransferencia = origenTransferencia;
        this.destinoTransferencia = destinoTransferencia;
    }

    @Override
    public String mensajeConfirmacion(){
        return "La transferencia a la cuenta "+ this.destinoTransferencia+" ha sido exitosa";
    }

   
    
    /**
     * Obtiene la cuenta de origen de la transferencia.
     *
     * @return Cuenta de origen de la transferencia.
     */
    public long get_origenTransferencia() {
        return origenTransferencia;
    }
    /**
     * Establece la cuenta de origen de la transferencia.
     *
     * @param origen_transferencia Nueva cuenta de origen de la transferencia.
     */
    public void set_origenTransferencia(long origen_transferencia) {
        this.origenTransferencia = origen_transferencia;
    }


    /**
     * Obtiene la cuenta de destino de la transferencia.
     *
     * @return Cuenta de destino de la transferencia.
     */
    public long get_destinoTransferencia() {
        return destinoTransferencia;
    }
    /**
     * Establece la cuenta de destino de la transferencia.
     *
     * @param destino_transferencia Nueva cuenta de destino de la transferencia.
     */
    public void set_destinoTransferencia(long destino_transferencia) {
        this.destinoTransferencia = destino_transferencia;
    }

    /**
     * Realiza la transferencia.
     */

    @Override
    public void run() {
        ProcesosControlador.realizarTransferencia(this);
    }
}
