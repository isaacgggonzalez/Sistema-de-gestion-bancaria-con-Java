
package controlador;

import modelo.Movimiento;
import modelo.exceptions.SaldoInsuficienteException;
import primer_final.*;
import repository.TransaccionRepositorio2;
import java.util.List;

/**
 * Clase que controla los procesos relacionados con las transacciones financieras.
 */
public class ProcesosControlador {

    /**
     * Obtiene una lista de movimientos asociados a una cuenta.
     *
     * @param idCuenta Identificador de la cuenta.
     * @return Lista de movimientos asociados a la cuenta.
     */
    public static List<Movimiento> obtenerMovimientos(Long idCuenta){
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        return transaccionRepositorio2.obtenerMovimientosPorCuenta(idCuenta);
    }
    /**
     * Confirma los datos de una transferencia.
     *
     * @param DestinoTransferencia Cuenta de destino de la transferencia.
     * @param cedula              Número de cédula del destinatario.
     * @param nombre_destinatario Nombre del destinatario.
     * @return True si los datos son confirmados, false en caso contrario.
     */
    public static boolean confirmarDatosTransferencia(long DestinoTransferencia, long cedula, String nombre_destinatario){
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        return transaccionRepositorio2.confirmarDatos(DestinoTransferencia, cedula, nombre_destinatario);
    }
    /**
     * Realiza una transferencia entre cuentas.
     *
     * @param transferencia Objeto Transferencia que contiene la información de la transferencia.
     */
    public static void realizarTransferencia(Transferencia transferencia){
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        Long idCuentaDestino = transaccionRepositorio2.recuperarIdCuenta(transferencia.get_destinoTransferencia());
        Long idCuentaOrigen = transaccionRepositorio2.recuperarIdCuenta(transferencia.get_origenTransferencia());
        Long idTransaccion = transaccionRepositorio2.insertTransaccion(transferencia);
        transaccionRepositorio2.insertTransferencia(idTransaccion, idCuentaOrigen, idCuentaDestino);
        transaccionRepositorio2.actualizarSaldoCuenta(idCuentaDestino, +transferencia.getMontoTransaccion());
        transaccionRepositorio2.actualizarSaldoCuenta(idCuentaOrigen, -transferencia.getMontoTransaccion());
        transaccionRepositorio2.insertMovimiento(idCuentaDestino, idTransaccion);
        transaccionRepositorio2.insertMovimiento(idCuentaOrigen, idTransaccion);
    }

