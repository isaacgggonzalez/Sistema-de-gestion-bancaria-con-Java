package primer_final;

import java.util.Date;

public class TarjetaDeCredito {
    private long id_cliente;
    private double linea_tarjeta;
    private double deuda_tarjeta;
    private Date vencimiento_tarjeta;
    private long nro_tarjeta;
      

    // Constructor
    public TarjetaDeCredito(double deuda_tarjeta, double linea_tarjeta, 
            Date vencimiento_tarjeta, long nro_tarjeta, long id_cliente) {
        this.deuda_tarjeta = deuda_tarjeta;
        this.linea_tarjeta = linea_tarjeta;
        this.vencimiento_tarjeta = vencimiento_tarjeta;
        this.nro_tarjeta = nro_tarjeta;
        this.id_cliente = id_cliente;
    }

    public double getDeuda_tarjeta() {
        return deuda_tarjeta;
    }

    public void setDeuda_tarjeta(double deuda_tarjeta) {
        this.deuda_tarjeta = deuda_tarjeta;
    }

    public Date getVencimiento_tarjeta() {
        return vencimiento_tarjeta;
    }

    public void setVencimiento_tarjeta(Date vencimiento_tarjeta) {
        this.vencimiento_tarjeta = vencimiento_tarjeta;
    }

    public long getNro_tarjeta() {
        return nro_tarjeta;
    }

    public void setNro_tarjeta(long nro_tarjeta) {
        this.nro_tarjeta = nro_tarjeta;
    }

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public double getLinea_tarjeta() {
        return linea_tarjeta;
    }

    public void setLinea_tarjeta(double linea_tarjeta) {
        this.linea_tarjeta = linea_tarjeta;
    }

   

}
