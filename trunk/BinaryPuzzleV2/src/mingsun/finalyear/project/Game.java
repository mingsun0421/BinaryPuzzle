package mingsun.finalyear.project;

import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game extends JFrame{
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	NumberButton buttons[] = new NumberButton[16];
	
	public static void main(String args[]) {
		new Game();
	}
	
	public Game() {
		super("Binary Puzzle");
		ImageIcon logo = new ImageIcon("./resource/Icon_Sudoku_212.png");
		setIconImage(logo.getImage());
		setSize(600,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(4,4));
		for(int i=0; i<16; i++) {
			buttons[i] = new NumberButton(i);
			panel.add(buttons[i]);
		}
		add(panel);
		
		setVisible(true);
	}
}
	

