/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita;

import com.jtattoo.plaf.smart.SmartLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.util.Properties;
import javax.swing.UIManager;
import pos.stalupita.herramientas.SpringContextLoad;
import pos.stalupita.view.DlgPrincipal;
import pos.stalupita.view.FrmMain;

/**
 *
 * @author adrian.ake
 */
public class MainStaLupita {

    public static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(MainStaLupita.class.getName());
    private FrmMain frmPrincipal = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainStaLupita posStaLupita = new MainStaLupita();
        posStaLupita.lanzarInicio();
        System.exit(1);
    }

    private void lanzarInicio() {
        this.addLaF();
        DlgPrincipal dashPrincipal = SpringContextLoad.getContext().getBean(DlgPrincipal.class);
        new DlgPrincipal(this.getFrmPrincipal(), true);
        Rectangle maxBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        dashPrincipal.setLocationRelativeTo(this.getFrmPrincipal());
        dashPrincipal.setBounds(maxBounds);
        dashPrincipal.setVisible(true);
    }

    public FrmMain getFrmPrincipal() {
        if (frmPrincipal == null) {
            frmPrincipal = SpringContextLoad.getContext().getBean(FrmMain.class);
            frmPrincipal.setLocationRelativeTo(null);
        }
        return frmPrincipal;
    }

    public void addLaF() {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");         
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
