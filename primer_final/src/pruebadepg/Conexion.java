package pruebadepg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que gestiona la conexión a la base de datos PostgreSQL.
 */
public class Conexion {
    private final String base = "lp2_final";
    private final String user = "postgres";
    private final String password = "1234";
    private final String url = "jdbc:postgresql://localhost:5432/" + base;
    /**
     * Obtiene y retorna una conexión a la base de datos PostgreSQL.
     *
     * @return La conexión a la base de datos.
     * @throws SQLException Si ocurre un error al conectar a la base de datos.
     */
    public Connection getConexion() throws SQLException {
        Connection conexion = null;
        try {
            // No es necesario cargar el controlador JDBC en versiones recientes (JDBC 4.0 y posteriores)
            // Class.forName("org.postgresql.Driver");

            // Establecer la conexión
            conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // Manejar la excepción de alguna manera apropiada en tu aplicación, por ejemplo, lanzando una excepción personalizada
            throw new SQLException("Error al conectar a la base de datos", e);
        }
        return conexion;
    }
    /**
     * Método principal utilizado para pruebas y ejecución de la clase Conexion.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        try {
            Conexion miConexion = new Conexion();
            Connection conexion = miConexion.getConexion();

            if (conexion != null) {
                System.out.println("Conexión exitosa a PostgreSQL");
                // Realizar operaciones con la base de datos si es necesario

                // Cerrar la conexión cuando hayas terminado
                conexion.close();
            } else {
                System.out.println("Error al conectar a PostgreSQL");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
