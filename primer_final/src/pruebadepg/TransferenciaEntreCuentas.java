package pruebadepg;

import config.ConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 * Clase que representa la realización de transferencias entre cuentas.
 */
public class TransferenciaEntreCuentas {
    /**
     * Realiza una transferencia entre dos cuentas.
     *
     * @param cuentaOrigen       El número de cuenta de origen.
     * @param cuentaDestino      El número de cuenta de destino.
     * @param nombreDestinatario El nombre del destinatario.
     * @param cedulaDestinatario La cédula del destinatario.
     * @param monto              El monto a transferir.
     */
    public void realizarTransferencia(long cuentaOrigen, long cuentaDestino, String nombreDestinatario,
                                      long cedulaDestinatario, double monto) {
        try (Connection conexion = ConexionBD.conectar()) {
            conexion.setAutoCommit(false);

            try {
                if (!verificarSaldoSuficiente(conexion, cuentaOrigen, monto)) {
                    System.out.println("Saldo insuficiente en la cuenta de origen. Transferencia cancelada.");
                    return;
                }

                debitarCuenta(conexion, cuentaOrigen, monto);
                acreditarCuenta(conexion, cuentaDestino, monto);
                registrarTransferencia(conexion, cuentaOrigen, cuentaDestino, nombreDestinatario, cedulaDestinatario, monto);

                conexion.commit();
                System.out.println("Transferencia realizada con éxito.");

            } catch (SQLException e) {
                conexion.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Verifica si el saldo en la cuenta de origen es suficiente para realizar la transferencia.
     *
     * @param conexion     La conexión a la base de datos.
     * @param cuentaOrigen El número de cuenta de origen.
     * @param monto        El monto a transferir.
     * @return true si el saldo es suficiente, false de lo contrario.
     * @throws SQLException Si ocurre un error al intentar realizar la consulta SQL.
     */
    private boolean verificarSaldoSuficiente(Connection conexion, long cuentaOrigen, double monto) throws SQLException {
        String consultaSaldo = "SELECT saldo FROM cuenta WHERE numero_cuenta = ?";
        try (PreparedStatement statement = conexion.prepareStatement(consultaSaldo)) {
            statement.setLong(1, cuentaOrigen);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    double saldo = resultSet.getDouble("saldo");
                    return saldo >= monto;
                }
            }
        }
        return false;
    }
    /**
     * Debita el monto de la cuenta de origen.
     *
     * @param conexion     La conexión a la base de datos.
     * @param cuentaOrigen El número de cuenta de origen.
     * @param monto        El monto a transferir.
     * @throws SQLException Si ocurre un error al intentar realizar la actualización SQL.
     */
    private void debitarCuenta(Connection conexion, long cuentaOrigen, double monto) throws SQLException {
        String actualizarSaldo = "UPDATE cuenta SET saldo = saldo - ? WHERE numero_cuenta = ?";
        try (PreparedStatement statement = conexion.prepareStatement(actualizarSaldo)) {
            statement.setDouble(1, monto);
            statement.setLong(2, cuentaOrigen);
            statement.executeUpdate();
        }
    }
    /**
     * Acredita el monto a la cuenta de destino.
     *
     * @param conexion      La conexión a la base de datos.
     * @param cuentaDestino El número de cuenta de destino.
     * @param monto         El monto a transferir.
     * @throws SQLException Si ocurre un error al intentar realizar la actualización SQL.
     */
    private void acreditarCuenta(Connection conexion, long cuentaDestino, double monto) throws SQLException {
        String actualizarSaldo = "UPDATE cuenta SET saldo = saldo + ? WHERE numero_cuenta = ?";
        try (PreparedStatement statement = conexion.prepareStatement(actualizarSaldo)) {
            statement.setDouble(1, monto);
            statement.setLong(2, cuentaDestino);
            statement.executeUpdate();
        }
    }
    /**
     * Registra la transferencia en la base de datos.
     *
     * @param conexion           La conexión a la base de datos.
     * @param cuentaOrigen       El número de cuenta de origen.
     * @param cuentaDestino      El número de cuenta de destino.
     * @param nombreDestinatario El nombre del destinatario.
     * @param cedulaDestinatario La cédula del destinatario.
     * @param monto              El monto transferido.
     * @throws SQLException Si ocurre un error al intentar realizar la inserción SQL.
     */
    private void registrarTransferencia(Connection conexion, long cuentaOrigen, long cuentaDestino,
                                       String nombreDestinatario, long cedulaDestinatario, double monto) throws SQLException {
        String insertarTransferencia = "INSERT INTO transferencia (cuenta_origen, cuenta_destino, nombre_destinatario, cedula_destinatario, monto) " +
                                      "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(insertarTransferencia)) {
            statement.setLong(1, cuentaOrigen);
            statement.setLong(2, cuentaDestino);
            statement.setString(3, nombreDestinatario);
            statement.setLong(4, cedulaDestinatario);
            statement.setDouble(5, monto);
            statement.executeUpdate();
        }
    }
    /**
     * Método principal utilizado para probar la funcionalidad de realizarTransferencia.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        TransferenciaEntreCuentas transferencia = new TransferenciaEntreCuentas();

        // Ejemplo de llamada al método para realizar una transferencia
        transferencia.realizarTransferencia(123456789, 987654321, "Destinatario", 987654321, 500.0);
    }
}
