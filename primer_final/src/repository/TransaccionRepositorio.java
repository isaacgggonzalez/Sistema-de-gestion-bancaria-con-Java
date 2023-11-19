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

public class TransaccionRepositorio {
       private static final String INSERTAR_TRANSACCION = "INSERT INTO "
               + "transaccion(tipo, fecha) VALUES(?,?)";
       
       public TransaccionRepositorio(){}
       
       public Long insertTransaccion(Transaccion transaccion){
           Connection connection = ConexionBD.conectar();
           try {
           
               PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_TRANSACCION);
               preparedStatement.setString(1, transaccion.getTipo_transaccion());
               preparedStatement.setString(2, transaccion.getFecha_transaccion());
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

       
        
       

       
}
