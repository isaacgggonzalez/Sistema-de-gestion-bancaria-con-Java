/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import repository.TransaccionRepositorio;
import primer_final.Transferencia;
/**
 *
 * @author Augusto
 */
public class ProcesosControlador {
    
    public void realizarTransferencia(Transferencia transaccion){
        TransaccionRepositorio transaccionRepositorio = new TransaccionRepositorio();
        Long idTransaccion = transaccionRepositorio.insertTransaccion(transaccion);
        //con ese id insertar la transferencia
    }
}
