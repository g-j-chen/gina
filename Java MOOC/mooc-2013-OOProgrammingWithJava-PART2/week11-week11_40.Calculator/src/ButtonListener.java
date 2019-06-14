
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class ButtonListener implements ActionListener {
    
    private JTextField outputField;
    private JTextField inputField;
    private JButton addButton;
    private JButton minusButton;
    private JButton clearButton;

    
    public ButtonListener(JTextField outputField, JTextField inputField, JButton addButton, JButton minusButton, JButton clearButton) {
        this.outputField = outputField;
        this.inputField = inputField;
        this.addButton = addButton;
        this.minusButton = minusButton;
        this.clearButton = clearButton;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int output = Integer.parseInt(outputField.getText());

        int input = 0;
        try {
            input = Integer.parseInt(inputField.getText());
        } catch (NumberFormatException ex) {
            inputField.setText("");
        }

        if(e.getSource() == addButton) {
            output += input;
        } else if(e.getSource() == minusButton) {
            output -= input;
        } else if(e.getSource() == clearButton) {
            output = 0;
        }
        String result = String.valueOf(output);
        outputField.setText(result);
        inputField.setText("");
        
        if(output == 0) {
            clearButton.setEnabled(false);
        } else {
            clearButton.setEnabled(true);
        }
    }
    
}
