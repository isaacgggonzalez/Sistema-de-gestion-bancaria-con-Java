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
               preparedStatement.setString(1, transaccion.get_TipoTransaccion());
               preparedStatement.setString(2, transaccion.get_FechaTransaccion());
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
}
