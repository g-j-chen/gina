package clicker.ui;

import clicker.applicationlogic.Calculator;
import clicker.applicationlogic.PersonalCalculator;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private PersonalCalculator calculator = new PersonalCalculator();

    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);
        
        JLabel text = new JLabel("0");
        JButton button = new JButton("Click!");
        ClickListener click = new ClickListener(calculator, text);
        button.addActionListener(click);
        
        container.add(text);
        container.add(button, BorderLayout.PAGE_END);
        
    }

    public JFrame getFrame() {
        return frame;
    }
}
