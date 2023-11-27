package primer_final;

import java.sql.Timestamp;
import java.util.Date;
//abstract
public class Transaccion {
    // Atributos
    private int idTransaccion;
    private double montoTransaccion;
    private Date fechaTransaccion;
    private final String tipoTransaccion;

    public Transaccion(Date fechaTransaccion, double montoTransaccion, String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.montoTransaccion = montoTransaccion;
    }

    public Transaccion(int idTransaccion,
                       Date fechaTransaccion, double montoTransaccion, String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
        this.idTransaccion = idTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.montoTransaccion = montoTransaccion;
    }


    public void realizarTransaccion(){}
    
    
    public int getIdTransaccion() {
        return idTransaccion;
    }
    
    public String getTipoTransaccion() {
        return tipoTransaccion;
    }
    
    public void setIdTransaccion(int Id_transaccion) {
        this.idTransaccion = Id_transaccion;
    }

    public void set_fecha_transaccion(Date fecha) {
        this.fechaTransaccion =  new Timestamp(System.currentTimeMillis());
    }
    
    public Date get_fecha_transaccion() {
        return fechaTransaccion;
    }

    public double getMontoTransaccion() {
        return montoTransaccion;
    }

    public void setMontoTransaccion(double montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }  
}
