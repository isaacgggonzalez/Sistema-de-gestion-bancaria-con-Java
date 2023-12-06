
package controlador;

import modelo.Movimiento;
import modelo.exceptions.SaldoInsuficienteException;
import primer_final.*;
import repository.TransaccionRepositorio2;

import java.util.List;

/**
 *
 * @author Augusto
 */
public class ProcesosControlador {


    public static List<Movimiento> obtenerMovimientos(Long idCuenta){
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        return transaccionRepositorio2.obtenerMovimientosPorCuenta(idCuenta);
    }
    public static boolean confirmarDatosTransferencia(long DestinoTransferencia, long cedula, String nombre_destinatario){
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        return transaccionRepositorio2.confirmarDatos(DestinoTransferencia, cedula, nombre_destinatario);
    }
    
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

    public static boolean validarPinTransaccion(long pinTransaccion){
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        return transaccionRepositorio2.validarPinTransaccion(pinTransaccion);
    }

    public static void realizarDeposito(Deposito deposito){
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        Long idCuenta = transaccionRepositorio2.recuperarIdCuenta(deposito.getCuentaDestino().getNumeroCuenta());
        Long idTransaccion = transaccionRepositorio2.insertTransaccion(deposito);
        transaccionRepositorio2.insertDeposito(idTransaccion, "CAJERO CENTRAL");
        transaccionRepositorio2.insertMovimiento(idCuenta, idTransaccion);
    }

    public static void realizarPagoTarjeta(PagoDeTarjeta pagoDeTarjeta){
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        Long idCuenta = transaccionRepositorio2.recuperarIdCuenta(pagoDeTarjeta.getNumeroCuenta());
        Long idTarjetaCredito = transaccionRepositorio2.recuperarIdTarjeta(pagoDeTarjeta.getTarjetaDeCredito().getNro_tarjeta());
        Long idTransaccion = transaccionRepositorio2.insertTransaccion(pagoDeTarjeta);
        transaccionRepositorio2.insertPagoTarjeta(idTransaccion,idTarjetaCredito);
        transaccionRepositorio2.pagarTarjetaCredito(pagoDeTarjeta.getMontoTransaccion(), idTarjetaCredito);
        transaccionRepositorio2.insertMovimiento(idCuenta, idTransaccion);
    }

    public static TarjetaDeCredito obtenerTarjeta(Long numeroTarjeta){
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        return transaccionRepositorio2.recuperarTarjetaCredito(numeroTarjeta);
    }

    public static void verificarLimite(Long nroTarjeta, double monto) throws SaldoInsuficienteException{
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        if(!transaccionRepositorio2.verificarLimite(nroTarjeta, monto)){
            throw new SaldoInsuficienteException("El límite de la tarjeta no es suficiente para la transaccion");
        }

    }

    public static void verificarSaldoSuficiente(Long numeroCuenta, double monto) throws SaldoInsuficienteException{
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        if(!transaccionRepositorio2.verificarSaldoSuficiente(numeroCuenta, monto)){
            throw new SaldoInsuficienteException("No posee saldo suficiente para esta operación");
        }

    }

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
        transaccionRepositorio2.insertMovimiento(pagoServicio.getCuenta().getNumeroCuenta(), idTransaccion);
    }
}
