package mingsun.finalyear.project;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	private JMenu gameMenu, moreOptions;
	private JMenuItem soloMode, solveMode, fourFour, fourFourS, sixSix, sixSixS, eightEight, eightEightS, checkButton,
			solveButton, printButton;
	private JPanel panel = new JPanel();
	private NumberButtonList nbList = new NumberButtonList();
	public int gridSize = 1;
	public JButton checkResultButton, nextLevelButton;
	private int level = 1;

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Game game = new Game();
				game.setVisible(true);
			}
		});
	}

	public Game() {
		super("Binary Puzzle");
		ImageIcon logo = new ImageIcon("./resource/Icon_Sudoku_212.png");
		setIconImage(logo.getImage());
		setSize(600, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		String pt1 = "<html><body width='";
		String pt2 = "'><h1>Welcome to BINARY PUZZLE WORLD</h1>" + "<h1>RULES</h1>"
				+ "<p>Each binary puzzle should be solved according to the following rules:<br><br>"
				+ "<p>1. Each box should contain a zero or a one.<br><br>"
				+ "<p>2. No more than two similar numbers next to or below each other are allowed.<br><br>"
				+ "<p>3. Each row and each column should contain an equal number of zeros and ones.<br><br>"
				+ "<p>4. Each row is unique and each column is unique.<br><br>"
				+ "<p>Each binary puzzle does only have one solution. You can always find this solution without guessing.<br><br>"
				+ "<p>GOOD LUCK! HAVE FUN!<br><br>" + "";

		int width = 500;
		String s = pt1 + width + pt2;
		JLabel label1 = new JLabel(s);
		panel.add(label1);
		// JMenuBar
		JMenuBar jmenuBar = new JMenuBar();
		setJMenuBar(jmenuBar);
		gameMenu = new JMenu("GAME MODE");
		moreOptions = new JMenu("MORE OPTIONS");
		jmenuBar.add(gameMenu);
		jmenuBar.add(moreOptions);

		soloMode = new JMenu("Playing Mode");
		solveMode = new JMenu("Sloving Mode");
		gameMenu.add(soloMode);
		gameMenu.add(solveMode);

		fourFour = new JMenuItem("4X4");
		fourFourS = new JMenuItem("4X4");
		sixSix = new JMenuItem("6X6");
		sixSixS = new JMenuItem("6X6");
		eightEight = new JMenuItem("8X8");
		eightEightS = new JMenuItem("8X8");

		soloMode.add(fourFour);
		// SOLVE
		solveMode.add(fourFourS);
		fourFourS.addActionListener(new GameSizeListener(4));
		fourFour.addActionListener(new GamePlayListener(4, 1));

		soloMode.add(sixSix);
		// SOLVE
		solveMode.add(sixSixS);
		sixSixS.addActionListener(new GameSizeListener(6));
		sixSix.addActionListener(new GamePlayListener(6, 1));

		soloMode.add(eightEight);
		// SOLVE
		solveMode.add(eightEightS);
		eightEight.addActionListener(new GamePlayListener(8, 1));
		eightEightS.addActionListener(new GameSizeListener(8));

		solveButton = new JMenuItem("solve it");
		checkButton = new JMenuItem("check it");
		// checkMenu.add(solveButton);
		// checkMenu.add(checkButton);
		// checkButton.addActionListener(new CheckListener(gridSize,nbList));
		// End JMenuBar
		//JMenuItem for print
		printButton = new JMenuItem("print grid");
		moreOptions.add(printButton);
		
		add(panel);
		setVisible(true);
	}
	
	public void setNbList(NumberButtonList list) {
		nbList = list;
	}

	public void buildInterface(int size) {
		// TODO gridSize cannot update
		gridSize = size;
		System.out.println("building interface: " + size);
		panel.removeAll();
		panel.setLayout(new GridLayout(size + 1, size));
		for (int i = 0; i < size * size; i++) {
			NumberButton numberButton = new NumberButton(i);
			nbList.add(numberButton);
			panel.add(numberButton);
		}
		JButton solveButton = new JButton("SOLVE");
		solveButton.setIcon(new ImageIcon("./resource/button_ok.png"));
		solveButton.setBackground(Color.WHITE);
		solveButton.addActionListener(new SolveListener(nbList, gridSize));
		//Add print button listener here
		printButton.addActionListener(new PrintButtonListener(nbList,gridSize));
		panel.add(solveButton);
		add(panel);
		setVisible(true);
	}

	// build non-empty interface
	public void buildFilledInterface(int size, NumberButtonList nbList) {
		// TODO gridSize cannot update
		gridSize = size;
		System.out.println("building interface: " + size);
		panel.removeAll();
		panel.setLayout(new GridLayout(size + 1, size));
		for (int i = 0; i < size * size; i++) {
			NumberButton numberButton = nbList.getNumberButton(i);
			numberButton.setIcon();
			panel.add(numberButton);
		}
		setNbList(nbList);
		checkResultButton = new JButton();
		panel.add(checkResultButton);
		checkResultButton.setIcon(new ImageIcon("./resource/start.png"));
		checkResultButton.setBackground(Color.WHITE);
		checkResultButton.addActionListener(new CheckListener(gridSize, nbList));
		JButton restartButton = new JButton();
		restartButton.setIcon(new ImageIcon("./resource/restart.png"));
		restartButton.setBackground(Color.WHITE);
		restartButton.addActionListener(new ReStartListener(nbList));
		panel.add(restartButton);
		JButton hintButton = new JButton();
		hintButton.setIcon(new ImageIcon("./resource/hint.png"));
		hintButton.setBackground(Color.WHITE);
		panel.add(hintButton);
		nextLevelButton = new JButton();
		nextLevelButton.setIcon(new ImageIcon("./resource/next.png"));
		nextLevelButton.setBackground(Color.WHITE);
		nextLevelButton.addActionListener(new NextButtonListener(size, level++));
		panel.add(nextLevelButton);
		//Add print button listener here
		printButton.addActionListener(new PrintButtonListener(nbList,gridSize));
		add(panel);
		setVisible(true);
	}

	public void levelPlus() {
		level = level + 1;
	}

	public void levelReset() {
		level = 1;
	}

	private class GameSizeListener implements ActionListener {
		private int size;

		public GameSizeListener(int size) {
			this.size = size;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			buildInterface(size);
		}
	}

	private class GamePlayListener implements ActionListener {
		private int size;
		private int level;

		public GamePlayListener(int size, int level) {
			this.level = level;
			this.size = size;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			levelReset();
			String fileName = "./resource/" + size + "x" + size + "Puzzle" + level + ".txt";
			ReadPuzzleTxt rpt = new ReadPuzzleTxt(fileName, size);
			NumberButtonList newNbList = null;
			try {
				newNbList = rpt.getList();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			buildFilledInterface(size, newNbList);
		}
	}

	private class NextButtonListener implements ActionListener {
		private int size;
		private int level;

		public NextButtonListener(int size, int level) {
			this.level = level;
			this.size = size;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			level = level + 1;
			levelPlus();
			String fileName = "./resource/" + size + "x" + size + "Puzzle" + level + ".txt";
			ReadPuzzleTxt rpt = new ReadPuzzleTxt(fileName, size);
			NumberButtonList newNbList = null;
			try {
				newNbList = rpt.getList();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			buildFilledInterface(size, newNbList);
		}
	}

	private class CheckListener implements ActionListener {
		private int size;
		private NumberButtonList nbList;

		public CheckListener(int size, NumberButtonList nbList) {
			this.size = size;
			this.nbList = nbList;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			CheckResult checkResult = new CheckResult(nbList, size);
			CheckComplete checkComplete = new CheckComplete(nbList, size);
			if (checkComplete.ifComplete()) {
				if (checkResult.checkEquality() && checkResult.checkNeighbours()) {
					System.out.println("Yes");
					JOptionPane.showMessageDialog(null, "congratulations! You have successfully solved this puzzle");
				} else {
					System.out.println("No");
					JOptionPane.showMessageDialog(null, "Sorry, You have not successfully solved this puzzle");
				}
			} else {
				System.out.println("No");
				JOptionPane.showMessageDialog(null, "OMG, You have not completed yet");
			}
		}
	}

	private class ReStartListener implements ActionListener {
		private NumberButtonList nbList;

		public ReStartListener(NumberButtonList nbList) {
			this.nbList = nbList;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int index = 0; index < nbList.getSize(); index++) {
				if (nbList.getNumberButton(index).getEditable()) {
					nbList.getNumberButton(index).setValue(2);
					nbList.getNumberButton(index).setIcon();
				}
			}
		}
	}

	private class SolveListener implements ActionListener {
		private NumberButtonList nbList;
		private SolvePuzzle solver;
		private int size;

		public SolveListener(NumberButtonList nbList, int size) {
			this.nbList = nbList;
			this.size = size;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			solver = new SolvePuzzle(nbList, size);
			solver.solverIt();
		}
	}
	
	private class PrintButtonListener implements ActionListener {
		private int size;
		private NumberButtonList nbList;

		public PrintButtonListener(NumberButtonList nbList, int size) {
			this.nbList = nbList;
			this.size = size;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			OutPutTxt opt = new OutPutTxt(nbList,size);
			opt.output();
		}
	}
}