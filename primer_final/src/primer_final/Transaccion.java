package primer_final;

import java.sql.Timestamp;
import java.util.Date;
//abstract
public class Transaccion {
    // Atributos
    private int Id_transaccion;
    private double monto_transaccion;
    private Date Fecha_transaccion;
    private final String Tipo_transaccion;
    
    public Transaccion(int Id_transaccion,
            Date Fecha_transaccion, double monto_transaccion, String Tipo_transaccion) {
        this.Tipo_transaccion = Tipo_transaccion;
        this.Id_transaccion = Id_transaccion;
        this.Fecha_transaccion = Fecha_transaccion;
        this.monto_transaccion = monto_transaccion;
    }
    
    
    public int getId_transaccion() {
        return Id_transaccion;
    }
    
    public String getTipo_transaccion() {
        return Tipo_transaccion;
    }
    
    public void setId_transaccion(int Id_transaccion) {
        this.Id_transaccion = Id_transaccion;
    }

    public void set_fecha_transaccion(Date fecha) {
        this.Fecha_transaccion =  new Timestamp(System.currentTimeMillis());
    }
    
    public Date get_fecha_transaccion() {
        return Fecha_transaccion;
    }

    public double getMonto_transaccion() {
        return monto_transaccion;
    }

    public void setMonto_transaccion(double monto_transaccion) {
        this.monto_transaccion = monto_transaccion;
    }  
}
