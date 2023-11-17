package pruebadepg;
import primer_final.LoginInterfaz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutenticacionLogin {
    
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "1234";
   
    
    public boolean verificarPinCuenta(long cedula, long numeroCuenta, int clave) {
        boolean credencialesCorrectas = false;

        try (Connection conexion = DriverManager.getConnection(url, user, password)) {
            // Llamada a la función de verificación de credenciales
            credencialesCorrectas = verificarCredencialesEnBaseDeDatos(conexion, cedula, numeroCuenta, clave);
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar la excepción de alguna manera apropiada en tu aplicación
        }
        return credencialesCorrectas;
    }

    // Función separada para realizar la verificación de credenciales en la base de datos
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