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

/**
 * Clase que maneja las operaciones de acceso a la base de datos relacionadas con las transacciones.
 */
public class TransaccionRepositorio2 {
        /**
        * Consulta SQL para insertar una transacción en la tabla 'transaccion'.
        * Se espera que los parámetros de la transacción sean tipo, fecha y monto.
        */
        private static final String INSERTAR_TRANSACCION = "INSERT INTO "
               + "transaccion(tipo, fecha, monto) VALUES (?, ?, ?)";
        /**
         * Consulta SQL para insertar un movimiento en la tabla 'movimiento'.
         * Se espera que los parámetros del movimiento sean el ID de la transacción y el ID de la cuenta.
         */
        private static final String INSERTAR_MOVIMIENTO = "INSERT INTO "
                + "movimiento(id_transaccion, id_cuenta) VALUES (?, ?)";
        /**
         * Consulta SQL para actualizar el saldo de una cuenta.
         * Se espera que los parámetros sean el monto y el ID de la cuenta.
         */
        private static final String ACTUALIZAR_SALDO = "UPDATE cuenta SET saldo = saldo + ? WHERE id_cuenta = ?";
        /**
         * Consulta SQL para realizar el pago de una tarjeta de crédito.
         * Se espera que los parámetros sean la reducción de deuda y el ID de la tarjeta de crédito.
         */
        private static final String PAGAR_TARJETA = "UPDATE tarjeta_credito SET deuda = deuda-?  WHERE id_tarjeta_credito = ?";
        /**
         * Consulta SQL para aumentar la deuda de una tarjeta de crédito.
         * Se espera que los parámetros sean el aumento de deuda y el número de tarjeta.
         */
        private static final String AUMENTAR_DEUDA_TARJETA = "UPDATE tarjeta_credito SET deuda = deuda+?  WHERE nro_tarjeta = ?";
        /**
        * Consulta SQL para recuperar el ID de una cuenta basado en el número de cuenta.
        * Se espera que el parámetro sea el número de cuenta.
        */
        private static final String RECUPERAR_ID_CUENTA = "SELECT id_cuenta FROM cuenta WHERE numero_cuenta = ?";
        /**
         * Consulta SQL para insertar una transferencia en la tabla 'transferencia'.
         * Se espera que los parámetros sean el ID de la transacción, el ID de la cuenta destino y el ID de la cuenta origen.
         */
        private static final String INSERTAR_TRANSFERENCIA = "INSERT INTO "
                + "transferencia(id_transaccion, id_cuenta_destino, id_cuenta_origen) VALUES(?, ?, ?)";
        /**
         * Consulta SQL para validar un PIN de transacción.
         * Se espera que el parámetro sea el PIN de transacción.
         */
        private static final String VALIDAR_PIN_TRANASCCION = "SELECT 1 FROM cuenta WHERE pin_transaccion = ?";
        /**
         * Consulta SQL para insertar un depósito en la tabla 'deposito'.
         * Se espera que los parámetros sean el ID de la transacción y el cajero.
         */
        private static final String INSERTAR_DEPOSITO = "INSERT INTO deposito(id_transaccion, cajero) VALUES (?,?)";
        /**
         * Consulta SQL para insertar un pago de servicio en la tabla 'pago_servicio'.
         * Se espera que los parámetros sean el ID del servicio y el ID de la transacción.
         */
        private static final String INSERTAR_PAGO_SERVICIO = "INSERT INTO pago_servicio(id_servicio, id_transaccion) VALUES(?, ?)";
        /**
         * Consulta SQL para recuperar el ID de un servicio basado en el nombre del servicio.
         * Se espera que el parámetro sea el nombre del servicio.
         */
        private static final String RECUPERAR_ID_SERVICIO = "SELECT id_servicio FROM servicio WHERE nombre = ?";
        /**
        * Consulta SQL para insertar un pago de tarjeta en la tabla 'pago_tarjeta'.
        * Se espera que los parámetros sean el ID de la tarjeta de crédito y el ID de la transacción.
        */
        private static final String INSERTAR_PAGO_TARJETA = "INSERT INTO pago_tarjeta(id_tarjeta_credito, id_transaccion) VALUES(?, ?)";
        /**
        * Consulta SQL para recuperar el ID de una tarjeta de crédito basado en el número de tarjeta.
        * Se espera que el parámetro sea el número de tarjeta.
        */
        private static final String RECUPERAR_ID_TARJETA = "SELECT id_tarjeta_credito FROM tarjeta_credito WHERE nro_tarjeta = ?";
        /**
        * Consulta SQL para recuperar información de una tarjeta de crédito basado en el número de tarjeta.
        * Se espera que el parámetro sea el número de tarjeta.
        */
        private static final String RECUPERAR_TARJETA_CREDITO = "SELECT id_tarjeta_credito, linea, deuda, fecha_vencimiento, nro_tarjeta FROM tarjeta_credito WHERE nro_tarjeta = ?";
        /**
         * Consulta SQL para recuperar tarjetas de crédito de un cliente basado en el ID del cliente.
         * Se espera que el parámetro sea el ID del cliente.
         */
        private static final String RECUPERAR_TARJETAS_CREDITO_CLIENTE = "SELECT id_tarjeta_credito, linea, deuda, fecha_vencimiento, nro_tarjeta FROM tarjeta_credito WHERE id_cliente = ?";
        /**
        * Consulta SQL para recuperar la línea y deuda de una tarjeta de crédito basado en el número de tarjeta.
        * Se espera que el parámetro sea el número de tarjeta.
        */
        private static final String RECUPERAR_LINEA_DEUDA = "SELECT linea, deuda FROM tarjeta_credito WHERE nro_tarjeta = ?";
        /**
        * Consulta SQL para recuperar el saldo de una cuenta basado en el número de cuenta.
        * Se espera que el parámetro sea el número de cuenta.
        */
        private static final String RECUPERAR_SALDO_CUENTA = "SELECT saldo FROM cuenta WHERE numero_cuenta = ?";
        /**
         * Consulta SQL para recuperar movimientos de una cuenta basado en el ID de la cuenta.
         * Se espera que el parámetro sea el ID de la cuenta.
         */
        private static final String RECUPERAR_MOVIMIENTOS = "SELECT t.id_transaccion, t.tipo, t.fecha, t.monto " +
                "FROM transaccion t " +
                "JOIN movimiento m ON t.id_transaccion = m.id_transaccion " +
                "WHERE m.id_cuenta = ?";
        
