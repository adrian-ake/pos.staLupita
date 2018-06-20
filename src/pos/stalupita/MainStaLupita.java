/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita;

import java.awt.Color;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import pos.stalupita.herramientas.SpringContextLoad;
import pos.stalupita.view.DlgInicio;
import pos.stalupita.view.DlgPrincipal;

/**
 *
 * @author adrian.ake
 */
public class MainStaLupita {

    public static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(MainStaLupita.class.getName());
    private DlgInicio dlgInicio = new DlgInicio(null, true);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainStaLupita posStaLupita = new MainStaLupita();
        posStaLupita.lanzarInicio();
        System.exit(0);//para no forzar el cierre del programa
    }

    private void lanzarInicio() {
        this.addLaF();
        new Thread(new HiloPresentacion()).start();
        DlgPrincipal dashPrincipal = SpringContextLoad.getContext().getBean(DlgPrincipal.class);
        dlgInicio.setVisible(false);
        dlgInicio.dispose();
        dashPrincipal.setLocationRelativeTo(null);
        dashPrincipal.setVisible(true);
    }

    public void addLaF() {
        try {
            UIDefaults defaults = UIManager.getLookAndFeelDefaults();
            if (defaults.get("Table.alternateRowColor") == null) {
                defaults.put("Table.alternateRowColor", new Color(240, 240, 240));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    class HiloPresentacion implements Runnable {

        @Override
        public void run() {
            this.lanzarPresentacion();
        }

        private void lanzarPresentacion() {
            dlgInicio.setLocationRelativeTo(null);
            dlgInicio.setAlwaysOnTop(true);
            dlgInicio.setVisible(true);
        }
    }
}
