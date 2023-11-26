package repository;

import config.ConexionBD;
import primer_final.Transaccion;
import primer_final.Transferencia;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransaccionRepositorio2 {
        private static final String INSERTAR_TRANSACCION = "INSERT INTO "
               + "transaccion(tipo, fecha, monto) VALUES (?, ?, ?)";

        private static final String INSERTAR_MOVIMIENTO = "INSERT INTO "
                + "movimiento(id_transaccion, id_cuenta) VALUES (?, ?)";

        private static final String ACTUALIZAR_SALDO = "UPDATE cuenta SET saldo = saldo + ? WHERE id_cuenta = ?";

        private static final String RECUPERAR_ID_CUENTA = "SELECT id_cuenta FROM cuenta WHERE numero_cuenta = ?";

        private static final String INSERTAR_TRANSFERENCIA = "INSERT INTO "
                + "transferencia(id_transaccion, id_cuenta_destino, id_cuenta_origen) VALUES(?, ?, ?)";

        private static final String VALIDAR_PIN_TRANASCCION = "SELECT 1 FROM cuenta WHERE pin_transaccion = ?";

        public TransaccionRepositorio2(){}
       
        public Long insertTransaccion(Transaccion transaccion){
           Connection connection = ConexionBD.conectar();
           try {
               PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_TRANSACCION, Statement.RETURN_GENERATED_KEYS);
               preparedStatement.setString(1, transaccion.getTipoTransaccion());
               preparedStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
               preparedStatement.setDouble(3, transaccion.getMontoTransaccion());
               preparedStatement.executeUpdate();
               ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
               generatedKeys.next();
               Long idGenerado = generatedKeys.getLong(1);
               System.out.println("Transaccion insertada con id: " + idGenerado);
               ConexionBD.cerrarConexion(connection);
               return idGenerado;
           } catch (SQLException ex) {
               Logger.getLogger(TransaccionRepositorio2.class.getName()).log(Level.SEVERE, null, ex);
               ConexionBD.cerrarConexion(connection);
               throw new RuntimeException("Error al intentar insertar la transaccion");
           }
       }

    public Long insertMovimiento(long idCuenta, long idTransaccion){
        Connection connection = ConexionBD.conectar();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_MOVIMIENTO, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, idTransaccion);
            preparedStatement.setLong(2, idCuenta);
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            Long idGenerado = generatedKeys.getLong(1);
            System.out.println("Movimiento insertado con id: " + idGenerado);
            ConexionBD.cerrarConexion(connection);
            return idGenerado;
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionRepositorio2.class.getName()).log(Level.SEVERE, null, ex);
            ConexionBD.cerrarConexion(connection);
            throw new RuntimeException("Error al intentar insertar el movimiento");
        }
    }

    public Long insertTransferencia(Long idTransaccion, Long idCuentaOrigen, Long idCuentaDestino){
        Connection connection = ConexionBD.conectar();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_TRANSFERENCIA, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, idTransaccion);
            preparedStatement.setLong(2, idCuentaDestino);
            preparedStatement.setLong(3, idCuentaOrigen);
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            System.out.println(generatedKeys.next());
            Long idGenerado = generatedKeys.getLong(1);
            System.out.println("Transferencia insertada con id: " + idGenerado);
            ConexionBD.cerrarConexion(connection);
            return idGenerado;
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionRepositorio2.class.getName()).log(Level.SEVERE, null, ex);
            ConexionBD.cerrarConexion(connection);
            throw new RuntimeException("Error al intentar insertar transferencia");
        }
    }

       public Long recuperarIdCuenta(Long numeroCuenta){
           Connection connection = ConexionBD.conectar();
           try {
               PreparedStatement statement = connection.prepareStatement(RECUPERAR_ID_CUENTA);
               statement.setLong(1, numeroCuenta);

               try (ResultSet resultSet = statement.executeQuery()) {
                   if(resultSet.next()){
                       ConexionBD.cerrarConexion(connection);
                       return resultSet.getLong("id_cuenta");
                   }else{
                       ConexionBD.cerrarConexion(connection);
                       throw new RuntimeException("No tiene una cuenta asociada");
                   }
               }
           } catch (SQLException ex) {
               Logger.getLogger(TransaccionRepositorio2.class.getName()).log(Level.SEVERE, null, ex);
               ConexionBD.cerrarConexion(connection);
               throw new RuntimeException("Error al intentar recuperar id_cuenta");
           }
       }

    public Boolean validarPinTransaccion(Long pinTransaccion){
        Connection connection = ConexionBD.conectar();
        try {
            PreparedStatement statement = connection.prepareStatement(VALIDAR_PIN_TRANASCCION);
            statement.setLong(1, pinTransaccion);

            try (ResultSet resultSet = statement.executeQuery()) {
                if(resultSet.next()){
                    ConexionBD.cerrarConexion(connection);
                    return true;
                }else{
                    ConexionBD.cerrarConexion(connection);
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionRepositorio2.class.getName()).log(Level.SEVERE, null, ex);
            ConexionBD.cerrarConexion(connection);
            throw new RuntimeException("Error al intentar recuperar id_cuenta");
        }
    }
       
        //que seria de transferencia
        public boolean confirmarDatos(long DestinoTransferencia, long cedula, String nombre_destinatario) {
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

        public void actualizarSaldoCuenta(long idCuenta, double monto) {
            Connection connection = ConexionBD.conectar();
            try {
                PreparedStatement statement = connection.prepareStatement(ACTUALIZAR_SALDO);
                statement.setDouble(1, monto);
                statement.setLong(2, idCuenta);
                statement.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(TransaccionRepositorio2.class.getName()).log(Level.SEVERE, null, ex);
                ConexionBD.cerrarConexion(connection);
                throw new RuntimeException("Error al intentar insertar la transaccion");
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
    
        /*
      private void boton_confirmarTransaccion1ActionPerformed(ActionEvent evt) {                                                            
        
        Connection connection = ConexionBD.conectar();
        try {
            // Obtener valores de los campos de texto
            long cuenta_Destino = Long.parseLong(cuentaDestino.getText().trim());
            String nombreDestinatario = nombre_destinatario.getText().trim();
            long cedula_destinatario = Long.parseLong(cedula.getText().trim());
            String montoTexto = monto.getText().trim();
            // Convertir la cadena a long
            long montoLong = Long.parseLong(montoTexto);
            
            // Validar que la cuenta_Destino sea positiva
            if (cuenta_Destino <= 0) {
                mostrarMensajeError("La cuenta de destino debe ser un número positivo.");
                return; // Salir del método si la validación no pasa
            }

            // Validar que la cedula_destinatario sea positiva
            if (cedula_destinatario <= 0) {
                mostrarMensajeError("La cédula del destinatario debe ser un número positivo.");
                return; // Salir del método si la validación no pasa
            }

            // Validar que el nombreDestinatario no esté vacío
            if (nombreDestinatario.isEmpty()) {
                mostrarMensajeError("El nombre del destinatario no puede estar vacío.");
                return; // Salir del método si la validación no pasa
            }
            
            if(cuenta.getNumeroCuenta() == cuenta_Destino){
                mostrarMensajeError("No se puede transferir a su misma cuenta.");
                return; // Salir del método si la validación no pasa
            
            }
            
        if(TransaccionRepositorio.verificarSaldoSuficiente( connection, cuenta.getNumeroCuenta(), montoLong) != false){
            // Confirmar los datos si todas las validaciones pasan

            if (TransaccionRepositorio.confirmarDatos(cuenta_Destino, cedula_destinatario, nombreDestinatario)){
                
                PinTransaccionInterfaz ventanaPIN = new PinTransaccionInterfaz(cliente, cuenta);
                ventanaPIN.setVisible(true);
               
                /*
                TransaccionRepositorio.debitarCuenta(connection, cuenta.getNumeroCuenta(), montoLong);
                TransaccionRepositorio.acreditarCuenta(connection, cuenta_Destino, montoLong);
                cuenta.setSaldoCuenta(cuenta.getSaldoCuenta() - montoLong);
                saldo.setText(Double.toString(cuenta.getSaldoCuenta()));
                TransaccionRepositorio.realizarTransaccion(connection, "Transferencia", montoLong, cuenta.getNumeroCuenta());
                
                
            }
        }else{
            mostrarMensajeError("Saldo insuficiente.");
        }

            } catch (NumberFormatException e) {
                // Manejar la excepción si hay un error al convertir los números
                mostrarMensajeError("Error al ingresar los datos. Intente de nuevo.");
            } catch (SQLException ex) {
                Logger.getLogger(BaseInterfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
 
        
        
        
    }                                                           
    
    
    public long  mostrarmonto(){
        String montoTexto = monto.getText().trim();
        // Convertir la cadena a long
        long montoLong = Long.parseLong(montoTexto);
        return montoLong;
    
    }
     */   
        
        
        
        
        
}
