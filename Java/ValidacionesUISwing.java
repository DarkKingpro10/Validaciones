package application.utils;

//Importamos las librerias a usar

import java.awt.Event;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 * Estas Validaciones solo funcionan con JavaSWing
 */

/**
 *
 * @author Jesus Gerardo alias DarkKingpro10
 */
public class ValidacionesUISwing {

    /**
     * Metodo que evita pegar en los campos de texto
     *
     * @param componente Un arreglo de JComponents
     */
    //Creamos metodo que evite copiar pero todos los componentes de un apartado */
    public void noPegar(JComponent[] componente) {
        //Recorremos el arreglo y asiganamos sus variables a otro
        for (JComponent campo : componente) {
            InputMap mapa = ((JComponent) campo).getInputMap(campo.WHEN_FOCUSED);
            //Asiganamos al mapa las restricciones
            mapa.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
            mapa.put(KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, Event.SHIFT_MASK), null);
        }
    }

    //Creamos metodo que evite copiar pero todos los componentes de un apartado
    public void noCopiar(JComponent[] componente) {
        //Recorremos el arreglo y asiganamos sus variables a otro
        for (JComponent campo : componente) {
            //Creamos un objeto de tipo input Map y asignamos el componente
            InputMap mapa = ((JComponent) campo).getInputMap();
            //Añadimos las restricciones al mapa
            mapa.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK), "null");
        }
    }

    /**
     * Los anteriores métodos se usan de la siguiente forma:
     * //Importando Validaciones
        ValidacionesUISwing validaciones = new ValidacionesUISwing();
        //Validaciones
        JComponent[] componentesAValidar = {txtNombre, txtPrecio, txtTiempoEMn}; //Aquí se crea un arreglo de los componentes que se desea validar
        validaciones.noPegar(componentesAValidar);
     */


    /**
     * Los métodos a continuación deberán aplicarse dentro de los eventos keyTyped, keyUp o KeyDown según se necesite ejemplo:
     * 
     *  private void txtCantidadLstKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadLstKeyTyped
            validaciones.soloNumeros(evt, 1, txtPrecio.getText());
        }
     */
    //Creamos metodo que valide solo numeros
    public void soloNumeros(KeyEvent evt, int opcion, String txt) {
        char c = evt.getKeyChar();
        //Creamos un switch que evalue las opciones
        switch (opcion) {
            case 1://Solo numeros
                //Validamos que la primera entrada no sea el espacio
                if (Character.isSpaceChar(c) && txt.equals("")) {
                    evt.consume();
                } else {
                    //Como no es realizamos la validacion original
                    if (c < '0' || c > '9') {
                        evt.consume();
                    }
                }
                break;
            case 2://Solo numeros y espacio
                //Validamos que la primera entrada no sea el espacio
                if (Character.isSpaceChar(c) && txt.equals("")) {
                    evt.consume();
                } else {
                    //Como no lo es validamos solo números y espacio
                    if (!Character.isDigit(c) && !Character.isSpaceChar(c)) {
                        evt.consume();
                    }
                }
                break;
            case 3://Solo numeros y guion
                //Validamos que la primera entrada no sea el espacio
                if (Character.isSpaceChar(c) && txt.equals("")) {
                    evt.consume();
                } else {
                    //Como no es realizamos la validacion original
                    char[] p = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-'};
                    int co = 0;
                    String s = txt, f = "-";
                    char d = f.charAt(0);
                    for (int i = 0; i <= 10; i++) {
                        if (p[i] == evt.getKeyChar()) {
                            co = 1;
                        }
                        if (s.contains("-") && d == evt.getKeyChar()) {
                            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
                        }
                    }
                    if (co == 0) {
                        evt.consume();
                    }
                }
                break;
            case 4: //Validar numeros y guion y espacio
                //Validamos que la primera entrada no sea el espacio
                if (Character.isSpaceChar(c) && txt.equals("")) {
                    evt.consume();
                } else {
                    //Como no es realizamos la validacion original
                    char[] p = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-'};
                    int co = 0;
                    String s = txt, f = "-";
                    char d = f.charAt(0);
                    for (int i = 0; i <= 10; i++) {
                        if (p[i] == evt.getKeyChar() || Character.isSpaceChar(c)) {
                            co = 1;
                        }
                        if (s.contains("-") && d == evt.getKeyChar()) {
                            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
                        }
                    }
                    if (co == 0) {
                        evt.consume();
                    }
                }
                break;
            case 5://Validamos que solo se permitan numeros y puntos
                //Validamos que la primera entrada no sea el espacio
                if (Character.isSpaceChar(c) && txt.equals("")) {
                    evt.consume();
                } else {
                    //Como no es realizamos la validacion original
                    char[] p = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.'};
                    int co = 0;
                    String s = txt, f = ".";
                    char d = f.charAt(0);
                    for (int i = 0; i <= 10; i++) {
                        if (p[i] == evt.getKeyChar()) {
                            co = 1;
                        }
                        if (s.contains(".") && d == evt.getKeyChar()) {
                            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
                        }
                    }
                    if (co == 0) {
                        evt.consume();
                    }
                }
                break;
            case 6://Validamos que permitan numeros, puntos y espacio
                //Validamos que la primera entrada no sea el espacio
                if (Character.isSpaceChar(c) && txt.equals("")) {
                    evt.consume();
                } else {
                    //Como no es realizamos la validacion original
                    char[] p = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.'};
                    int co = 0;
                    String s = txt, f = ".";
                    char d = f.charAt(0);
                    for (int i = 0; i <= 10; i++) {
                        if (p[i] == evt.getKeyChar() || Character.isSpaceChar(c)) {
                            co = 1;
                        }
                        if (s.contains(".") && d == evt.getKeyChar()) {
                            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
                        }
                    }
                    if (co == 0) {
                        evt.consume();
                    }
                }
                break;
            default:
            //No se hace nada y se pone solo para evitar errores
        }
    }

    //Creamos metodo para validar solo letras 
    public void soloLetras(KeyEvent evt, int opcion, String txt) {
        char c = evt.getKeyChar();
        //Creamos un switch que evalue las opciones
        switch (opcion) {
            case 1://Solo letras
                //Validamos que la primera entrada no sea el espacio
                if (Character.isSpaceChar(c) && txt.equals("")) {
                    evt.consume();
                } else {
                    //Como no es realizamos la validacion original
                    if (!Character.isLetter(c)) {
                        evt.consume();
                    }
                }
                break;
            case 2://Solo letras y espacio
                //Validamos que la primera entrada no sea el espacio
                if (Character.isSpaceChar(c) && txt.equals("")) {
                    evt.consume();
                } else {
                    //Como no lo es validamos solo números y espacio
                    if (!Character.isLetter(c) && !Character.isSpaceChar(c)) {
                        evt.consume();
                    }
                }
                break;
            case 3://Solo letras y caracteres especiales
                //Validamos que la primera entrada no sea el espacio
                if (Character.isSpaceChar(c) && txt.equals("")) {
                    evt.consume();
                } else {
                    //Como no es realizamos la validacion original
                    char[] p = {'-', '_', '@', '#', '&', '(', '*', '.', ',', ')'};
                    int co = 0;
                    for (int i = 0; i <= 9; i++) {
                        if (p[i] == evt.getKeyChar() || Character.isLetter(c)) {
                            co = 1;
                        }
                    }
                    if (co == 0) {
                        evt.consume();
                    }
                }
                break;
            case 4: //Validar solo letras, caracteres especiales y espacio
                //Validamos que la primera entrada no sea el espacio
                if (Character.isSpaceChar(c) && txt.equals("")) {
                    evt.consume();
                } else {
                    //Como no es realizamos la validacion original
                    char[] p = {'-', '_', '@', '#', '&', '(', '*', '.', ',', ')', '"', '´'};
                    int co = 0;
                    for (int i = 0; i <= 11; i++) {
                        if (p[i] == evt.getKeyChar() || Character.isLetter(c) || Character.isSpaceChar(c)) {
                            co = 1;
                        }
                    }
                    if (co == 0) {
                        evt.consume();
                    }
                }
                break;
            default:
            //No se hace nada y se pone solo para evitar errores
        }
    }

    /**Método para evitar que un input sobre pase una cantidad */
    public void Cantidad(KeyEvent evt, String str, int cant) {
        if (str.length() >= cant) {
            evt.consume();
        }
    }

    //Método para añadir un punto y permitir que solo exista un punto en los números decimales
    public void formatoDecimal(KeyEvent evt, String str) {
        if (str.contains(".")) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '.') {
                    try {
                        c = str.charAt(i + 2);
                        evt.consume();
                    } catch (Exception e) {
                    }
                }
            }
        }
    }
    
    /**
     * Método para obtener la confirmación de una acción 
     * @param mensaje El mensaje que 
     * @param titulo
     * @return 
     */
    public boolean confirmarAccion(String mensaje, String titulo) {
        Object[] opciones = {"Sí", "No"};
        int confirmacion = JOptionPane.showOptionDialog(
            null,
            mensaje,
            titulo,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]
        );
        return confirmacion == JOptionPane.YES_OPTION;
    }
}