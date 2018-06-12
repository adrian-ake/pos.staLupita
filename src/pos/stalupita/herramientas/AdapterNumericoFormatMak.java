package pos.stalupita.herramientas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author adrian.ake
 */
public class AdapterNumericoFormatMak extends KeyAdapter {

    private JTextField txtNumero;
    private boolean conPunto;
    private char puntoDecimal = '.';
    private String regex;
    private int longitudEnteros;
    private int longitudDecimal;
    private boolean isConsumed = false;

    public AdapterNumericoFormatMak(JTextField numero, int longitudEnteros,
            int longitudDecimales) {
        super();
        txtNumero = numero;
        this.longitudEnteros = longitudEnteros;
        this.longitudDecimal = longitudDecimales;
        if (longitudDecimales > 0) {
            conPunto = true;
            this.regex = "\\d*\\.\\d{" + longitudDecimales + "}";
        } else {
            conPunto = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Si el evento fue consumido en el KeyPressed no permite visualizarlo en el JTextComponent
        if (isConsumed) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT
                || e.getKeyCode() == KeyEvent.VK_HOME || e.getKeyCode() == KeyEvent.VK_END
                || e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_ESCAPE
                || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN
                || e.getKeyCode() == KeyEvent.VK_F1 || e.isAltDown()
                || e.getKeyCode() == KeyEvent.VK_PAGE_UP || e.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            //deja pasar el evento
            return;
        }
        char tecla = e.getKeyChar();
        double maximo = 0;
        double numero = 0;
        isConsumed = false;
        String inicioString = "";

        try {
            //Si no es texto vacio
            if (!txtNumero.getText().trim().isEmpty()) {
                //Si texto es diferende de punto decimal (".")
                if (!txtNumero.getText().trim().equals(".")) {
                    Double valorActual = Double.parseDouble(txtNumero.getText());
                    //Si valorActual == 0 y no contiene punto decimal => limpia el JTextComponent
                    if (valorActual.equals(0.0) && !txtNumero.getText().contains(".")) {
                        txtNumero.setText("");
                    }
                }
            }
            //Capta el String concatenando la tecla actual
            inicioString = getTextAfterEvent(e, inicioString);
            maximo = Double.parseDouble(retornaMaximo());
            numero = Double.parseDouble(inicioString);
        } catch (NumberFormatException ex) {
        }

        if (inicioString.length() == 0 && tecla == '0') {
            consumeEvento(e);
        }

        if (conPunto && !validaDecimal(inicioString)) {
            consumeEvento(e);
        }

        if (maximo <= numero) {
            consumeEvento(e);
        }

        if (conPunto && (tecla == puntoDecimal)) {
            if (txtNumero.getText().contains("" + puntoDecimal)) {
                consumeEvento(e);
            }
        } else {
            if ("0123456789".indexOf(tecla) == -1) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
                    //no hace nada
                } else {
                    consumeEvento(e);
                }
            }
        }
    }

    private String retornaMaximo() {
        BigDecimal d = new BigDecimal(10);
        d = d.pow(longitudEnteros);
        return d.toString();
    }

    private boolean validaDecimal(String id) {
        boolean valido = true;
        Pattern pc = Pattern.compile("\\d*");
        Matcher m = pc.matcher(id);
        valido = m.matches();
        if (!valido) {
            pc = Pattern.compile("\\d*\\.");
            m = pc.matcher(id);
            valido = m.matches();
        }
        if (!valido) {
            for (int c = 1; c < longitudDecimal + 1; c++) {
                if (!valido) {
                    pc = Pattern.compile("\\d*\\.\\d{" + c + "}");
                    m = pc.matcher(id);
                    valido = m.matches();
                } else {
                    break;
                }
            }
        }
        return valido;
    }

    private void consumeEvento(KeyEvent e) {
        isConsumed = true;
        e.consume();
    }

    private String getTextAfterEvent(KeyEvent e, String inicioString) {
        String finalString = "";
        //Si el texto (en JTextComponent) esta seleccionado y se oprime la tecla DELETE o BACK_SPACE
        if (txtNumero.getSelectedText() != null
                && (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE)) {
            //Texto actual
            inicioString = txtNumero.getText();
            finalString = txtNumero.getText();
            //texto NO seleccionado
            inicioString = inicioString.substring(0, txtNumero.getSelectionStart());
            finalString = finalString.substring(txtNumero.getSelectionEnd(), txtNumero.getText().length());
            inicioString = inicioString + finalString;
        } else if (txtNumero.getSelectedText() != null) { //Cuando se tiene seleccionado texto y se desea escribir
            //Texto actual
            inicioString = txtNumero.getText();
            finalString = txtNumero.getText();
            //texto NO seleccionado
            inicioString = inicioString.substring(0, txtNumero.getSelectionStart());
            finalString = finalString.substring(txtNumero.getSelectionEnd(), txtNumero.getText().length());
            inicioString = inicioString + e.getKeyChar() + finalString;
        } else {
            //Posición del cursor en el JTextComponent
            int caretPosition = txtNumero.getCaretPosition();
            //String que contiene el principio del texto en el JTextComponent hasta donde se localiza el cursor
            inicioString = txtNumero.getText().substring(0, caretPosition);
            //Si longitud de texto en JTextComponent es mayor a la posicion de cursor
            if (txtNumero.getText().length() > caretPosition) {
                finalString = txtNumero.getText().substring(caretPosition, txtNumero.getText().length());
            }
            //Une el nuevo valor tecleado
            //Si la tecla fue BACK_SPACE, elimina el último caracter del string inicioString
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                if (inicioString.length() > 0) {
                    inicioString = inicioString.substring(0, caretPosition - 1);
                } else {
                    inicioString = "";
                }
                inicioString = inicioString + finalString;
            } //Si la tecla fue DELETE, elimina el primer caracter del string finalString
            else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                if (finalString.length() > 1) {
                    finalString = finalString.substring(1, finalString.length());
                } else {
                    finalString = "";
                }
                inicioString = inicioString + finalString;
            } else {
                //une todo el String actual agregando el nuevo valor tecleado
                inicioString = inicioString + e.getKeyChar() + finalString;
            }
        }
        return inicioString;
    }
}
