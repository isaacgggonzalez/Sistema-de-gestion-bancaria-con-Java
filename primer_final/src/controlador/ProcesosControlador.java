
package controlador;

import modelo.*;
import modelo.exceptions.SaldoInsuficienteException;
import repository.TransaccionRepositorio;
import java.util.List;

/**
 * Clase que controla los procesos relacionados con las transacciones financieras.
 */
public class ProcesosControlador {


    public static Cliente obtenerCliente(long cedula){
        TransaccionRepositorio transaccionRepositorio = new TransaccionRepositorio();
        return transaccionRepositorio.obtenerCliente(cedula);
    }

    public static Cuenta obtenerCuenta(long numeroCuenta){
        TransaccionRepositorio transaccionRepositorio = new TransaccionRepositorio();
        return transaccionRepositorio.obtenerCuenta(numeroCuenta);
    }

    public static boolean verificarPinCuenta(long cedula, long numeroCuenta, int clave){
        TransaccionRepositorio transaccionRepositorio = new TransaccionRepositorio();
        return transaccionRepositorio.verificarPinCuenta(cedula, numeroCuenta, clave);
    }

    /**
     * Obtiene una lista de movimientos asociados a una cuenta.
     *
     * @param idCuenta Identificador de la cuenta.
     * @return Lista de movimientos asociados a la cuenta.
     */
    public static List<Movimiento> obtenerMovimientos(Long idCuenta){
        TransaccionRepositorio transaccionRepositorio = new TransaccionRepositorio();
        return transaccionRepositorio.obtenerMovimientosPorCuenta(idCuenta);
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
        TransaccionRepositorio transaccionRepositorio = new TransaccionRepositorio();
        return transaccionRepositorio.confirmarDatos(DestinoTransferencia, cedula, nombre_destinatario);
    }
    /**
     * Realiza una transferencia entre cuentas.
     *
     * @param transferencia Objeto Transferencia que contiene la información de la transferencia.
     */
    public static void realizarTransferencia(Transferencia transferencia){
        TransaccionRepositorio transaccionRepositorio = new TransaccionRepositorio();
        Long idCuentaDestino = transaccionRepositorio.recuperarIdCuenta(transferencia.get_destinoTransferencia());
        Long idCuentaOrigen = transaccionRepositorio.recuperarIdCuenta(transferencia.get_origenTransferencia());
        Long idTransaccion = transaccionRepositorio.insertTransaccion(transferencia);
        transaccionRepositorio.insertTransferencia(idTransaccion, idCuentaOrigen, idCuentaDestino);
        transaccionRepositorio.actualizarSaldoCuenta(idCuentaDestino, +transferencia.getMontoTransaccion());
        transaccionRepositorio.actualizarSaldoCuenta(idCuentaOrigen, -transferencia.getMontoTransaccion());
        transaccionRepositorio.insertMovimiento(idCuentaDestino, idTransaccion);
        transaccionRepositorio.insertMovimiento(idCuentaOrigen, idTransaccion);
    }

