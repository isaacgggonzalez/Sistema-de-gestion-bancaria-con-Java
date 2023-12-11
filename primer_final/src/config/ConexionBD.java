package config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.RuntimeException;

/**
 * Clase que gestiona la conexión a la base de datos.
 */
public class ConexionBD {
    private static final String BASE = "lp2_final_grupo11";
    private static String USER;
    private static String PASSWORD;
    private static final String URL = "jdbc:postgresql://localhost:5432/" + BASE;
    
    
    private static void credenciales(){
        String dir = System.getProperty("user.dir");
        try (BufferedReader br = new BufferedReader(new FileReader(dir+"/credenciales.txt"))) {
            USER= br.readLine();
            PASSWORD= br.readLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Establece una conexión a la base de datos.
     *
     * @return Objeto Connection que representa la conexión a la base de datos.
     * @throws RuntimeException Si hay un error al conectar a la base de datos.
     */
    public static Connection conectar() {
        credenciales();
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

