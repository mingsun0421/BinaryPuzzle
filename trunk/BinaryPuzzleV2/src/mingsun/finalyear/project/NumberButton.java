package mingsun.finalyear.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class NumberButton extends JButton implements ActionListener{
	private ImageIcon One,Zero;
	private int value = 0;
	private int ID;
	
	public NumberButton(int ID) {
		this.ID = ID;
		One = new ImageIcon("./resource/OneIcon.png");
		Zero = new ImageIcon("./resource/ZeroIcon.png");
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		value++;
		value%=3;
		switch(value){
			case 0:
				setIcon(null);
				break;
			case 1:
				setIcon(One);
				break;
			case 2:
				setIcon(Zero);
				break;
		}
	}
	
	public int getID() {
		return ID;
	}
	
	public int getValue() {
		return value;
	}
}
