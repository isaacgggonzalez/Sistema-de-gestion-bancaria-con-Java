package interfaz;

import modelo.Cliente;
import modelo.Cuenta;
import modelo.Transaccion;

import java.text.SimpleDateFormat;

/**
 * Interfaz para mostrar un comprobante de transacción.
 * Esta interfaz se utiliza para mostrar información detallada sobre una transacción, incluyendo detalles del cliente,
 * información de la cuenta y detalles específicos de la transacción.
 */
public class ComprobanteInterfaz extends javax.swing.JFrame {
    /**
     * Cliente asociado a la transacción.
     */
    Cliente cliente;
    /**
     * Cuenta asociada a la transacción.
     */
    Cuenta cuenta;
    /**
     * Transacción para la cual se genera el comprobante.
     */
    Transaccion transaccion;
    /**
     * Crea una nueva instancia de la interfaz ComprobanteInterfaz sin parámetros.
     * Esta instancia se utiliza cuando no hay información específica para mostrar en el comprobante.
     */
    public ComprobanteInterfaz() {
        initComponents();
    }
    /**
     * Crea una nueva instancia de la interfaz ComprobanteInterfaz con información específica.
     *
     * @param cliente     Cliente asociado a la transacción.
     * @param cuenta      Cuenta asociada a la transacción.
     * @param transaccion Transacción para la cual se genera el comprobante.
     */
    public ComprobanteInterfaz(Cliente cliente, Cuenta cuenta, Transaccion transaccion) {
        this.cliente = cliente;
        this.cuenta = cuenta;
        this.transaccion = transaccion;
        initComponents();
        this.setLocationRelativeTo(this); //Ubicar la interfaz en el centro

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
        transaccion_texto = new java.awt.Label();
        texto_fecha5 = new java.awt.Label();
        texto_fecha6 = new java.awt.Label();
        monto_texto = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        texto_fecha1 = new java.awt.Label();
        texto_fecha2 = new java.awt.Label();
        label2 = new java.awt.Label();
        texto_fecha4 = new java.awt.Label();
        cliente_texto = new java.awt.Label();
        fecha_texto = new java.awt.Label();
        descripcion_texto = new java.awt.Label();
        label1 = new java.awt.Label();
        boton_salir = new java.awt.Button();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(196, 196, 196));

        jDesktopPane1.setBackground(new java.awt.Color(196, 196, 196));
        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        transaccion_texto.setAlignment(java.awt.Label.CENTER);
        transaccion_texto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        transaccion_texto.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        transaccion_texto.setText("Pago Internet");

        texto_fecha5.setAlignment(java.awt.Label.CENTER);
        texto_fecha5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        texto_fecha5.setText("Monto Transaccion");

        texto_fecha6.setAlignment(java.awt.Label.CENTER);
        texto_fecha6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        texto_fecha6.setText("Servicio");

        monto_texto.setAlignment(java.awt.Label.CENTER);
        monto_texto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        monto_texto.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        monto_texto.setText("xxxxxxx Gs");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(transaccion_texto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(texto_fecha5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(monto_texto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(texto_fecha6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(texto_fecha6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transaccion_texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto_fecha5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monto_texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(217, 217, 217));

        texto_fecha1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        texto_fecha1.setText("Descripción:");

        texto_fecha2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        texto_fecha2.setText("Cliente:");

        label2.setAlignment(java.awt.Label.CENTER);
        label2.setBackground(new java.awt.Color(102, 102, 102));
        label2.setMinimumSize(new java.awt.Dimension(10, 425));
        label2.setName(""); // NOI18N
        label2.setPreferredSize(new java.awt.Dimension(10, 20));

        texto_fecha4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        texto_fecha4.setText("Fecha:");

        cliente_texto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cliente_texto.setText("DD/MM/AAAA");

        fecha_texto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        fecha_texto.setText("DD/MM/AAAA");

        descripcion_texto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        descripcion_texto.setText("Tarjeta terminada en 0425");

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(102, 102, 102));
        label1.setMinimumSize(new java.awt.Dimension(5, 425));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_fecha4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fecha_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(241, 241, 241)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cliente_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descripcion_texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(250, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_fecha4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha_texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cliente_texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto_fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(descripcion_texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );

        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jDesktopPane1.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 31, 820, 440));

        boton_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_salir.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        boton_salir.setLabel("Salir");
        boton_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_salirActionPerformed(evt);
            }
        });
        jDesktopPane1.add(boton_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, 160, 50));

        jPanel3.setBackground(new java.awt.Color(192, 192, 192));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 883, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );

        jDesktopPane1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        String formato = "dd/MM/yyyy";  // Puedes ajustar el formato segÃºn tus necesidades
        // Crear un objeto SimpleDateFormat con el formato
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        fecha_texto.setText(sdf.format(transaccion.get_fecha_transaccion()));
        transaccion_texto.setText(transaccion.getTipoTransaccion());
        cliente_texto.setText(cliente.getNombreCliente()+" "+ cliente.getApellidoCliente());
        descripcion_texto.setText(transaccion.mensajeConfirmacion());
        monto_texto.setText(String.valueOf(transaccion.getMontoTransaccion()));
        
        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cierra la interfaz actual y abre la interfaz principal de la aplicación.
     * La interfaz principal es la BaseInterfaz, y se activa el menú de transferencia en esa interfaz.
     *
     * @param evt Evento de acción que desencadena el método.
     */
    private void boton_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_salirActionPerformed
        BaseInterfaz ventanaSecundaria = new BaseInterfaz(cliente,cuenta);
        ventanaSecundaria.setVisible(true);
        ventanaSecundaria.activarMenuTransferencia();
        this.dispose();
    }//GEN-LAST:event_boton_salirActionPerformed

    /**
    * Método principal que inicia la aplicación y muestra la interfaz de comprobante.
    *
    * @param args Los argumentos de la línea de comandos, no se utilizan en este caso.
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
            java.util.logging.Logger.getLogger(ComprobanteInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComprobanteInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComprobanteInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComprobanteInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComprobanteInterfaz().setVisible(true);
            }
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button boton_salir;
    public java.awt.Label cliente_texto;
    public java.awt.Label descripcion_texto;
    public java.awt.Label fecha_texto;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private java.awt.Label label1;
    private java.awt.Label label2;
    public java.awt.Label monto_texto;
    private java.awt.Label texto_fecha1;
    private java.awt.Label texto_fecha2;
    private java.awt.Label texto_fecha4;
    private java.awt.Label texto_fecha5;
    private java.awt.Label texto_fecha6;
    public java.awt.Label transaccion_texto;
    // End of variables declaration//GEN-END:variables
}