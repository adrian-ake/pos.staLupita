/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pos.stalupita.controller.VentasController;
import pos.stalupita.herramientas.Utilities;
import pos.stalupita.model.DetalleTicket;

/**
 *
 * @author adrian.ake
 */
@Scope(value = "prototype")
@Component
public class DlgGraficaVentaDia extends javax.swing.JDialog {

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DlgVentas.class.getName());

    @Resource
    private VentasController ventasController;

    @Autowired
    public DlgGraficaVentaDia(VentasController ventasController) {
        super(null, ModalityType.APPLICATION_MODAL);
        initComponents();
        Utilities.setDialogIcon(this);
        this.setResizable(false);
        this.ventasController = ventasController;
        this.getContentPane().setBackground(new java.awt.Color(149, 163, 190));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlFondoVerde = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbtnBuscar = new javax.swing.JButton();
        pnlGraficaVta = new javax.swing.JPanel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jtxtTotalVentas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtTotalGanancia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtTotalRegistros = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grafica de Productos vendidos por dia");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jpnlFondoVerde.setBackground(new java.awt.Color(4, 151, 135));
        jpnlFondoVerde.setBorder(new javax.swing.border.SoftBevelBorder(0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Grafica Ventas Diarias");

        javax.swing.GroupLayout jpnlFondoVerdeLayout = new javax.swing.GroupLayout(jpnlFondoVerde);
        jpnlFondoVerde.setLayout(jpnlFondoVerdeLayout);
        jpnlFondoVerdeLayout.setHorizontalGroup(
            jpnlFondoVerdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFondoVerdeLayout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnlFondoVerdeLayout.setVerticalGroup(
            jpnlFondoVerdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlFondoVerdeLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Selecciona Fecha:");

        jbtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/09_search-24.png"))); // NOI18N
        jbtnBuscar.setText("Consultar");
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });

        pnlGraficaVta.setBackground(new java.awt.Color(255, 255, 255));
        pnlGraficaVta.setAutoscrolls(true);

        jdcFecha.setDate(new Date());
        jdcFecha.setDateFormatString("d-MM-yyyy");
        jdcFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(149, 163, 190));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(0), "Resumen de Consulta", 0, 0, null, java.awt.Color.white));
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
                .addContainerGap(15, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnBuscar))
                    .addComponent(pnlGraficaVta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnlFondoVerde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnlFondoVerde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlGraficaVta, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        this.generarGraficaBarras();
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void generarGraficaBarras() {
        // Fuente de Datos
        DefaultPieDataset data = this.getMontosVentas_Series();

        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
                "Grafica de Productos Vendidos por fecha",
                data,
                true,
                true,
                false);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);

        ChartPanel CP = new ChartPanel(chart);
        pnlGraficaVta.removeAll();
        pnlGraficaVta.add(CP, BorderLayout.CENTER);
        pnlGraficaVta.revalidate();
        pnlGraficaVta.repaint();
        this.revalidate();
        this.repaint();
        this.pack();
    }

    private DefaultPieDataset getMontosVentas_Series() {
        List<DetalleTicket> detalleTickets = this.ventasController.getDetsAgrupadoXProducto(this.jdcFecha.getDate());
        DefaultPieDataset data = new DefaultPieDataset();
        for (DetalleTicket detalleTicket : detalleTickets) {
            data.setValue(detalleTicket.getProducto().getDescripcion(), new Double(detalleTicket.getTotal().toString()));
        }
        generarResumenConsulta(detalleTickets);
        return data;
    }

    private void generarResumenConsulta(List<DetalleTicket> detalleTickets) {
        BigDecimal venta_diaria_total = BigDecimal.ZERO;
        BigDecimal ganancia_diaria_totale = BigDecimal.ZERO;
        for (DetalleTicket detalleTicket : detalleTickets) {
            venta_diaria_total = venta_diaria_total.add(detalleTicket.getTotal());
            ganancia_diaria_totale = ganancia_diaria_totale.add(detalleTicket.getGanancia());
        }
        this.jtxtTotalVentas.setText(venta_diaria_total.toString());
        this.jtxtTotalGanancia.setText(ganancia_diaria_totale.toString());
        this.jtxtTotalRegistros.setText(String.valueOf(detalleTickets.size()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnBuscar;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JPanel jpnlFondoVerde;
    private javax.swing.JTextField jtxtTotalGanancia;
    private javax.swing.JTextField jtxtTotalRegistros;
    private javax.swing.JTextField jtxtTotalVentas;
    private javax.swing.JPanel pnlGraficaVta;
    // End of variables declaration//GEN-END:variables

}
