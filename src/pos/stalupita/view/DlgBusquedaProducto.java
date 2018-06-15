/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pos.stalupita.controller.ProductoController;
import pos.stalupita.herramientas.PlaceHolder;
import pos.stalupita.herramientas.RoundedBorderBtn;
import pos.stalupita.herramientas.Utilities;
import pos.stalupita.model.Producto;
import pos.stalupita.tablemodels.TableModelConsProd;

/**
 *
 * @author adrian.ake
 */
@Component
public class DlgBusquedaProducto extends javax.swing.JDialog {

    @Resource
    private ProductoController productoController;

    private Producto producto_selecionado = null;
    private BigDecimal cantidad_comprada = BigDecimal.ZERO;

    /**
     * Creates new form DlgAdminProductos
     */
    public DlgBusquedaProducto(java.awt.Frame parent, boolean modal) {
        super(null, ModalityType.APPLICATION_MODAL);
        initComponents();
        Utilities.setDialogIcon(this);
        this.setMnemonic();
        this.cargarComponents();
    }

    @Autowired
    public DlgBusquedaProducto() {
        super(null, ModalityType.APPLICATION_MODAL);
        initComponents();
        Utilities.setDialogIcon(this);
        this.setMnemonic();
        this.cargarComponents();
    }

    private void cargarComponents() {
        jtxtNombre.setUI(new PlaceHolder("Nombre del Producto", false, Color.GRAY));
        this.btnAgregarProducto.setBorder(new RoundedBorderBtn(8));
        this.btnCancelar.setBorder(new RoundedBorderBtn(8));

    }

    public final void setMnemonic() {
//        getActionMap(btnAgregarProducto, "agregar", KeyEvent.VK_A);
        btnAgregarProducto.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "agregar");
//        getActionMap(btnAgregarProducto, "agregar", KeyEvent.VK_A);

        btnCancelar.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancelar");
        getActionMap(btnCancelar, "cancelar", KeyEvent.VK_ESCAPE);

