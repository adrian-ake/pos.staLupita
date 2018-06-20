/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.view;

import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
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

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DlgPrincipal.class.getName());

    @Resource
    private DlgRegistrar_prod jdlgRegistrar_prod;
    @Resource
    private DlgAdminProductos dlgAdminProductos;
    @Resource
    private DlgBusquedaProducto dlgBusquedaProducto;
    @Resource
    private DlgPago dlgPago;
    @Resource
    private DlgVentas dlgVentas;
    @Resource
    private TicketController ticketController;

    @Autowired
    public DlgPrincipal(TicketController ticketController) {
        super(null, ModalityType.APPLICATION_MODAL);
        initComponents();
        Dimension dimension_venta = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(dimension_venta);
        Utilities.setDialogIcon(this);
        this.cargarConfigsVtana();
        this.setMnemonic();
        this.ticketController = ticketController;        
        this.getContentPane().setBackground(new java.awt.Color(149, 163, 190));
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
        jPanel1 = new javax.swing.JPanel();
        btnCambiarCantidad = new javax.swing.JButton();
        btnAgregarProducto = new javax.swing.JButton();
        btnEliminarProduto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblDetalleTicket = new javax.swing.JTable();
        jpnlFondoVerde = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnPagarVenta = new javax.swing.JButton();
        btnCancelarVenta = new javax.swing.JButton();
        jlblCantidadVenta = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlblTotalVenta = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Sistema- V1.0.0");
        setBackground(new java.awt.Color(149, 163, 190));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(245, 246, 250));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(0), "Opciones Venta", 1, 0, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 51, 153))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        btnCambiarCantidad.setBackground(new java.awt.Color(255, 255, 255));
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

        btnAgregarProducto.setBackground(new java.awt.Color(255, 255, 255));
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

        btnEliminarProduto.setBackground(new java.awt.Color(255, 255, 255));
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
                    .addComponent(btnCambiarCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminarProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCambiarCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(4, 151, 135));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(4, 151, 135), 5, true));

        jtblDetalleTicket.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtblDetalleTicket.setModel(tableModelDetTicket1);
        jScrollPane1.setViewportView(jtblDetalleTicket);

        jpnlFondoVerde.setBackground(new java.awt.Color(4, 151, 135));
        jpnlFondoVerde.setBorder(new javax.swing.border.SoftBevelBorder(0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Punto de Venta");

        btnSalir.setBackground(new java.awt.Color(4, 151, 135));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/stalupita/view/resources/check-out-32.png"))); // NOI18N
        btnSalir.setToolTipText("Salir del Programa");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlFondoVerdeLayout = new javax.swing.GroupLayout(jpnlFondoVerde);
        jpnlFondoVerde.setLayout(jpnlFondoVerdeLayout);
        jpnlFondoVerdeLayout.setHorizontalGroup(
            jpnlFondoVerdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFondoVerdeLayout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 313, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        jpnlFondoVerdeLayout.setVerticalGroup(
            jpnlFondoVerdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFondoVerdeLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jpnlFondoVerdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(245, 246, 250));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(0), "Opciones Venta", 1, 0, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 51, 153))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        btnPagarVenta.setBackground(new java.awt.Color(255, 255, 255));
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

        btnCancelarVenta.setBackground(new java.awt.Color(255, 255, 255));
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

        jlblCantidadVenta.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        jlblCantidadVenta.setText("0.00");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Cantidad:");

        jlblTotalVenta.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        jlblTotalVenta.setText("0.00");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Total:  $");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jlblCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnCancelarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPagarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPagarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jlblTotalVenta)
                            .addComponent(jlblCantidadVenta))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(33, 32, 64));
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
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jpnlFondoVerde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jpnlFondoVerde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirSistema() {
        String msg_html = "<html><center>"
                + "<b>¿Está seguro que desea salir?</b> "
                + "</center></html>";
        JLabel jLabel = new JLabel(msg_html);
        if (JOptionPane.showConfirmDialog(null, jLabel, "Mensaje del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            this.dispose();
        }
    }

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        this.salirSistema();
    }//GEN-LAST:event_closeDialog

    private void jmitemRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemRegistrarActionPerformed
        this.jdlgRegistrar_prod.setModal(true);
        this.jdlgRegistrar_prod.setLocationRelativeTo(null);
        this.jdlgRegistrar_prod.setTitulo("Registrar Producto");
        this.jdlgRegistrar_prod.resetDatos();
        this.jdlgRegistrar_prod.setVisible(true);
    }//GEN-LAST:event_jmitemRegistrarActionPerformed

    private void jmitemventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemventasActionPerformed
        this.dlgVentas.setModal(true);
        this.dlgVentas.setLocationRelativeTo(null);
        this.dlgVentas.setVisible(true);
    }//GEN-LAST:event_jmitemventasActionPerformed

    private void jmitemAdministrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmitemAdministrarActionPerformed
        dlgAdminProductos.setModal(true);
        dlgAdminProductos.setLocationRelativeTo(null);
        dlgAdminProductos.setVisible(true);
    }//GEN-LAST:event_jmitemAdministrarActionPerformed
    private void editarCantidadProducto() {
        Integer index_selected = this.jtblDetalleTicket.getSelectedRow();
        DetalleTicket detalleTicket = this.getDetailXIndex(index_selected);
        String msg_html = "<html><center>"
                + " Ingresa la cantidad para "
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
        if (cantidad_txt != null && cantidad_txt.isEmpty() || cantidad_prod.compareTo(BigDecimal.ZERO) < 1) {//se ingreso una cantidad erronea
            msg_html = "<html><center>"
                    + " La cantidad para el producto "
                    + "<b>" + detalleTicket.getProducto().getDescripcion() + "</b> "
                    + " debe ser un numero valido y mayor a cero "
                    + "</center></html>";
            jLabel = new JLabel(msg_html);
            JOptionPane.showMessageDialog(this, jLabel, "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
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

    private void eliminarDetalle() {
        Integer index_selected = this.jtblDetalleTicket.getSelectedRow();
        DetalleTicket detalleTicket = this.getDetailXIndex(index_selected);
        String msg_html = "<html><center>"
                + " ¿Está seguro que desea Eliminar el producto"
                + "<b>" + detalleTicket.getProducto().getDescripcion() + "</b>? "
                + "</center></html>";
        JLabel jLabel = new JLabel(msg_html);

        if (JOptionPane.showConfirmDialog(null, jLabel, "Mensaje del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
            this.ticketController.eliminarDetalle(detalleTicket);
            JOptionPane.showMessageDialog(this, "El producto ha sido eliminado de la venta", "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void btnCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVentaActionPerformed
        String msg_html = "<html><center>"
                + "<b>¿Está seguro que desea cancelar la venta actual?</b> "
                + "</center></html>";
        JLabel jLabel = new JLabel(msg_html);

        if (JOptionPane.showConfirmDialog(null, jLabel, "Mensaje del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
            this.cancelarTicket();
            JOptionPane.showMessageDialog(this, "El ticket actual ha sido cancelado", "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
            this.cargarTicketPendiente();
            this.refrescarTotales();
        }

    }//GEN-LAST:event_btnCancelarVentaActionPerformed

    private void btnPagarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarVentaActionPerformed
        if (!this.tableModelDetTicket1.isEmpty()) {
            dlgPago.setModal(true);
            dlgPago.setLocationRelativeTo(null);
            dlgPago.setDatos(this.getTicketTotalizado());
            dlgPago.setVisible(true);
            this.cargarTicketPendiente();
            this.refrescarTotales();
        } else {
            JOptionPane.showMessageDialog(this, "No puedes pagar una venta sin productos", "Mensaje del Sistema", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnPagarVentaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.salirSistema();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEliminarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProdutoActionPerformed
        if (this.validacionXSeleccion()) {
            this.eliminarDetalle();
            this.refrescarTotales();
            this.cargarTicketPendiente();
        } else {
            JOptionPane.showMessageDialog(this, "Elige el producto que deseas Eliminar", "Mensaje del Sistema", JOptionPane.WARNING_MESSAGE);
        }
        this.refrescarTotales();
    }//GEN-LAST:event_btnEliminarProdutoActionPerformed

    private void btnCambiarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarCantidadActionPerformed
        if (this.validacionXSeleccion()) {
            this.editarCantidadProducto();
            this.cargarTicketPendiente();
            this.refrescarTotales();
        } else {
            JOptionPane.showMessageDialog(this, "Elige el producto que deseas Editar", "Mensaje del Sistema", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCambiarCantidadActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        dlgBusquedaProducto.setModal(true);
        dlgBusquedaProducto.setLocationRelativeTo(null);
        dlgBusquedaProducto.setVisible(true);
        if (!this.isNull(dlgBusquedaProducto.getProducto_selecionado()) && !this.isNull(dlgBusquedaProducto.getCantidad_comprada())) {
            this.agregarProducto(dlgBusquedaProducto.getProducto_selecionado(), dlgBusquedaProducto.getCantidad_comprada());
        }
        this.refrescarTotales();
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void cancelarTicket() {
        try {
            Ticket ticket_cancelar = this.getTicketCancel();
            this.ticketController.actualizarTckt(ticket_cancelar);
        } catch (Exception e) {
            log.error("error al tratar de cancelar el ticket de venta", e);
        }
    }

    private Ticket getTicketCancel() {
        Ticket ticket_totalizado = this.getTicketActivo();
        ticket_totalizado.setPagado(false);
        ticket_totalizado.setEstado(false);
        ticket_totalizado.setFechaCancelado(new Date());
        return ticket_totalizado;
    }

    private Ticket getTicketTotalizado() {
        Ticket ticket_totalizado = this.getTicketActivo();
        ticket_totalizado.setTotal(new BigDecimal(this.jlblTotalVenta.getText()));
        ticket_totalizado.setGanancia(this.getGanancia());
        return ticket_totalizado;
    }

    private BigDecimal getGanancia() {
        BigDecimal ganancia = BigDecimal.ZERO;
        List<DetalleTicket> detalles_venta = this.tableModelDetTicket1.serialize();
        for (DetalleTicket detalles_venta1 : detalles_venta) {
            ganancia = ganancia.add(detalles_venta1.getGanancia()).setScale(2, RoundingMode.HALF_UP);
        }
        return ganancia;
    }

    @Override
    public void setVisible(boolean b) {
        this.jtblDetalleTicket.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
        this.cargarTicketPendiente();
        cargarComponentes();
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
    }

    private void cargarComponentes() {
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int width = (int) screenSize.getWidth();
//        int height = (int) screenSize.getHeight();
////        width = (int) (width - (width / 1.5));
//        height = height - (height / 2);
//        setSize(width, height);
//        this.jpnlFondoGris.setSize(width, height);
//        this.pack();   
//        this.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
//        this.jpnlFondoGris.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
//        this.jpnlFondoGris.setSize(screenSize);
//        this.pack();   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnCambiarCantidad;
    private javax.swing.JButton btnCancelarVenta;
    private javax.swing.JButton btnEliminarProduto;
    private javax.swing.JButton btnPagarVenta;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlblCantidadVenta;
    private javax.swing.JLabel jlblTotalVenta;
    private javax.swing.JMenuItem jmitemAdministrar;
    private javax.swing.JMenuItem jmitemCompras;
    private javax.swing.JMenuItem jmitemGrafCompras;
    private javax.swing.JMenuItem jmitemGrafVentas;
    private javax.swing.JMenuItem jmitemInventario;
    private javax.swing.JMenuItem jmitemRegistrar;
    private javax.swing.JMenuItem jmitemStock;
    private javax.swing.JMenuItem jmitemventas;
    private javax.swing.JPanel jpnlFondoVerde;
    private javax.swing.JTable jtblDetalleTicket;
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
        this.tableModelDetTicket1.change(new ArrayList<DetalleTicket>());
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
        this.jlblTotalVenta.setText(total.toString());
        this.jlblCantidadVenta.setText(String.valueOf(detalles.size()));
    }
}
