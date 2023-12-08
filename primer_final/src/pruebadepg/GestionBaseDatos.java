package pruebadepg;
import config.ConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Clase que gestiona la inserción de datos en las tablas cliente y cuenta de la base de datos.
 */
public class GestionBaseDatos {
    /**
     * Inserta datos de cliente y cuenta en las respectivas tablas de la base de datos.
     *
     * @param nombre      El nombre del cliente.
     * @param apellido    El apellido del cliente.
     * @param cedula      La cédula del cliente.
     * @param fechaNac    La fecha de nacimiento del cliente en formato "yyyy-MM-dd".
     * @param pinCuenta   El PIN de la cuenta del cliente.
     * @param numeroCuenta El número de cuenta del cliente.
     */
    public void insertarDatosCliente(String nombre, String apellido, long cedula, String fechaNac, int pinCuenta, long numeroCuenta) {
        try (Connection conexion = ConexionBD.conectar()) {
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
    /**
     * Método principal utilizado para pruebas y ejecución de la clase GestionBaseDatos.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        GestionBaseDatos gestionBD = new GestionBaseDatos();

        // Ejemplo de inserción de datos
        gestionBD.insertarDatosCliente("alan", "gonz", 2034565, "2000-03-15", 1234, 123456789);
    }
}
