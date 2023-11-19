package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.RuntimeException;
public class ConexionBD {
    private static final String BASE = "postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";
    private static final String URL = "jdbc:postgresql://localhost:5432/" + BASE;

    public static Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar a la base de datos", e);
        }
        return conexion;
    }

    public static void cerrarConexion(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

