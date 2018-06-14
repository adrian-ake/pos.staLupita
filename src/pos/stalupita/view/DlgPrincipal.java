/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.view;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pos.stalupita.herramientas.Utilities;

/**
 *
 * @author adrian.ake
 */
@Component(value = "singleton")
public class DlgPrincipal extends javax.swing.JDialog {

    @Resource
    private DlgRegistrar_prod jdlgRegistrar_prod;
    @Resource
    private DlgAdminProductos dlgAdminProductos;

    /**
     * Creates new form jdlgPrincipal
     */
    public DlgPrincipal(java.awt.Frame parent, boolean modal) {
        super(null, ModalityType.APPLICATION_MODAL);
        initComponents();
        Utilities.setDialogIcon(this);
        this.cargarConfigsVtana();
    }

    @Autowired
    public DlgPrincipal() {
        super(null, ModalityType.APPLICATION_MODAL);
        initComponents();
        Utilities.setDialogIcon(this);
        this.cargarConfigsVtana();
    }

    private void cargarConfigsVtana() {
        this.setTitle(Utilities.getTituloVtanas());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlFondoGris = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnNuevoTicket3 = new javax.swing.JButton();
        btnNuevoTicket6 = new javax.swing.JButton();
        btnNuevoTicket8 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnNuevoTicket7 = new javax.swing.JButton();
        btnNuevoTicket9 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jpnlFondoVerde = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmitemRegistrar = new javax.swing.JMenuItem();
        jmitemInventario = new javax.swing.JMenuItem();
        jmitemAdministrar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmitemCompras = new javax.swing.JMenuItem();
        jmitemventas = new javax.swing.JMenuItem();
        jmitemStock = new javax.swing.JMenuItem();
        jmitemGrafCompras = new javax.swing.JMenuItem();
        jmitemGrafVentas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema- V1.0.0");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jpnlFondoGris.setBackground(new java.awt.Color(119, 136, 152));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Opciones Venta", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 51, 153))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        btnNuevoTicket3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnNuevoTicket3.setForeground(new java.awt.Color(51, 102, 255));
        btnNuevoTicket3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/shopping-edit-48.png"))); // NOI18N
        btnNuevoTicket3.setText("Editar Producto");
        btnNuevoTicket3.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnNuevoTicket3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoTicket3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnNuevoTicket6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnNuevoTicket6.setForeground(new java.awt.Color(51, 102, 255));
        btnNuevoTicket6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/shopping-add-48.png"))); // NOI18N
        btnNuevoTicket6.setText("Añadir Producto");
        btnNuevoTicket6.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnNuevoTicket6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoTicket6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnNuevoTicket8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnNuevoTicket8.setForeground(new java.awt.Color(51, 102, 255));
        btnNuevoTicket8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/shopping-stop-48.png"))); // NOI18N
        btnNuevoTicket8.setText("Eliminar Producto");
        btnNuevoTicket8.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnNuevoTicket8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoTicket8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevoTicket3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevoTicket6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevoTicket8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoTicket6)
                .addGap(18, 18, 18)
                .addComponent(btnNuevoTicket3)
                .addGap(18, 18, 18)
                .addComponent(btnNuevoTicket8)
                .addContainerGap(407, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Venta Actual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 51, 153)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Total $:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Cantidad:");

        btnNuevoTicket7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnNuevoTicket7.setForeground(new java.awt.Color(51, 102, 255));
        btnNuevoTicket7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/shopping-cancel-48.png"))); // NOI18N
        btnNuevoTicket7.setText("Cancelar Venta");
        btnNuevoTicket7.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnNuevoTicket7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoTicket7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnNuevoTicket9.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnNuevoTicket9.setForeground(new java.awt.Color(51, 102, 255));
        btnNuevoTicket9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/wallet-48.png"))); // NOI18N
        btnNuevoTicket9.setText("Pagar Venta");
        btnNuevoTicket9.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnNuevoTicket9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoTicket9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField1.setText("0.00");

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField2.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addComponent(btnNuevoTicket7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNuevoTicket9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevoTicket9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevoTicket7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jpnlFondoVerde.setBackground(new java.awt.Color(4, 151, 135));
        jpnlFondoVerde.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Punto de Venta");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/if_Account_1891016.png"))); // NOI18N

        javax.swing.GroupLayout jpnlFondoVerdeLayout = new javax.swing.GroupLayout(jpnlFondoVerde);
        jpnlFondoVerde.setLayout(jpnlFondoVerdeLayout);
        jpnlFondoVerdeLayout.setHorizontalGroup(
            jpnlFondoVerdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFondoVerdeLayout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 481, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jpnlFondoVerdeLayout.setVerticalGroup(
            jpnlFondoVerdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFondoVerdeLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jpnlFondoVerdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnlFondoGrisLayout = new javax.swing.GroupLayout(jpnlFondoGris);
        jpnlFondoGris.setLayout(jpnlFondoGrisLayout);
        jpnlFondoGrisLayout.setHorizontalGroup(
            jpnlFondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFondoGrisLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlFondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlFondoGrisLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(132, Short.MAX_VALUE))
                    .addGroup(jpnlFondoGrisLayout.createSequentialGroup()
                        .addGroup(jpnlFondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnlFondoVerde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jpnlFondoGrisLayout.setVerticalGroup(
            jpnlFondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFondoGrisLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jpnlFondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnlFondoGrisLayout.createSequentialGroup()
                        .addComponent(jpnlFondoVerde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(41, 107, 189));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/OFFice-70-4-48.png"))); // NOI18N
        jMenu1.setText("Producto");

        jmitemRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/07_plus-24.png"))); // NOI18N
        jmitemRegistrar.setText("Registrar");
        jmitemRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemRegistrarActionPerformed(evt);
            }
        });
        jMenu1.add(jmitemRegistrar);

        jmitemInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/about_faq_help_hint_info_information-4-24.png"))); // NOI18N
        jmitemInventario.setText("Inventario");
        jMenu1.add(jmitemInventario);

        jmitemAdministrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/06_menu_bullet-24.png"))); // NOI18N
        jmitemAdministrar.setText("Administrar");
        jmitemAdministrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemAdministrarActionPerformed(evt);
            }
        });
        jMenu1.add(jmitemAdministrar);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/OFFice-51-48.png"))); // NOI18N
        jMenu2.setText("Reportes");

        jmitemCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/cash_dollar_funding_investment_money__currency-3-24.png"))); // NOI18N
        jmitemCompras.setText("Compras");
        jMenu2.add(jmitemCompras);

        jmitemventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/basket_cart_red_shopping-24.png"))); // NOI18N
        jmitemventas.setText("Ventas");
        jmitemventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmitemventasActionPerformed(evt);
            }
        });
        jMenu2.add(jmitemventas);

        jmitemStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/Search_document-24.png"))); // NOI18N
        jmitemStock.setText("Stocks | Inventario");
        jMenu2.add(jmitemStock);

        jmitemGrafCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/Chart-24.png"))); // NOI18N
        jmitemGrafCompras.setText("Grafica Compras");
        jMenu2.add(jmitemGrafCompras);

        jmitemGrafVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/Diagram-24.png"))); // NOI18N
        jmitemGrafVentas.setText("Grafica Ventas");
        jMenu2.add(jmitemGrafVentas);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnlFondoGris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlFondoGris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jmitemRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemRegistrarActionPerformed
        this.jdlgRegistrar_prod.setModal(true);
        this.jdlgRegistrar_prod.setLocationRelativeTo(this);
        this.jdlgRegistrar_prod.setTitulo("Registrar Producto");
        this.jdlgRegistrar_prod.resetDatos();
        this.jdlgRegistrar_prod.setVisible(true);
    }//GEN-LAST:event_jmitemRegistrarActionPerformed

    private void jmitemventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemventasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmitemventasActionPerformed

    private void jmitemAdministrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemAdministrarActionPerformed
        dlgAdminProductos.setModal(true);
        dlgAdminProductos.setLocationRelativeTo(this);
        dlgAdminProductos.setVisible(true);
    }//GEN-LAST:event_jmitemAdministrarActionPerformed

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevoTicket3;
    private javax.swing.JButton btnNuevoTicket6;
    private javax.swing.JButton btnNuevoTicket7;
    private javax.swing.JButton btnNuevoTicket8;
    private javax.swing.JButton btnNuevoTicket9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JMenuItem jmitemAdministrar;
    private javax.swing.JMenuItem jmitemCompras;
    private javax.swing.JMenuItem jmitemGrafCompras;
    private javax.swing.JMenuItem jmitemGrafVentas;
    private javax.swing.JMenuItem jmitemInventario;
    private javax.swing.JMenuItem jmitemRegistrar;
    private javax.swing.JMenuItem jmitemStock;
    private javax.swing.JMenuItem jmitemventas;
    private javax.swing.JPanel jpnlFondoGris;
    private javax.swing.JPanel jpnlFondoVerde;
    // End of variables declaration//GEN-END:variables
}
