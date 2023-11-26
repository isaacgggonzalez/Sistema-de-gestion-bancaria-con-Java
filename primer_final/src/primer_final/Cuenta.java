package primer_final;
import java.math.BigDecimal;


public class Cuenta{
    private long id_cuenta;
    private long pin_cuenta;
    private double saldo_cuenta;
    private long id_cliente;
    private int Pin_transaccion;
    private long numero_cuenta;

    // Constructor
    public Cuenta(long id_cuenta,long numero_cuenta, long pin_cuenta, double saldo_cuenta, long id_cliente, int Pin_transaccion) {
        this.id_cuenta = id_cuenta;
        this.numero_cuenta = numero_cuenta;
        this.id_cliente = id_cliente;
        this.pin_cuenta = pin_cuenta;
        this.saldo_cuenta = saldo_cuenta;
        this.Pin_transaccion = Pin_transaccion;
    }

    // Getter y Setter para cada atributo

    public long getId_cuenta() {
        return id_cuenta;
    }

    public long getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(long numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public void setId_cuenta(long id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public long getPin_cuenta() {
        return pin_cuenta;
    }

    public void setPin_cuenta(long pin_cuenta) {
        this.pin_cuenta = pin_cuenta;
    }

    public double getSaldo_cuenta() {
        return saldo_cuenta;
    }

    public void setSaldo_cuenta(double saldo_cuenta) {
        this.saldo_cuenta = saldo_cuenta;
    }

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    public int getPin_transaccion() {
        return Pin_transaccion;
    }

    public void setPin_transaccion(int Pin_transaccion) {
        this.Pin_transaccion = Pin_transaccion;
    }
    

}