    /**
     * Valida el PIN de una transacción.
     *
     * @param pinTransaccion PIN de la transacción a validar.
     * @return True si el PIN es válido, false en caso contrario.
     */
    public static boolean validarPinTransaccion(long pinTransaccion){
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        return transaccionRepositorio2.validarPinTransaccion(pinTransaccion);
    }
    /**
     * Realiza un depósito en una cuenta.
     *
     * @param deposito Objeto Deposito que contiene la información del depósito.
     */
    public static void realizarDeposito(Deposito deposito){
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        Long idCuenta = transaccionRepositorio2.recuperarIdCuenta(deposito.getCuentaDestino().getNumeroCuenta());
        Long idTransaccion = transaccionRepositorio2.insertTransaccion(deposito);
        transaccionRepositorio2.actualizarSaldoCuenta(idCuenta, deposito.getMontoTransaccion());
        transaccionRepositorio2.insertDeposito(idTransaccion, "CAJERO CENTRAL");
        transaccionRepositorio2.insertMovimiento(idCuenta, idTransaccion);
    }
    /**
     * Realiza un pago de tarjeta de crédito.
     *
     * @param pagoDeTarjeta Objeto PagoDeTarjeta que contiene la información del pago.
     */
    public static void realizarPagoTarjeta(PagoDeTarjeta pagoDeTarjeta){
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        Long idCuenta = transaccionRepositorio2.recuperarIdCuenta(pagoDeTarjeta.getNumeroCuenta());
        Long idTarjetaCredito = transaccionRepositorio2.recuperarIdTarjeta(pagoDeTarjeta.getTarjetaDeCredito().getNro_tarjeta());
        Long idTransaccion = transaccionRepositorio2.insertTransaccion(pagoDeTarjeta);
        transaccionRepositorio2.insertPagoTarjeta(idTransaccion,idTarjetaCredito);
        transaccionRepositorio2.pagarTarjetaCredito(pagoDeTarjeta.getMontoTransaccion(), idTarjetaCredito);
        transaccionRepositorio2.actualizarSaldoCuenta(idCuenta, pagoDeTarjeta.getMontoTransaccion());
        transaccionRepositorio2.insertMovimiento(idCuenta, idTransaccion);
    }
    /**
     * Obtiene una tarjeta de crédito por su número.
     *
     * @param numeroTarjeta Número de la tarjeta de crédito.
     * @return La tarjeta de crédito correspondiente al número proporcionado.
     */
    public static TarjetaDeCredito obtenerTarjeta(Long numeroTarjeta){
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        return transaccionRepositorio2.recuperarTarjetaCredito(numeroTarjeta);
    }
    /**
     * Obtiene una lista de tarjetas de crédito asociadas a un cliente.
     *
     * @param idCliente Identificador único del cliente.
     * @return Lista de tarjetas de crédito asociadas al cliente.
     */
    public static List<TarjetaDeCredito> obtenerTarjetas(Long idCliente){
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        return transaccionRepositorio2.recuperarTarjetasCredito(idCliente);
    }
    /**
     * Verifica si el límite de una tarjeta de crédito es suficiente para una transacción.
     *
     * @param nroTarjeta Número de la tarjeta de crédito.
     * @param monto Monto de la transacción.
     * @throws SaldoInsuficienteException Si el límite no es suficiente para la transacción.
     */
    public static void verificarLimite(Long nroTarjeta, double monto) throws SaldoInsuficienteException{
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        if(!transaccionRepositorio2.verificarLimite(nroTarjeta, monto)){
            throw new SaldoInsuficienteException("El límite de la tarjeta no es suficiente para la transaccion");
        }

    }
    /**
     * Verifica si el saldo de una cuenta es suficiente para una transacción.
     *
     * @param numeroCuenta Número de la cuenta.
     * @param monto Monto de la transacción.
     * @throws SaldoInsuficienteException Si el saldo no es suficiente para la transacción.
     */
    public static void verificarSaldoSuficiente(Long numeroCuenta, double monto) throws SaldoInsuficienteException{
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        if(!transaccionRepositorio2.verificarSaldoSuficiente(numeroCuenta, monto)){
            throw new SaldoInsuficienteException("No posee saldo suficiente para esta operación");
        }

    }
    /**
     * Realiza un pago de servicio.
     *
     * @param pagoServicio Objeto PagoServicio que contiene la información del pago de servicio.
     */
    public static void realizarPagoServicio(PagoServicio pagoServicio) {
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        Long idTransaccion = transaccionRepositorio2.insertTransaccion(pagoServicio);
        
        if (pagoServicio.getTarjetaAbonante() != null) {
            transaccionRepositorio2.aumentarDeuda(pagoServicio.getTarjetaAbonante().getNro_tarjeta(), pagoServicio.getMontoTransaccion());
        } else {
            transaccionRepositorio2.actualizarSaldoCuenta(pagoServicio.getCuenta().getNumeroCuenta(), -pagoServicio.getMontoTransaccion());
        }
        Long idServicio = transaccionRepositorio2.recuperarIdServicio(pagoServicio.getServicio().get_NombreServicio());
        transaccionRepositorio2.insertPagoServicio(idTransaccion, idServicio);
        Long idCuenta = transaccionRepositorio2.recuperarIdCuenta(pagoServicio.getCuenta().getNumeroCuenta());
        transaccionRepositorio2.insertMovimiento(idCuenta, idTransaccion);
    }

}
