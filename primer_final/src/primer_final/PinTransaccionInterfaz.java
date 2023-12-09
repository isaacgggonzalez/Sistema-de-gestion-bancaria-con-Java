
package primer_final;

import controlador.ProcesosControlador;


/**
 * La clase PinTransaccionInterfaz representa la interfaz gráfica para validar un PIN de transacción.
 * Puede utilizarse para realizar transacciones financieras.
 */
public class PinTransaccionInterfaz extends javax.swing.JFrame {
    private long monto;
    private long cuentaDestino;
    private long cuentaOrigen;
    
    Cliente cliente;
    Cuenta cuenta;

    Transaccion transaccion;
    /**
     * Constructor que inicializa la interfaz con el cliente y la cuenta asociados.
     *
     * @param cliente El cliente asociado a la transacción.
     * @param cuenta  La cuenta asociada a la transacción.
     */
    public PinTransaccionInterfaz(Cliente cliente, Cuenta cuenta) {
        initComponents();
        this.setLocationRelativeTo(this); //Ubicar la interfaz en el centro
        this.cliente = cliente;
        this.cuenta = cuenta;
    }
    
    /**
     * Constructor que inicializa la interfaz con la transacción, cliente y cuenta asociados.
     *
     * @param transaccion La transacción asociada.
     * @param cliente     El cliente asociado a la transacción.
     * @param cuenta      La cuenta asociada a la transacción.
     */
    public PinTransaccionInterfaz(Transaccion transaccion, Cliente cliente, Cuenta cuenta) {
        initComponents();
        this.cliente = cliente;
        this.cuenta = cuenta;
        this.setLocationRelativeTo(this); //Ubicar la interfaz en el centro
        this.transaccion = transaccion;
    }

    /**
     * Constructor por defecto que inicializa la interfaz sin parámetros.
     */
    public PinTransaccionInterfaz() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        texto_pinIncorrecto = new java.awt.Label();
        Pin1 = new java.awt.Label();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        boton_salir = new java.awt.Button();
        boton_aceptar = new java.awt.Button();
        box_pin = new javax.swing.JPasswordField();
        ojo_clave = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane1.setForeground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/perfil-del-usuario 150x150.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        texto_pinIncorrecto.setAlignment(java.awt.Label.CENTER);
        texto_pinIncorrecto.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        texto_pinIncorrecto.setForeground(new java.awt.Color(204, 0, 0));

        Pin1.setAlignment(java.awt.Label.CENTER);
        Pin1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Pin1.setText("Pin");

        jLayeredPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boton_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        boton_salir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boton_salir.setLabel("Salir");
        boton_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_salirActionPerformed(evt);
            }
        });

        boton_aceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        boton_aceptar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boton_aceptar.setLabel("Aceptar");
        boton_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_aceptarActionPerformed(evt);
            }
        });

        box_pin.setBackground(new java.awt.Color(255, 255, 255));
        box_pin.setForeground(new java.awt.Color(0, 0, 0));
        box_pin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_pinActionPerformed(evt);
            }
        });
        box_pin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                box_pinKeyTyped(evt);
            }
        });

        ojo_clave.setBackground(new java.awt.Color(255, 255, 255));
        ojo_clave.setForeground(new java.awt.Color(255, 255, 255));
        ojo_clave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_cerrarOjo.png"))); // NOI18N
        ojo_clave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ojo_clave.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ojo_clave.setMaximumSize(new java.awt.Dimension(22, 22));
        ojo_clave.setMinimumSize(new java.awt.Dimension(22, 22));
        ojo_clave.setPreferredSize(new java.awt.Dimension(22, 22));
        ojo_clave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ojo_claveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(texto_pinIncorrecto, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                            .addComponent(Pin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(194, 194, 194)
                                        .addComponent(ojo_clave, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(box_pin, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(boton_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(boton_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addGap(20, 20, 20)
                        .addComponent(Pin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texto_pinIncorrecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(ojo_clave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(box_pin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(jLayeredPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean claveVisible = false;
    private static boolean validarPin= false;
    /**
     * Cambia la visibilidad de la contraseña al hacer clic en el ojo.
     *
     * @param evt Evento de clic del mouse.
     */
    private void ojo_claveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ojo_claveMouseClicked
        // Cambiar la visibilidad de la contraseña
        if (claveVisible) {
            box_pin.setEchoChar('*'); // Si es visible, ocultar
            ojo_clave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_cerrarOjo.png")));
        } else {
            box_pin.setEchoChar((char) 0); // Si está oculta, hacer visible
            ojo_clave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_ojo.png")));
        }

        claveVisible = !claveVisible; // Invertir el estado
    }//GEN-LAST:event_ojo_claveMouseClicked
    /**
     * Maneja la acción cuando se selecciona una opción en el cuadro de texto de PIN.
     *
     * @param evt Evento de acción.
     */
    private void box_pinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_pinActionPerformed
        // Que se visualize la contraseña
        char echoChar = claveVisible ? '\u0000' : '*';
        box_pin.setEchoChar(echoChar);
    }//GEN-LAST:event_box_pinActionPerformed
    /**
     * Maneja la acción de salir.
     *
     * @param evt Evento de acción.
     */
    private void boton_salirActionPerformed(java.awt.event.ActionEvent evt){
         
    }
    /**
     * Maneja la acción de tecla escrita en el cuadro de texto de PIN.
     *
     * @param evt Evento de tecla.
     */
    private void box_pinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_box_pinKeyTyped
        // Que se visualize la contraseña
        char echoChar = claveVisible ? '\u0000' : '*';
        box_pin.setEchoChar(echoChar);
    }//GEN-LAST:event_box_pinKeyTyped
    /**
     * Maneja la acción cuando se hace clic en el botón de aceptar.
     *
     * @param evt Evento de acción.
     */
    private void boton_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_aceptarActionPerformed
        try{
        texto_pinIncorrecto.setText("");
        //trim sirve para eliminar espacio en blanco
        int cedula = cliente.getCiCliente();
        long numeroCuenta = cuenta.getNumeroCuenta();
        String claveTexto = box_pin.getText().trim();
        int clave = Integer.parseInt(claveTexto);
        
        // Validar que los campos no estén vacíos
        if (claveTexto.isEmpty()) {
            texto_pinIncorrecto.setText("El Pin no puede estar vacío.");
        } else {
            texto_pinIncorrecto.setText(""); // No debe mostrar el mensaje de error si no hay error
        }
        ValidarPinTransaccion validarPinTransaccion = new ValidarPinTransaccion(clave);
        Thread hiloValidarPin = new Thread(validarPinTransaccion);
        hiloValidarPin.start();
        hiloValidarPin.join();
        if(validarPinTransaccion.esPinValido()){
            Thread hiloTransaccion = new Thread (transaccion);
            hiloTransaccion.start();
            hiloTransaccion.join();

            ComprobanteInterfaz comprobante = new ComprobanteInterfaz(cliente, cuenta, transaccion);
            comprobante.setVisible(true);
            dispose();
        }else{
            texto_pinIncorrecto.setText("PIN INCORRECTO!");
        }}catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
   
        
    }//GEN-LAST:event_boton_aceptarActionPerformed
    /**
     * Maneja la validación del PIN, estableciendo los valores del monto y las cuentas.
     *
     * @param montoLong       El monto de la transacción.
     * @param cuenta_Destino  La cuenta de destino.
     * @param cuenta_origen   La cuenta de origen.
     */
    public void manejarValidacionPin(long montoLong,long cuenta_Destino,long cuenta_origen) {
        monto=montoLong;
        cuentaDestino=cuenta_Destino;
        cuentaOrigen=cuenta_origen;
    }
    /**
     * Obtiene el monto de la transacción.
     *
     * @return El monto de la transacción.
     */
    public long montoLong(){
        return monto;
    }
    /**
     * Obtiene la cuenta de destino.
     *
     * @return La cuenta de destino.
     */
    public long cuenta_Destino(){
        return cuentaDestino;
    }
    /**
     * Obtiene la cuenta de origen.
     *
     * @return La cuenta de origen.
     */
    public long cuenta_origen(){
        return cuentaOrigen;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PinTransaccionInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PinTransaccionInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PinTransaccionInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PinTransaccionInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PinTransaccionInterfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label Pin1;
    private java.awt.Button boton_aceptar;
    private java.awt.Button boton_salir;
    private javax.swing.JPasswordField box_pin;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel ojo_clave;
    private java.awt.Label texto_pinIncorrecto;
    // End of variables declaration//GEN-END:variables
}
