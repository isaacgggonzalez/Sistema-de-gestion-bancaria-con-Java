package pruebadepg;

import config.ConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import primer_final.*;
import java.math.BigDecimal;

public class GestorClientes {

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


    public static void main(String[] args) {
        
        // Puedes realizar pruebas aquí si lo deseas
        /*
        long cedulaCliente = 5900426;
        Cliente nombreCliente = obtenerCliente(cedulaCliente);
        System.out.println("Nombre del cliente con cédula " + cedulaCliente + ": " + nombreCliente);
        */
    }
}
