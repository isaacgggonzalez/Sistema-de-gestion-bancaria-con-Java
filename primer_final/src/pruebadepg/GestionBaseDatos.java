package pruebadepg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GestionBaseDatos {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "1234";

    public void insertarDatosCliente(String nombre, String apellido, long cedula, String fechaNac, int pinCuenta, long numeroCuenta) {
        try (Connection conexion = DriverManager.getConnection(url, user, password)) {
            // Inserción de datos en las tablas cliente y cuenta
            String insertarCliente = "INSERT INTO cliente (cedula, nombre, apellido, fecha_nac) VALUES (?, ?, ?, ?)";
            String insertarCuenta = "INSERT INTO cuenta (id_cliente, pin_cuenta, numero_cuenta) VALUES (?, ?, ?)";

            try (PreparedStatement statementCliente = conexion.prepareStatement(insertarCliente, PreparedStatement.RETURN_GENERATED_KEYS);
                    PreparedStatement statementCuenta = conexion.prepareStatement(insertarCuenta)) {

                // Convertir la cadena de fecha a java.sql.Date
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date parsedDate = sdf.parse(fechaNac);
                java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());

                // Inserción en la tabla cliente
                statementCliente.setLong(1, cedula);
                statementCliente.setString(2, nombre);
                statementCliente.setString(3, apellido);
                statementCliente.setDate(4, sqlDate);
                statementCliente.executeUpdate();

                // Obtener el ID del cliente recién insertado
                ResultSet generatedKeys = statementCliente.getGeneratedKeys();
                if (generatedKeys.next()) {
                    long idCliente = generatedKeys.getLong(1);

                    // Inserción en la tabla cuenta
                    statementCuenta.setLong(1, idCliente);
                    statementCuenta.setInt(2, pinCuenta);
                    statementCuenta.setLong(3, numeroCuenta);
                    statementCuenta.executeUpdate();

                    System.out.println("Datos insertados correctamente.");
                }
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace(); // Manejar la excepción de alguna manera apropiada en tu aplicación
        }
    }

    public static void main(String[] args) {
        GestionBaseDatos gestionBD = new GestionBaseDatos();

        // Ejemplo de inserción de datos
        gestionBD.insertarDatosCliente("alan", "gonz", 2034565, "2000-03-15", 1234, 123456789);
    }
}
