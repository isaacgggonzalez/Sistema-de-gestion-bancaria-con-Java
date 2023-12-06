
package primer_final;

import controlador.ProcesosControlador;

import java.util.Date;

public class PagoServicio extends Transaccion {
    private static final String TIPO_TRANSACCION = "Pago de Servicio";
    private TarjetaDeCredito tarjetaAbonante;

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    private Cuenta cuenta;

    private Servicio servicio;



    public PagoServicio(Date Fecha_transaccion,
                        Cuenta cuenta_abonante, TarjetaDeCredito tarjetaAbonante, double monto_transaccion) {
        // Llamada al constructor de la clase base (Transaccion)
        super(Fecha_transaccion, monto_transaccion, TIPO_TRANSACCION);
        this.cuenta = cuenta_abonante;
        this.tarjetaAbonante = tarjetaAbonante;
    }


    // Constructor
    public PagoServicio(int Id_pago, int Id_transaccion, int Pin_transaccion,
                        Date Fecha_transaccion, String tipoTransaccion,
                        Cuenta cuenta_abonante, TarjetaDeCredito tarjetaAbonante, double monto_transaccion) {
        // Llamada al constructor de la clase base (Transaccion)
        super(Id_transaccion, Fecha_transaccion, monto_transaccion, TIPO_TRANSACCION);

        this.tarjetaAbonante = tarjetaAbonante;
    }
    
    // Métodos getter y setter para origen_transferencia

    // Métodos getter y setter para tarjeta_abonante
    public TarjetaDeCredito getTarjetaAbonante() {
        return tarjetaAbonante;
    }

    @Override
    public void realizarTransaccion(){
        ProcesosControlador.realizarPagoServicio(this);
    }

    @Override
    public String mensajeConfirmacion(){
        return "Pago del servicio "+ this.servicio.get_NombreServicio()+" con monto "+ getMontoTransaccion()+" ha sido exitosa";
    }


    public void setTarjetaAbonante(TarjetaDeCredito tarjetaAbonante) {
        this.tarjetaAbonante = tarjetaAbonante;
    }
}
