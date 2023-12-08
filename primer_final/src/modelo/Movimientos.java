package modelo;

import controlador.ProcesosControlador;

import java.util.List;

public class Movimientos implements Runnable{
    private final long idCuenta;

    private List<Movimiento> movimientos;

    public Movimientos(long idCuenta){
        this.idCuenta = idCuenta;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    @Override
    public void run() {
        movimientos = ProcesosControlador.obtenerMovimientos(idCuenta);
    }
}
