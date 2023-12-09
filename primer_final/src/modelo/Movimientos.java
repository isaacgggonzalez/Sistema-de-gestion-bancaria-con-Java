package modelo;

import controlador.ProcesosControlador;

import java.util.List;

/**
 * La clase Movimientos representa un hilo que obtiene los movimientos asociados a una cuenta.
 */
public class Movimientos implements Runnable{
    private final long idCuenta;

    private List<Movimiento> movimientos;
    /**
     * Constructor de la clase Movimientos.
     *
     * @param idCuenta El identificador de la cuenta asociada a los movimientos.
     */
    public Movimientos(long idCuenta){
        this.idCuenta = idCuenta;
    }
    /**
     * Obtiene la lista de movimientos asociados a la cuenta.
     *
     * @return La lista de movimientos.
     */
    public List<Movimiento> getMovimientos() {
        return movimientos;
    }
    /**
     * Método run que se ejecuta cuando se inicia el hilo. Obtiene los movimientos asociados a la cuenta.
     */
    @Override
    public void run() {
        movimientos = ProcesosControlador.obtenerMovimientos(idCuenta);
    }
}
