package pruebadepg;

import config.ConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InicializadorDB {
        
    public static void inicializarBaseDatos() {

        try (Connection conexion = ConexionBD.conectar();
             Statement statement = conexion.createStatement()) {

            // Crear tabla cliente
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS cliente(" +
                    "id_cliente BIGSERIAL PRIMARY KEY," +
                    "cedula BIGINT UNIQUE NOT NULL," +
                    "nombre VARCHAR(50) NOT NULL," +
                    "apellido VARCHAR(50) NOT NULL," +
                    "fecha_nac DATE NOT NULL)");

            // Insertar datos en la tabla cliente
            statement.executeUpdate("INSERT INTO cliente(cedula, nombre, apellido, fecha_nac) VALUES " +
                    "(12345678, 'Juan', 'Perez', '1990-01-01')," +
                    "(9876543, 'Maria', 'Gomez', '1985-05-15'),"+
                    "(5900426, 'Alan', 'Alcaraz', '2003-07-30')");

            // Crear tabla cuenta
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS cuenta(" +
                    "id_cuenta BIGSERIAL PRIMARY KEY," +
                    "id_cliente BIGINT NOT NULL," +
                    "saldo NUMERIC(18, 0)," +
                    "numero_cuenta BIGINT NOT NULL," +
                    "pin_cuenta BIGINT NOT NULL," +
                    "FOREIGN KEY(id_cliente) REFERENCES cliente(id_cliente)," +
                    "UNIQUE(id_cuenta, id_cliente))");

            // Insertar datos en la tabla cuenta
            statement.executeUpdate("INSERT INTO cuenta(id_cliente, saldo, numero_cuenta, pin_cuenta) VALUES " +
                    "(1, 1000, 1234567890, 1234)," +
                    "(2, 1500, 9876543210, 5678),"+
                    "(3, 2500, 1234, 1234)");

            // Crear tabla transaccion
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS transaccion(" +
                    "id_transaccion BIGSERIAL PRIMARY KEY," +
                    "tipo VARCHAR(20) NOT NULL," +
                    "fecha TIMESTAMP NOT NULL)");

            // Crear tabla deposito
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS deposito(" +
                    "id_deposito BIGSERIAL PRIMARY KEY," +
                    "id_transaccion BIGINT UNIQUE NOT NULL," +
                    "id_cuenta BIGINT NOT NULL," +
                    "monto NUMERIC(18, 0) NOT NULL," +
                    "FOREIGN KEY(id_cuenta) REFERENCES cuenta(id_cuenta)," +
                    "FOREIGN KEY(id_transaccion) REFERENCES transaccion(id_transaccion))");

            // Crear tabla transferencia
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS transferencia(" +
                    "id_transferencia BIGSERIAL PRIMARY KEY," +
                    "id_transaccion BIGINT UNIQUE NOT NULL," +
                    "id_cuenta_destino BIGINT NOT NULL," +
                    "id_cuenta_origen BIGINT NOT NULL," +
                    "monto NUMERIC(18, 0) NOT NULL," +
                    "FOREIGN KEY(id_cuenta_destino) REFERENCES cuenta(id_cuenta)," +
                    "FOREIGN KEY(id_cuenta_origen) REFERENCES cuenta(id_cuenta)," +
                    "FOREIGN KEY(id_transaccion) REFERENCES transaccion(id_transaccion))");

            // Crear tabla servicio
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS servicio(" +
                    "id_servicio BIGSERIAL PRIMARY KEY," +
                    "nombre VARCHAR(100) NOT NULL," +
                    "monto NUMERIC(18, 0) NOT NULL)");

            // Crear tabla pago_servicio
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS pago_servicio(" +
                    "id_pago_servicio BIGSERIAL PRIMARY KEY," +
                    "id_servicio BIGINT UNIQUE NOT NULL," +
                    "id_transaccion BIGINT UNIQUE NOT NULL," +
                    "id_cuenta BIGINT NOT NULL," +
                    "monto NUMERIC(18, 0) NOT NULL," +
                    "FOREIGN KEY(id_cuenta) REFERENCES cuenta(id_cuenta)," +
                    "FOREIGN KEY(id_transaccion) REFERENCES transaccion(id_transaccion)," +
                    "FOREIGN KEY(id_servicio) REFERENCES servicio(id_servicio))");

            // Crear tabla tarjeta_credito
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS tarjeta_credito(" +
                    "id_tarjeta_credito BIGSERIAL PRIMARY KEY," +
                    "id_cliente BIGINT NOT NULL," +
                    "linea NUMERIC(18,0) NOT NULL," +
                    "deuda NUMERIC(18, 0) NOT NULL DEFAULT 0," +
                    "fecha_vencimiento DATE NOT NULL," +
                    "nro_tarjeta NUMERIC(7,0) UNIQUE NOT NULL," +
                    "FOREIGN KEY(id_cliente) REFERENCES cliente(id_cliente))");

            // Insertar datos en la tabla tarjeta_credito
            statement.executeUpdate("INSERT INTO tarjeta_credito(id_cliente, linea, fecha_vencimiento, nro_tarjeta) VALUES " +
                    "(1, 2000, '2023-12-31', 1234567)," +
                    "(2, 3000, '2024-06-30', 7654321),"+
                    "(3, 4000, '2024-06-30', 3604561)");

            // Crear tabla pago_tarjeta
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS pago_tarjeta(" +
                    "id_pago_tarjeta BIGSERIAL PRIMARY KEY," +
                    "monto NUMERIC(18, 0) NOT NULL," +
                    "id_tarjeta_credito BIGINT UNIQUE NOT NULL," +
                    "id_cuenta BIGINT NOT NULL," +
                    "FOREIGN KEY(id_cuenta) REFERENCES cuenta(id_cuenta)," +
                    "FOREIGN KEY(id_tarjeta_credito) REFERENCES tarjeta_credito(id_tarjeta_credito))");

            System.out.println("Base de datos inicializada correctamente.");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        inicializarBaseDatos();
    }    
    
    
}