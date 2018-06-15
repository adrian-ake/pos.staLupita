/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pos.stalupita.controller.TicketController;
import pos.stalupita.herramientas.Utilities;
import pos.stalupita.model.DetalleTicket;
import pos.stalupita.model.Producto;
import pos.stalupita.model.Ticket;

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
    @Resource
    private DlgBusquedaProducto dlgBusquedaProducto;

    @Resource
    private TicketController ticketController;

    /**
     * Creates new form jdlgPrincipal
     */
    public DlgPrincipal(java.awt.Frame parent, boolean modal) {
        super(null, ModalityType.APPLICATION_MODAL);
        initComponents();
        Utilities.setDialogIcon(this);
        this.cargarConfigsVtana();
        this.setMnemonic();
    }

    @Autowired
    public DlgPrincipal(TicketController ticketController) {
        super(null, ModalityType.APPLICATION_MODAL);
        initComponents();
        Utilities.setDialogIcon(this);
        this.cargarConfigsVtana();
        this.setMnemonic();

        this.ticketController = ticketController;
    }

    private void cargarConfigsVtana() {
        this.setTitle(Utilities.getTituloVtanas());
    }

    public final void setMnemonic() {
        btnAgregarProducto.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "agregar");
        getActionMap(btnAgregarProducto, "agregar", KeyEvent.VK_F1);

        btnCambiarCantidad.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "cambiar");
        getActionMap(btnCambiarCantidad, "cambiar", KeyEvent.VK_C);

        btnEliminarProduto.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0), "eliminar");
        getActionMap(btnEliminarProduto, "eliminar", KeyEvent.VK_E);

        btnCancelarVenta.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_X, 0), "cancelar");
        getActionMap(btnCancelarVenta, "cancelar", KeyEvent.VK_X);

        btnPagarVenta.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0), "pagar");
        getActionMap(btnPagarVenta, "pagar", KeyEvent.VK_P);

        btnAgregarProducto.setMnemonic(KeyEvent.VK_F1);
        btnCambiarCantidad.setMnemonic(KeyEvent.VK_C);
        btnEliminarProduto.setMnemonic(KeyEvent.VK_E);
        btnCancelarVenta.setMnemonic(KeyEvent.VK_X);
        btnPagarVenta.setMnemonic(KeyEvent.VK_P);
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
        } else if (nombreAccion.equals("cambiar")) {
            return new AbstractAction(nombreAccion) {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (btnCambiarCantidad.isEnabled()) {
                        btnCambiarCantidadActionPerformed(evt);
                    }
                }
            };
        } else if (nombreAccion.equals("eliminar")) {
            return new AbstractAction(nombreAccion) {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (btnEliminarProduto.isEnabled()) {
                        btnEliminarProdutoActionPerformed(evt);
                    }
                }
            };
        } else if (nombreAccion.equals("cancelar")) {
            return new AbstractAction(nombreAccion) {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (btnCancelarVenta.isEnabled()) {
                        btnCancelarVentaActionPerformed(evt);
                    }
                }
            };
        } else if (nombreAccion.equals("pagar")) {
            return new AbstractAction(nombreAccion) {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (btnPagarVenta.isEnabled()) {
                        btnPagarVentaActionPerformed(evt);
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

        tableModelDetTicket1 = new pos.stalupita.tablemodels.TableModelDetTicket();
        jpnlFondoGris = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnCambiarCantidad = new javax.swing.JButton();
        btnAgregarProducto = new javax.swing.JButton();
        btnEliminarProduto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCancelarVenta = new javax.swing.JButton();
        btnPagarVenta = new javax.swing.JButton();
        jtxtTotalVenta = new javax.swing.JTextField();
        jtxtCantidadVenta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblDetalleTicket = new javax.swing.JTable();
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

        btnCambiarCantidad.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnCambiarCantidad.setForeground(new java.awt.Color(51, 102, 255));
        btnCambiarCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/shopping-edit-48.png"))); // NOI18N
        btnCambiarCantidad.setText("<html><center><b>Cambiar Cantidad</b> &nbsp<br><font color = blue>(Alt + C)</font> </center></html>");
        btnCambiarCantidad.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnCambiarCantidad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCambiarCantidad.setPreferredSize(new java.awt.Dimension(173, 73));
        btnCambiarCantidad.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCambiarCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarCantidadActionPerformed(evt);
            }
        });

        btnAgregarProducto.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(51, 102, 255));
        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/shopping-add-48.png"))); // NOI18N
        btnAgregarProducto.setText("<html><center><b>Añadir Producto</b> <br><font color = blue>(Alt + F1)</font> </center></html>");
        btnAgregarProducto.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnAgregarProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarProducto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnEliminarProduto.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnEliminarProduto.setForeground(new java.awt.Color(51, 102, 255));
        btnEliminarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/shopping-stop-48.png"))); // NOI18N
        btnEliminarProduto.setText("<html><center><b>Eliminar Producto</b> &nbsp<br><font color = blue>(Alt + E)</font> </center></html>");
        btnEliminarProduto.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnEliminarProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarProduto.setPreferredSize(new java.awt.Dimension(173, 73));
        btnEliminarProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnCambiarCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnEliminarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Venta Actual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 51, 153)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Total $:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Cantidad:");

        btnCancelarVenta.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnCancelarVenta.setForeground(new java.awt.Color(51, 102, 255));
        btnCancelarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/shopping-cancel-48.png"))); // NOI18N
        btnCancelarVenta.setText("<html><center><b>Cancelar Venta</b><br><font color = blue>(Alt + X)</font> </center></html>");
        btnCancelarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVentaActionPerformed(evt);
            }
        });

        btnPagarVenta.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnPagarVenta.setForeground(new java.awt.Color(51, 102, 255));
        btnPagarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/wallet-48.png"))); // NOI18N
        btnPagarVenta.setText("<html><center><b>Pagar Venta</b> &nbsp<br><font color = blue>(Alt + P)</font> </center></html>");
        btnPagarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPagarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPagarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarVentaActionPerformed(evt);
            }
        });

        jtxtTotalVenta.setEditable(false);
        jtxtTotalVenta.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jtxtTotalVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtTotalVenta.setText("0.00");

        jtxtCantidadVenta.setEditable(false);
        jtxtCantidadVenta.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jtxtCantidadVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtCantidadVenta.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtxtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jtxtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnPagarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jtxtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPagarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(btnCancelarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jtblDetalleTicket.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtblDetalleTicket.setModel(tableModelDetTicket1);
        jScrollPane1.setViewportView(jtblDetalleTicket);

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
                .addGap(318, 318, 318)
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlFondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)
                    .addComponent(jpnlFondoVerde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 84, Short.MAX_VALUE))
        );
        jpnlFondoGrisLayout.setVerticalGroup(
            jpnlFondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFondoGrisLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jpnlFondoVerde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpnlFondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpnlFondoGrisLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(41, 107, 189));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        dlgBusquedaProducto.setModal(true);
        dlgBusquedaProducto.setLocationRelativeTo(this);
        dlgBusquedaProducto.setVisible(true);
        if (!this.isNull(dlgBusquedaProducto.getProducto_selecionado()) && !this.isNull(dlgBusquedaProducto.getCantidad_comprada())) {
            this.agregarProducto(dlgBusquedaProducto.getProducto_selecionado(), dlgBusquedaProducto.getCantidad_comprada());
        }
        this.refrescarTotales();
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnCambiarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarCantidadActionPerformed
        if (this.validacionXSeleccion()) {
            this.editarCantidadProducto();
            this.cargarTicketPendiente();
            this.refrescarTotales();
        } else {
            JOptionPane.showMessageDialog(this, "Elige el producto que deseas Editar", "Mensaje del Sistema", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCambiarCantidadActionPerformed
    private void editarCantidadProducto() {        Integer index_selected = this.jtblDetalleTicket.getSelectedRow();
        DetalleTicket detalleTicket = this.getDetailXIndex(index_selected);
        String msg_html = "<html><center>"
                + " Ingresa la nueva cantidad para "
                + "<b>" + detalleTicket.getProducto().getDescripcion() + "</b> "
                + "en " + detalleTicket.getProducto().getUnidadMedida().getDescripcion()
                + "</center></html>";
        JLabel jLabel = new JLabel(msg_html);
        String cantidad_txt = JOptionPane.showInputDialog(null, jLabel, "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
        BigDecimal cantidad_prod = BigDecimal.ZERO;
        try {
            cantidad_prod = new BigDecimal(cantidad_txt);
        } catch (Exception e) {
        }
        if (cantidad_txt.isEmpty() || cantidad_prod.compareTo(BigDecimal.ZERO) < 1) {//se ingreso una cantidad erronea
            JOptionPane.showMessageDialog(this, "La cantidad para el producto " + detalleTicket.getProducto().getDescripcion()
                    + " debe ser un numero valido y mayor a cero", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
        } else {
            this.agruparProducto(detalleTicket, cantidad_prod);
        }
    }

    public DetalleTicket getDetailXIndex(Integer index) {
        return this.tableModelDetTicket1.get(index);
    }

    private boolean validacionXSeleccion() {
        Integer index_selected = this.jtblDetalleTicket.getSelectedRow();
        return index_selected != -1;
    }


    private void btnEliminarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProdutoActionPerformed
        if (this.validacionXSeleccion()) {
            this.refrescarTotales();
        } else {
            JOptionPane.showMessageDialog(this, "Elige el producto que deseas Eliminar", "Mensaje del Sistema", JOptionPane.WARNING_MESSAGE);
        }
        this.refrescarTotales();
    }//GEN-LAST:event_btnEliminarProdutoActionPerformed

    private void btnCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVentaActionPerformed
        this.refrescarTotales();
    }//GEN-LAST:event_btnCancelarVentaActionPerformed

    private void btnPagarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarVentaActionPerformed
        this.refrescarTotales();
    }//GEN-LAST:event_btnPagarVentaActionPerformed

    @Override
    public void setVisible(boolean b) {
        this.jtblDetalleTicket.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
        this.cargarTicketPendiente();
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnCambiarCantidad;
    private javax.swing.JButton btnCancelarVenta;
    private javax.swing.JButton btnEliminarProduto;
    private javax.swing.JButton btnPagarVenta;
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
    private javax.swing.JTable jtblDetalleTicket;
    private javax.swing.JTextField jtxtCantidadVenta;
    private javax.swing.JTextField jtxtTotalVenta;
    private pos.stalupita.tablemodels.TableModelDetTicket tableModelDetTicket1;
    // End of variables declaration//GEN-END:variables

    private void agruparProducto(DetalleTicket agregadoDetalle, BigDecimal nueva_cantidad) {
        BigDecimal total_vendido = agregadoDetalle.getProducto().getPrecio().multiply(nueva_cantidad).setScale(2, RoundingMode.HALF_UP);//total_vendido
        BigDecimal total_comprado = agregadoDetalle.getProducto().getCosto().multiply(nueva_cantidad).setScale(2, RoundingMode.HALF_UP);//total_costo
        BigDecimal total_ganado = total_vendido.subtract(total_comprado).setScale(2, RoundingMode.HALF_UP);//total_ganancia

        agregadoDetalle.setTicket(this.getTicketActivo());
        agregadoDetalle.setCantidad(nueva_cantidad);
        agregadoDetalle.setTotal(total_vendido);
        agregadoDetalle.setGanancia(total_ganado);

        this.ticketController.actualizarDet(agregadoDetalle);
    }

    private void agregarProducto(Producto producto_selecionado, BigDecimal cantidad_comprada) {
        Ticket ticket_pendiente = this.getTicketActivo();
        List<DetalleTicket> lista_detalles = this.ticketController.getDetfFromTckt(ticket_pendiente.getIdticket());
        DetalleTicket nuevoDetalle = this.getNuevoDetalle(producto_selecionado, cantidad_comprada);
        if (lista_detalles.contains(nuevoDetalle)) {//si esta en la lisa ->agrupa
            int index_list = lista_detalles.indexOf(nuevoDetalle);
            DetalleTicket agregadoDetalle = lista_detalles.get(index_list);
            this.agruparProducto(agregadoDetalle, nuevoDetalle);
        } else {
            this.ticketController.guardarDetalleTicket(nuevoDetalle);
        }
        lista_detalles = this.ticketController.getDetfFromTckt(ticket_pendiente.getIdticket());
        this.tableModelDetTicket1.change(new ArrayList<DetalleTicket>());
        this.tableModelDetTicket1.change(lista_detalles);
    }

    private void agruparProducto(DetalleTicket agregadoDetalle, DetalleTicket nuevoDetalle) {

        BigDecimal cantidad_final = agregadoDetalle.getCantidad().add(nuevoDetalle.getCantidad()).setScale(2, RoundingMode.HALF_UP);
        BigDecimal total_final = agregadoDetalle.getTotal().add(nuevoDetalle.getTotal()).setScale(2, RoundingMode.HALF_UP);
        BigDecimal ganancial_final = agregadoDetalle.getGanancia().add(nuevoDetalle.getGanancia()).setScale(2, RoundingMode.HALF_UP);

        agregadoDetalle.setCantidad(cantidad_final);
        agregadoDetalle.setTotal(total_final);
        agregadoDetalle.setGanancia(ganancial_final);
        this.ticketController.actualizarDet(agregadoDetalle);
    }

    private DetalleTicket getNuevoDetalle(Producto producto_selecionado, BigDecimal cantidad_comprada) {
        BigDecimal total_vendido = producto_selecionado.getPrecio().multiply(cantidad_comprada).setScale(2, RoundingMode.HALF_UP);//total_vendido
        BigDecimal total_comprado = producto_selecionado.getCosto().multiply(cantidad_comprada).setScale(2, RoundingMode.HALF_UP);//total_costo
        BigDecimal total_ganado = total_vendido.subtract(total_comprado).setScale(2, RoundingMode.HALF_UP);//total_ganancia

        DetalleTicket nuevo_det = new DetalleTicket();
        nuevo_det.setTicket(this.getTicketActivo());
        nuevo_det.setProducto(producto_selecionado);
        nuevo_det.setPrecio(producto_selecionado.getPrecio());
        nuevo_det.setCantidad(cantidad_comprada);
        nuevo_det.setTotal(total_vendido);
        nuevo_det.setGanancia(total_ganado);
        return nuevo_det;
    }

    private Ticket getTicketActivo() {
        Ticket ticketActivo = this.ticketController.getTicketActivo();
        if (this.isNull(ticketActivo)) {//si es null se crea nuevo ticket
            ticketActivo = new Ticket();
            ticketActivo.setIdticket(0);
            ticketActivo.setTotal(BigDecimal.ZERO);
            ticketActivo.setGanancia(BigDecimal.ZERO);
            ticketActivo.setPago(BigDecimal.ZERO);
            ticketActivo.setCambio(BigDecimal.ZERO);
            ticketActivo.setFechaRegistrado(new Date());
            ticketActivo.setPagado(false);
            ticketActivo.setEstado(true);
            this.ticketController.guardarTicket(ticketActivo);
            ticketActivo = this.ticketController.getTicketActivo();
        }
        return ticketActivo;
    }

    public void cargarTicketPendiente() {
        Ticket ticketActivo = this.ticketController.getTicketActivo();
        if (this.isNull(ticketActivo)) {//si es null se crea nuevo ticket
            ticketActivo = new Ticket();
            ticketActivo.setIdticket(0);
            ticketActivo.setTotal(BigDecimal.ZERO);
            ticketActivo.setGanancia(BigDecimal.ZERO);
            ticketActivo.setPago(BigDecimal.ZERO);
            ticketActivo.setCambio(BigDecimal.ZERO);
            ticketActivo.setFechaRegistrado(new Date());
            ticketActivo.setPagado(false);
            ticketActivo.setEstado(true);
            this.ticketController.guardarTicket(ticketActivo);
            ticketActivo = this.ticketController.getTicketActivo();
        }
        List<DetalleTicket> lista_detalles = this.ticketController.getDetfFromTckt(ticketActivo.getIdticket());
        this.tableModelDetTicket1.change(lista_detalles);
        this.refrescarTotales();
    }

    private boolean isNull(Object object) {
        return object == null;
    }

    private void refrescarTotales() {
        List<DetalleTicket> detalles = this.tableModelDetTicket1.serialize();
        BigDecimal total = BigDecimal.ZERO;
        for (DetalleTicket detalle : detalles) {
            total = total.add(detalle.getTotal()).setScale(2, RoundingMode.HALF_UP);;
        }
        this.jtxtTotalVenta.setText(total.toString());
        this.jtxtCantidadVenta.setText(String.valueOf(detalles.size()));
    }
}
