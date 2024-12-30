package mypackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements ActionListener{

	
    JButton button;
    JTextField textField;
    JLabel resultLabel;  // Use JLabel for displaying the result
    Postfix postfix = new Postfix();

    public MyFrame() {

        this.setTitle("Stack-Based Postfix Expression Calculator");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 10));
        textField.setFont(new Font("Consolas", Font.PLAIN, 60));
        textField.setForeground(new Color(0x00FF00));  
        textField.setBackground(Color.black);
        textField.setCaretColor(Color.white);
        textField.setText("enter_postfix");

        textField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));  

        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Trigger the same action as the button press
                    calculateResult();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        button = new JButton("Calculate");
        button.setFont(new Font("Consolas", Font.PLAIN, 25));  
        button.setPreferredSize(new Dimension(250, 60)); 
        button.addActionListener(this);

        resultLabel = new JLabel("Result: ");
        resultLabel.setPreferredSize(new Dimension(250, 40));
        resultLabel.setFont(new Font("Consolas", Font.PLAIN, 35));
        resultLabel.setForeground(Color.black);  

        this.add(textField);
        this.add(Box.createVerticalStrut(20));
        this.add(button);
        this.add(Box.createVerticalStrut(20));
        this.add(resultLabel);  
        this.add(Box.createVerticalStrut(20));

        this.setSize(1500, 300);  
        this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
            calculateResult();
		}
	}

    private void calculateResult()
    {
        String text = textField.getText();
        try {
            double result = postfix.calculate(text);
            resultLabel.setText("Result: " + Double.toString(result));
        } catch (Exception e) {
            resultLabel.setText("Result: ERROR");
        }
        
    }
}