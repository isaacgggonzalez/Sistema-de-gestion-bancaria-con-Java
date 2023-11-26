package repository;

import config.ConexionBD;
import primer_final.Transaccion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.RuntimeException;
import java.sql.Timestamp;
import javax.swing.table.DefaultTableModel;

public class TransaccionRepositorio {
        private static final String INSERTAR_TRANSACCION = "INSERT INTO "
               + "transaccion(tipo, fecha) VALUES(?,?)";
       
        public TransaccionRepositorio(){}
       
        public Long insertTransaccion(Transaccion transaccion){
           Connection connection = ConexionBD.conectar();
           try {
           
               PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_TRANSACCION);
               preparedStatement.setInt(1, transaccion.getIdTransaccion());
               preparedStatement.setDate(2, (java.sql.Date) transaccion.get_fecha_transaccion());
               preparedStatement.executeUpdate();
               ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
               Long idGenerado = generatedKeys.getLong(1);
               System.out.println("Transaccion insertada con id: " + idGenerado);
               ConexionBD.cerrarConexion(connection);
               return idGenerado;
           } catch (SQLException ex) {
               Logger.getLogger(TransaccionRepositorio.class.getName()).log(Level.SEVERE, null, ex);
               ConexionBD.cerrarConexion(connection);
               throw new RuntimeException("Error al intentar insertar la transaccion");
           }
       }
       
        //que seria de transferencia
        public static boolean confirmarDatos(long DestinoTransferencia, long cedula, String nombre_destinatario) {
            Connection connection = ConexionBD.conectar();
            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cliente c, cuenta cu WHERE c.cedula = ? AND cu.numero_cuenta = ? AND c.nombre = ?")) {
                preparedStatement.setLong(1, cedula);
                preparedStatement.setLong(2, DestinoTransferencia);
                preparedStatement.setString(3, nombre_destinatario);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println("Credenciales encontradas en la base de datos.");
                        ConexionBD.cerrarConexion(connection);
                        return true;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                ConexionBD.cerrarConexion(connection);
                // Manejo de excepciones, puedes lanzar una excepción personalizada o devolver un valor predeterminado según sea necesario
            }

            return false;
        }
        
        public static void debitarCuenta(Connection conexion, long cuentaOrigen, double monto) throws SQLException {
            String actualizarSaldo = "UPDATE cuenta SET saldo = saldo - ? WHERE numero_cuenta = ?";
            try (PreparedStatement statement = conexion.prepareStatement(actualizarSaldo)) {
                statement.setDouble(1, monto);
                statement.setLong(2, cuentaOrigen);
                statement.executeUpdate();
            }
        }

        public static void acreditarCuenta(Connection conexion, long cuentaDestino, double monto) throws SQLException {
            String actualizarSaldo = "UPDATE cuenta SET saldo = saldo + ? WHERE numero_cuenta = ?";
            try (PreparedStatement statement = conexion.prepareStatement(actualizarSaldo)) {
                statement.setDouble(1, monto);
                statement.setLong(2, cuentaDestino);
                statement.executeUpdate();
            }
        }
        
        
        public static boolean verificarSaldoSuficiente(Connection conexion, long cuentaOrigen, double monto) throws SQLException {
            // Implementa la lógica para verificar si la cuenta de origen tiene saldo suficiente
            String consultaSaldo = "SELECT saldo FROM cuenta WHERE numero_cuenta = ?";
            try (PreparedStatement statement = conexion.prepareStatement(consultaSaldo)) {
                statement.setLong(1, cuentaOrigen);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        double saldo = resultSet.getDouble("saldo");
                        return (saldo >= monto && monto>0);
                    }
                }
            }
            return false;
        }
        
        
        public static void realizarTransaccion(Connection conexion, String tipoTransaccion, double monto, long numero_cuenta) throws SQLException {
            // Insertar nueva entrada en la tabla de transaccion
            String insertarTransaccion = "INSERT INTO movimiento(tipo, fecha, monto, id_cuenta) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = conexion.prepareStatement(insertarTransaccion)) {
                statement.setString(1, tipoTransaccion);
                statement.setTimestamp(2, new Timestamp(System.currentTimeMillis())); // Obtener la fecha actual
                statement.setDouble(3, monto);
                statement.setLong(4, numero_cuenta);
                statement.executeUpdate();
            }
        }
        
        public static DefaultTableModel obtenerTransaccionesPorCuenta(long idCuenta) {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID Transacción");
            modelo.addColumn("Tipo de Transacción");
            modelo.addColumn("Fecha de Transacción");
            modelo.addColumn("Monto");

            try (Connection conexion = ConexionBD.conectar()) {
                String consulta = "SELECT * FROM transaccion WHERE numero_cuenta = ?";
                try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
                    statement.setLong(1, idCuenta);

                    try (ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            Object[] fila = {
                                resultSet.getLong("id_transaccion"),
                                resultSet.getString("tipo"),
                                resultSet.getDate("fecha"),
                                resultSet.getDouble("monto")
                            };
                            modelo.addRow(fila);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Manejar la excepción según sea necesario
            }

            return modelo;
        }
    
     
        
        
}
