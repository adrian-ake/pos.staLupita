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

/**
 *
 * @author adrian.ake
 */
public class PosStaLupita {
    
    public static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(PosStaLupita.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PosStaLupita posStaLupita = new PosStaLupita();
        posStaLupita.lanzarInicio();
        System.exit(1);
    }
    
    private void lanzarInicio() {
        JdlgPrincipal dashPrincipal = SpringContextLoad.getContext().getBean(JdlgPrincipal.class);
        Rectangle maxBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        dashPrincipal.setBounds(maxBounds);
        dashPrincipal.setVisible(true);
    }
    
}
