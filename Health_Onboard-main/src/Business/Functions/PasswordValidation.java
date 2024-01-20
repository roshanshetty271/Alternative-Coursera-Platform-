/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Functions;

/**
 *
 * @author roshan
 */
import java.awt.Color;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class PasswordValidation extends InputVerifier {
      @Override
    public boolean verify(JComponent input) {
        String textField = ((JTextField) input).getText();
        
        String pattern = "^([a-zA-Z+]+[0-9+]+[@#]+)$";
        
        if (textField.length() > 0) {
            if (textField.toLowerCase().startsWith(" ") || textField.length() == 0 || textField.matches(pattern) != true) {
                input.setBackground(Color.red);
                JOptionPane.showMessageDialog(input, "Please enter valid password. Pattern: Character followed by Number followed by # or @", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                input.setBackground(Color.white);
                return true;
            }
        }
        else
        {
            input.setBackground(Color.white);
            return true;
        }
    }
}