        btnAgregarProducto.setMnemonic(KeyEvent.VK_A);
        btnCancelar.setMnemonic(KeyEvent.VK_ESCAPE);
    }

    public void getActionMap(JComponent componente, String nombreAccion, int tecla) {
        componente.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(tecla, 0), nombreAccion);
        componente.getActionMap().put(nombreAccion,
                newAbstractAction(nombreAccion));
    }

    public AbstractAction newAbstractAction(String nombreAccion) {
        if (nombreAccion.equals("agregar")) {
            return new AbstractAction(nombreAccion) {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (btnAgregarProducto.isEnabled()) {
                        btnAgregarProductoActionPerformed(evt);
                    }
                }
            };
        } else if (nombreAccion.equals("cancelar")) {
            return new AbstractAction(nombreAccion) {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (btnCancelar.isEnabled()) {
                        btnCancelarActionPerformed(evt);
                    }
                }
            };
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableModelConsProd1 = new pos.stalupita.tablemodels.TableModelConsProd();
        jpnlFondoGris = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCatlProductos = new javax.swing.JTable();
        jpnlFondoVerde = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAgregarProducto = new javax.swing.JButton();
        jtxtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jpnlFondoGris.setBackground(new java.awt.Color(119, 136, 152));

        jScrollPane1.setBackground(new java.awt.Color(4, 151, 135));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(4, 151, 135), 5, true));

        jtbCatlProductos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtbCatlProductos.setModel(tableModelConsProd1);
        jScrollPane1.setViewportView(jtbCatlProductos);

        jpnlFondoVerde.setBackground(new java.awt.Color(4, 151, 135));
        jpnlFondoVerde.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Productos Registrados");

        javax.swing.GroupLayout jpnlFondoVerdeLayout = new javax.swing.GroupLayout(jpnlFondoVerde);
        jpnlFondoVerde.setLayout(jpnlFondoVerdeLayout);
        jpnlFondoVerdeLayout.setHorizontalGroup(
            jpnlFondoVerdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFondoVerdeLayout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnlFondoVerdeLayout.setVerticalGroup(
            jpnlFondoVerdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFondoVerdeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(51, 102, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/010_x-24.png"))); // NOI18N
        btnCancelar.setText("<html><center><b>Cancelar</b> &nbsp<font color = blue>(ESC)</font> </center></html>");
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAgregarProducto.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(51, 102, 255));
        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/011_yes-24.png"))); // NOI18N
        btnAgregarProducto.setText("<html><center><b>Aceptar</b> &nbsp<font color = blue>(Alt + A)</font> </center></html>");
        btnAgregarProducto.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnAgregarProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarProducto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        jtxtNombre.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jtxtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtNombreFocusGained(evt);
            }
        });
        jtxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtNombreKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");

        javax.swing.GroupLayout jpnlFondoGrisLayout = new javax.swing.GroupLayout(jpnlFondoGris);
        jpnlFondoGris.setLayout(jpnlFondoGrisLayout);
        jpnlFondoGrisLayout.setHorizontalGroup(
            jpnlFondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFondoGrisLayout.createSequentialGroup()
                .addGroup(jpnlFondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlFondoGrisLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jpnlFondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpnlFondoVerde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlFondoGrisLayout.createSequentialGroup()
                                .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpnlFondoGrisLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpnlFondoGrisLayout.setVerticalGroup(
            jpnlFondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFondoGrisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlFondoVerde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jpnlFondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnlFondoGrisLayout.createSequentialGroup()
                        .addGroup(jpnlFondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(false);
        dispose();
        this.setProducto_selecionado(null);
        this.setCantidad_comprada(null);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        if (this.validacionXSeleccion()) {
            Integer index_selected = this.jtbCatlProductos.getSelectedRow();
            Producto producto_sel = this.getProductoXIndex(index_selected);
            String cantidad_txt = JOptionPane.showInputDialog(this, "Ingresa la cantidad de " + producto_sel.getDescripcion() + " en " + producto_sel.getUnidadMedida().getDescripcion(), "Mensaje del sistema", JOptionPane.INFORMATION_MESSAGE);
            BigDecimal cantidad_prod = BigDecimal.ZERO;
            try {
                cantidad_prod = new BigDecimal(cantidad_txt);
            } catch (Exception e) {
            }
            if (cantidad_txt.isEmpty() || cantidad_prod.compareTo(BigDecimal.ZERO) < 1) {
                JOptionPane.showMessageDialog(this, "La cantidad para el producto " + producto_sel.getDescripcion() + " debe ser un numero valido y mayor a cero", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
                this.setProducto_selecionado(null);
                this.setCantidad_comprada(null);
            } else {
                this.setProducto_selecionado(producto_sel);
                this.setCantidad_comprada(cantidad_prod);
                this.dispose();
            }
        } else {
            this.setProducto_selecionado(null);
            this.setCantidad_comprada(null);
            JOptionPane.showMessageDialog(this, "Elige el producto que deseas Agregar a la venta actual", "Mensaje del Sistema", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void jtxtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNombreKeyReleased
        if (!this.jtxtNombre.getText().isEmpty()) {
            try {
                TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((TableModelConsProd) this.jtbCatlProductos.getModel()));
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + this.jtxtNombre.getText()));

                this.jtbCatlProductos.setRowSorter(sorter);
            } catch (java.util.regex.PatternSyntaxException e) {
                return;
            }
        } else {
            this.jtbCatlProductos.setRowSorter(null);
        }
    }//GEN-LAST:event_jtxtNombreKeyReleased

    private void jtxtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtNombreFocusGained
        this.jtxtNombre.selectAll();
    }//GEN-LAST:event_jtxtNombreFocusGained

    private void cargarProductosActivos() {
        this.tableModelConsProd1.change(new ArrayList<Producto>());
        List<Producto> productos = this.productoController.getAllProductosActivos();
        this.tableModelConsProd1.change(productos);
    }

    @Override
    public void setVisible(boolean b) {
        this.cargarProductosActivos();
        this.jtbCatlProductos.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        this.jtxtNombre.setFocusable(true);
        this.setProducto_selecionado(null);
        this.setCantidad_comprada(null);
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpnlFondoGris;
    private javax.swing.JPanel jpnlFondoVerde;
    private javax.swing.JTable jtbCatlProductos;
    private javax.swing.JTextField jtxtNombre;
    private pos.stalupita.tablemodels.TableModelConsProd tableModelConsProd1;
    // End of variables declaration//GEN-END:variables

    private boolean validacionXSeleccion() {
        Integer index_selected = this.jtbCatlProductos.getSelectedRow();
        return index_selected != -1;
    }

    public Producto getProductoXIndex(Integer index) {
        return this.tableModelConsProd1.get(index);
    }

    public Producto getProducto_selecionado() {
        return producto_selecionado;
    }

    public void setProducto_selecionado(Producto producto_selecionado) {
        this.producto_selecionado = producto_selecionado;
    }

    public BigDecimal getCantidad_comprada() {
        return cantidad_comprada;
    }

    public void setCantidad_comprada(BigDecimal cantidad_comprada) {
        this.cantidad_comprada = cantidad_comprada;
    }

}