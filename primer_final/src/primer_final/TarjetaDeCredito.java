package primer_final;

public class TarjetaDeCredito {
    private double deuda_tarjeta;
    private double limite_tarjeta;
    private String vencimiento_tarjeta;
    private String nro_tarjeta;
    private Cliente cliente_asociado;  

    // Constructor
    public TarjetaDeCredito(double deuda_tarjeta, double limite_tarjeta, 
            String vencimiento_tarjeta, String nro_tarjeta, Cliente cliente_asociado) {
        this.deuda_tarjeta = deuda_tarjeta;
        this.limite_tarjeta = limite_tarjeta;
        this.vencimiento_tarjeta = vencimiento_tarjeta;
        this.nro_tarjeta = nro_tarjeta;
        this.cliente_asociado = cliente_asociado;
    }

    public double getDeuda_tarjeta() {
        return deuda_tarjeta;
    }

    public void setDeuda_tarjeta(double deuda_tarjeta) {
        this.deuda_tarjeta = deuda_tarjeta;
    }

    public double getLimite_tarjeta() {
        return limite_tarjeta;
    }

    public void setLimite_tarjeta(double limite_tarjeta) {
        this.limite_tarjeta = limite_tarjeta;
    }

    public String getVencimiento_tarjeta() {
        return vencimiento_tarjeta;
    }

    public void setVencimiento_tarjeta(String vencimiento_tarjeta) {
        this.vencimiento_tarjeta = vencimiento_tarjeta;
    }

    public String getNro_tarjeta() {
        return nro_tarjeta;
    }

    public void setNro_tarjeta(String nro_tarjeta) {
        this.nro_tarjeta = nro_tarjeta;
    }

    public Cliente getCliente_asociado() {
        return cliente_asociado;
    }

    public void setCliente_asociado(Cliente cliente_asociado) {
        this.cliente_asociado = cliente_asociado;
    }

}
