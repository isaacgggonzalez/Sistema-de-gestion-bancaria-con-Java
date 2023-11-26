package pruebadepg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class TransferenciaEntreCuentas {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "1234";

    public void realizarTransferencia(long cuentaOrigen, long cuentaDestino, String nombreDestinatario,
                                      long cedulaDestinatario, double monto) {
        try (Connection conexion = DriverManager.getConnection(url, user, password)) {
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

    private void debitarCuenta(Connection conexion, long cuentaOrigen, double monto) throws SQLException {
        String actualizarSaldo = "UPDATE cuenta SET saldo = saldo - ? WHERE numero_cuenta = ?";
        try (PreparedStatement statement = conexion.prepareStatement(actualizarSaldo)) {
            statement.setDouble(1, monto);
            statement.setLong(2, cuentaOrigen);
            statement.executeUpdate();
        }
    }

    private void acreditarCuenta(Connection conexion, long cuentaDestino, double monto) throws SQLException {
        String actualizarSaldo = "UPDATE cuenta SET saldo = saldo + ? WHERE numero_cuenta = ?";
        try (PreparedStatement statement = conexion.prepareStatement(actualizarSaldo)) {
            statement.setDouble(1, monto);
            statement.setLong(2, cuentaDestino);
            statement.executeUpdate();
        }
    }

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

    public static void main(String[] args) {
        TransferenciaEntreCuentas transferencia = new TransferenciaEntreCuentas();

        // Ejemplo de llamada al método para realizar una transferencia
        transferencia.realizarTransferencia(123456789, 987654321, "Destinatario", 987654321, 500.0);
    }
}
