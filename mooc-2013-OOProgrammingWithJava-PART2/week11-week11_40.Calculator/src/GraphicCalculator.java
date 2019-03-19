
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator implements Runnable {
    private JFrame frame;
    private JTextField output;
    private JTextField input;
    private JButton add;
    private JButton minus;
    private JButton clear;

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300, 150));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        
        output = new JTextField("0");
        output.setEnabled(false);
        input = new JTextField();
        
        container.add(output);
        container.add(input);
        container.add(createPanel());
    }

    public JFrame getFrame() {
        return frame;
    }
    
    private JPanel createPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 3));
       
        add = new JButton("+");
        minus = new JButton("-");
        clear = new JButton("Z");
        clear.setEnabled(false);
        
        ButtonListener buttonListener = new ButtonListener(output, input, add, minus, clear);
        
        add.addActionListener(buttonListener);
        panel.add(add);
        
        minus.addActionListener(buttonListener);
        panel.add(minus);
        
        clear.addActionListener(buttonListener);
        panel.add(clear);

        return panel;
    }
}
