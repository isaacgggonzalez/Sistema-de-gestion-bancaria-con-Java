package primer_final;


public class Cuenta{
    private long idCuenta;
    private long pinCuenta;
    private double saldoCuenta;
    private long idCliente;
    private int pinTransaccion;
    private long numeroCuenta;

    // Constructor
    public Cuenta(long idCuenta, long numeroCuenta, long pinCuenta, double saldoCuenta, long idCliente, int pinTransaccion) {
        this.idCuenta = idCuenta;
        this.numeroCuenta = numeroCuenta;
        this.idCliente = idCliente;
        this.pinCuenta = pinCuenta;
        this.saldoCuenta = saldoCuenta;
        this.pinTransaccion = pinTransaccion;
    }

    // Getter y Setter para cada atributo

    public long getIdCuenta() {
        return idCuenta;
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setIdCuenta(long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public long getPinCuenta() {
        return pinCuenta;
    }

    public void setPinCuenta(long pinCuenta) {
        this.pinCuenta = pinCuenta;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
    
    public int getPinTransaccion() {
        return pinTransaccion;
    }

    public void setPinTransaccion(int Pin_transaccion) {
        this.pinTransaccion = Pin_transaccion;
    }
    

}
