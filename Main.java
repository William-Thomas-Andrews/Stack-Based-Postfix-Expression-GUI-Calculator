import java.util.Scanner;
import mypackage.Postfix;
import mypackage.MyFrame;
import mypackage.MyStack;

import javax.security.auth.callback.TextInputCallback;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;



public class Main{

	public static void main(String[] args) 
    {

        Postfix postfix = new Postfix();


        // This commented part is an example used for callbacks:

        // TextCallback callback = new TextCallback() 
        // {
        //     @Override
        //     public void onTextReceived(String text) throws Exception
        //     {

        //         System.out.println("Received text: " + text);
        //         double result = postfix.calculate(text); // not useful, we need to call this function in MyFrame and calculate it there and display the message on box
        //         // Postfix postfix = new Postfix();
        //     }
        // };

		// JTextField = A GUI textbox component that can be used to add, set, or get text

		MyFrame myframe = new MyFrame();
	}
}