package mingsun.finalyear.project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * the class designed to represent one single number button which is clickable, 
 * for each click it change its value and icon from 0 to 1 to empty.
 * @author Ming Sun
 * @param One ImageIcon
 * @param Zero ImageIcon
 * @param OneU ImageIcon
 * @param ZeroU ImageIcon
 * @param value integer
 * @param ID integer
 * @editable Boolean
 */
public class NumberButton extends JButton implements ActionListener {
	private static final long serialVersionUID = 1L;
	private ImageIcon One, Zero, OneU, ZeroU;
	private int value = 2;
	private int ID;
	private boolean editable = true;
	/**
	 * Constructor.
	 * @param ID integer of number index.
	 */
	public NumberButton(int ID) {
		setBackground(Color.white);
		this.ID = ID;
		One = new ImageIcon("./resource/number1.png");
		OneU = new ImageIcon("./resource/number1u.png");
		Zero = new ImageIcon("./resource/number0.png");
		ZeroU = new ImageIcon("./resource/number0u.png");
		this.addActionListener(this);
	}
	/**
	 * Action performed method to change icon when clicked.
	 */
	public void actionPerformed(ActionEvent e) {
		if (editable) {
			value = value + 1;
			value %= 3;
			switch (value) {
			case 0:
				setIcon(Zero);
				System.out.println(ID + " " + value);
				break;
			case 1:
				setIcon(One);
				System.out.println(ID + " " + value);
				break;
			case 2:
				setIcon(null);
				System.out.println(ID + " " + value);
				break;
			}
		}
	}
	/**
	 * Reset button's icon.
	 */
	public void setIcon() {
		if (editable) {
			switch (value) {
			case 0:
				setIcon(Zero);
				System.out.println(ID + " " + value);
				break;
			case 1:
				setIcon(One);
				System.out.println(ID + " " + value);
				break;
			case 2:
				setIcon(null);
				System.out.println(ID + " " + value);
				break;
			}
		} else {
			switch (value) {
			case 0:
				setIcon(ZeroU);
				System.out.println(ID + " " + value);
				break;
			case 1:
				setIcon(OneU);
				System.out.println(ID + " " + value);
				break;
			case 2:
				setIcon(null);
				System.out.println(ID + " " + value);
				break;
			}
		}
	}
	/**
	 * Get method to get id.
	 * @return integer
	 */
	public int getID() {
		return ID;
	}
	/**
	 * Get method to get value.
	 * @return integer
	 */
	public int getValue() {
		return value;
	}
	/**
	 * Set method to set value of button.
	 * @param value integer
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * Set method to change editable.
	 * @param boo boolean
	 */
	public void setEditable(boolean boo) {
		this.editable = boo;
	}
	/**
	 * Get method to get editable of button.
	 * @return boolean
	 */
	public boolean getEditable() {
		return editable;
	}
}
