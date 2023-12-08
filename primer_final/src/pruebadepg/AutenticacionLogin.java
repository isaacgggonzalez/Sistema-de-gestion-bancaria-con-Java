package pruebadepg;
import config.ConexionBD;
import primer_final.LoginInterfaz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Clase que gestiona la autenticación de usuarios mediante la verificación de credenciales.
 */
public class AutenticacionLogin {
   
    /**
     * Verifica la autenticación de un usuario mediante la comparación de las credenciales con la base de datos.
     *
     * @param cedula       El número de cédula del usuario.
     * @param numeroCuenta El número de cuenta del usuario.
     * @param clave        La clave o PIN del usuario.
     * @return true si las credenciales son correctas, false si no lo son.
     */
    public boolean verificarPinCuenta(long cedula, long numeroCuenta, int clave) {
        boolean credencialesCorrectas = false;

        try (Connection conexion = ConexionBD.conectar()) {
            // Llamada a la función de verificación de credenciales
            credencialesCorrectas = verificarCredencialesEnBaseDeDatos(conexion, cedula, numeroCuenta, clave);
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar la excepción de alguna manera apropiada en tu aplicación
        }
        return credencialesCorrectas;
    }
    

    /**
     * Verifica las credenciales del usuario en la base de datos.
     *
     * @param conexion     La conexión a la base de datos.
     * @param cedula       El número de cédula del usuario.
     * @param numeroCuenta El número de cuenta del usuario.
     * @param clave        La clave o PIN del usuario.
     * @return true si las credenciales son correctas, false si no lo son.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    private boolean verificarCredencialesEnBaseDeDatos(Connection conexion, long cedula, long numeroCuenta, int clave) throws SQLException {
        boolean credencialesCorrectas = false;

        // Consulta SQL para verificar las credenciales
        String consulta = "SELECT * FROM cuenta cu "
                         + "WHERE cu.id_cliente IN (SELECT c.id_cliente FROM cliente c WHERE c.cedula = ?) "
                         + "AND cu.numero_cuenta = ? AND cu.pin_cuenta = ?";

        System.out.println("Parámetros: cedula=" + cedula + ", numeroCuenta=" + numeroCuenta + ", pinCuenta=" + clave);
        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setLong(1, cedula);
            statement.setLong(2, numeroCuenta);
            statement.setInt(3, clave);

            try (ResultSet resultSet = statement.executeQuery()) {
                // Si hay resultados, las credenciales son correctas
                if (resultSet.next()) {
                    System.out.println("Credenciales encontradas en la base de datos.");
                    credencialesCorrectas = true;
                } else {
                    System.out.println("No se encontraron credenciales en la base de datos.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al ejecutar la consulta SQL.");
        }

        return credencialesCorrectas;
    }
    
    
    
    /**
     * Método principal utilizado para pruebas y ejecución de la clase AutenticacionLogin.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        AutenticacionLogin autenticacion = new AutenticacionLogin();
        LoginInterfaz loginInterfaz = new LoginInterfaz();
        String cedulaString = loginInterfaz.getBox_cedula();
        // Convertir el String a long
        long cedula = 0; // Valor predeterminado si no se puede convertir
        try {
            cedula = Long.parseLong(cedulaString);
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Manejar la excepción si el formato no es válido
        }
        
        //long cedula = 5209767; 
        long numeroCuenta = 987654321; 
        int clave = 1234; 
        
       if (autenticacion.verificarPinCuenta(cedula, numeroCuenta, clave)) {
            System.out.println("Credenciales correctas. Inicio de sesión exitoso.");
            // Realizar acciones después de iniciar sesión
            System.out.println("Fin del bloque de inicio de sesión exitoso.");
        } else {
            System.out.println("Credenciales incorrectas. Inicio de sesión fallido.");
        }
    }
}