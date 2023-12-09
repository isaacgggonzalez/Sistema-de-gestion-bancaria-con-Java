package pruebadepg;

import config.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Cliente;
import modelo.Cuenta;

/**
 * Clase que gestiona la obtención de información relacionada con clientes y cuentas en la base de datos.
 */
public class GestorClientes {
    /**
     * Obtiene un objeto Cliente a partir de la base de datos según la cédula proporcionada.
     *
     * @param cedula La cédula del cliente a buscar.
     * @return El objeto Cliente correspondiente a la cédula dada, o null si no se encuentra.
     */
    public static Cliente obtenerCliente(long cedula) {
    Cliente cliente = null;

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement preparedStatement = conexion.prepareStatement("SELECT * FROM cliente WHERE cedula = ?")) {

        preparedStatement.setLong(1, cedula);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                int idCliente = resultSet.getInt("id_cliente");
                int ciCliente = resultSet.getInt("cedula");
                String nombreCliente = resultSet.getString("nombre");
                String apellidoCliente = resultSet.getString("apellido");
                String nacimientoCliente = resultSet.getString("fecha_nac");

                cliente = new Cliente(idCliente, ciCliente, nombreCliente, apellidoCliente, nacimientoCliente);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
        // Manejo de excepciones, puedes lanzar una excepción personalizada o devolver un valor predeterminado según sea necesario
    }

    return cliente;
}
    /**
     * Obtiene un objeto Cuenta a partir del número de cuenta proporcionado.
     *
     * @param numeroCuenta El número de cuenta de la cuenta a buscar.
     * @return El objeto Cuenta correspondiente al número de cuenta dado, o null si no se encuentra.
     */
    public static Cuenta obtenerCuenta(long numeroCuenta) {
        Cuenta cuenta = null;
        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement preparedStatement = conexion.prepareStatement("SELECT * FROM cuenta WHERE numero_cuenta = ?")) {

            preparedStatement.setLong(1, numeroCuenta);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    long idCuenta = resultSet.getInt("id_cuenta");
                    long pinCuenta = resultSet.getLong("pin_cuenta");
                    double saldo = resultSet.getDouble("saldo");
                    long idCliente = resultSet.getLong("id_cliente");
                    long numeroCuentaResultado = resultSet.getLong("numero_cuenta");
                    int pin_transaccion = resultSet.getInt("pin_transaccion");

                    cuenta = new Cuenta(idCuenta, numeroCuentaResultado, pinCuenta, saldo, idCliente, pin_transaccion);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones, puedes lanzar una excepción personalizada o devolver un valor predeterminado según sea necesario
        }

        return cuenta;

    }

    /**
     * Método principal utilizado para pruebas y ejecución de la clase GestorClientes.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        
        // Puedes realizar pruebas aquí si lo deseas
        /*
        long cedulaCliente = 5900426;
        Cliente nombreCliente = obtenerCliente(cedulaCliente);
        System.out.println("Nombre del cliente con cédula " + cedulaCliente + ": " + nombreCliente);
        */
    }
}
