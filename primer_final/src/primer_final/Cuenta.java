package primer_final;
public class Cuenta{
    private int id_cuenta;
    private int pin_cuenta;
    private double saldo_cuenta;
    private int id_cliente;

    // Constructor
    public Cuenta(int id_cuenta, int pin_cuenta, double saldo_cuenta, int id_cliente) {
        this.id_cuenta = id_cuenta;
        this.id_cliente = id_cliente;
        this.pin_cuenta = pin_cuenta;
        this.saldo_cuenta = saldo_cuenta;
    }

    // Getter y Setter para cada atributo

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public int getPin_cuenta() {
        return pin_cuenta;
    }

    public void setPin_cuenta(int pin_cuenta) {
        this.pin_cuenta = pin_cuenta;
    }

    public double getSaldo_cuenta() {
        return saldo_cuenta;
    }

    public void setSaldo_cuenta(double saldo_cuenta) {
        this.saldo_cuenta = saldo_cuenta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

}
