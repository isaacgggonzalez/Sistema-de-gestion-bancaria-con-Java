package primer_final;

public class Transferencia extends Transaccion {
    private double Monto_transferencia;
    private String origen_transferencia;
    private String destino_transferencia;

    // Constructor
    public Transferencia(int Id_transaccion, int Pin_transaccion, String Tipo_transaccion, 
            String Fecha_transaccion,double Monto_transferencia, 
            String origen_transferencia, String destino_transferencia) {
        // Llamada al constructor de la clase base (Transaccion)
        super(Id_transaccion, Pin_transaccion, Tipo_transaccion, Fecha_transaccion);

        this.Monto_transferencia = Monto_transferencia;
        this.origen_transferencia = origen_transferencia;
        this.destino_transferencia = destino_transferencia;
    }

    // Métodos getter y setter para Monto_transferencia
    public double get_montoTransferencia() {
        return Monto_transferencia;
    }

    public void set_montoTransferencia(double Monto_transferencia) {
        this.Monto_transferencia = Monto_transferencia;
    }

    // Métodos getter y setter para origen_transferencia
    public String get_origenTransferencia() {
        return origen_transferencia;
    }

    public void set_origenTransferencia(String origen_transferencia) {
        this.origen_transferencia = origen_transferencia;
    }

    // Métodos getter y setter para destino_transferencia
    public String get_destinoTransferencia() {
        return destino_transferencia;
    }

    public void set_destinoTransferencia(String destino_transferencia) {
        this.destino_transferencia = destino_transferencia;
    }
}