        /**
        * Constructor por defecto de la clase TransaccionRepositorio2.
        */     
        public TransaccionRepositorio2(){}
       /**
        * Inserta una transacción en la base de datos y devuelve el ID generado para la transacción.
        *
        * @param transaccion La transacción que se va a insertar.
        * @return El ID generado para la transacción.
        * @throws RuntimeException Si ocurre un error al intentar insertar la transacción.
        */
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
    /**
     * Inserta un movimiento en la base de datos y devuelve el ID generado para el movimiento.
     *
     * @param idCuenta      El ID de la cuenta asociada al movimiento.
     * @param idTransaccion El ID de la transacción asociada al movimiento.
     * @return El ID generado para el movimiento.
     * @throws RuntimeException Si ocurre un error al intentar insertar el movimiento.
     */
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
    /**
     * Inserta una transferencia en la base de datos y devuelve el ID generado para la transferencia.
     *
     * @param idTransaccion   El ID de la transacción asociada a la transferencia.
     * @param idCuentaOrigen  El ID de la cuenta de origen de la transferencia.
     * @param idCuentaDestino El ID de la cuenta de destino de la transferencia.
     * @return El ID generado para la transferencia.
     * @throws RuntimeException Si ocurre un error al intentar insertar la transferencia.
     */
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
    /**
     * Inserta un depósito en la base de datos y devuelve el ID generado para el depósito.
     *
     * @param idTransaccion El ID de la transacción asociada al depósito.
     * @param cajero        El nombre del cajero asociado al depósito.
     * @return El ID generado para el depósito.
     * @throws RuntimeException Si ocurre un error al intentar insertar el depósito.
     */
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

    /**
    * Inserta un registro de pago de servicio en la base de datos y devuelve el ID generado para el pago de servicio.
    *
    * @param idTransaccion El ID de la transacción asociada al pago de servicio.
    * @param idServicio    El ID del servicio asociado al pago.
    * @return El ID generado para el pago de servicio.
    * @throws RuntimeException Si ocurre un error al intentar insertar el pago de servicio.
    */
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
    
