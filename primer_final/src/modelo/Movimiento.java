package modelo;

import primer_final.Cuenta;
import primer_final.Transaccion;

import java.util.Date;

public class Movimiento extends Transaccion {
    private Cuenta cuenta;

    public Movimiento(Date fechaTransaccion, double montoTransaccion, String tipoTransaccion) {
        super(fechaTransaccion, montoTransaccion, tipoTransaccion);
    }
    public Movimiento(long idTransaccion, Date fechaTransaccion, double montoTransaccion, String tipoTransaccion) {
        super(idTransaccion, fechaTransaccion, montoTransaccion, tipoTransaccion);
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
