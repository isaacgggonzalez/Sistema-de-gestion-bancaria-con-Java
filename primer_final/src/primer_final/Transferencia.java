package primer_final;

import java.sql.Timestamp;
import java.util.Date;

public class Transferencia extends Transaccion {
    private static final String TIPO_TRANSACCION = "Transferencia";
    private long origen_transferencia;
    private long destino_transferencia;
    
   

    // Constructor
    public Transferencia(int Id_transaccion, 
        Date Fecha_transaccion,String Tipo_transaccion ,long origen_transferencia, long destino_transferencia, 
        double Monto_transferencia) {
        // Llamada al constructor de la clase base (Transaccion)
        super(Id_transaccion, Fecha_transaccion, Monto_transferencia, TIPO_TRANSACCION);
        
       
        this.origen_transferencia = origen_transferencia;
        this.destino_transferencia = destino_transferencia;
    }

   
    
    // Métodos getter y setter para origen_transferencia
    public long get_origenTransferencia() {
        return origen_transferencia;
    }

    public void set_origenTransferencia(long origen_transferencia) {
        this.origen_transferencia = origen_transferencia;
    }


    // Métodos getter y setter para destino_transferencia
    public long get_destinoTransferencia() {
        return destino_transferencia;
    }

    public void set_destinoTransferencia(long destino_transferencia) {
        this.destino_transferencia = destino_transferencia;
    }
}
