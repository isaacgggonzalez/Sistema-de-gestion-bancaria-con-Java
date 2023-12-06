package primer_final;

import java.util.Date;

public class TarjetaDeCredito {
    private long id_cliente;
    private long id_tarjeta;
    private double linea_tarjeta;
    private double deuda_tarjeta;
    private double limite_tarjeta;
    private Date vencimiento_tarjeta;
    private Long nro_tarjeta;
    private Cliente cliente_asociado;  

    // Constructor
    public TarjetaDeCredito(double deuda_tarjeta, double limite_tarjeta, 
            Date vencimiento_tarjeta, Long nro_tarjeta, Cliente cliente_asociado) {
        this.deuda_tarjeta = deuda_tarjeta;
        this.linea_tarjeta = linea_tarjeta;
        this.vencimiento_tarjeta = vencimiento_tarjeta;
        this.nro_tarjeta = nro_tarjeta;
        this.cliente_asociado = cliente_asociado;
        this.id_cliente = id_cliente;
        this.id_tarjeta = id_tarjeta;
    }

    public TarjetaDeCredito( ) {

    }
    public TarjetaDeCredito( long id_tarjeta,long id_cliente, double deuda_tarjeta, double limite_tarjeta,
                            Date vencimiento_tarjeta, Long nro_tarjeta) {
        this.deuda_tarjeta = deuda_tarjeta;
        this.linea_tarjeta = linea_tarjeta;
        this.vencimiento_tarjeta = vencimiento_tarjeta;
        this.nro_tarjeta = nro_tarjeta;
        this.cliente_asociado = cliente_asociado;
        this.id_cliente = id_cliente;
        this.id_tarjeta = id_tarjeta;
    }

    public double getDeuda_tarjeta() {
        return deuda_tarjeta;
    }

    public void setDeuda_tarjeta(double deuda_tarjeta) {
        this.deuda_tarjeta = deuda_tarjeta;
    }

    public double getLinea_tarjeta() {
        return linea_tarjeta;
    }

    public void setLinea_tarjeta(double linea_tarjeta) {
        this.linea_tarjeta = linea_tarjeta;
    }

    public Date getVencimiento_tarjeta() {
        return vencimiento_tarjeta;
    }

    public void setVencimiento_tarjeta(Date vencimiento_tarjeta) {
        this.vencimiento_tarjeta = vencimiento_tarjeta;
    }

    public Long getNro_tarjeta() {
        return nro_tarjeta;
    }

    public void setNro_tarjeta(Long nro_tarjeta) {
        this.nro_tarjeta = nro_tarjeta;
    }

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Cliente getCliente_asociado() {
        return cliente_asociado;
    }

    public void setCliente_asociado(Cliente cliente_asociado) {
        this.cliente_asociado = cliente_asociado;
    }

}
