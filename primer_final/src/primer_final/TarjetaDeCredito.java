package primer_final;
import java.util.Date;

/**
 * Representa una tarjeta de crédito con información como el límite, deuda, vencimiento y número de tarjeta.
 */
public class TarjetaDeCredito {
    /**
     * Identificador del cliente asociado a la tarjeta.
     */
    private long id_cliente;
    /**
     * Identificador único de la tarjeta.
     */
    private long id_tarjeta;
    /**
     * Línea de crédito asociada a la tarjeta.
     */
    private double linea_tarjeta;
    /**
     * Deuda acumulada en la tarjeta.
     */
    private double deuda_tarjeta;
    /**
     * Fecha de vencimiento de la tarjeta.
     */
    private Date vencimiento_tarjeta;
    /**
     * Número de la tarjeta de crédito.
     */
    private Long nro_tarjeta;
    /**
     * Cliente asociado a la tarjeta.
     */
    private Cliente cliente_asociado;  
    

    // Constructor
    /**
     * Constructor de la clase TarjetaDeCredito.
     *
     * @param deuda_tarjeta         Deuda acumulada en la tarjeta.
     * @param limite_tarjeta        Línea de crédito asociada a la tarjeta.
     * @param vencimiento_tarjeta   Fecha de vencimiento de la tarjeta.
     * @param nro_tarjeta           Número de la tarjeta de crédito.
     * @param cliente_asociado      Cliente asociado a la tarjeta.
     */
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
    /**
     * Constructor de la clase TarjetaDeCredito sin parámetros.
     */
    public TarjetaDeCredito( ) {

    }
    /**
     * Constructor de la clase TarjetaDeCredito con identificadores adicionales.
     *
     * @param id_tarjeta            Identificador único de la tarjeta.
     * @param id_cliente            Identificador del cliente asociado a la tarjeta.
     * @param deuda_tarjeta         Deuda acumulada en la tarjeta.
     * @param limite_tarjeta        Línea de crédito asociada a la tarjeta.
     * @param vencimiento_tarjeta   Fecha de vencimiento de la tarjeta.
     * @param nro_tarjeta           Número de la tarjeta de crédito.
     */
    public TarjetaDeCredito( long id_tarjeta,long id_cliente, double deuda_tarjeta, double linea_tarjeta,
                            Date vencimiento_tarjeta, Long nro_tarjeta) {
        this.deuda_tarjeta = deuda_tarjeta;
        this.linea_tarjeta = linea_tarjeta;
        this.vencimiento_tarjeta = vencimiento_tarjeta;
        this.nro_tarjeta = nro_tarjeta;
        this.cliente_asociado = cliente_asociado;
        this.id_cliente = id_cliente;
        this.id_tarjeta = id_tarjeta;
    }
    
    /**
     * Constructor de la clase TarjetaDeCredito con identificador adicional.
     *
     * @param id_tarjeta            Identificador único de la tarjeta.
     * @param deuda_tarjeta         Deuda acumulada en la tarjeta.
     * @param limite_tarjeta        Línea de crédito asociada a la tarjeta.
     * @param vencimiento_tarjeta   Fecha de vencimiento de la tarjeta.
     * @param nro_tarjeta           Número de la tarjeta de crédito.
     */
    public TarjetaDeCredito( long id_tarjeta, double deuda_tarjeta, double linea_tarjeta,
                             Date vencimiento_tarjeta, Long nro_tarjeta) {
        this.deuda_tarjeta = deuda_tarjeta;
        this.linea_tarjeta = linea_tarjeta;
        this.vencimiento_tarjeta = vencimiento_tarjeta;
        this.nro_tarjeta = nro_tarjeta;
        this.id_tarjeta = id_tarjeta;
    }
    /**
     * Obtiene la deuda acumulada en la tarjeta.
     *
     * @return Deuda acumulada en la tarjeta.
     */
    public double getDeuda_tarjeta() {
        return deuda_tarjeta;
    }
    /**
     * Establece la deuda acumulada en la tarjeta.
     *
     * @param deuda_tarjeta Nueva deuda acumulada en la tarjeta.
     */
    public void setDeuda_tarjeta(double deuda_tarjeta) {
        this.deuda_tarjeta = deuda_tarjeta;
    }
    /**
     * Obtiene la línea de crédito asociada a la tarjeta.
     *
     * @return Línea de crédito asociada a la tarjeta.
     */
    public double getLinea_tarjeta() {
        return linea_tarjeta;
    }
    /**
     * Establece la línea de crédito asociada a la tarjeta.
     *
     * @param linea_tarjeta Nueva línea de crédito asociada a la tarjeta.
     */
    public void setLinea_tarjeta(double linea_tarjeta) {
        this.linea_tarjeta = linea_tarjeta;
    }
    /**
     * Obtiene la fecha de vencimiento de la tarjeta.
     *
     * @return Fecha de vencimiento de la tarjeta.
     */
    public Date getVencimiento_tarjeta() {
        return vencimiento_tarjeta;
    }
    /**
     * Establece la fecha de vencimiento de la tarjeta.
     *
     * @param vencimiento_tarjeta Nueva fecha de vencimiento de la tarjeta.
     */
    public void setVencimiento_tarjeta(Date vencimiento_tarjeta) {
        this.vencimiento_tarjeta = vencimiento_tarjeta;
    }
    /**
     * Obtiene el número de la tarjeta de crédito.
     *
     * @return Número de la tarjeta de crédito.
     */
    public Long getNro_tarjeta() {
        return nro_tarjeta;
    }
    /**
     * Establece el número de la tarjeta de crédito.
     *
     * @param nro_tarjeta Nuevo número de la tarjeta de crédito.
     */
    public void setNro_tarjeta(Long nro_tarjeta) {
        this.nro_tarjeta = nro_tarjeta;
    }
    /**
     * Obtiene el identificador del cliente asociado a la tarjeta.
     *
     * @return Identificador del cliente asociado a la tarjeta.
     */
    public long getId_cliente() {
        return id_cliente;
    }
    /**
     * Establece el identificador del cliente asociado a la tarjeta.
     *
     * @param id_cliente Nuevo identificador del cliente asociado a la tarjeta.
     */
    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }
    /**
     * Obtiene el cliente asociado a la tarjeta.
     *
     * @return Cliente asociado a la tarjeta.
     */
    public Cliente getCliente_asociado() {
        return cliente_asociado;
    }
    /**
     * Establece el cliente asociado a la tarjeta.
     *
     * @param cliente_asociado Nuevo cliente asociado a la tarjeta.
     */
    public void setCliente_asociado(Cliente cliente_asociado) {
        this.cliente_asociado = cliente_asociado;
    }

}