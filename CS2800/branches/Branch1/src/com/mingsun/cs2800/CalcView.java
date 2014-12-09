package com.mingsun.cs2800;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//
public class CalcView {

	JFrame frame;
	private String expression = "";
	private float answer;
	private String answerString;
	private boolean isInfix = true;
	private CalcModel model;
	private JRadioButton rdbtnReversePolish;
	private JRadioButton rdbtnNewRadioButton;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public CalcView() {
		initialize();
	}

	public final String getExpression() {
		return expression;
	}

	public final void setAnswer(String str) {
		answerString = str;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("MingSun Calculator");

		rdbtnNewRadioButton = new JRadioButton("Infix");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isInfix = true;
				rdbtnReversePolish.setSelected(false);
				if (!rdbtnNewRadioButton.isSelected()) {
					rdbtnReversePolish.setSelected(true);
					isInfix = false;
				}
			}
		});
		rdbtnNewRadioButton.setBounds(11, 12, 155, 29);
		frame.getContentPane().add(rdbtnNewRadioButton);

		rdbtnReversePolish = new JRadioButton("Reverse Polish");
		rdbtnReversePolish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isInfix = false;
				rdbtnNewRadioButton.setSelected(false);
				if (!rdbtnReversePolish.isSelected()) {
					rdbtnNewRadioButton.setSelected(true);
					isInfix = true;
				}
			}
		});
		rdbtnReversePolish.setBounds(11, 48, 155, 29);
		frame.getContentPane().add(rdbtnReversePolish);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(21, 89, 383, 29);
		frame.getContentPane().add(textPane);

		JTextArea txtrExpression = new JTextArea();
		txtrExpression.setText("Expression");
		txtrExpression.setBounds(424, 89, 89, 29);
		txtrExpression.setEditable(false);
		frame.getContentPane().add(txtrExpression);

		JTextPane answerPane = new JTextPane();
		answerPane.setBounds(21, 130, 383, 29);
		answerPane.setEditable(false);
		frame.getContentPane().add(answerPane);

		JTextArea textArea = new JTextArea();
		textArea.setText("Result");
		textArea.setBounds(424, 130, 89, 29);
		textArea.setEditable(false);
		frame.getContentPane().add(textArea);

		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "1";
				textPane.setText(expression);
			}
		});
		button.setBounds(21, 186, 115, 29);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "2";
				textPane.setText(expression);
			}
		});
		button_1.setBounds(151, 186, 115, 29);
		frame.getContentPane().add(button_1);

		JButton button_2 = new JButton("3");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "3";
				textPane.setText(expression);
			}
		});
		button_2.setBounds(281, 186, 115, 29);
		frame.getContentPane().add(button_2);

		JButton button_3 = new JButton("4");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "4";
				textPane.setText(expression);
			}
		});
		button_3.setBounds(21, 231, 115, 29);
		frame.getContentPane().add(button_3);

		JButton button_4 = new JButton("5");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "5";
				textPane.setText(expression);
			}
		});
		button_4.setBounds(151, 231, 115, 29);
		frame.getContentPane().add(button_4);

		JButton button_5 = new JButton("6");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "6";
				textPane.setText(expression);
			}
		});
		button_5.setBounds(281, 231, 115, 29);
		frame.getContentPane().add(button_5);

		JButton button_6 = new JButton("7");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "7";
				textPane.setText(expression);
			}
		});
		button_6.setBounds(21, 277, 115, 29);
		frame.getContentPane().add(button_6);

		JButton button_7 = new JButton("8");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "8";
				textPane.setText(expression);
			}
		});
		button_7.setBounds(151, 277, 115, 29);
		frame.getContentPane().add(button_7);

		JButton button_8 = new JButton("9");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "9";
				textPane.setText(expression);
			}
		});
		button_8.setBounds(281, 276, 115, 29);
		frame.getContentPane().add(button_8);

		JButton button_9 = new JButton("0");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "0";
				textPane.setText(expression);
			}
		});
		button_9.setBounds(151, 322, 115, 29);
		frame.getContentPane().add(button_9);

		JButton button_s = new JButton("SPACE");
		button_s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + " ";
				textPane.setText(expression);
			}
		});
		button_s.setBounds(21, 322, 115, 29);
		frame.getContentPane().add(button_s);

		JButton button_10 = new JButton(".");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + ".";
				textPane.setText(expression);
			}
		});
		button_10.setBounds(281, 322, 115, 29);
		frame.getContentPane().add(button_10);

		JButton button_11 = new JButton("+");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "+";
				textPane.setText(expression);
			}
		});
		button_11.setBounds(411, 186, 115, 29);
		frame.getContentPane().add(button_11);

		JButton button_12 = new JButton("-");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "-";
				textPane.setText(expression);
			}
		});
		button_12.setBounds(411, 231, 115, 29);
		frame.getContentPane().add(button_12);

		JButton button_13 = new JButton("*");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "*";
				textPane.setText(expression);
			}
		});
		button_13.setBounds(411, 277, 115, 29);
		frame.getContentPane().add(button_13);

		JButton button_14 = new JButton("/");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "/";
				textPane.setText(expression);
			}
		});
		button_14.setBounds(411, 322, 115, 29);
		frame.getContentPane().add(button_14);

		JButton button_15 = new JButton("=");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expression = textPane.getText();
				textPane.setText(expression);
				if(expression.matches("[0-9+-[*][/][(][)][.][ ]]+")) {
					if (isInfix) {
						try {
							StandardCalc stdCal = new StandardCalc();
							answer = stdCal.evaluate(expression);
						} catch (MyException e) {
							e.printStackTrace();
						}
						answerString = Float.toString(answer);
					} else {
						try {
							RevPolishCalc revPoli = new RevPolishCalc();
							answer = revPoli.evaluate(expression);
						} catch (MyException e) {
							e.printStackTrace();
						}
						answerString = Float.toString(answer);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Invalid Input");
				}
				answerPane.setText(answerString);
				expression = "";
				textPane.setText(expression);
			}
		});
		button_15.setBounds(217, 399, 115, 29);
		frame.getContentPane().add(button_15);
	}
}