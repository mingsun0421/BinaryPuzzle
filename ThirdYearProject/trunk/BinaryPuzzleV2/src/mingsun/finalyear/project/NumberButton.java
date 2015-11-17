package mingsun.finalyear.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class NumberButton extends JButton implements ActionListener{
	private static final long serialVersionUID = 1L;
	private ImageIcon One,Zero;
	private int value = 2;
	private int ID;
	private boolean editable = true;
	
	public NumberButton(int ID) {
		this.ID = ID;
		One = new ImageIcon("./resource/numbers14.png");
		Zero = new ImageIcon("./resource/ZeroIcon.png");
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(editable){
		value = value + 1;
		value%=3;
		switch(value){
			case 0:
				setIcon(Zero);
				System.out.println(ID+" "+value);
				break;
			case 1:
				setIcon(One);
				System.out.println(ID+" "+value);
				break;
			case 2:
				setIcon(null);
				System.out.println(ID+" "+value);
				break;
		}
		}
	}
	public void setIcon(){
		switch(value){
		case 0:
			setIcon(Zero);
			System.out.println(ID+" "+value);
			break;
		case 1:
			setIcon(One);
			System.out.println(ID+" "+value);
			break;
		case 2:
			setIcon(null);
			System.out.println(ID+" "+value);
			break;
		}
	}
	
	public int getID() {
		return ID;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	public void setEditable(boolean boo) {
		this.editable = boo;
	}
	
	public boolean getEditable(){
		return editable;
	}
}
