package com.mingsun.cs2800;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This class is calculator's view.
 * @author Ming Sun email<zaac003@live.rhul.ac.uk>
 *
 */
public class CalcView {
	/**
	 * @param frame JFrame
	 */
	JFrame frame;
	/**
	 * @param expression String initialise to null.
	 */
	private String expression = "";
	/**
	 * @param answer float
	 */
	private float answer;
	/**
	 * @param answerString String
	 */
	private String answerString;
	/**
	 * @param isInfix boolean
	 */
	private boolean isInfix = true;
	/**
	 * @param rdbtnReversePolish JRadioButton
	 */
	private JRadioButton rdbtnReversePolish;
	/**
	 * @param rdbtnNewRadioButton JRadioButton
	 */
	private JRadioButton rdbtnNewRadioButton;

	/**
	 * Create the application.
	 */
	public CalcView() {
		initialize();
	}
	/**
	 * This method will return the expression of string.
	 * @return	String
	 */
	public final String getExpression() {
		return expression;
	}
	/**
	 * This method will set the answer.
	 * @param str String
	 */
	public final void setAnswer(final String str) {
		answerString = str;
	}

	/**
	 * Initialise the contents of the frame.
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
			public void actionPerformed(final ActionEvent arg0) {
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
			public void actionPerformed(final ActionEvent arg0) {
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
			public void actionPerformed(final ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "1";
				textPane.setText(expression);
			}
		});
		button.setBounds(21, 186, 115, 29);
		frame.getContentPane().add(button);

		JButton button1 = new JButton("2");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "2";
				textPane.setText(expression);
			}
		});
		button1.setBounds(151, 186, 115, 29);
		frame.getContentPane().add(button1);

		JButton button2 = new JButton("3");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "3";
				textPane.setText(expression);
			}
		});
		button2.setBounds(281, 186, 115, 29);
		frame.getContentPane().add(button2);

		JButton button3 = new JButton("4");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "4";
				textPane.setText(expression);
			}
		});
		button3.setBounds(21, 231, 115, 29);
		frame.getContentPane().add(button3);

		JButton button4 = new JButton("5");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "5";
				textPane.setText(expression);
			}
		});
		button4.setBounds(151, 231, 115, 29);
		frame.getContentPane().add(button4);

		JButton button5 = new JButton("6");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "6";
				textPane.setText(expression);
			}
		});
		button5.setBounds(281, 231, 115, 29);
		frame.getContentPane().add(button5);

		JButton button6 = new JButton("7");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "7";
				textPane.setText(expression);
			}
		});
		button6.setBounds(21, 277, 115, 29);
		frame.getContentPane().add(button6);

		JButton button7 = new JButton("8");
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "8";
				textPane.setText(expression);
			}
		});
		button7.setBounds(151, 277, 115, 29);
		frame.getContentPane().add(button7);

		JButton button8 = new JButton("9");
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "9";
				textPane.setText(expression);
			}
		});
		button8.setBounds(281, 276, 115, 29);
		frame.getContentPane().add(button8);

		JButton button9 = new JButton("0");
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "0";
				textPane.setText(expression);
			}
		});
		button9.setBounds(151, 322, 115, 29);
		frame.getContentPane().add(button9);

		JButton buttonSpace = new JButton("SPACE");
		buttonSpace.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + " ";
				textPane.setText(expression);
			}
		});
		buttonSpace.setBounds(21, 322, 115, 29);
		frame.getContentPane().add(buttonSpace);

		JButton button10 = new JButton(".");
		button10.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + ".";
				textPane.setText(expression);
			}
		});
		button10.setBounds(281, 322, 115, 29);
		frame.getContentPane().add(button10);

		JButton button11 = new JButton("+");
		button11.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "+";
				textPane.setText(expression);
			}
		});
		button11.setBounds(411, 186, 115, 29);
		frame.getContentPane().add(button11);

		JButton button12 = new JButton("-");
		button12.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "-";
				textPane.setText(expression);
			}
		});
		button12.setBounds(411, 231, 115, 29);
		frame.getContentPane().add(button12);

		JButton button13 = new JButton("*");
		button13.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "*";
				textPane.setText(expression);
			}
		});
		button13.setBounds(411, 277, 115, 29);
		frame.getContentPane().add(button13);

		JButton button14 = new JButton("/");
		button14.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				expression = textPane.getText();
				expression = expression + "/";
				textPane.setText(expression);
			}
		});
		button14.setBounds(411, 322, 115, 29);
		frame.getContentPane().add(button14);

		JButton button15 = new JButton("=");
		button15.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				expression = textPane.getText();
				textPane.setText(expression);
				if (expression.matches("[0-9+-[*][/][(][)][.][ ]]+")) {
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
				
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Input");
				}
				answerPane.setText(answerString);
				expression = "";
				textPane.setText(expression);
			}
		});
		button15.setBounds(217, 399, 115, 29);
		frame.getContentPane().add(button15);
	}
}