    /**
     * Valida el PIN de una transacción.
     *
     * @param pinTransaccion PIN de la transacción a validar.
     * @return True si el PIN es válido, false en caso contrario.
     */
    public static boolean validarPinTransaccion(long pinTransaccion){
        TransaccionRepositorio transaccionRepositorio = new TransaccionRepositorio();
        return transaccionRepositorio.validarPinTransaccion(pinTransaccion);
    }
    /**
     * Realiza un depósito en una cuenta.
     *
     * @param deposito Objeto Deposito que contiene la información del depósito.
     */
    public static void realizarDeposito(Deposito deposito){
        TransaccionRepositorio transaccionRepositorio = new TransaccionRepositorio();
        Long idCuenta = transaccionRepositorio.recuperarIdCuenta(deposito.getCuentaDestino().getNumeroCuenta());
        Long idTransaccion = transaccionRepositorio.insertTransaccion(deposito);
        transaccionRepositorio.actualizarSaldoCuenta(idCuenta, deposito.getMontoTransaccion());
        transaccionRepositorio.insertDeposito(idTransaccion, "CAJERO CENTRAL");
        transaccionRepositorio.insertMovimiento(idCuenta, idTransaccion);
    }
    /**
     * Realiza un pago de tarjeta de crédito.
     *
     * @param pagoDeTarjeta Objeto PagoDeTarjeta que contiene la información del pago.
     */
    public static void realizarPagoTarjeta(PagoDeTarjeta pagoDeTarjeta){
        TransaccionRepositorio transaccionRepositorio = new TransaccionRepositorio();
        Long idCuenta = transaccionRepositorio.recuperarIdCuenta(pagoDeTarjeta.getNumeroCuenta());
        Long idTarjetaCredito = transaccionRepositorio.recuperarIdTarjeta(pagoDeTarjeta.getTarjetaDeCredito().getNro_tarjeta());
        Long idTransaccion = transaccionRepositorio.insertTransaccion(pagoDeTarjeta);
        transaccionRepositorio.insertPagoTarjeta(idTransaccion,idTarjetaCredito);
        transaccionRepositorio.pagarTarjetaCredito(pagoDeTarjeta.getMontoTransaccion(), idTarjetaCredito);
        transaccionRepositorio.actualizarSaldoCuenta(idCuenta, pagoDeTarjeta.getMontoTransaccion());
        transaccionRepositorio.insertMovimiento(idCuenta, idTransaccion);
    }
    /**
     * Obtiene una tarjeta de crédito por su número.
     *
     * @param numeroTarjeta Número de la tarjeta de crédito.
     * @return La tarjeta de crédito correspondiente al número proporcionado.
     */
    public static TarjetaDeCredito obtenerTarjeta(Long numeroTarjeta){
        TransaccionRepositorio transaccionRepositorio = new TransaccionRepositorio();
        return transaccionRepositorio.recuperarTarjetaCredito(numeroTarjeta);
    }
    /**
     * Obtiene una lista de tarjetas de crédito asociadas a un cliente.
     *
     * @param idCliente Identificador único del cliente.
     * @return Lista de tarjetas de crédito asociadas al cliente.
     */
    public static List<TarjetaDeCredito> obtenerTarjetas(Long idCliente){
        TransaccionRepositorio transaccionRepositorio = new TransaccionRepositorio();
        return transaccionRepositorio.recuperarTarjetasCredito(idCliente);
    }
    /**
     * Verifica si el límite de una tarjeta de crédito es suficiente para una transacción.
     *
     * @param nroTarjeta Número de la tarjeta de crédito.
     * @param monto Monto de la transacción.
     * @throws SaldoInsuficienteException Si el límite no es suficiente para la transacción.
     */
    public static void verificarLimite(Long nroTarjeta, double monto) throws SaldoInsuficienteException{
        TransaccionRepositorio transaccionRepositorio = new TransaccionRepositorio();
        if(!transaccionRepositorio.verificarLimite(nroTarjeta, monto)){
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
        TransaccionRepositorio transaccionRepositorio = new TransaccionRepositorio();
        if(!transaccionRepositorio.verificarSaldoSuficiente(numeroCuenta, monto)){
            throw new SaldoInsuficienteException("No posee saldo suficiente para esta operación");
        }

    }
    /**
     * Realiza un pago de servicio.
     *
     * @param pagoServicio Objeto PagoServicio que contiene la información del pago de servicio.
     */
    public static void realizarPagoServicio(PagoServicio pagoServicio) {
        TransaccionRepositorio transaccionRepositorio = new TransaccionRepositorio();
        Long idTransaccion = transaccionRepositorio.insertTransaccion(pagoServicio);
        
        if (pagoServicio.getTarjetaAbonante() != null) {
            transaccionRepositorio.aumentarDeuda(pagoServicio.getTarjetaAbonante().getNro_tarjeta(), pagoServicio.getMontoTransaccion());
        } else {
            transaccionRepositorio.actualizarSaldoCuenta(pagoServicio.getCuenta().getNumeroCuenta(), -pagoServicio.getMontoTransaccion());
        }
        Long idServicio = transaccionRepositorio.recuperarIdServicio(pagoServicio.getServicio().get_NombreServicio());
        transaccionRepositorio.insertPagoServicio(idTransaccion, idServicio);
        Long idCuenta = transaccionRepositorio.recuperarIdCuenta(pagoServicio.getCuenta().getNumeroCuenta());
        transaccionRepositorio.insertMovimiento(idCuenta, idTransaccion);
    }

}
