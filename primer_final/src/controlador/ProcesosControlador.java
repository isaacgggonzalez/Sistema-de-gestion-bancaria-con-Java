/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import primer_final.Deposito;
import primer_final.PagoDeTarjeta;
import repository.TransaccionRepositorio;
import primer_final.Transferencia;
import repository.TransaccionRepositorio2;

/**
 *
 * @author Augusto
 */
public class ProcesosControlador {
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
        Long idTransaccion = transaccionRepositorio2.insertTransaccion(deposito);
        transaccionRepositorio2.insertDeposito(idTransaccion, "CAJERO CENTRAL");
    }

    public static void realizarPagoTarjeta(PagoDeTarjeta pagoDeTarjeta){
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        Long idTarjetaCredito = transaccionRepositorio2.recuperarIdTarjeta(pagoDeTarjeta.getTarjetaDeCredito().getNro_tarjeta());
        Long idTransaccion = transaccionRepositorio2.insertTransaccion(pagoDeTarjeta);
        transaccionRepositorio2.insertPagoTarjeta(idTransaccion,idTarjetaCredito);
        transaccionRepositorio2.pagarTarjetaCredito(pagoDeTarjeta.getMontoTransaccion(), idTarjetaCredito);
    }
}
