package modelo;

import controlador.ProcesosControlador;

/**
 * La clase ValidarPinTransaccion implementa la interfaz Runnable y se utiliza para validar un PIN de transacción.
 * Se ejecuta en un hilo separado para realizar la validación de forma asíncrona.
 */
public class ValidarPinTransaccion implements Runnable{

    private long pinTransaccion;
    private boolean pinValido;

    /**
     * Construye una nueva instancia de ValidarPinTransaccion con el PIN de transacción proporcionado.
     *
     * @param pinTransaccion El PIN de la transacción que se va a validar.
     */
    public ValidarPinTransaccion(long pinTransaccion) {
        this.pinTransaccion = pinTransaccion;
    }
    /**
     * Obtiene el estado de validez del PIN de transacción.
     *
     * @return true si el PIN de la transacción es válido, false en caso contrario.
     */
    public boolean esPinValido() {
        return pinValido;
    }
    /**
     * Ejecuta la validación del PIN de transacción en un hilo separado.
     * El resultado se almacena en la variable pinValido.
     */
    @Override
    public void run() {
        pinValido = ProcesosControlador.validarPinTransaccion(pinTransaccion);
    }
    /**
     * Obtiene el PIN de la transacción.
     *
     * @return El PIN de la transacción.
     */
    public long getPinTransaccion() {
        return pinTransaccion;
    }
    /**
     * Establece un nuevo valor para el PIN de la transacción.
     *
     * @param pinTransaccion El nuevo valor del PIN de la transacción.
     */
    public void setPinTransaccion(long pinTransaccion) {
        this.pinTransaccion = pinTransaccion;
    }
}
