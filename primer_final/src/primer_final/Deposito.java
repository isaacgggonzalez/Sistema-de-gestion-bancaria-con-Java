package primer_final;

import controlador.ProcesosControlador;

import java.util.Date;

public class Deposito extends Transaccion {
    private static final String TIPO_TRANSACCION = "Deposito";
    private Cuenta cuentaDestino;

    public Deposito(int Pin_transaccion, String tipoTransaccion,
                    Date Fecha_transaccion, Cuenta cuentaDestino, double monto_transaccion) {
        // Llamada al constructor de la clase base (Transaccion)
        super(Fecha_transaccion, monto_transaccion, TIPO_TRANSACCION);

        this.cuentaDestino = cuentaDestino;
    }

    // Constructor
    public Deposito(int Id_transaccion, int Pin_transaccion,
                    Date Fecha_transaccion, Cuenta cuentaDestino, double monto_transaccion) {
        // Llamada al constructor de la clase base (Transaccion)
        super(Id_transaccion, Fecha_transaccion, monto_transaccion, TIPO_TRANSACCION);

        this.cuentaDestino = cuentaDestino;
    }

    public Deposito(Date Fecha_transaccion, Cuenta cuentaDestino, double monto_transaccion) {
        // Llamada al constructor de la clase base (Transaccion)
        super(Fecha_transaccion, monto_transaccion, TIPO_TRANSACCION);
        this.cuentaDestino = cuentaDestino;
    }

    // Métodos getter y setter para monto_deposito
    

    // Métodos getter y setter para cuenta_destino
    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    @Override
    public void realizarTransaccion(){
        ProcesosControlador.realizarDeposito(this);
    }

    @Override
    public String mensajeConfirmacion(){return "El deposito a la cuenta con monto " + getMontoTransaccion()+
            "Gs "+ cuentaDestino.getNumeroCuenta() + " ha sido exitosa";}
}
