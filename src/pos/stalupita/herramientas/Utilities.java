/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.herramientas;

import javax.swing.ImageIcon;

/**
 *
 * @author Adrian Alonso Aké Ek
 */
public class Utilities {

    private static final String ICONO_VENTANAS = "/pos/stalupita/view/resources/pos_icon.png";
    public static final String TITULO_VENTANAS = "Alimentos y Herbicidas Sta Lupita";
    public static final String VERSION_SISTEMA = "V1.0.0";

    public static void setFrameIcon(javax.swing.JFrame frame) {
        if (frame == null) {
            return;
        }
        frame.setTitle(getTituloVtanas());
        frame.setIconImage(new ImageIcon(frame.getClass().getResource(ICONO_VENTANAS)).getImage());
    }

    public static void setDialogIcon(javax.swing.JDialog dialog) {
        if (dialog == null) {
            return;
        }
        dialog.setTitle(getTituloVtanas());
        dialog.setIconImage(new ImageIcon(dialog.getClass().getResource(ICONO_VENTANAS)).getImage());
        dialog.setResizable(false);
    }

    public static ImageIcon getImageIcon() {
        return new ImageIcon(Utilities.class.getResource(ICONO_VENTANAS));
    }

    public static String getTituloVtanas() {
        return Utilities.TITULO_VENTANAS + " " + Utilities.VERSION_SISTEMA;
    }
}
