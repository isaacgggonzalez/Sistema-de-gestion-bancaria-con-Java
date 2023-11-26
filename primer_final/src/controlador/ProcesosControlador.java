/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

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

    public static void validarPinTransaccion(long pinTransaccion){
        TransaccionRepositorio2 transaccionRepositorio2 = new TransaccionRepositorio2();
        transaccionRepositorio2.validarPinTransaccion(pinTransaccion);
    }
}
