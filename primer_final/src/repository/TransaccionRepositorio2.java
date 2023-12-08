package repository;

import config.ConexionBD;
import modelo.Movimiento;
import primer_final.TarjetaDeCredito;
import primer_final.Transaccion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TransaccionRepositorio2 {
        private static final String INSERTAR_TRANSACCION = "INSERT INTO "
               + "transaccion(tipo, fecha, monto) VALUES (?, ?, ?)";

        private static final String INSERTAR_MOVIMIENTO = "INSERT INTO "
                + "movimiento(id_transaccion, id_cuenta) VALUES (?, ?)";

        private static final String ACTUALIZAR_SALDO = "UPDATE cuenta SET saldo = saldo + ? WHERE id_cuenta = ?";

        private static final String PAGAR_TARJETA = "UPDATE tarjeta_credito SET deuda = deuda-?  WHERE id_tarjeta_credito = ?";

        private static final String AUMENTAR_DEUDA_TARJETA = "UPDATE tarjeta_credito SET deuda = deuda+?  WHERE nro_tarjeta = ?";
        private static final String RECUPERAR_ID_CUENTA = "SELECT id_cuenta FROM cuenta WHERE numero_cuenta = ?";

        private static final String INSERTAR_TRANSFERENCIA = "INSERT INTO "
                + "transferencia(id_transaccion, id_cuenta_destino, id_cuenta_origen) VALUES(?, ?, ?)";

        private static final String VALIDAR_PIN_TRANASCCION = "SELECT 1 FROM cuenta WHERE pin_transaccion = ?";

        private static final String INSERTAR_DEPOSITO = "INSERT INTO deposito(id_transaccion, cajero) VALUES (?,?)";

        private static final String INSERTAR_PAGO_SERVICIO = "INSERT INTO pago_servicio(id_servicio, id_transaccion) VALUES(?, ?)";

        private static final String RECUPERAR_ID_SERVICIO = "SELECT id_servicio FROM servicio WHERE nombre = ?";
        private static final String INSERTAR_PAGO_TARJETA = "INSERT INTO pago_tarjeta(id_tarjeta_credito, id_transaccion) VALUES(?, ?)";
        private static final String RECUPERAR_ID_TARJETA = "SELECT id_tarjeta_credito FROM tarjeta_credito WHERE nro_tarjeta = ?";
        private static final String RECUPERAR_TARJETA_CREDITO = "SELECT id_tarjeta_credito, linea, deuda, fecha_vencimiento, nro_tarjeta FROM tarjeta_credito WHERE nro_tarjeta = ?";

    private static final String RECUPERAR_TARJETAS_CREDITO_CLIENTE = "SELECT id_tarjeta_credito, linea, deuda, fecha_vencimiento, nro_tarjeta FROM tarjeta_credito WHERE id_cliente = ?";
        private static final String RECUPERAR_LINEA_DEUDA = "SELECT linea, deuda FROM tarjeta_credito WHERE nro_tarjeta = ?";

        private static final String RECUPERAR_SALDO_CUENTA = "SELECT saldo FROM cuenta WHERE numero_cuenta = ?";

        private static final String RECUPERAR_MOVIMIENTOS = "SELECT t.id_transaccion, t.tipo, t.fecha, t.monto " +
                "FROM transaccion t " +
                "JOIN movimiento m ON t.id_transaccion = m.id_transaccion " +
                "WHERE m.id_cuenta = ?";

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

    public Long insertDeposito(Long idTransaccion, String cajero){
        Connection connection = ConexionBD.conectar();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_DEPOSITO, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, idTransaccion);
            preparedStatement.setString(2, cajero);
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            System.out.println(generatedKeys.next());
            Long idGenerado = generatedKeys.getLong(1);
            System.out.println("Deposito insertada con id: " + idGenerado);
            ConexionBD.cerrarConexion(connection);
            return idGenerado;
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionRepositorio2.class.getName()).log(Level.SEVERE, null, ex);
            ConexionBD.cerrarConexion(connection);
            throw new RuntimeException("Error al intentar insertar deposito");
        }
    }

    public Long insertPagoServicio(Long idTransaccion, Long idServicio){
        Connection connection = ConexionBD.conectar();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_PAGO_SERVICIO, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, idServicio);
            preparedStatement.setLong(2, idTransaccion);
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            System.out.println(generatedKeys.next());
            Long idGenerado = generatedKeys.getLong(1);
            System.out.println("Pago Servicio insertada con id: " + idGenerado);
            ConexionBD.cerrarConexion(connection);
            return idGenerado;
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionRepositorio2.class.getName()).log(Level.SEVERE, null, ex);
            ConexionBD.cerrarConexion(connection);
            throw new RuntimeException("Error al intentar insertar pago servicio");
        }
    }

    public Long insertPagoTarjeta(Long idTransaccion, Long idTarjetaCredito){
        Connection connection = ConexionBD.conectar();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_PAGO_TARJETA, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, idTarjetaCredito);
            preparedStatement.setLong(2, idTransaccion);
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            System.out.println(generatedKeys.next());
            Long idGenerado = generatedKeys.getLong(1);
            System.out.println("Pago Tarjeta insertada con id: " + idGenerado);
            ConexionBD.cerrarConexion(connection);
            return idGenerado;
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionRepositorio2.class.getName()).log(Level.SEVERE, null, ex);
            ConexionBD.cerrarConexion(connection);
            throw new RuntimeException("Error al intentar insertar pago tarjeta");
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

    public Long recuperarIdServicio(String servicio){
        Connection connection = ConexionBD.conectar();
        try {
            PreparedStatement statement = connection.prepareStatement(RECUPERAR_ID_SERVICIO);
            statement.setString(1, servicio);

            try (ResultSet resultSet = statement.executeQuery()) {
                if(resultSet.next()){
                    ConexionBD.cerrarConexion(connection);
                    return resultSet.getLong("id_servicio");
                }else{
                    ConexionBD.cerrarConexion(connection);
                    throw new RuntimeException("Servicio no encontrado con ese nombre: "+servicio);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionRepositorio2.class.getName()).log(Level.SEVERE, null, ex);
            ConexionBD.cerrarConexion(connection);
            throw new RuntimeException("Error al intentar recupeprar servicio con nombre "+ servicio);
        }
    }
    public Long recuperarIdTarjeta(Long numeroTarjetaCredito){
        Connection connection = ConexionBD.conectar();
        try {
            PreparedStatement statement = connection.prepareStatement(RECUPERAR_ID_TARJETA);
            statement.setLong(1, numeroTarjetaCredito);

            try (ResultSet resultSet = statement.executeQuery()) {
                if(resultSet.next()){
                    ConexionBD.cerrarConexion(connection);
                    return resultSet.getLong("id_tarjeta_credito");
                }else{
                    ConexionBD.cerrarConexion(connection);
                    throw new RuntimeException("Numero tarjeta no valida");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionRepositorio2.class.getName()).log(Level.SEVERE, null, ex);
            ConexionBD.cerrarConexion(connection);
            throw new RuntimeException("Error al intentar recuperar id_cuenta");
        }
    }

    public TarjetaDeCredito recuperarTarjetaCredito(Long numeroTarjetaCredito){
        Connection connection = ConexionBD.conectar();
        try {
            PreparedStatement statement = connection.prepareStatement(RECUPERAR_TARJETA_CREDITO);
            statement.setLong(1, numeroTarjetaCredito);

            ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()){
                    ConexionBD.cerrarConexion(connection);
                    return new TarjetaDeCredito(resultSet.getLong("id_tarjeta_credito"),
                            resultSet.getDouble("deuda"), resultSet.getDouble("linea"),
                            resultSet.getDate("fecha_vencimiento"), numeroTarjetaCredito);
                }else{
                    ConexionBD.cerrarConexion(connection);
                    throw new RuntimeException("Numero tarjeta no valida");
                }

        } catch (SQLException ex) {
            Logger.getLogger(TransaccionRepositorio2.class.getName()).log(Level.SEVERE, null, ex);
            ConexionBD.cerrarConexion(connection);
            throw new RuntimeException("Error al intentar recuperar tarjeta credito");
        }
    }

    public List<TarjetaDeCredito> recuperarTarjetasCredito(Long idCliente){
        Connection connection = ConexionBD.conectar();
        try {
            PreparedStatement statement = connection.prepareStatement(RECUPERAR_TARJETAS_CREDITO_CLIENTE);
            statement.setLong(1, idCliente);

            ResultSet resultSet = statement.executeQuery();
            List<TarjetaDeCredito> tarjetaDeCreditos = new ArrayList<>();
            while (resultSet.next()){
                tarjetaDeCreditos.add(new TarjetaDeCredito(resultSet.getLong("id_tarjeta_credito"), idCliente,
                        resultSet.getDouble("deuda"), resultSet.getDouble("linea"),
                        resultSet.getDate("fecha_vencimiento"), resultSet.getLong("nro_tarjeta")));
            }
            return tarjetaDeCreditos;
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionRepositorio2.class.getName()).log(Level.SEVERE, null, ex);
            ConexionBD.cerrarConexion(connection);
            throw new RuntimeException("Error al intentar recuperar tarjeta credito");
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
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontró una coincidencia para los datos proporcionados.", "Error", JOptionPane.ERROR_MESSAGE);
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
        
        public boolean verificarSaldoSuficiente(long cuenta, double monto) {
            Connection connection = ConexionBD.conectar();
            // Implementa la lógica para verificar si la cuenta de origen tiene saldo suficiente
           try{
                PreparedStatement statement = connection.prepareStatement(RECUPERAR_SALDO_CUENTA);
                statement.setLong(1, cuenta);

                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    double saldo = resultSet.getDouble("saldo");
                    return (saldo >= monto && monto>0);
                }
                return false;
            }catch (SQLException ex){
               Logger.getLogger(TransaccionRepositorio2.class.getName()).log(Level.SEVERE, null, ex);
               ConexionBD.cerrarConexion(connection);
               throw new RuntimeException("Error al intentar recuperar el saldo de la cuenta "+ cuenta);
            }
        }

        public void pagarTarjetaCredito(Double monto, Long idTarjetaCredito){
            Connection connection = ConexionBD.conectar();
            try {
                PreparedStatement statement = connection.prepareStatement(PAGAR_TARJETA);
                statement.setDouble(1, monto);
                statement.setLong(2, idTarjetaCredito);
                statement.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(TransaccionRepositorio2.class.getName()).log(Level.SEVERE, null, ex);
                ConexionBD.cerrarConexion(connection);
                throw new RuntimeException("Error al intentar actualizar la tarjeta_credito");
            }
        }

    public void aumentarDeuda(long numero_tarjeta, double monto) {
        System.out.println("aumentar numero_tarjeta: "+numero_tarjeta);
        System.out.println("aumentar monto: "+monto);
        Connection connection = ConexionBD.conectar();
        try{
            PreparedStatement statement = connection.prepareStatement(AUMENTAR_DEUDA_TARJETA);
            statement.setDouble(1, monto);
            statement.setLong(2, numero_tarjeta);
            statement.executeUpdate();

        }catch (SQLException ex){
            Logger.getLogger(TransaccionRepositorio2.class.getName()).log(Level.SEVERE, null, ex);
            ConexionBD.cerrarConexion(connection);
            throw new RuntimeException("Error al intentar aumentar la deuda de la tarjeta_credito "+ numero_tarjeta);
        }
    }

    public boolean verificarLimite(long numero_tarjeta, double monto){
        // Implementa la lógica para verificar si el pago supera el limite de la tarjeta
        Connection connection = ConexionBD.conectar();
        try {
            PreparedStatement statement = connection.prepareStatement(RECUPERAR_LINEA_DEUDA);
            statement.setLong(1, numero_tarjeta);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                double linea = resultSet.getDouble("linea");
                double deuda = resultSet.getDouble("deuda");
                return (linea >= deuda + monto && monto>0);
            }
            return false;
        }
        catch (SQLException ex) {
            Logger.getLogger(TransaccionRepositorio2.class.getName()).log(Level.SEVERE, null, ex);
            ConexionBD.cerrarConexion(connection);
            throw new RuntimeException("Error al intentar recuperar la linea y deduda de la tarjeta de credito");
        }
    }


        
    public List<Movimiento> obtenerMovimientosPorCuenta(long idCuenta) {
        Connection connection = ConexionBD.conectar();
        try {
            List<Movimiento> movimientos = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement(RECUPERAR_MOVIMIENTOS);
            statement.setLong(1, idCuenta);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                   Movimiento movimiento = new Movimiento(
                        resultSet.getLong("id_transaccion"),
                        resultSet.getDate("fecha"),
                        resultSet.getDouble("monto"),
                        resultSet.getString("tipo")
                   );
                   movimientos.add(movimiento);
            }
            return movimientos;

        }catch (SQLException ex){
            Logger.getLogger(TransaccionRepositorio2.class.getName()).log(Level.SEVERE, null, ex);
            ConexionBD.cerrarConexion(connection);
            throw new RuntimeException("Error al intentar recuperar los movimientos de la cuenta");
        }

}



        
}
