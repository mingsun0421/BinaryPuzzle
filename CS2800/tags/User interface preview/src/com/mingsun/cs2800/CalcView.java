package com.mingsun.cs2800;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
//
public class CalcView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcView window = new CalcView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalcView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Infix");
		rdbtnNewRadioButton.setBounds(11, 12, 155, 29);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnReversePolish = new JRadioButton("Reverse Polish");
		rdbtnReversePolish.setBounds(11, 48, 155, 29);
		frame.getContentPane().add(rdbtnReversePolish);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(21, 89, 383, 29);
		frame.getContentPane().add(textPane);
		
		JTextArea txtrExpression = new JTextArea();
		txtrExpression.setText("Expression");
		txtrExpression.setBounds(424, 89, 89, 29);
		frame.getContentPane().add(txtrExpression);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(21, 130, 383, 29);
		frame.getContentPane().add(textPane_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("Result");
		textArea.setBounds(424, 130, 89, 29);
		frame.getContentPane().add(textArea);
		
		JButton button = new JButton("1");
		button.setBounds(21, 186, 115, 29);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("2");
		button_1.setBounds(151, 186, 115, 29);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("3");
		button_2.setBounds(281, 186, 115, 29);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("4");
		button_3.setBounds(21, 231, 115, 29);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.setBounds(151, 231, 115, 29);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.setBounds(281, 231, 115, 29);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("7");
		button_6.setBounds(21, 277, 115, 29);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("8");
		button_7.setBounds(151, 277, 115, 29);
		frame.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("9");
		button_8.setBounds(281, 276, 115, 29);
		frame.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("0");
		button_9.setBounds(73, 322, 115, 29);
		frame.getContentPane().add(button_9);
		
		JButton button_10 = new JButton(".");
		button_10.setBounds(229, 322, 115, 29);
		frame.getContentPane().add(button_10);
		
		JButton button_11 = new JButton("+");
		button_11.setBounds(411, 186, 115, 29);
		frame.getContentPane().add(button_11);
		
		JButton button_12 = new JButton("-");
		button_12.setBounds(411, 231, 115, 29);
		frame.getContentPane().add(button_12);
		
		JButton button_13 = new JButton("*");
		button_13.setBounds(411, 277, 115, 29);
		frame.getContentPane().add(button_13);
		
		JButton button_14 = new JButton("/");
		button_14.setBounds(411, 322, 115, 29);
		frame.getContentPane().add(button_14);
		
		JButton button_15 = new JButton("=");
		button_15.setBounds(217, 399, 115, 29);
		frame.getContentPane().add(button_15);
	}
}