    /**
    * Inserta un registro de pago de tarjeta en la base de datos y devuelve el ID generado para el pago de tarjeta.
    *
    * @param idTransaccion      El ID de la transacción asociada al pago de tarjeta.
    * @param idTarjetaCredito   El ID de la tarjeta de crédito asociada al pago.
    * @return El ID generado para el pago de tarjeta.
    * @throws RuntimeException Si ocurre un error al intentar insertar el pago de tarjeta.
    */
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
        /**
         * Recupera el ID de una cuenta asociada a un número de cuenta específico.
         *
         * @param numeroCuenta El número de cuenta para el cual se quiere recuperar el ID.
         * @return El ID de la cuenta asociada al número de cuenta.
         * @throws RuntimeException Si no se encuentra una cuenta asociada al número proporcionado.
         */
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
    /**
     * Recupera el ID de un servicio asociado a un nombre específico.
     *
     * @param servicio El nombre del servicio para el cual se quiere recuperar el ID.
     * @return El ID del servicio asociado al nombre proporcionado.
     * @throws RuntimeException Si no se encuentra un servicio con el nombre proporcionado.
     */
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
    /**
    * Recupera el ID de una tarjeta de crédito asociada a un número de tarjeta específico.
    *
    * @param numeroTarjetaCredito El número de tarjeta de crédito para el cual se quiere recuperar el ID.
    * @return El ID de la tarjeta de crédito asociada al número de tarjeta proporcionado.
    * @throws RuntimeException Si no se encuentra una tarjeta de crédito asociada al número proporcionado.
    */
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
    /**
     * Recupera una tarjeta de crédito asociada a un número de tarjeta específico.
     *
     * @param numeroTarjetaCredito El número de tarjeta de crédito para el cual se quiere recuperar la tarjeta.
     * @return Una instancia de TarjetaDeCredito que contiene la información asociada a la tarjeta de crédito.
     * @throws RuntimeException Si no se encuentra una tarjeta de crédito asociada al número proporcionado.
     */
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
    /**
     * Recupera una lista de tarjetas de crédito asociadas a un ID de cliente específico.
     *
     * @param idCliente El ID del cliente para el cual se quieren recuperar las tarjetas de crédito.
     * @return Una lista de instancias de TarjetaDeCredito asociadas al cliente.
     * @throws RuntimeException Si ocurre un error al intentar recuperar las tarjetas de crédito.
     */
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
    /**
     * Valida el PIN de transacción en la base de datos.
     *
     * @param pinTransaccion El PIN de transacción a validar.
     * @return true si el PIN es válido, false de lo contrario.
     * @throws RuntimeException Si ocurre un error al intentar validar el PIN de transacción.
     */
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
       /**
        * Confirma la existencia de datos en la base de datos para realizar una transferencia.
        *
        * @param destinoTransferencia El número de cuenta destino para la transferencia.
        * @param cedula              La cédula del destinatario.
        * @param nombreDestinatario  El nombre del destinatario.
        * @return true si los datos son confirmados, false de lo contrario.
        * @throws RuntimeException Si ocurre un error al intentar confirmar los datos.
        */
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
        /**
         * Actualiza el saldo de una cuenta en la base de datos.
         *
         * @param idCuenta El ID de la cuenta cuyo saldo se va a actualizar.
         * @param monto    El monto que se va a agregar al saldo de la cuenta.
         * @throws RuntimeException Si ocurre un error al intentar actualizar el saldo de la cuenta.
         */
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
        /**
        * Verifica si una cuenta tiene saldo suficiente para realizar una transacción.
        *
        * @param cuenta El número de cuenta para la cual se quiere verificar el saldo.
        * @param monto  El monto de la transacción que se quiere realizar.
        * @return true si la cuenta tiene saldo suficiente, false de lo contrario.
        * @throws RuntimeException Si ocurre un error al intentar verificar el saldo de la cuenta.
        */
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
        /**
         * Realiza el pago de una tarjeta de crédito actualizando la deuda en la base de datos.
         *
         * @param monto            El monto que se va a pagar a la tarjeta de crédito.
         * @param idTarjetaCredito El ID de la tarjeta de crédito a la que se va a realizar el pago.
         * @throws RuntimeException Si ocurre un error al intentar realizar el pago a la tarjeta de crédito.
         */
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
    /**
     * Aumenta la deuda de una tarjeta de crédito en la base de datos.
     *
     * @param numeroTarjeta El número de tarjeta de crédito para el cual se va a aumentar la deuda.
     * @param monto         El monto que se va a agregar a la deuda de la tarjeta de crédito.
     * @throws RuntimeException Si ocurre un error al intentar aumentar la deuda de la tarjeta de crédito.
     */
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
    /**
     * Verifica si un pago supera el límite de una tarjeta de crédito.
     *
     * @param numeroTarjeta El número de tarjeta de crédito para el cual se quiere verificar el límite.
     * @param monto         El monto del pago que se quiere verificar.
     * @return true si el pago no supera el límite, false de lo contrario.
     * @throws RuntimeException Si ocurre un error al intentar verificar el límite de la tarjeta de crédito.
     */
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


    /**
    * Obtiene una lista de movimientos asociados a una cuenta.
    *
    * @param idCuenta El ID de la cuenta para la cual se quieren recuperar los movimientos.
    * @return Una lista de instancias de Movimiento asociadas a la cuenta.
    * @throws RuntimeException Si ocurre un error al intentar recuperar los movimientos de la cuenta.
    */
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
