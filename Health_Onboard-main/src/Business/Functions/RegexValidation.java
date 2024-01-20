/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Functions;

import java.awt.Color;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author roshan
 */
public class RegexValidation extends InputVerifier{
    
    @Override
    public boolean verify(JComponent input) {
        String textField = ((JTextField) input).getText();
     
        String pattern = "^[0-9]*[a-zA-Z][a-zA-Z0-9\\s]*$";
        if (textField.length() > 0) {
            if (textField.toLowerCase().startsWith(" ") || textField.length() == 0 || textField.matches(pattern) != true) {
                input.setBackground(Color.red);
                JOptionPane.showMessageDialog(input, "Please enter valid string. Special characters are not allowed", "Error", JOptionPane.ERROR_MESSAGE);
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
