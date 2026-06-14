package utilidades;

import javax.swing.JOptionPane;

public class Validar_mail2 {

    public static void main(String[] args) {
        
        boolean arroba = false;
        boolean punto = false;
        
        
        String mail = JOptionPane.showInputDialog("Ingrese su email por favor: ");
        
        
        if (mail != null && !mail.trim().isEmpty()) {
            
            
            for (int i = 0; i < mail.length(); i++) {
                if (mail.charAt(i) == '@') {
                    arroba = true;
                }
                if (mail.charAt(i) == '.') {
                    punto = true;
                }
            }
            
            
            if (arroba && punto) {
                System.out.println("ÉXITO");
                JOptionPane.showMessageDialog(null, "ÉXITO: El email es válido.");
            } else {
                System.out.println("FALLO");
                JOptionPane.showMessageDialog(null, "FALLO: El email ingresado NO es válido (le falta un @ o un punto).", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } else {
            System.out.println("Operación cancelada o ingreso vacío.");
        }
    }
}