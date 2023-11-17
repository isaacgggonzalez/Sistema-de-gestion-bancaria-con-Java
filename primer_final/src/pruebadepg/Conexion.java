package pruebadepg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private final String base = "postgres";
    private final String user = "postgres";
    private final String password = "1234";
    private final String url = "jdbc:postgresql://localhost:5432/" + base;

    public Connection getConexion() {
        Connection conexion = null;
        try {
            // Cargar el controlador JDBC de PostgreSQL
            Class.forName("org.postgresql.Driver");

            // Establecer la conexión
            conexion = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Manejar la excepción de alguna manera apropiada en tu aplicación
        }
        return conexion;
    }

    public static void main(String[] args) {
        Conexion miConexion = new Conexion();
        Connection conexion = miConexion.getConexion();

        if (conexion != null) {
            System.out.println("Conexión exitosa a PostgreSQL");
            // Realizar operaciones con la base de datos si es necesario
        } else {
            System.out.println("Error al conectar a PostgreSQL");
        }
    }
}
