package pruebadepg;


import config.ConexionBD;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Clase que representa la realización de un depósito en una cuenta y su registro en la base de datos.
 */
public class Deposito {
    /**
     * Realiza un depósito en la cuenta de destino y registra la transacción en la base de datos.
     *
     * @param cuentaDestino El número de cuenta de destino donde se realizará el depósito.
     * @param monto         El monto a depositar en la cuenta.
     */
    public void realizarDeposito(long cuentaDestino, double monto) {
        try (Connection conexion = ConexionBD.conectar()) {
            // Iniciar transacción
            conexion.setAutoCommit(false);

            try {
                // Realizar crédito en la cuenta de destino
                acreditarCuenta(conexion, cuentaDestino, monto);

                // Registrar el depósito en la base de datos
                registrarDeposito(conexion, cuentaDestino, monto);

                // Confirmar la transacción
                conexion.commit();
                System.out.println("Depósito realizado con éxito.");

            } catch (SQLException e) {
                // Si hay algún error, hacer rollback de la transacción
                conexion.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Acredita el monto en la cuenta de destino.
     *
     * @param conexion      La conexión a la base de datos.
     * @param cuentaDestino El número de cuenta de destino donde se acreditará el monto.
     * @param monto         El monto a acreditar en la cuenta.
     * @throws SQLException Si ocurre un error de SQL durante la operación.
     */
    private void acreditarCuenta(Connection conexion, long cuentaDestino, double monto) throws SQLException {
        // Implementa la lógica para acreditar el monto en la cuenta de destino
        String actualizarSaldo = "UPDATE cuenta SET saldo = saldo + ? WHERE id_cuenta = ?";

        try (PreparedStatement statement = conexion.prepareStatement(actualizarSaldo)) {
            statement.setDouble(1, monto);
            statement.setLong(2, cuentaDestino);
            statement.executeUpdate();
        }
    }
    /**
     * Registra el depósito en la base de datos.
     *
     * @param conexion      La conexión a la base de datos.
     * @param cuentaDestino El número de cuenta de destino donde se realizó el depósito.
     * @param monto         El monto depositado.
     * @throws SQLException Si ocurre un error de SQL durante la operación.
     */
    private void registrarDeposito(Connection conexion, long cuentaDestino, double monto) throws SQLException {
        // Implementa la lógica para registrar el depósito en la base de datos
        String insertarDeposito = "INSERT INTO deposito (id_cuenta, monto, fecha) VALUES (?, ?, ?)";

        try (PreparedStatement statement = conexion.prepareStatement(insertarDeposito)) {
            statement.setLong(1, cuentaDestino);
            statement.setDouble(2, monto);
            statement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            statement.executeUpdate();
        }
    }
    
    /**
     * Método principal utilizado para pruebas y ejecución de la clase Deposito.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        Deposito deposito = new Deposito();

        // Ejemplo de llamada al método para realizar un depósito
        deposito.realizarDeposito(987654321, 20000.0);
    }
}
