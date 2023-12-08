package primer_final;

import controlador.ProcesosControlador;

public class ValidarPinTransaccion implements Runnable{

    private long pinTransaccion;
    private boolean pinValido;


    public boolean esPinValido() {
        return pinValido;
    }


    public ValidarPinTransaccion(long pinTransaccion) {
        this.pinTransaccion = pinTransaccion;
    }


    @Override
    public void run() {
        pinValido = ProcesosControlador.validarPinTransaccion(pinTransaccion);
    }

    public long getPinTransaccion() {
        return pinTransaccion;
    }

    public void setPinTransaccion(long pinTransaccion) {
        this.pinTransaccion = pinTransaccion;
    }
}
