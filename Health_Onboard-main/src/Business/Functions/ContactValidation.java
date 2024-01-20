/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Functions;

/**
 *
 * @author dhanush
 */

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ContactValidation extends InputVerifier{
     @Override
    public boolean verify(JComponent input) {
        String textField = ((JTextField) input).getText();
        
         String pattern = "^[1-9]{1}+[0-9]{9}$" ;
         Pattern dobPattern = Pattern.compile(pattern);
            Matcher matcher = dobPattern.matcher(textField);
            if (textField.length() > 0) {
               if (textField.toLowerCase().startsWith(" ") || textField.length() == 0 || matcher.matches() != true) {
                input.setBackground(Color.red);
                JOptionPane.showMessageDialog(input, "Please Enter Valid number", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                input.setBackground(Color.white);
                return true;
            }
            }    
        else {
            input.setBackground(Color.white);
            return true;
        }
    
   
    }
    
}
