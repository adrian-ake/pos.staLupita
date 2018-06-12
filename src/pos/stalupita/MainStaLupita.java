/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import pos.stalupita.herramientas.SpringContextLoad;
import pos.stalupita.view.JdlgPrincipal;
import pos.stalupita.view.jFrmMain;

/**
 *
 * @author adrian.ake
 */
public class MainStaLupita {

    public static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(MainStaLupita.class.getName());
    private jFrmMain frmPrincipal = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainStaLupita posStaLupita = new MainStaLupita();
        posStaLupita.lanzarInicio();
        System.exit(1);
    }

    private void lanzarInicio() {
        JdlgPrincipal dashPrincipal = SpringContextLoad.getContext().getBean(JdlgPrincipal.class);
        new JdlgPrincipal(this.getFrmPrincipal(), true);
        Rectangle maxBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        dashPrincipal.setLocationRelativeTo(this.getFrmPrincipal());
        dashPrincipal.setBounds(maxBounds);
        dashPrincipal.setVisible(true);
    }

    public jFrmMain getFrmPrincipal() {
        if (frmPrincipal == null) {
            frmPrincipal = SpringContextLoad.getContext().getBean(jFrmMain.class);
            frmPrincipal.setLocationRelativeTo(null);
        }
        return frmPrincipal;
    }
}
