package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.RuntimeException;

/**
 * Clase que gestiona la conexión a la base de datos.
 */
public class ConexionBD {
    private static final String BASE = "lp2_final";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";
    private static final String URL = "jdbc:postgresql://localhost:5432/" + BASE;
    
    /**
     * Establece una conexión a la base de datos.
     *
     * @return Objeto Connection que representa la conexión a la base de datos.
     * @throws RuntimeException Si hay un error al conectar a la base de datos.
     */
    public static Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar a la base de datos", e);
        }
        return conexion;
    }
    /**
     * Cierra la conexión a la base de datos.
     *
     * @param connection Objeto Connection que representa la conexión a cerrar.
     */
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

