package interfaz;


import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DebugGraphics;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import controlador.ProcesosControlador;
import java.awt.Desktop;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URI;

import modelo.*;
import modelo.exceptions.SaldoInsuficienteException;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import javax.swing.JOptionPane;

import javax.swing.Timer;
/**
 * Clase que representa la interfaz principal de la aplicación.
 * Esta clase extiende javax.swing.JFrame y proporciona la interfaz gráfica para la interacción del usuario.
 * La interfaz incluye diversos elementos como botones, campos de texto y paneles para realizar operaciones bancarias.
 **/
public class BaseInterfaz extends javax.swing.JFrame {
    private static boolean validarPin = false;

    /**
     * Creates new form BaseInterfaz
     */
    Cliente cliente;
    Cuenta cuenta;
    
     /**
     * Constructor de la clase BaseInterfaz que inicializa la interfaz y configura
     * la ubicación en el centro. También inicia un temporizador para actualizar la hora.
     *
     * @param cliente Objeto Cliente asociado a la interfaz.
     * @param cuenta Objeto Cuenta asociado a la interfaz.
     */
    public BaseInterfaz(Cliente cliente,Cuenta cuenta) {
        initComponents();
        this.setLocationRelativeTo(this); //Ubicar la interfaz en el centro
        this.cliente=cliente;
        this.cuenta=cuenta;
        
        // Crea un Timer que ejecutará la tarea cada segundo
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llama a la función para actualizar la hora
                actualizarHora();
            }
        });

        // Inicia el Timer
        timer.start();
        
    }
    
    /**
     * Muestra los integrantes en la interfaz.
     */
    private void mostrarIntegrantes() {
        integrante1.setVisible(true);
        integrante2.setVisible(true);
        integrante3.setVisible(true);
        integrante4.setVisible(true);
    }
    /**
     * Muestra el número del grupo en la interfaz.
     */
    public void mostrarGrupo(){
        numeroGrupo.setText("Grupo N°11");
    }
    
    /**
     * Abre un enlace externo a través del navegador web predeterminado.
     */
    private void abrirEnlace() {
        try {
            // Ruta relativa al archivo HTML local
            String rutaArchivoHTML = "dist\\javadoc\\index.html";

            // Crear un objeto File con la ruta del archivo
            File archivoHTML = new File(rutaArchivoHTML);

            // Verificar si el archivo existe antes de intentar abrirlo
            if (archivoHTML.exists()) {
                // Convertir la ruta a un URI utilizando el esquema "file"
                URI uri = archivoHTML.toURI();

                // Utilizar Desktop para abrir el archivo en el navegador predeterminado
                Desktop.getDesktop().browse(uri);
            } else {
                System.out.println("El archivo no existe: " + rutaArchivoHTML);
            }
        } catch (Exception e) {
            // Manejar la excepción, por ejemplo, mostrar un mensaje de error
            e.printStackTrace();
        }
    }
    
    
    
    /**
     * Ejecuta hilos para realizar operaciones específicas en subprocesos separados.
     */
    public void run(){
        try {
        Thread hiloMostrarIntegrantes = new Thread(this::mostrarIntegrantes);
        Thread hiloMostrarGrupo = new Thread(this::mostrarGrupo);
        Thread hiloAbrirEnlace = new Thread(this::abrirEnlace);
        hiloMostrarIntegrantes.start();
        hiloMostrarIntegrantes.join();
        hiloMostrarGrupo.start();
        hiloAbrirEnlace.start();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new JDesktopPane();
        InterfazPrincipal = new JLayeredPane();
        jLayeredPane1 = new JLayeredPane();
        texto_fecha = new JLabel();
        texto_usuario = new JLabel();
        logo = new JLabel();
        jTabbedPane1 = new JTabbedPane();
        jPanel1 = new JPanel();
        botonesMenu = new JLayeredPane();
        boton_pagarTarjeta = new Button();
        boton_deposito = new Button();
        boton_pagarServicio = new Button();
        boton_consultarSaldo = new Button();
        boton_acercaSistema = new Button();
        boton_transferenciaCuenta = new Button();
        boton_cerrarSesion = new Button();
        separador = new JLayeredPane();
        label1 = new Label();
        menu_interaccion = new JLayeredPane();
        menu_transferencia = new Panel();
        boton_cancelarTransferencia = new Button();
        boton_confirmarTransaccion1 = new Button();
        cuentaDestino = new JTextField();
        label8 = new Label();
        cedula = new JTextField();
        label9 = new Label();
        nombre_destinatario = new JTextField();
        label10 = new Label();
        monto = new JTextField();
        label11 = new Label();
        label12 = new Label();
        saldo = new JTextField();
        numero_origen = new JTextField();
        label13 = new Label();
        menu_consultarSaldo = new Panel();
        label2 = new Label();
        saldo1 = new JTextField();
        label7 = new Label();
        jScrollPane1 = new JScrollPane();
        TablaConsulta = new JTable();
        menu_deposito = new Panel();
        boton_cancelarDeposito = new Button();
        boton_confirmarDeposito = new Button();
        montoDeposito = new JTextField();
        label17 = new Label();
        saldoDeposito = new JTextField();
        label19 = new Label();
        menu_pagarTarjeta = new Panel();
        boton_cancelarPagoTarjeta = new Button();
        boton_confirmarTransaccion6 = new Button();
        label34 = new Label();
        montoTarjeta = new JTextField();
        label37 = new Label();
        label38 = new Label();
        saldoTarjeta = new JTextField();
        numeroTarjeta = new JTextField();
        label39 = new Label();
        deudatotalTarjeta = new JTextField();
        label40 = new Label();
        label41 = new Label();
        deudalimiteTarjeta = new JTextField();
        list1 = new List();
        seleccionarTarjeta = new JComboBox<>();
        menu_acercaSistema = new Panel();
        label48 = new Label();
        numeroGrupo = new Label();
        label54 = new Label();
        label55 = new Label();
        label56 = new Label();
        botonDocumentacion = new Button();
        integrante1 = new Label();
        integrante2 = new Label();
        integrante3 = new Label();
        integrante4 = new Label();
        menu_pagarServicio = new Panel();
        boton_cancelarTransaccion7 = new Button();
        confirmar_pago_serv = new Button();
        label35 = new Label();
        nro_servicio = new JTextField();
        label42 = new Label();
        monto_ingresado = new JTextField();
        label43 = new Label();
        label44 = new Label();
        saldo_pago_serv = new JTextField();
        cuenta_origen_pago_serv = new JTextField();
        label45 = new Label();
        servicio_a_pagar = new JComboBox<>();
        metodo_de_pago = new JComboBox<>();
        label36 = new Label();
        monto_definido = new JTextField();
        label46 = new Label();
        saldoTarjetaServicio = new JTextField();
        textSaldoTarjeta = new Label();
        fondo1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1020, 660));
        setResizable(false);

        jDesktopPane1.setMaximumSize(new Dimension(1020, 660));
        jDesktopPane1.setMinimumSize(new Dimension(1020, 660));
        jDesktopPane1.setPreferredSize(new Dimension(1020, 660));
        jDesktopPane1.setLayout(new AbsoluteLayout());

        InterfazPrincipal.setEnabled(false);
        InterfazPrincipal.setMaximumSize(new Dimension(1020, 640));
        InterfazPrincipal.setMinimumSize(new Dimension(1020, 640));

        jLayeredPane1.setEnabled(false);
        jLayeredPane1.setMaximumSize(new Dimension(1020, 640));
        jLayeredPane1.setMinimumSize(new Dimension(1020, 640));

        texto_fecha.setFont(new Font("Arial", 1, 28)); // NOI18N
        texto_fecha.setForeground(new Color(255, 255, 255));
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = formatoFecha.format(fechaActual);
        texto_fecha.setText(fechaFormateada);

        texto_usuario.setFont(new Font("Arial", 1, 48)); // NOI18N
        texto_usuario.setForeground(new Color(255, 255, 255));
        texto_usuario.setText("Bienvenido, usuario!");

        logo.setIcon(new ImageIcon(getClass().getResource("/imagenes/Logo 350x350.png"))); // NOI18N

        jTabbedPane1.setForeground(new Color(255, 255, 255));
        jTabbedPane1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setFont(new Font("Arial", 1, 12)); // NOI18N
        jTabbedPane1.setVerifyInputWhenFocusTarget(false);

        jPanel1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setEnabled(false);
        jPanel1.setPreferredSize(new Dimension(1020, 500));

        botonesMenu.setEnabled(false);

        boton_pagarTarjeta.setActionCommand("pagarTarjeta");
        boton_pagarTarjeta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_pagarTarjeta.setFont(new Font("Arial", 0, 18)); // NOI18N
        boton_pagarTarjeta.setLabel("Pagar Tarjeta");
        boton_pagarTarjeta.setMinimumSize(new Dimension(245, 35));
        boton_pagarTarjeta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boton_pagarTarjetaActionPerformed(evt);
            }
        });

        boton_deposito.setActionCommand("deposito");
        boton_deposito.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_deposito.setFont(new Font("Arial", 0, 18)); // NOI18N
        boton_deposito.setLabel("Deposito");
        boton_deposito.setMinimumSize(new Dimension(245, 35));
        boton_deposito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boton_depositoActionPerformed(evt);
            }
        });

        boton_pagarServicio.setActionCommand("pagarServicio");
        boton_pagarServicio.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_pagarServicio.setFont(new Font("Arial", 0, 18)); // NOI18N
        boton_pagarServicio.setLabel("Pagar Servicio");
        boton_pagarServicio.setMinimumSize(new Dimension(245, 35));
        boton_pagarServicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boton_pagarServicioActionPerformed(evt);
            }
        });

        boton_consultarSaldo.setActionCommand("consultarSaldo");
        boton_consultarSaldo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_consultarSaldo.setFont(new Font("Arial", 0, 18)); // NOI18N
        boton_consultarSaldo.setLabel("Consultar Saldo");
        boton_consultarSaldo.setMinimumSize(new Dimension(245, 35));
        boton_consultarSaldo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boton_consultarSaldoActionPerformed(evt);
            }
        });

        boton_acercaSistema.setActionCommand("acercaSistema");
        boton_acercaSistema.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_acercaSistema.setFont(new Font("Arial", 0, 18)); // NOI18N
        boton_acercaSistema.setLabel("Acerca del Sistema");
        boton_acercaSistema.setMinimumSize(new Dimension(245, 35));
        boton_acercaSistema.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boton_acercaSistemaActionPerformed(evt);
            }
        });

        boton_transferenciaCuenta.setActionCommand("transferenciaCuentas");
        boton_transferenciaCuenta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_transferenciaCuenta.setFont(new Font("Arial", 0, 18)); // NOI18N
        boton_transferenciaCuenta.setLabel("Transferencia entre Cuentas");
        boton_transferenciaCuenta.setMinimumSize(new Dimension(245, 35));
        boton_transferenciaCuenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boton_transferenciaCuentaActionPerformed(evt);
            }
        });

        boton_cerrarSesion.setActionCommand("Cerrar Sesion");
        boton_cerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_cerrarSesion.setFont(new Font("Arial", 0, 18)); // NOI18N
        boton_cerrarSesion.setLabel("Cerrar Sesion");
        boton_cerrarSesion.setMinimumSize(new Dimension(245, 35));
        boton_cerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boton_cerrarSesionActionPerformed(evt);
            }
        });

        botonesMenu.setLayer(boton_pagarTarjeta, JLayeredPane.DEFAULT_LAYER);
        botonesMenu.setLayer(boton_deposito, JLayeredPane.DEFAULT_LAYER);
        botonesMenu.setLayer(boton_pagarServicio, JLayeredPane.DEFAULT_LAYER);
        botonesMenu.setLayer(boton_consultarSaldo, JLayeredPane.DEFAULT_LAYER);
        botonesMenu.setLayer(boton_acercaSistema, JLayeredPane.DEFAULT_LAYER);
        botonesMenu.setLayer(boton_transferenciaCuenta, JLayeredPane.DEFAULT_LAYER);
        botonesMenu.setLayer(boton_cerrarSesion, JLayeredPane.DEFAULT_LAYER);

        GroupLayout botonesMenuLayout = new GroupLayout(botonesMenu);
        botonesMenu.setLayout(botonesMenuLayout);
        botonesMenuLayout.setHorizontalGroup(botonesMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(botonesMenuLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(botonesMenuLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(boton_pagarServicio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_deposito, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_pagarTarjeta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_acercaSistema, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(boton_consultarSaldo, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_transferenciaCuenta, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_cerrarSesion, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        botonesMenuLayout.setVerticalGroup(botonesMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, botonesMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boton_transferenciaCuenta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(boton_consultarSaldo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19)
                .addComponent(boton_deposito, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23)
                .addComponent(boton_pagarTarjeta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19)
                .addComponent(boton_pagarServicio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22)
                .addComponent(boton_acercaSistema, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boton_cerrarSesion, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        separador.setEnabled(false);
        separador.setMinimumSize(new Dimension(5, 425));

        label1.setAlignment(Label.CENTER);
        label1.setBackground(new Color(181, 181, 181));
        label1.setMinimumSize(new Dimension(5, 425));

        separador.setLayer(label1, JLayeredPane.DEFAULT_LAYER);

        GroupLayout separadorLayout = new GroupLayout(separador);
        separador.setLayout(separadorLayout);
        separadorLayout.setHorizontalGroup(separadorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(label1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 5, Short.MAX_VALUE)
        );
        separadorLayout.setVerticalGroup(separadorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(separadorLayout.createSequentialGroup()
                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );

        menu_interaccion.setBackground(new Color(153, 153, 153));
        menu_interaccion.setForeground(new Color(153, 153, 153));

        menu_transferencia.setBackground(new Color(153, 153, 153));
        menu_transferencia.setFont(new Font("Arial", 0, 14)); // NOI18N
        menu_transferencia.setMinimumSize(new Dimension(643, 367));
        menu_transferencia.setPreferredSize(new Dimension(643, 367));

        boton_cancelarTransferencia.setActionCommand("cancelarTransaccion");
        boton_cancelarTransferencia.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_cancelarTransferencia.setFont(new Font("Arial", 0, 18)); // NOI18N
        boton_cancelarTransferencia.setForeground(new Color(51, 51, 51));
        boton_cancelarTransferencia.setLabel("Cancelar Transaccion");
        boton_cancelarTransferencia.setMaximumSize(new Dimension(190, 30));
        boton_cancelarTransferencia.setMinimumSize(new Dimension(190, 30));
        boton_cancelarTransferencia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boton_cancelarTransferenciaActionPerformed(evt);
            }
        });

        boton_confirmarTransaccion1.setActionCommand("confirmarTransaccion");
        boton_confirmarTransaccion1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_confirmarTransaccion1.setFont(new Font("Arial", 0, 18)); // NOI18N
        boton_confirmarTransaccion1.setForeground(new Color(51, 51, 51));
        boton_confirmarTransaccion1.setLabel("Confirmar Transaccion");
        boton_confirmarTransaccion1.setMinimumSize(new Dimension(190, 30));
        boton_confirmarTransaccion1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boton_confirmarTransaccion1ActionPerformed(evt);
            }
        });

        cuentaDestino.setBackground(new Color(255, 255, 255));
        cuentaDestino.setForeground(new Color(0, 0, 0));
        cuentaDestino.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cuentaDestinoActionPerformed(evt);
            }
        });

        label8.setAlignment(Label.CENTER);
        label8.setFont(new Font("Arial", 1, 14)); // NOI18N
        label8.setForeground(new Color(0, 1, 0));
        label8.setText("Cuenta de Destino");

        cedula.setBackground(new Color(255, 255, 255));
        cedula.setForeground(new Color(0, 0, 0));
        cedula.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cedulaActionPerformed(evt);
            }
        });

        label9.setAlignment(Label.CENTER);
        label9.setFont(new Font("Arial", 1, 14)); // NOI18N
        label9.setForeground(new Color(0, 1, 0));
        label9.setText("Nombre de Destinatario");

        nombre_destinatario.setBackground(new Color(255, 255, 255));
        nombre_destinatario.setForeground(new Color(0, 0, 0));
        nombre_destinatario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                nombre_destinatarioActionPerformed(evt);
            }
        });

        label10.setAlignment(Label.CENTER);
        label10.setFont(new Font("Arial", 1, 14)); // NOI18N
        label10.setForeground(new Color(0, 1, 0));
        label10.setText("Cédula de Destinatario");

        monto.setBackground(new Color(255, 255, 255));
        monto.setForeground(new Color(0, 0, 0));
        monto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                montoActionPerformed(evt);
            }
        });

        label11.setAlignment(Label.CENTER);
        label11.setFont(new Font("Arial", 1, 14)); // NOI18N
        label11.setForeground(new Color(0, 1, 0));
        label11.setText("Monto");

        label12.setAlignment(Label.CENTER);
        label12.setFont(new Font("Arial", 1, 14)); // NOI18N
        label12.setForeground(new Color(0, 1, 0));
        label12.setText("Cuenta de Origen");

        saldo.setBackground(new Color(196, 196, 196));
        saldo.setForeground(new Color(0, 0, 0));
        saldo.setHorizontalAlignment(JTextField.CENTER);
        saldo.setToolTipText("");
        saldo.setEnabled(false);
        saldo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saldoActionPerformed(evt);
            }
        });

        numero_origen.setBackground(new Color(196, 196, 196));
        numero_origen.setForeground(new Color(0, 0, 0));
        numero_origen.setEnabled(false);
        numero_origen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                numero_origenActionPerformed(evt);
            }
        });

        label13.setAlignment(Label.CENTER);
        label13.setFont(new Font("Arial", 1, 14)); // NOI18N
        label13.setForeground(new Color(0, 1, 0));
        label13.setText("Saldo");

        GroupLayout menu_transferenciaLayout = new GroupLayout(menu_transferencia);
        menu_transferencia.setLayout(menu_transferenciaLayout);
        menu_transferenciaLayout.setHorizontalGroup(menu_transferenciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, menu_transferenciaLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(menu_transferenciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(nombre_destinatario)
                    .addComponent(cuentaDestino)
                    .addComponent(label9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cedula, GroupLayout.Alignment.TRAILING)
                    .addComponent(label10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menu_transferenciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, menu_transferenciaLayout.createSequentialGroup()
                        .addGroup(menu_transferenciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(monto)
                            .addComponent(label11, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82))
                    .addGroup(menu_transferenciaLayout.createSequentialGroup()
                        .addGroup(menu_transferenciaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(numero_origen, GroupLayout.Alignment.LEADING)
                            .addComponent(label12, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77))))
            .addGroup(GroupLayout.Alignment.TRAILING, menu_transferenciaLayout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(boton_cancelarTransferencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(boton_confirmarTransaccion1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
            .addGroup(GroupLayout.Alignment.TRAILING, menu_transferenciaLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label13, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saldo, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        menu_transferenciaLayout.setVerticalGroup(menu_transferenciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(menu_transferenciaLayout.createSequentialGroup()
                .addGroup(menu_transferenciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(menu_transferenciaLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(saldo, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(GroupLayout.Alignment.TRAILING, menu_transferenciaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addGroup(menu_transferenciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(menu_transferenciaLayout.createSequentialGroup()
                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cuentaDestino, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                    .addGroup(menu_transferenciaLayout.createSequentialGroup()
                        .addGroup(menu_transferenciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(menu_transferenciaLayout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(label9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(menu_transferenciaLayout.createSequentialGroup()
                                .addComponent(label12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numero_origen, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)
                        .addGroup(menu_transferenciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, menu_transferenciaLayout.createSequentialGroup()
                                .addComponent(label11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(monto, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                            .addGroup(menu_transferenciaLayout.createSequentialGroup()
                                .addComponent(nombre_destinatario, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cedula, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(menu_transferenciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(boton_confirmarTransaccion1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_cancelarTransferencia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        menu_consultarSaldo.setBackground(new Color(153, 153, 153));
        menu_consultarSaldo.setFont(new Font("Arial", 0, 14)); // NOI18N
        menu_consultarSaldo.setPreferredSize(new Dimension(643, 367));

        label2.setAlignment(Label.CENTER);
        label2.setFont(new Font("Arial", 1, 14)); // NOI18N
        label2.setForeground(new Color(0, 1, 0));
        label2.setText("Movimiento de la Cuenta");

        saldo1.setBackground(new Color(196, 196, 196));
        saldo1.setForeground(new Color(0, 0, 0));
        saldo1.setHorizontalAlignment(JTextField.CENTER);
        saldo1.setEnabled(false);
        saldo1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saldo1ActionPerformed(evt);
            }
        });

        label7.setAlignment(Label.CENTER);
        label7.setFont(new Font("Arial", 1, 14)); // NOI18N
        label7.setForeground(new Color(0, 1, 0));
        label7.setText("Saldo");

        jScrollPane1.setEnabled(false);
        jScrollPane1.setRequestFocusEnabled(false);

        TablaConsulta.setBackground(new Color(255, 255, 255));
        TablaConsulta.setForeground(new Color(204, 204, 204));
        TablaConsulta.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "ID", "Tipo de Servicio", "Monto"
            }
        ));
        TablaConsulta.setEnabled(false);
        TablaConsulta.setGridColor(new Color(204, 204, 204));
        TablaConsulta.setRequestFocusEnabled(false);
        TablaConsulta.setSelectionBackground(new Color(204, 204, 204));
        TablaConsulta.setSelectionForeground(new Color(204, 204, 204));
        TablaConsulta.setShowHorizontalLines(true);
        TablaConsulta.setShowVerticalLines(true);
        TablaConsulta.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TablaConsulta);
        TablaConsulta.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        GroupLayout menu_consultarSaldoLayout = new GroupLayout(menu_consultarSaldo);
        menu_consultarSaldo.setLayout(menu_consultarSaldoLayout);
        menu_consultarSaldoLayout.setHorizontalGroup(menu_consultarSaldoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, menu_consultarSaldoLayout.createSequentialGroup()
                .addGroup(menu_consultarSaldoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(GroupLayout.Alignment.LEADING, menu_consultarSaldoLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(menu_consultarSaldoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)))
                    .addGroup(menu_consultarSaldoLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saldo1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        menu_consultarSaldoLayout.setVerticalGroup(menu_consultarSaldoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(menu_consultarSaldoLayout.createSequentialGroup()
                .addGroup(menu_consultarSaldoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(menu_consultarSaldoLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(saldo1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(GroupLayout.Alignment.TRAILING, menu_consultarSaldoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addComponent(label2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        menu_deposito.setBackground(new Color(153, 153, 153));
        menu_deposito.setFont(new Font("Arial", 0, 14)); // NOI18N
        menu_deposito.setMaximumSize(new Dimension(643, 367));
        menu_deposito.setMinimumSize(new Dimension(643, 367));
        menu_deposito.setPreferredSize(new Dimension(643, 367));

        boton_cancelarDeposito.setActionCommand("cancelarTransaccion");
        boton_cancelarDeposito.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_cancelarDeposito.setFont(new Font("Arial", 0, 18)); // NOI18N
        boton_cancelarDeposito.setForeground(new Color(51, 51, 51));
        boton_cancelarDeposito.setLabel("Cancelar Transaccion");
        boton_cancelarDeposito.setMaximumSize(new Dimension(190, 30));
        boton_cancelarDeposito.setMinimumSize(new Dimension(190, 30));
        boton_cancelarDeposito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boton_cancelarDepositoActionPerformed(evt);
            }
        });

        boton_confirmarDeposito.setActionCommand("confirmarTransaccion");
        boton_confirmarDeposito.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_confirmarDeposito.setFont(new Font("Arial", 0, 18)); // NOI18N
        boton_confirmarDeposito.setForeground(new Color(51, 51, 51));
        boton_confirmarDeposito.setLabel("Confirmar Transaccion");
        boton_confirmarDeposito.setMinimumSize(new Dimension(190, 30));
        boton_confirmarDeposito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boton_confirmarDepositoActionPerformed(evt);
            }
        });

        montoDeposito.setBackground(new Color(255, 255, 255));
        montoDeposito.setForeground(new Color(0, 0, 0));
        montoDeposito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                montoDepositoActionPerformed(evt);
            }
        });

        label17.setAlignment(Label.CENTER);
        label17.setFont(new Font("Arial", 1, 14)); // NOI18N
        label17.setForeground(new Color(0, 1, 0));
        label17.setText("Monto");

        saldoDeposito.setBackground(new Color(196, 196, 196));
        saldoDeposito.setForeground(new Color(0, 0, 0));
        saldoDeposito.setHorizontalAlignment(JTextField.CENTER);
        saldoDeposito.setEnabled(false);
        saldoDeposito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saldoDepositoActionPerformed(evt);
            }
        });

        label19.setAlignment(Label.CENTER);
        label19.setFont(new Font("Arial", 1, 14)); // NOI18N
        label19.setForeground(new Color(0, 1, 0));
        label19.setText("Saldo");

        GroupLayout menu_depositoLayout = new GroupLayout(menu_deposito);
        menu_deposito.setLayout(menu_depositoLayout);
        menu_depositoLayout.setHorizontalGroup(menu_depositoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, menu_depositoLayout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(boton_cancelarDeposito, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(boton_confirmarDeposito, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
            .addGroup(GroupLayout.Alignment.TRAILING, menu_depositoLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label19, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saldoDeposito, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(menu_depositoLayout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addGroup(menu_depositoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(montoDeposito)
                    .addComponent(label17, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu_depositoLayout.setVerticalGroup(menu_depositoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(menu_depositoLayout.createSequentialGroup()
                .addGroup(menu_depositoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(menu_depositoLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(saldoDeposito, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                    .addGroup(menu_depositoLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(label19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(label17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(montoDeposito, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 725, Short.MAX_VALUE)
                .addGroup(menu_depositoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(boton_confirmarDeposito, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_cancelarDeposito, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        menu_pagarTarjeta.setBackground(new Color(153, 153, 153));
        menu_pagarTarjeta.setFont(new Font("Arial", 0, 14)); // NOI18N
        menu_pagarTarjeta.setMinimumSize(new Dimension(643, 367));

        boton_cancelarPagoTarjeta.setActionCommand("cancelarTransaccion");
        boton_cancelarPagoTarjeta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_cancelarPagoTarjeta.setFont(new Font("Arial", 0, 18)); // NOI18N
        boton_cancelarPagoTarjeta.setForeground(new Color(51, 51, 51));
        boton_cancelarPagoTarjeta.setLabel("Cancelar Transaccion");
        boton_cancelarPagoTarjeta.setMaximumSize(new Dimension(190, 30));
        boton_cancelarPagoTarjeta.setMinimumSize(new Dimension(190, 30));
        boton_cancelarPagoTarjeta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boton_cancelarPagoTarjetaActionPerformed(evt);
            }
        });

        boton_confirmarTransaccion6.setActionCommand("confirmarTransaccion");
        boton_confirmarTransaccion6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_confirmarTransaccion6.setFont(new Font("Arial", 0, 18)); // NOI18N
        boton_confirmarTransaccion6.setForeground(new Color(51, 51, 51));
        boton_confirmarTransaccion6.setLabel("Confirmar Transaccion");
        boton_confirmarTransaccion6.setMinimumSize(new Dimension(190, 30));
        boton_confirmarTransaccion6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boton_confirmarTransaccion6ActionPerformed(evt);
            }
        });

        label34.setAlignment(Label.CENTER);
        label34.setFont(new Font("Arial", 1, 14)); // NOI18N
        label34.setForeground(new Color(0, 1, 0));
        label34.setText("Seleccionar Tarjeta");

        montoTarjeta.setBackground(new Color(255, 255, 255));
        montoTarjeta.setForeground(new Color(0, 0, 0));
        montoTarjeta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                montoTarjetaActionPerformed(evt);
            }
        });

        label37.setAlignment(Label.CENTER);
        label37.setFont(new Font("Arial", 1, 14)); // NOI18N
        label37.setForeground(new Color(0, 1, 0));
        label37.setText("Monto");

        label38.setAlignment(Label.CENTER);
        label38.setFont(new Font("Arial", 1, 14)); // NOI18N
        label38.setForeground(new Color(0, 1, 0));
        label38.setText("Numero de Tarjeta");

        saldoTarjeta.setBackground(new Color(196, 196, 196));
        saldoTarjeta.setForeground(new Color(0, 0, 0));
        saldoTarjeta.setHorizontalAlignment(JTextField.CENTER);
        saldoTarjeta.setEnabled(false);
        saldoTarjeta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saldoTarjetaActionPerformed(evt);
            }
        });

        numeroTarjeta.setBackground(new Color(255, 255, 255));
        numeroTarjeta.setForeground(new Color(0, 0, 0));
        numeroTarjeta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                numeroTarjetaActionPerformed(evt);
            }
        });
        numeroTarjeta.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                numeroTarjetaKeyReleased(evt);
            }
        });

        label39.setAlignment(Label.CENTER);
        label39.setFont(new Font("Arial", 1, 14)); // NOI18N
        label39.setForeground(new Color(0, 1, 0));
        label39.setText("Saldo");

        deudatotalTarjeta.setBackground(new Color(255, 255, 255));
        deudatotalTarjeta.setForeground(new Color(0, 0, 0));
        deudatotalTarjeta.setEnabled(false);
        deudatotalTarjeta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deudatotalTarjetaActionPerformed(evt);
            }
        });

        label40.setAlignment(Label.CENTER);
        label40.setFont(new Font("Arial", 1, 14)); // NOI18N
        label40.setForeground(new Color(0, 1, 0));
        label40.setText("Deuda Total");

        label41.setAlignment(Label.CENTER);
        label41.setFont(new Font("Arial", 1, 14)); // NOI18N
        label41.setForeground(new Color(0, 1, 0));
        label41.setText("Deuda Limite");

        deudalimiteTarjeta.setBackground(new Color(255, 255, 255));
        deudalimiteTarjeta.setForeground(new Color(0, 0, 0));
        deudalimiteTarjeta.setEnabled(false);
        deudalimiteTarjeta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deudalimiteTarjetaActionPerformed(evt);
            }
        });

        seleccionarTarjeta.setBackground(new Color(255, 255, 255));
        seleccionarTarjeta.setModel(new DefaultComboBoxModel<>(new String[] { "Otras Tarjetas" }));
        seleccionarTarjeta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                seleccionarTarjetaActionPerformed(evt);
            }
        });

        GroupLayout menu_pagarTarjetaLayout = new GroupLayout(menu_pagarTarjeta);
        menu_pagarTarjeta.setLayout(menu_pagarTarjetaLayout);
        menu_pagarTarjetaLayout.setHorizontalGroup(menu_pagarTarjetaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, menu_pagarTarjetaLayout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(boton_cancelarPagoTarjeta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(boton_confirmarTransaccion6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
            .addGroup(GroupLayout.Alignment.TRAILING, menu_pagarTarjetaLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label39, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saldoTarjeta, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(GroupLayout.Alignment.TRAILING, menu_pagarTarjetaLayout.createSequentialGroup()
                .addGroup(menu_pagarTarjetaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(GroupLayout.Alignment.LEADING, menu_pagarTarjetaLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(menu_pagarTarjetaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(label34, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(seleccionarTarjeta, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(menu_pagarTarjetaLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(menu_pagarTarjetaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(deudalimiteTarjeta)
                            .addComponent(label41, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu_pagarTarjetaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(menu_pagarTarjetaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(deudatotalTarjeta)
                        .addComponent(label40, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                    .addGroup(menu_pagarTarjetaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, menu_pagarTarjetaLayout.createSequentialGroup()
                            .addGroup(menu_pagarTarjetaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(montoTarjeta)
                                .addComponent(label37, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30))
                        .addGroup(menu_pagarTarjetaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(numeroTarjeta)
                            .addComponent(label38, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52))
        );
        menu_pagarTarjetaLayout.setVerticalGroup(menu_pagarTarjetaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(menu_pagarTarjetaLayout.createSequentialGroup()
                .addGroup(menu_pagarTarjetaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(menu_pagarTarjetaLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(saldoTarjeta, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(GroupLayout.Alignment.TRAILING, menu_pagarTarjetaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label39, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addGroup(menu_pagarTarjetaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(menu_pagarTarjetaLayout.createSequentialGroup()
                        .addComponent(label38, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numeroTarjeta, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label40, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deudatotalTarjeta, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                    .addGroup(menu_pagarTarjetaLayout.createSequentialGroup()
                        .addComponent(label34, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seleccionarTarjeta, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label41, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deudalimiteTarjeta, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(label37, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(montoTarjeta, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(menu_pagarTarjetaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(boton_confirmarTransaccion6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_cancelarPagoTarjeta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        menu_acercaSistema.setBackground(new Color(153, 153, 153));
        menu_acercaSistema.setFont(new Font("Arial", 0, 14)); // NOI18N
        menu_acercaSistema.setMinimumSize(new Dimension(643, 367));
        menu_acercaSistema.setPreferredSize(new Dimension(643, 367));

        label48.setAlignment(Label.CENTER);
        label48.setFont(new Font("Arial", 1, 18)); // NOI18N
        label48.setForeground(new Color(0, 1, 0));
        label48.setText("Facultad Politécnica");

        numeroGrupo.setFont(new Font("Arial", 1, 18)); // NOI18N
        numeroGrupo.setForeground(new Color(0, 1, 0));
        numeroGrupo.setText("Grupo N° XX");

        label54.setAlignment(Label.CENTER);
        label54.setFont(new Font("Arial", 1, 56)); // NOI18N
        label54.setForeground(new Color(204, 0, 0));
        label54.setText("Examen Final - 2023");

        label55.setFont(new Font("Arial", 1, 18)); // NOI18N
        label55.setForeground(new Color(0, 1, 0));
        label55.setText("Lista de Integrantes");

        label56.setAlignment(Label.CENTER);
        label56.setFont(new Font("Arial", 1, 18)); // NOI18N
        label56.setForeground(new Color(0, 1, 0));
        label56.setText("Lenguajes de Programación 2");

        botonDocumentacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonDocumentacion.setFont(new Font("Arial", 1, 14)); // NOI18N
        botonDocumentacion.setForeground(new Color(0, 1, 0));
        botonDocumentacion.setLabel("Ver Documentación");
        botonDocumentacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonDocumentacionActionPerformed(evt);
            }
        });

        integrante1.setFont(new Font("Arial", 1, 18)); // NOI18N
        integrante1.setForeground(new Color(0, 1, 0));
        integrante1.setText("Isaac González");
        integrante1.setVisible(false);

        integrante2.setFont(new Font("Arial", 1, 18)); // NOI18N
        integrante2.setForeground(new Color(0, 1, 0));
        integrante2.setText("Alan Alcaraz");
        integrante2.setVisible(false);

        integrante3.setFont(new Font("Arial", 1, 18)); // NOI18N
        integrante3.setForeground(new Color(0, 1, 0));
        integrante3.setText("Leandro Ferreira");
        integrante3.setVisible(false);

        integrante4.setFont(new Font("Arial", 1, 18)); // NOI18N
        integrante4.setForeground(new Color(0, 1, 0));
        integrante4.setText("Augusto Florentin");
        integrante4.setVisible(false);

        GroupLayout menu_acercaSistemaLayout = new GroupLayout(menu_acercaSistema);
        menu_acercaSistema.setLayout(menu_acercaSistemaLayout);
        menu_acercaSistemaLayout.setHorizontalGroup(menu_acercaSistemaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(menu_acercaSistemaLayout.createSequentialGroup()
                .addGroup(menu_acercaSistemaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(menu_acercaSistemaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(menu_acercaSistemaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(label56, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
                            .addGroup(menu_acercaSistemaLayout.createSequentialGroup()
                                .addComponent(label48, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                                .addComponent(botonDocumentacion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(menu_acercaSistemaLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(menu_acercaSistemaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(label54, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label55, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(numeroGrupo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34))
            .addGroup(menu_acercaSistemaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(menu_acercaSistemaLayout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(integrante1, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(594, Short.MAX_VALUE)))
            .addGroup(menu_acercaSistemaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(menu_acercaSistemaLayout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(integrante2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(594, Short.MAX_VALUE)))
            .addGroup(menu_acercaSistemaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(menu_acercaSistemaLayout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(integrante3, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(594, Short.MAX_VALUE)))
            .addGroup(menu_acercaSistemaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(menu_acercaSistemaLayout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(integrante4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(594, Short.MAX_VALUE)))
        );
        menu_acercaSistemaLayout.setVerticalGroup(menu_acercaSistemaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(menu_acercaSistemaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(menu_acercaSistemaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(label48, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonDocumentacion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addComponent(label56, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label54, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(numeroGrupo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(label55, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(377, 377, 377))
            .addGroup(menu_acercaSistemaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(menu_acercaSistemaLayout.createSequentialGroup()
                    .addGap(245, 245, 245)
                    .addComponent(integrante1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(122, Short.MAX_VALUE)))
            .addGroup(menu_acercaSistemaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(menu_acercaSistemaLayout.createSequentialGroup()
                    .addGap(270, 270, 270)
                    .addComponent(integrante2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(97, Short.MAX_VALUE)))
            .addGroup(menu_acercaSistemaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(menu_acercaSistemaLayout.createSequentialGroup()
                    .addGap(300, 300, 300)
                    .addComponent(integrante3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(67, Short.MAX_VALUE)))
            .addGroup(menu_acercaSistemaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(menu_acercaSistemaLayout.createSequentialGroup()
                    .addGap(330, 330, 330)
                    .addComponent(integrante4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(37, Short.MAX_VALUE)))
        );

        menu_pagarServicio.setBackground(new Color(153, 153, 153));
        menu_pagarServicio.setFont(new Font("Arial", 0, 14)); // NOI18N
        menu_pagarServicio.setMinimumSize(new Dimension(643, 367));
        menu_pagarServicio.setPreferredSize(new Dimension(643, 367));

        boton_cancelarTransaccion7.setActionCommand("cancelarTransaccion");
        boton_cancelarTransaccion7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_cancelarTransaccion7.setFont(new Font("Arial", 0, 18)); // NOI18N
        boton_cancelarTransaccion7.setForeground(new Color(51, 51, 51));
        boton_cancelarTransaccion7.setLabel("Cancelar Transaccion");
        boton_cancelarTransaccion7.setMaximumSize(new Dimension(190, 30));
        boton_cancelarTransaccion7.setMinimumSize(new Dimension(190, 30));
        boton_cancelarTransaccion7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boton_cancelarTransaccion7ActionPerformed(evt);
            }
        });

        confirmar_pago_serv.setActionCommand("confirmarTransaccion");
        confirmar_pago_serv.setCursor(new Cursor(Cursor.HAND_CURSOR));
        confirmar_pago_serv.setFont(new Font("Arial", 0, 18)); // NOI18N
        confirmar_pago_serv.setForeground(new Color(51, 51, 51));
        confirmar_pago_serv.setLabel("Confirmar Transaccion");
        confirmar_pago_serv.setMinimumSize(new Dimension(190, 30));
        confirmar_pago_serv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                confirmar_pago_servActionPerformed(evt);
            }
        });

        label35.setAlignment(Label.CENTER);
        label35.setFont(new Font("Arial", 1, 14)); // NOI18N
        label35.setForeground(new Color(0, 1, 0));
        label35.setText("Seleccionar Servicios");

        nro_servicio.setBackground(new Color(255, 255, 255));
        nro_servicio.setForeground(new Color(0, 0, 0));
        nro_servicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                nro_servicioActionPerformed(evt);
            }
        });

        label42.setAlignment(Label.CENTER);
        label42.setFont(new Font("Arial", 1, 14)); // NOI18N
        label42.setForeground(new Color(0, 1, 0));
        label42.setText("Numero de Servicio");

        monto_ingresado.setBackground(new Color(255, 255, 255));
        monto_ingresado.setForeground(new Color(0, 0, 0));
        monto_ingresado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                monto_ingresadoActionPerformed(evt);
            }
        });

        label43.setAlignment(Label.CENTER);
        label43.setFont(new Font("Arial", 1, 14)); // NOI18N
        label43.setForeground(new Color(0, 1, 0));
        label43.setText("Monto");

        label44.setAlignment(Label.CENTER);
        label44.setFont(new Font("Arial", 1, 14)); // NOI18N
        label44.setForeground(new Color(0, 1, 0));
        label44.setText("Cuenta de Origen");

        saldo_pago_serv.setBackground(new Color(196, 196, 196));
        saldo_pago_serv.setForeground(new Color(0, 0, 0));
        saldo_pago_serv.setHorizontalAlignment(JTextField.CENTER);
        saldo_pago_serv.setEnabled(false);
        saldo_pago_serv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saldo_pago_servActionPerformed(evt);
            }
        });

        cuenta_origen_pago_serv.setBackground(new Color(196, 196, 196));
        cuenta_origen_pago_serv.setForeground(new Color(0, 0, 0));
        cuenta_origen_pago_serv.setEnabled(false);
        cuenta_origen_pago_serv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cuenta_origen_pago_servActionPerformed(evt);
            }
        });

        label45.setAlignment(Label.CENTER);
        label45.setFont(new Font("Arial", 1, 14)); // NOI18N
        label45.setForeground(new Color(0, 1, 0));
        label45.setText("Saldo");

        servicio_a_pagar.setBackground(new Color(255, 255, 255));
        servicio_a_pagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                servicio_a_pagarActionPerformed(evt);
            }
        });

        metodo_de_pago.setBackground(new Color(255, 255, 255));
        metodo_de_pago.setModel(new DefaultComboBoxModel<>(new String[] { "Saldo de cuenta" }));
        metodo_de_pago.setToolTipText("");
        metodo_de_pago.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                metodo_de_pagoActionPerformed(evt);
            }
        });

        label36.setAlignment(Label.CENTER);
        label36.setFont(new Font("Arial", 1, 14)); // NOI18N
        label36.setForeground(new Color(0, 1, 0));
        label36.setText("Metodo de Pago");

        monto_definido.setBackground(new Color(196, 196, 196));
        monto_definido.setForeground(new Color(0, 0, 0));
        monto_definido.setEnabled(false);
        monto_definido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                monto_definidoActionPerformed(evt);
            }
        });

        label46.setAlignment(Label.CENTER);
        label46.setFont(new Font("Arial", 1, 14)); // NOI18N
        label46.setForeground(new Color(0, 1, 0));
        label46.setText("Monto del Servicio");

        saldoTarjetaServicio.setBackground(new Color(196, 196, 196));
        saldoTarjetaServicio.setForeground(new Color(0, 0, 0));
        saldoTarjetaServicio.setEnabled(false);
        saldoTarjetaServicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saldoTarjetaServicioActionPerformed(evt);
            }
        });

        textSaldoTarjeta.setAlignment(Label.CENTER);
        textSaldoTarjeta.setFont(new Font("Arial", 1, 14)); // NOI18N
        textSaldoTarjeta.setForeground(new Color(0, 1, 0));
        textSaldoTarjeta.setText("Saldo de la Tarjeta");
        textSaldoTarjeta.setVisible(false);

        GroupLayout menu_pagarServicioLayout = new GroupLayout(menu_pagarServicio);
        menu_pagarServicio.setLayout(menu_pagarServicioLayout);
        menu_pagarServicioLayout.setHorizontalGroup(menu_pagarServicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, menu_pagarServicioLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_cancelarTransaccion7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confirmar_pago_serv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
            .addGroup(GroupLayout.Alignment.TRAILING, menu_pagarServicioLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label45, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saldo_pago_serv, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(GroupLayout.Alignment.TRAILING, menu_pagarServicioLayout.createSequentialGroup()
                .addGroup(menu_pagarServicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(menu_pagarServicioLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(menu_pagarServicioLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(label35, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(servicio_a_pagar, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nro_servicio, GroupLayout.Alignment.LEADING)
                            .addComponent(label42, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(menu_pagarServicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(metodo_de_pago, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label36, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
                    .addGroup(GroupLayout.Alignment.TRAILING, menu_pagarServicioLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(menu_pagarServicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(saldoTarjetaServicio, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textSaldoTarjeta, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu_pagarServicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(monto_definido, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                    .addComponent(label46, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                    .addGroup(menu_pagarServicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, menu_pagarServicioLayout.createSequentialGroup()
                            .addGroup(menu_pagarServicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(monto_ingresado)
                                .addComponent(label43, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                            .addGap(82, 82, 82))
                        .addGroup(menu_pagarServicioLayout.createSequentialGroup()
                            .addGroup(menu_pagarServicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(cuenta_origen_pago_serv, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label44, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap()))))
        );
        menu_pagarServicioLayout.setVerticalGroup(menu_pagarServicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(menu_pagarServicioLayout.createSequentialGroup()
                .addGroup(menu_pagarServicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(menu_pagarServicioLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(saldo_pago_serv, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(GroupLayout.Alignment.TRAILING, menu_pagarServicioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label45, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addGroup(menu_pagarServicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(menu_pagarServicioLayout.createSequentialGroup()
                        .addComponent(label44, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cuenta_origen_pago_serv, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label46, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monto_definido, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(label43, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monto_ingresado, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                    .addGroup(menu_pagarServicioLayout.createSequentialGroup()
                        .addGroup(menu_pagarServicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(menu_pagarServicioLayout.createSequentialGroup()
                                .addComponent(label35, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(menu_pagarServicioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(servicio_a_pagar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(metodo_de_pago, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                            .addComponent(label36, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(menu_pagarServicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(menu_pagarServicioLayout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(label42, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nro_servicio, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                            .addGroup(menu_pagarServicioLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(textSaldoTarjeta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saldoTarjetaServicio, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(menu_pagarServicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(boton_cancelarTransaccion7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(confirmar_pago_serv, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        menu_interaccion.setLayer(menu_transferencia, JLayeredPane.DEFAULT_LAYER);
        menu_interaccion.setLayer(menu_consultarSaldo, JLayeredPane.DEFAULT_LAYER);
        menu_interaccion.setLayer(menu_deposito, JLayeredPane.DEFAULT_LAYER);
        menu_interaccion.setLayer(menu_pagarTarjeta, JLayeredPane.DEFAULT_LAYER);
        menu_interaccion.setLayer(menu_acercaSistema, JLayeredPane.DEFAULT_LAYER);
        menu_interaccion.setLayer(menu_pagarServicio, JLayeredPane.DEFAULT_LAYER);

        GroupLayout menu_interaccionLayout = new GroupLayout(menu_interaccion);
        menu_interaccion.setLayout(menu_interaccionLayout);
        menu_interaccionLayout.setHorizontalGroup(menu_interaccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(menu_interaccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu_consultarSaldo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(menu_interaccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(menu_interaccionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(menu_transferencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
            .addGroup(menu_interaccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(menu_interaccionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(menu_deposito, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE)))
            .addGroup(menu_interaccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(menu_interaccionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(menu_acercaSistema, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
            .addGroup(menu_interaccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(menu_interaccionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(menu_pagarTarjeta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
            .addGroup(menu_interaccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(menu_interaccionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(menu_pagarServicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );
        menu_interaccionLayout.setVerticalGroup(menu_interaccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(menu_interaccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu_consultarSaldo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(menu_interaccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(menu_interaccionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(menu_transferencia, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(12, Short.MAX_VALUE)))
            .addGroup(menu_interaccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, menu_interaccionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(menu_deposito, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(menu_interaccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(menu_interaccionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(menu_acercaSistema, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(menu_interaccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(menu_interaccionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(menu_pagarTarjeta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(menu_interaccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(menu_interaccionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(menu_pagarServicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(botonesMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu_interaccion))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonesMenu))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(separador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(menu_interaccion, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Menu Principal", jPanel1);

        jLayeredPane1.setLayer(texto_fecha, JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(texto_usuario, JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(logo, JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTabbedPane1, JLayeredPane.DEFAULT_LAYER);

        GroupLayout jLayeredPane1Layout = new GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(jLayeredPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(texto_usuario, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_fecha, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addComponent(logo, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addComponent(jTabbedPane1)
        );
        jLayeredPane1Layout.setVerticalGroup(jLayeredPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(texto_fecha, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(texto_usuario, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                    .addComponent(logo, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        InterfazPrincipal.setLayer(jLayeredPane1, JLayeredPane.DEFAULT_LAYER);

        GroupLayout InterfazPrincipalLayout = new GroupLayout(InterfazPrincipal);
        InterfazPrincipal.setLayout(InterfazPrincipalLayout);
        InterfazPrincipalLayout.setHorizontalGroup(InterfazPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        InterfazPrincipalLayout.setVerticalGroup(InterfazPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, InterfazPrincipalLayout.createSequentialGroup()
                .addComponent(jLayeredPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jDesktopPane1.add(InterfazPrincipal, new AbsoluteConstraints(0, 0, -1, -1));

        fondo1.setIcon(new ImageIcon(getClass().getResource("/imagenes/Fondo1020x641.png"))); // NOI18N
        fondo1.setToolTipText("");
        fondo1.setMaximumSize(new Dimension(2147483647, 2147483647));
        fondo1.setMinimumSize(new Dimension(1020, 640));
        fondo1.setOpaque(true);
        fondo1.setPreferredSize(new Dimension(1020, 640));
        jDesktopPane1.add(fondo1, new AbsoluteConstraints(0, 0, 1020, -1));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, GroupLayout.PREFERRED_SIZE, 627, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private Button botonPresionadoActualmente = null;
    /**
    * Maneja el evento de acción cuando se presiona el botón para consultar el saldo.
    * Actualiza la interfaz con el saldo actual de la cuenta, cambia la apariencia del
    * botón presionado y muestra los detalles de las transacciones en una tabla.
    *
    * @param evt Objeto ActionEvent que representa el evento de acción.
    */
    private void boton_consultarSaldoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_boton_consultarSaldoActionPerformed
        
        saldo1.setText(String.format("%.0f", cuenta.getSaldoCuenta())); 
        
        // Cambiar la apariencia del botón cuando se presiona
        if (botonPresionadoActualmente != null) {
            botonPresionadoActualmente.setBackground(new java.awt.Color(240, 240, 240));  // Color original del fondo
        }

        // Establecer el color oscuro para el botón actual
        boton_consultarSaldo.setBackground(new java.awt.Color(102, 102, 102));

        // Actualizar la referencia al botón actualmente presionado
        botonPresionadoActualmente = boton_consultarSaldo;
        menu_transferencia.setVisible(false);
        menu_consultarSaldo.setVisible(true);
        menu_pagarTarjeta.setVisible(false);
        menu_deposito.setVisible(false);
        menu_pagarServicio.setVisible(false);
        menu_pagarTarjeta.setVisible(false);
        menu_acercaSistema.setVisible(false);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Transacción");
        modelo.addColumn("Tipo de Transacción");
        modelo.addColumn("Fecha de Transacción");
        modelo.addColumn("Monto");
        Movimientos movimientos = new Movimientos(cuenta.getIdCuenta());
        Thread hiloMovimientos = new Thread(movimientos);
        hiloMovimientos.start();
        try {
            hiloMovimientos.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(Movimiento movimiento : movimientos.getMovimientos() ){
            Object[] fila = {
                    movimiento.getIdTransaccion(),
                    movimiento.getTipoTransaccion(),
                    movimiento.get_fecha_transaccion(),
                    movimiento.getSigno()+" "+movimiento.getMontoTransaccion()
            };
            modelo.addRow(fila);
        }
        TablaConsulta.setModel(modelo);
    }//GEN-LAST:event_boton_consultarSaldoActionPerformed
    private void boton_transferenciaCuentaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_boton_transferenciaCuentaActionPerformed
        
        numero_origen.setText(cuenta.getNumeroCuenta()+ "");
        saldo.setText(String.format("%.0f", cuenta.getSaldoCuenta())); 
        texto_usuario.setText(cliente.getNombreCliente()+" "+cliente.getApellidoCliente());
        
        // Cambiar la apariencia del botón cuando se presiona
        // Restaurar el color original del botón anteriormente presionado
        if (botonPresionadoActualmente != null) {
            botonPresionadoActualmente.setBackground(new java.awt.Color(240, 240, 240));  // Color original del fondo
        }

        // Establecer el color oscuro para el botón actual
        boton_transferenciaCuenta.setBackground(new java.awt.Color(102, 102, 102));

        // Actualizar la referencia al botón actualmente presionado
        botonPresionadoActualmente = boton_transferenciaCuenta;
        //Si esta activo el boton de Transferencia solo que este activo el de menu_transferencia
        menu_transferencia.setVisible(true);
        menu_consultarSaldo.setVisible(false);
        menu_deposito.setVisible(false);
        menu_pagarTarjeta.setVisible(false);
        menu_pagarServicio.setVisible(false);
        menu_pagarTarjeta.setVisible(false);
        menu_acercaSistema.setVisible(false);
    }//GEN-LAST:event_boton_transferenciaCuentaActionPerformed

    private boolean codigoEjecutado = false;  
    /**
    * Maneja el evento de acción cuando se presiona el botón para realizar un pago de servicio.
    * Cambia la apariencia del botón presionado, muestra o oculta los componentes de menú correspondientes
    * y configura la interfaz para realizar un pago de servicio. Además, inicializa y presenta opciones
    * de servicios y métodos de pago, y establece el monto del primer servicio como valor predeterminado.
    *
    * @param evt Objeto ActionEvent que representa el evento de acción.
    */
    
    private void boton_pagarServicioActionPerformed(ActionEvent evt) {//GEN-FIRST:event_boton_pagarServicioActionPerformed

        // Cambiar la apariencia del botón cuando se presiona        
        if (botonPresionadoActualmente != null) {
            botonPresionadoActualmente.setBackground(new java.awt.Color(240, 240, 240));  // Color original del fondo
        }

        // Establecer el color oscuro para el botón actual
        boton_pagarServicio.setBackground(new java.awt.Color(102, 102, 102));

        // Actualizar la referencia al botón actualmente presionado
        botonPresionadoActualmente = boton_pagarServicio;
        menu_transferencia.setVisible(false);
        menu_consultarSaldo.setVisible(false);
        menu_deposito.setVisible(false);
        menu_pagarTarjeta.setVisible(false);
        menu_pagarServicio.setVisible(true);
        menu_pagarTarjeta.setVisible(false);
        menu_acercaSistema.setVisible(false);
        saldoTarjetaServicio.setVisible(false);
        saldo_pago_serv.setText(String.format("%.0f", cuenta.getSaldoCuenta())); 
        
        //saldo_pago_serv.setText(cuenta.getSaldoCuenta() + "");
        cuenta_origen_pago_serv.setText(cuenta.getNumeroCuenta() + "");
        if (!codigoEjecutado) {
            java.util.List<Servicio> servicios = ProcesosControlador.obtenerServicios();
            java.util.List<TarjetaDeCredito> tarjetas = ProcesosControlador.obtenerTarjetas(cliente.getIdCliente());

            for(Servicio servicio: servicios){
                servicio_a_pagar.addItem(servicio.get_NombreServicio());
            }
            for(TarjetaDeCredito tarjeta: tarjetas){
                if(tarjeta.getId_cliente() == cliente.getIdCliente())
                    metodo_de_pago.addItem("TC: " + tarjeta.getNro_tarjeta());
            }

            monto_definido.setText(servicios.get(0).get_CostoServicio()+"");
        }
        monto_ingresado.setEditable(false);
        codigoEjecutado = true;
    }//GEN-LAST:event_boton_pagarServicioActionPerformed
    private boolean botonTransferencia = false;
    /**
    * Maneja el evento de acción cuando se presiona el botón para realizar un pago con tarjeta de crédito.
    * Cambia la apariencia del botón presionado, muestra o oculta los componentes de menú correspondientes,
    * y configura la interfaz para realizar un pago con tarjeta de crédito. Además, inicializa y presenta
    * opciones de tarjetas de crédito disponibles para el cliente.
    *
    * @param evt Objeto ActionEvent que representa el evento de acción.
    */
    private void boton_pagarTarjetaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_boton_pagarTarjetaActionPerformed
        // Cambiar la apariencia del botón cuando se presiona
        if (botonPresionadoActualmente != null) {
            botonPresionadoActualmente.setBackground(new java.awt.Color(240, 240, 240));  // Color original del fondo
        }

        // Establecer el color oscuro para el botón actual
        boton_pagarTarjeta.setBackground(new java.awt.Color(102, 102, 102));
        if (!botonTransferencia) {
            java.util.List<TarjetaDeCredito> tarjetas = ProcesosControlador.obtenerTarjetas(cliente.getIdCliente());
            for(TarjetaDeCredito tarjeta: tarjetas){
                seleccionarTarjeta.addItem("TC: " + tarjeta.getNro_tarjeta());
            }
        }
        // Actualizar la referencia al botón actualmente presionado
        botonPresionadoActualmente = boton_pagarTarjeta;
        menu_transferencia.setVisible(false);
        menu_consultarSaldo.setVisible(false);
        menu_deposito.setVisible(false);
        menu_pagarTarjeta.setVisible(true);
        menu_pagarServicio.setVisible(false);
        menu_acercaSistema.setVisible(false);
        botonTransferencia = true;
        saldoTarjeta.setText(String.format("%.0f", cuenta.getSaldoCuenta()));        
        

    }//GEN-LAST:event_boton_pagarTarjetaActionPerformed
    /**
    * Maneja el evento de acción cuando se presiona el botón para realizar un depósito.
    * Cambia la apariencia del botón presionado, muestra o oculta los componentes de menú correspondientes,
    * y configura la interfaz para realizar un depósito. Además, actualiza la interfaz con el saldo actual
    * de la cuenta.
    *
    * @param evt Objeto ActionEvent que representa el evento de acción.
    */
    private void boton_depositoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_boton_depositoActionPerformed
         // Cambiar la apariencia del botón cuando se presiona
        if (botonPresionadoActualmente != null) {
            botonPresionadoActualmente.setBackground(new java.awt.Color(240, 240, 240));  // Color original del fondo
        }

        // Establecer el color oscuro para el botón actual
        boton_deposito.setBackground(new java.awt.Color(102, 102, 102));

        // Actualizar la referencia al botón actualmente presionado
        botonPresionadoActualmente = boton_deposito;

        //Si esta activo el boton de Transferencia solo que este activo el de menu_transferencia
        menu_deposito.setVisible(true);
        menu_transferencia.setVisible(false);
        menu_consultarSaldo.setVisible(false);
        menu_pagarTarjeta.setVisible(false);
        menu_pagarServicio.setVisible(false);
        menu_acercaSistema.setVisible(false);
        saldoDeposito.setText(String.format("%.0f", cuenta.getSaldoCuenta()));


    }//GEN-LAST:event_boton_depositoActionPerformed
    /**
    * Maneja el evento de acción cuando se presiona el botón para ver información acerca del sistema.
    * Cambia la apariencia del botón presionado, muestra o oculta los componentes de menú correspondientes,
    * y configura la interfaz para mostrar información acerca del sistema.
    *
    * @param evt Objeto ActionEvent que representa el evento de acción.
    */
    private void boton_acercaSistemaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_boton_acercaSistemaActionPerformed
        // Cambiar la apariencia del botón cuando se presiona
        if (botonPresionadoActualmente != null) {
            botonPresionadoActualmente.setBackground(new java.awt.Color(240, 240, 240));  // Color original del fondo
        }

        // Establecer el color oscuro para el botón actual
        boton_acercaSistema.setBackground(new java.awt.Color(102, 102, 102));

        // Actualizar la referencia al botón actualmente presionado
        botonPresionadoActualmente = boton_acercaSistema;

        //Si esta activo el boton de Transferencia solo que este activo el de menu_transferencia
        menu_deposito.setVisible(false);
        menu_transferencia.setVisible(false);
        menu_consultarSaldo.setVisible(false);
        menu_pagarTarjeta.setVisible(false);
        menu_pagarServicio.setVisible(false);
        menu_acercaSistema.setVisible(true);
    }//GEN-LAST:event_boton_acercaSistemaActionPerformed
    /**
     * Maneja el evento de acción cuando se presiona el botón para cerrar la sesión del usuario.
     * Cambia la apariencia del botón presionado, actualiza la referencia al botón actualmente presionado,
     * y realiza la acción de cerrar la sesión, abriendo la interfaz de inicio de sesión y cerrando la
     * interfaz actual.
     *
     * @param evt Objeto ActionEvent que representa el evento de acción.
     */
    private void boton_cerrarSesionActionPerformed(ActionEvent evt) {//GEN-FIRST:event_boton_cerrarSesionActionPerformed
        // Cambiar la apariencia del botón cuando se presiona
        if (botonPresionadoActualmente != null) {
            botonPresionadoActualmente.setBackground(new java.awt.Color(240, 240, 240));  // Color original del fondo
        }

        // Establecer el color oscuro para el botón actual
        boton_cerrarSesion.setBackground(new java.awt.Color(102, 102, 102));

        // Actualizar la referencia al botón actualmente presionado
        botonPresionadoActualmente = boton_cerrarSesion;

        // Conecto la interfaz cuando inicie sesion,para  que se abra la interfaz de menu principal
        LoginInterfaz ventanaLogin = new LoginInterfaz();
        ventanaLogin.setVisible(true);
        this.dispose();//Cierra esta ventana
    }//GEN-LAST:event_boton_cerrarSesionActionPerformed
    /**
    * Actualiza el texto de un componente de interfaz con la fecha y hora actuales en el formato "dd/MM/yyyy HH:mm:ss".
    */
    private void actualizarHora() {
            // Obtén la fecha y hora actual
            Date fechaActual = new Date();

            // Formatea la fecha en el formato deseado
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String fechaFormateada = formatoFecha.format(fechaActual);

            // Actualiza el texto del label con la fecha formateada
            texto_fecha.setText(fechaFormateada);
    }
    
    private void saldo1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_saldo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saldo1ActionPerformed
    /**
    * Borra los datos insertados en el menu de transferencia al apretar el boton de cancelar
    */
    private void boton_cancelarTransferenciaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_boton_cancelarTransferenciaActionPerformed
        cuentaDestino.setText("");
        nombre_destinatario.setText("");
        cedula.setText("");
        monto.setText("");
    }//GEN-LAST:event_boton_cancelarTransferenciaActionPerformed

    /**
     * Maneja el evento de acción cuando se confirma una transacción de transferencia.
     * Obtiene y valida los datos ingresados, realiza las verificaciones necesarias,
     * y procede a confirmar la transferencia si todas las validaciones son exitosas.
     *
     * @param evt Objeto ActionEvent que representa el evento de acción.
     */
    private void boton_confirmarTransaccion1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_boton_confirmarTransaccion1ActionPerformed
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
            
        ProcesosControlador.verificarSaldoSuficiente(cuenta.getNumeroCuenta(), montoLong);
            // Confirmar los datos si todas las validaciones pasan

            if (ProcesosControlador.confirmarDatosTransferencia(cuenta_Destino, cedula_destinatario, nombreDestinatario)){

                Transferencia transferencia = new Transferencia
                        (new Date(System.currentTimeMillis()),cuenta.getNumeroCuenta(), cuenta_Destino, montoLong);
                cuenta.setSaldoCuenta(cuenta.getSaldoCuenta() - montoLong);
                //saldo.setText(Double.toString(cuenta.getSaldoCuenta()));
                nombre_destinatario.setText("");
                cuentaDestino.setText("");
                cedula.setText("");
                monto.setText("");
                PinTransaccionInterfaz ventanaPIN = new PinTransaccionInterfaz(transferencia, cliente, cuenta);
                ventanaPIN.setVisible(true);
                this.dispose();
                
            }


            } catch (NumberFormatException e) {
                // Manejar la excepción si hay un error al convertir los números
                mostrarMensajeError("Error al ingresar los datos. Intente de nuevo.");
            }catch (SaldoInsuficienteException e) {
            mostrarMensajeError("Error al ingresar los datos. Intente de nuevo.");
        }

    }//GEN-LAST:event_boton_confirmarTransaccion1ActionPerformed
    
    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private void cuentaDestinoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cuentaDestinoActionPerformed
  
    }//GEN-LAST:event_cuentaDestinoActionPerformed

    private void cedulaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaActionPerformed

    private void nombre_destinatarioActionPerformed(ActionEvent evt) {//GEN-FIRST:event_nombre_destinatarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_destinatarioActionPerformed

    private void montoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_montoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_montoActionPerformed

    private void saldoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_saldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saldoActionPerformed

    private void numero_origenActionPerformed(ActionEvent evt) {//GEN-FIRST:event_numero_origenActionPerformed
    
    }//GEN-LAST:event_numero_origenActionPerformed
    
    
    /**
    * Borra los datos insertados en el menu de deposito al apretar el boton de cancelar
    */
    private void boton_cancelarDepositoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_boton_cancelarDepositoActionPerformed
        montoDeposito.setText("");
    }//GEN-LAST:event_boton_cancelarDepositoActionPerformed
    /**
     * Maneja el evento de acción cuando se presiona el botón para confirmar un depósito.
     * Obtiene el monto del depósito del campo de texto, realiza la operación de depósito,
     * actualiza el saldo de la cuenta, muestra un comprobante y cierra la interfaz actual.
     *
     * @param evt Objeto ActionEvent que representa el evento de acción.
     */
    private void boton_confirmarDepositoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_boton_confirmarDepositoActionPerformed
        try {
        // Obtener el monto_utilizado del depósito como String
        String montoDepositoString = montoDeposito.getText();

        // Convertir el String a double
        double deposito = Double.parseDouble(montoDepositoString);
        Deposito depositoObj = new Deposito(Date.from(Instant.now()), cuenta, deposito);
        if(deposito>0){
            Thread hiloDeposito = new Thread(depositoObj);
            hiloDeposito.start();
            hiloDeposito.join();
            cuenta.setSaldoCuenta(cuenta.getSaldoCuenta() + deposito);
            saldoDeposito.setText(Double.toString(cuenta.getSaldoCuenta()));
            ComprobanteInterfaz comprobante = new ComprobanteInterfaz(cliente, cuenta, depositoObj);
            comprobante.setVisible(true);
            // Imprimir el saldo actualizado (opcional)
            dispose();
        }
        else {
              JOptionPane.showMessageDialog(null, "Monto invalido", "Error", JOptionPane.ERROR_MESSAGE);
                }
      
    } catch (NumberFormatException e) {
        // Manejar la excepción si el formato del montoDeposito no es válido
         JOptionPane.showMessageDialog(null, "Monto invalido", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_boton_confirmarDepositoActionPerformed

    private void montoDepositoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_montoDepositoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_montoDepositoActionPerformed

    private void saldoDepositoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_saldoDepositoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saldoDepositoActionPerformed

    private void deudalimiteTarjetaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_deudalimiteTarjetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deudalimiteTarjetaActionPerformed

    private void deudatotalTarjetaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_deudatotalTarjetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deudatotalTarjetaActionPerformed

    private void numeroTarjetaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_numeroTarjetaActionPerformed

    }//GEN-LAST:event_numeroTarjetaActionPerformed

    private void saldoTarjetaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_saldoTarjetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saldoTarjetaActionPerformed

    private void montoTarjetaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_montoTarjetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_montoTarjetaActionPerformed
    /**
     * Maneja el evento de acción cuando se presiona el botón para confirmar una transacción de pago de tarjeta de crédito.
     * Obtiene el monto a pagar y el número de tarjeta de crédito seleccionada, realiza las validaciones necesarias,
     * y muestra una interfaz para ingresar el PIN antes de realizar la transacción de pago de tarjeta de crédito.
     *
     * @param evt Objeto ActionEvent que representa el evento de acción.
     */
    private void boton_confirmarTransaccion6ActionPerformed(ActionEvent evt) {
        try{
            if(!(montoTarjeta.getText() == null || montoTarjeta.getText().isEmpty())){
                double montoAPagar = Double.parseDouble(montoTarjeta.getText());
                Long numeroTarjetaL;
                String tarjetaSeleccionada = (String) seleccionarTarjeta.getSelectedItem();
                if(tarjetaSeleccionada.equals("Otras Tarjetas")){
                    numeroTarjetaL = Long.parseLong(numeroTarjeta.getText());
                }else{
                    tarjetaSeleccionada = tarjetaSeleccionada.substring(4);
                    numeroTarjetaL = Long.parseLong(tarjetaSeleccionada);
                }
                TarjetaDeCredito tarjetaDeCredito = ProcesosControlador.obtenerTarjeta(numeroTarjetaL);
                numeroTarjeta.setText(String.valueOf(tarjetaDeCredito.getNro_tarjeta()));
                deudalimiteTarjeta.setText(String.valueOf(tarjetaDeCredito.getLinea_tarjeta())+ " Gs");
                deudatotalTarjeta.setText(String.valueOf(tarjetaDeCredito.getDeuda_tarjeta())+ " Gs");
                if(montoAPagar>tarjetaDeCredito.getDeuda_tarjeta() || montoAPagar < 1 ){
                    JOptionPane.showMessageDialog(this, "El monto a pagar no es valido", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    PagoDeTarjeta pagoDeTarjeta = new PagoDeTarjeta(new Date(System.currentTimeMillis()), tarjetaDeCredito, montoAPagar);
                    pagoDeTarjeta.setNumeroCuenta(cuenta.getNumeroCuenta());
                    PinTransaccionInterfaz ventanaPIN = new PinTransaccionInterfaz(pagoDeTarjeta, cliente, cuenta);
                    ventanaPIN.setVisible(true);
                    this.dispose();
                }
            }
        }
        catch (NumberFormatException e) {
        // Manejar la excepción si el formato del montoDeposito no es válido
         JOptionPane.showMessageDialog(null, "Monto invalido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
    * Borra los datos insertados en el menu de pago de tarjeta al apretar el boton de cancelar
    */
    private void boton_cancelarPagoTarjetaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_boton_cancelarTransaccion6ActionPerformed
        seleccionarTarjeta.setSelectedIndex(0);
        montoTarjeta.setText("");
    }//GEN-LAST:event_boton_cancelarTransaccion6ActionPerformed
    /**
     * Maneja el evento de acción cuando se selecciona una opción en el ComboBox de tarjetas.
     * Actualiza la información de la interfaz según la tarjeta seleccionada y habilita o deshabilita
     * la edición del campo de texto para ingresar el número de tarjeta dependiendo de la selección.
     *
     * @param evt Objeto ActionEvent que representa el evento de acción.
     */
    private void seleccionarTarjetaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_servicioTarjetaActionPerformed
        String tarjetaSeleccionada = ((String) seleccionarTarjeta.getSelectedItem());
        if(!tarjetaSeleccionada.equals("Otras Tarjetas")){
            tarjetaSeleccionada = tarjetaSeleccionada.substring(4);
            Long numeroTarjetaL = Long.parseLong(tarjetaSeleccionada);
            TarjetaDeCredito tarjetaDeCredito = ProcesosControlador.obtenerTarjeta(numeroTarjetaL);
            numeroTarjeta.setText(String.valueOf(tarjetaDeCredito.getNro_tarjeta()));
            deudalimiteTarjeta.setText(String.valueOf(tarjetaDeCredito.getLinea_tarjeta())+ " Gs");
            deudatotalTarjeta.setText(String.valueOf(tarjetaDeCredito.getDeuda_tarjeta())+ " Gs");
            numeroTarjeta.setEnabled(false);
        }
        else{
            numeroTarjeta.setEnabled(true);
            numeroTarjeta.setText("");
            deudalimiteTarjeta.setText("");
            deudatotalTarjeta.setText("");
        }




    }//GEN-LAST:event_servicioTarjetaActionPerformed

    private void servicioTarjetaActionPerformed(ActionEvent evt) {
    }


    private void cuenta_origen_pago_servActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cuenta_origen_pago_servActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuenta_origen_pago_servActionPerformed

    private void saldo_pago_servActionPerformed(ActionEvent evt) {//GEN-FIRST:event_saldo_pago_servActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saldo_pago_servActionPerformed

    private void monto_ingresadoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_monto_ingresadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monto_ingresadoActionPerformed

    private void nro_servicioActionPerformed(ActionEvent evt) {//GEN-FIRST:event_nro_servicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nro_servicioActionPerformed
    /**
     * Maneja el evento de acción cuando se presiona el botón para confirmar un pago de servicio.
     * Obtiene el monto del pago y realiza validaciones. Luego, crea un objeto PagoServicio,
     * configura la información del servicio y el método de pago, verifica el límite o saldo
     * según el método de pago, muestra la interfaz para ingresar el PIN y realiza el pago de servicio.
     *
     * @param evt Objeto ActionEvent que representa el evento de acción.
     */
    private void confirmar_pago_servActionPerformed(ActionEvent evt) {//GEN-FIRST:event_confirmar_pago_servActionPerformed
        double monto_utilizado;
        double nroServicio;
        long tarjeta_usada;
        boolean monto_valido = false;
        boolean servicio_valido = false;
       
        try{
            nroServicio = Double.parseDouble(nro_servicio.getText());
            if (nroServicio > 0){
                servicio_valido = true;
            }
        }catch(NumberFormatException errorDeServicio){
            servicio_valido = false;
        }
        try{
            if (monto_ingresado.getText().equals("")){
                monto_utilizado = Double.parseDouble(monto_definido.getText());
                monto_valido = true;
            }
            else{
                try{
                    monto_utilizado = Double.parseDouble(monto_ingresado.getText());
                    if (monto_utilizado > 0){
                        monto_valido = true;
                    }
                }catch(NumberFormatException errorDeMonto){
                    monto_utilizado = 0;
                    monto_valido = false;
                    JOptionPane.showMessageDialog(null, "Monto invalido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            if(monto_valido && servicio_valido){
                PagoServicio pagoServicio = new PagoServicio(new Date(System.currentTimeMillis()), cuenta, null, monto_utilizado);
                Servicio servicio = new Servicio(0L, (String) servicio_a_pagar.getSelectedItem(), monto_utilizado);
                pagoServicio.setServicio(servicio);
                String metodoPago = (String)metodo_de_pago.getSelectedItem();
                if(metodoPago!=null && metodoPago.contains("TC")){
                    String numberString = metodoPago.substring(4);
                    tarjeta_usada = Long.parseLong(numberString);
                    TarjetaDeCredito tarjetaDeCredito = new TarjetaDeCredito();
                    tarjetaDeCredito.setCliente_asociado(cliente);
                    tarjetaDeCredito.setNro_tarjeta(tarjeta_usada);
                    pagoServicio.setTarjetaAbonante(tarjetaDeCredito);
                    ProcesosControlador.verificarLimite(tarjeta_usada, monto_utilizado);
                }
                else{
                    pagoServicio.setCuenta(cuenta);
                    ProcesosControlador.verificarSaldoSuficiente(cuenta.getNumeroCuenta(), monto_utilizado);
                    cuenta.setSaldoCuenta(cuenta.getSaldoCuenta() - monto_utilizado);
                    saldo.setText(Double.toString(cuenta.getSaldoCuenta()));
                }
                PinTransaccionInterfaz ventanaPIN = new PinTransaccionInterfaz(pagoServicio, cliente, cuenta);
                ventanaPIN.setVisible(true);
                this.dispose();
            }else
                JOptionPane.showMessageDialog(null, "Datos de transaccion invalidos, favor verifique y vuelva a intentar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (SaldoInsuficienteException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_confirmar_pago_servActionPerformed
    /**
    * Borra los datos insertados en el menu de pago de servicios al apretar el boton de cancelar
    */
    private void boton_cancelarTransaccion7ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_boton_cancelarTransaccion7ActionPerformed
        servicio_a_pagar.setSelectedIndex(0);
        metodo_de_pago.setSelectedIndex(0);
        monto_ingresado.setText("");
        nro_servicio.setText("");
    }//GEN-LAST:event_boton_cancelarTransaccion7ActionPerformed
    /**
     * Maneja el evento de acción cuando se selecciona un servicio en el ComboBox de servicios a pagar.
     * Actualiza la información del monto definido y la capacidad de edición del campo de texto
     * según la selección del servicio.
     *
     * @param evt Objeto ActionEvent que representa el evento de acción.
     */ 
    private void servicio_a_pagarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_servicio_a_pagarActionPerformed
        
        java.util.List<Servicio> servicios = ProcesosControlador.obtenerServicios();
        Servicio servicio_elegido = servicios.get(0);
        for(Servicio servicio: servicios){
            if (servicio.get_NombreServicio().equals(servicio_a_pagar.getSelectedItem()))
                servicio_elegido = servicio;
        }
       
        if (servicio_elegido.get_CostoServicio() != 0){
            monto_definido.setText(servicio_elegido.get_CostoServicio() + "");
            monto_ingresado.setText("");
            monto_ingresado.setEditable(false);
        }
        else{
            monto_definido.setText("No definido");
            monto_ingresado.setEditable(true);
        }
    }//GEN-LAST:event_servicio_a_pagarActionPerformed

    private void monto_definidoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_monto_definidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monto_definidoActionPerformed

    private void botonDocumentacionActionPerformed(ActionEvent evt) {//GEN-FIRST:event_botonDocumentacionActionPerformed
       run();
    }//GEN-LAST:event_botonDocumentacionActionPerformed
    /**
    * Maneja el evento de acción cuando se selecciona un método de pago en el ComboBox de métodos de pago.
    * Actualiza la visibilidad de la información de saldo de tarjeta según la selección del método de pago.
    *
    * @param evt Objeto ActionEvent que representa el evento de acción.
    */
    private void metodo_de_pagoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_metodo_de_pagoActionPerformed
        // TODO add your handling code here:
        String metodo_pago = (String) metodo_de_pago.getSelectedItem();
        if (!"Saldo de cuenta".equals(metodo_pago)){
            saldoTarjetaServicio.setVisible(true);
            textSaldoTarjeta.setVisible(true);
            metodo_pago = metodo_pago.substring(4);
            Long numeroTarjetaL = Long.parseLong(metodo_pago);
            TarjetaDeCredito tarjetaDeCredito = ProcesosControlador.obtenerTarjeta(numeroTarjetaL);
            saldoTarjetaServicio.setText(String.valueOf(tarjetaDeCredito.getLinea_tarjeta()-tarjetaDeCredito.getDeuda_tarjeta()));
        }
        else{
            saldoTarjetaServicio.setVisible(false);
            textSaldoTarjeta.setVisible(false);
        }

    }//GEN-LAST:event_metodo_de_pagoActionPerformed
    /**
     * Maneja el evento de liberación de tecla cuando se ingresa un número de tarjeta.
     * Obtiene el número de tarjeta ingresado, intenta obtener la información de la tarjeta
     * de crédito asociada y actualiza la interfaz con el límite y deuda de la tarjeta, si existe.
     *
     * @param evt Objeto KeyEvent que representa el evento de liberación de tecla.
     */
    private void numeroTarjetaKeyReleased(KeyEvent evt) {//GEN-FIRST:event_numeroTarjetaKeyReleased
        Long numeroTarjetaL;
        TarjetaDeCredito tarjetaDeCredito;
        String texto = numeroTarjeta.getText();
        try{
             numeroTarjetaL = Long.valueOf(texto);
        }catch(NumberFormatException e){
            numeroTarjetaL = (long)0;
        }
        try{
            tarjetaDeCredito = ProcesosControlador.obtenerTarjeta(numeroTarjetaL);
        }catch(RuntimeException e){
           tarjetaDeCredito = null;
        }

        if (tarjetaDeCredito!=null){
            deudalimiteTarjeta.setText(String.valueOf(tarjetaDeCredito.getLinea_tarjeta())+ " Gs");
            deudatotalTarjeta.setText(String.valueOf(tarjetaDeCredito.getDeuda_tarjeta())+ " Gs");
        }
        else{
            deudalimiteTarjeta.setText("");
            deudatotalTarjeta.setText("");
        }
    }//GEN-LAST:event_numeroTarjetaKeyReleased

    private void saldoTarjetaServicioActionPerformed(ActionEvent evt) {//GEN-FIRST:event_saldoTarjetaServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saldoTarjetaServicioActionPerformed

    public void activarMenuTransferencia() {
        boton_transferenciaCuentaActionPerformed(null);
    }

    /**
    * Método principal para iniciar la aplicación.
    * Configura el aspecto visual de la interfaz y lanza la aplicación.
    *
    * @param args Los argumentos de la línea de comandos (no utilizados en este caso).
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
            java.util.logging.Logger.getLogger(BaseInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaseInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaseInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaseInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                
                //BaseInterfaz loginInterfaz = new BaseInterfaz();
                //loginInterfaz.boton_transferenciaCuentaActionPerformed(null);
                //loginInterfaz.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLayeredPane InterfazPrincipal;
    private JTable TablaConsulta;
    private Button botonDocumentacion;
    private Button boton_acercaSistema;
    private Button boton_cancelarDeposito;
    private Button boton_cancelarPagoTarjeta;
    private Button boton_cancelarTransaccion7;
    private Button boton_cancelarTransferencia;
    private Button boton_cerrarSesion;
    private Button boton_confirmarDeposito;
    private Button boton_confirmarTransaccion1;
    private Button boton_confirmarTransaccion6;
    private Button boton_consultarSaldo;
    private Button boton_deposito;
    private Button boton_pagarServicio;
    private Button boton_pagarTarjeta;
    public Button boton_transferenciaCuenta;
    private JLayeredPane botonesMenu;
    public JTextField cedula;
    private Button confirmar_pago_serv;
    public JTextField cuentaDestino;
    private JTextField cuenta_origen_pago_serv;
    private JTextField deudalimiteTarjeta;
    private JTextField deudatotalTarjeta;
    private JLabel fondo1;
    private Label integrante1;
    private Label integrante2;
    private Label integrante3;
    private Label integrante4;
    private JDesktopPane jDesktopPane1;
    private JLayeredPane jLayeredPane1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;
    private Label label1;
    private Label label10;
    private Label label11;
    private Label label12;
    private Label label13;
    private Label label17;
    private Label label19;
    private Label label2;
    private Label label34;
    private Label label35;
    private Label label36;
    private Label label37;
    private Label label38;
    private Label label39;
    private Label label40;
    private Label label41;
    private Label label42;
    private Label label43;
    private Label label44;
    private Label label45;
    private Label label46;
    private Label label48;
    private Label label54;
    private Label label55;
    private Label label56;
    private Label label7;
    private Label label8;
    private Label label9;
    private List list1;
    private JLabel logo;
    private Panel menu_acercaSistema;
    private Panel menu_consultarSaldo;
    private Panel menu_deposito;
    private JLayeredPane menu_interaccion;
    private Panel menu_pagarServicio;
    private Panel menu_pagarTarjeta;
    private Panel menu_transferencia;
    private JComboBox<String> metodo_de_pago;
    public JTextField monto;
    private JTextField montoDeposito;
    private JTextField montoTarjeta;
    private JTextField monto_definido;
    private JTextField monto_ingresado;
    public JTextField nombre_destinatario;
    private JTextField nro_servicio;
    private Label numeroGrupo;
    private JTextField numeroTarjeta;
    private JTextField numero_origen;
    private JTextField saldo;
    private JTextField saldo1;
    private JTextField saldoDeposito;
    private JTextField saldoTarjeta;
    private JTextField saldoTarjetaServicio;
    private JTextField saldo_pago_serv;
    private JComboBox<String> seleccionarTarjeta;
    private JLayeredPane separador;
    private JComboBox<String> servicio_a_pagar;
    private Label textSaldoTarjeta;
    private JLabel texto_fecha;
    private JLabel texto_usuario;
    // End of variables declaration//GEN-END:variables
}