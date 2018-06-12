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
    private static final String TITULO_VENTANAS = "Alimentos y Herbicidas Sta Lupita";

    public static void setFrameIcon(javax.swing.JFrame frame) {
        if (frame == null) {
            return;
        }
        frame.setTitle(TITULO_VENTANAS);
        frame.setIconImage(new ImageIcon(frame.getClass().getResource(ICONO_VENTANAS)).getImage());
    }

    public static void setDialogIcon(javax.swing.JDialog dialog) {
        if (dialog == null) {
            return;
        }
        dialog.setTitle(TITULO_VENTANAS);
        dialog.setIconImage(new ImageIcon(dialog.getClass().getResource(ICONO_VENTANAS)).getImage());
        dialog.setResizable(false);
    }

    public static ImageIcon getImageIcon() {
        return new ImageIcon(Utilities.class.getResource(ICONO_VENTANAS));
    }
}
