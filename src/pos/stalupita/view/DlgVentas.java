/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.view;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pos.stalupita.controller.VentasController;
import pos.stalupita.herramientas.Utilities;
import pos.stalupita.model.Ticket;

/**
 *
 * @author adrian.ake
 */
@Component
public class DlgVentas extends javax.swing.JDialog {

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DlgVentas.class.getName());

    @Resource
    private VentasController ventasController;

    /**
     * Creates new form DlgVentas
     */
    public DlgVentas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @Autowired
    public DlgVentas(VentasController ventasController) {
        super(null, ModalityType.APPLICATION_MODAL);
        initComponents();
        Utilities.setDialogIcon(this);
        this.ventasController = ventasController;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableModelTicketsVta1 = new pos.stalupita.tablemodels.TableModelTicketsVta();
        jpnlFondoGris = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTickets = new javax.swing.JTable();
        jpnlFondoVerde = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jDcFechaDesde = new com.toedter.calendar.JDateChooser();
        jDcFechaHasta = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbtnBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jtxtTotalVentas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtTotalGanancia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtTotalRegistros = new javax.swing.JTextField();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jpnlFondoGris.setBackground(new java.awt.Color(149, 163, 190));

        jScrollPane1.setBackground(new java.awt.Color(4, 151, 135));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(4, 151, 135), 5, true));

        jtbTickets.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jtbTickets.setModel(tableModelTicketsVta1);
        jtbTickets.setGridColor(new java.awt.Color(255, 255, 255));
        jtbTickets.setSelectionBackground(new java.awt.Color(0, 120, 215));
        jScrollPane1.setViewportView(jtbTickets);

        jpnlFondoVerde.setBackground(new java.awt.Color(4, 151, 135));
        jpnlFondoVerde.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ventas Registradas");

        javax.swing.GroupLayout jpnlFondoVerdeLayout = new javax.swing.GroupLayout(jpnlFondoVerde);
        jpnlFondoVerde.setLayout(jpnlFondoVerdeLayout);
        jpnlFondoVerdeLayout.setHorizontalGroup(
            jpnlFondoVerdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFondoVerdeLayout.createSequentialGroup()
                .addGap(394, 394, 394)
                .addComponent(jLabel1)
                .addContainerGap(401, Short.MAX_VALUE))
        );
        jpnlFondoVerdeLayout.setVerticalGroup(
            jpnlFondoVerdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFondoVerdeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jDcFechaDesde.setDate(new Date());
        jDcFechaDesde.setDateFormatString("dd-MM-yyyy");
        jDcFechaDesde.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jDcFechaHasta.setDate(new Date());
        jDcFechaHasta.setDateFormatString("dd-MM-yyyy");
        jDcFechaHasta.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Desde:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Hasta:");

        jbtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/09_search-24.png"))); // NOI18N
        jbtnBuscar.setText("Consultar");
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(149, 163, 190));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Resumen de Consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Ventas $:");

        jtxtTotalVentas.setEditable(false);
        jtxtTotalVentas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtTotalVentas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtTotalVentas.setText("0");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total Ganancia $:");

        jtxtTotalGanancia.setEditable(false);
        jtxtTotalGanancia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtTotalGanancia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtTotalGanancia.setText("0");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Numero ventas:");

        jtxtTotalRegistros.setEditable(false);
        jtxtTotalRegistros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtTotalRegistros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtTotalRegistros.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(279, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtxtTotalVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtxtTotalGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jtxtTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jtxtTotalGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jtxtTotalVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnlFondoGrisLayout = new javax.swing.GroupLayout(jpnlFondoGris);
        jpnlFondoGris.setLayout(jpnlFondoGrisLayout);
        jpnlFondoGrisLayout.setHorizontalGroup(
            jpnlFondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFondoGrisLayout.createSequentialGroup()
                .addGroup(jpnlFondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnlFondoGrisLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnlFondoGrisLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jpnlFondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnlFondoVerde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnlFondoGrisLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDcFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jDcFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jbtnBuscar)))))
                .addGap(15, 15, 15))
        );
        jpnlFondoGrisLayout.setVerticalGroup(
            jpnlFondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFondoGrisLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jpnlFondoVerde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jpnlFondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDcFechaHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDcFechaDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnlFondoGrisLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jpnlFondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jpnlFondoGris, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        this.consultarDatos();
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private boolean validarAntesConsulta() {
        return true;
    }

    private void consultarDatos() {
        Date fecha_desde = this.jDcFechaDesde.getDate();
        Date fecha_hasta = this.jDcFechaHasta.getDate();
        List<Ticket> tickes_vendidos = this.ventasController.getTicketsByFech(fecha_desde, fecha_hasta);
        this.tableModelTicketsVta1.change(tickes_vendidos);
        this.calcularTotales();
        this.setFormatTbl();
    }

    private void calcularTotales() {
        List<Ticket> tickes_vendidos = this.tableModelTicketsVta1.serialize();
        BigDecimal venta_total = BigDecimal.ZERO;
        BigDecimal ganancia_total = BigDecimal.ZERO;
        for (Ticket tickes_vendido : tickes_vendidos) {
            venta_total = venta_total.add(tickes_vendido.getTotal()).setScale(2, RoundingMode.HALF_UP);
            ganancia_total = ganancia_total.add(tickes_vendido.getGanancia()).setScale(2, RoundingMode.HALF_UP);
        }
        this.jtxtTotalVentas.setText(venta_total.toString());
        this.jtxtTotalGanancia.setText(ganancia_total.toString());
        this.jtxtTotalRegistros.setText(String.valueOf(tickes_vendidos.size()));
    }

    @Override
    public void setVisible(boolean b) {
        this.consultarDatos();
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
    }

    private void setFormatTbl() {
        this.jtbTickets.getColumnModel().getColumn(1).setCellRenderer(new MyRenderer());
        this.jtbTickets.getColumnModel().getColumn(2).setCellRenderer(new MyRenderer());
    }

    class MyRenderer extends DefaultTableCellRenderer {

        @Override
        public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value.toString());
            Color fondo_blanco = new Color(255, 255, 255, 255);
            Color c_verde = new Color(4, 151, 135, 255);
            Color c_azul = new Color(80, 67, 255, 255);
            Color fondo_azul = new Color(0, 120, 215, 255);

            if (column == 2) {
                if (isSelected) {
                    setForeground(Color.WHITE);
                    setBackground(fondo_azul);
                } else {
                    setForeground(c_verde);
                    setBackground(fondo_blanco);
                }
            }
            if (column == 1) {
                if (isSelected) {
                    setForeground(Color.WHITE);
                    setBackground(fondo_azul);
                } else {
                    setForeground(c_azul);
                    setBackground(fondo_blanco);
                }
            }

            return this;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDcFechaDesde;
    private com.toedter.calendar.JDateChooser jDcFechaHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JPanel jpnlFondoGris;
    private javax.swing.JPanel jpnlFondoVerde;
    private javax.swing.JTable jtbTickets;
    private javax.swing.JTextField jtxtTotalGanancia;
    private javax.swing.JTextField jtxtTotalRegistros;
    private javax.swing.JTextField jtxtTotalVentas;
    private pos.stalupita.tablemodels.TableModelTicketsVta tableModelTicketsVta1;
    // End of variables declaration//GEN-END:variables
}
