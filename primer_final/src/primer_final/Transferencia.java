package primer_final;

import controlador.ProcesosControlador;

import java.util.Date;

public class Transferencia extends Transaccion {
    private static final String TIPO_TRANSACCION = "Transferencia";
    private long origenTransferencia;
    private long destinoTransferencia;



    public Transferencia(Date Fecha_transaccion, long origenTransferencia, long destinoTransferencia,
                         double Monto_transferencia) {
        // Llamada al constructor de la clase base (Transaccion)
        super(Fecha_transaccion, Monto_transferencia, TIPO_TRANSACCION);
        this.origenTransferencia = origenTransferencia;
        this.destinoTransferencia = destinoTransferencia;
    }

    // Constructor
    public Transferencia(int Id_transaccion,
                         Date Fecha_transaccion, String Tipo_transaccion , long origenTransferencia, long destinoTransferencia,
                         double Monto_transferencia) {
        // Llamada al constructor de la clase base (Transaccion)
        super(Id_transaccion, Fecha_transaccion, Monto_transferencia, TIPO_TRANSACCION);
        
       
        this.origenTransferencia = origenTransferencia;
        this.destinoTransferencia = destinoTransferencia;
    }

    @Override
    public void realizarTransaccion(){
        ProcesosControlador.realizarTransferencia(this);
    }

    @Override
    public String mensajeConfirmacion(){
        return "La transferencia a la cuenta "+ this.destinoTransferencia+" ha sido exitosa";
    }

   
    
    // Métodos getter y setter para origen_transferencia
    public long get_origenTransferencia() {
        return origenTransferencia;
    }

    public void set_origenTransferencia(long origen_transferencia) {
        this.origenTransferencia = origen_transferencia;
    }


    // Métodos getter y setter para destino_transferencia
    public long get_destinoTransferencia() {
        return destinoTransferencia;
    }

    public void set_destinoTransferencia(long destino_transferencia) {
        this.destinoTransferencia = destino_transferencia;
    }
}
