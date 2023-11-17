package pruebadepg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PagoTarjeta {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "1234";

    public void realizarPagoTarjeta(long idCliente) {
        try (Connection conexion = DriverManager.getConnection(url, user, password)) {
            // Obtener las tarjetas de crédito asociadas al cliente
            String consultaTarjetas = "SELECT id_tarjeta_credito, nro_tarjeta FROM tarjeta_credito WHERE id_cliente = ?";
            try (PreparedStatement statementTarjetas = conexion.prepareStatement(consultaTarjetas)) {
                statementTarjetas.setLong(1, idCliente);

                try (ResultSet resultSetTarjetas = statementTarjetas.executeQuery()) {
                    // Mostrar las tarjetas de crédito disponibles
                    System.out.println("Tarjetas de Crédito Disponibles:");
                    while (resultSetTarjetas.next()) {
                        long idTarjeta = resultSetTarjetas.getLong("id_tarjeta_credito");
                        String nroTarjeta = resultSetTarjetas.getString("nro_tarjeta");
                        System.out.println("ID: " + idTarjeta + " - Número de Tarjeta: " + nroTarjeta);
                    }

                    // Solicitar al usuario que seleccione una tarjeta
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Ingrese el ID de la tarjeta a pagar: ");
                    long idTarjetaSeleccionada = scanner.nextLong();

                    // Realizar el pago de la tarjeta seleccionada
                    pagarTarjeta(conexion, idTarjetaSeleccionada);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void pagarTarjeta(Connection conexion, long idTarjeta) throws SQLException {
        // Implementa la lógica para realizar el pago de la tarjeta
        // Puedes actualizar el saldo y otros detalles en la base de datos
        // (Deberías ajustar esta lógica según la estructura de tu base de datos y tus necesidades específicas.)
    }

    public static void main(String[] args) {
        PagoTarjeta pagoTarjeta = new PagoTarjeta();

        // Ejemplo de llamada al método para realizar un pago de tarjeta
        long idCliente = 123456789; // Reemplazar con el valor del cliente
        pagoTarjeta.realizarPagoTarjeta(idCliente);
    }
}
