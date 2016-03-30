package mingsun.finalyear.project;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * This class implements the hint functionality, which will update the list with
 * 1 or 2 more filled correct answers.
 * 
 * @author Ming Sun
 *
 */
public class Hint {
	
	private NumberButtonList numberButtonList;
	private int gameSize;
	/**
	 * @param numberButtonList
	 *            NumberButtonList.
	 * @param gameSize
	 *            Integer.
	 */
	public Hint(NumberButtonList numberButtonList, int gameSize) {
		this.numberButtonList = numberButtonList;
		this.gameSize = gameSize;
	}

	/**
	 * Set hint index value and solve the puzzle, finally assign the value to
	 * the list.
	 */
	public void giveHint() {
		/**
		 * @param hintIndex
		 *            Integer, target index value of puzzle.
		 */
		int hintIndex = 0;
		for (int index = 0; index < numberButtonList.getSize(); index++) {
			if (numberButtonList.getNumberButton(index).getValue() == 2) {
				hintIndex = index;
				break;
			}
		}
		int hintValue = solverIt(hintIndex);
		numberButtonList.getNumberButton(hintIndex).setValue(hintValue);
		numberButtonList.setAllIcon();
		JOptionPane.showMessageDialog(null, "Hint is given");
	}

	/**
	 * This is modification of backtracking solving algorithms.
	 * 
	 * @param hintIndex
	 *            Integer, target index value of puzzle.
	 * @return Integer, value of result.
	 */
	public int solverIt(int hintIndex) {
		ArrayList<Integer> positions = new ArrayList<Integer>();
		ArrayList<Integer> marked = new ArrayList<Integer>();
		for (int index = 0; index < numberButtonList.getSize(); index++) {
			if (numberButtonList.getNumberButton(index).getValue() == 2) {
				positions.add(index);
				marked.add(0);
			}
		}
		System.out.println("Positons size: " + positions.size());
		int pIndex = 0;
		int count = 0;
		while (pIndex < positions.size()) {
			System.out.println("TYR: " + count);
			System.out.println("INDEX:  " + pIndex);
			System.out.println(" MARKED: " + marked.get(pIndex));
			if (marked.get(pIndex) == 0) {
				numberButtonList.getNumberButton(positions.get(pIndex)).setValue(1);
				marked.set(pIndex, 1);
				if (checkEquality() && checkNeighbours()) {
					pIndex = pIndex + 1;
				} else {
					numberButtonList.getNumberButton(positions.get(pIndex)).setValue(0);
					marked.set(pIndex, 2);
					if (checkEquality() && checkNeighbours()) {
						pIndex = pIndex + 1;
					} else {
						marked.set(pIndex, 0);
						numberButtonList.getNumberButton(positions.get(pIndex)).setValue(2);
						pIndex = pIndex - 1;
					}
				}
			} else if (marked.get(pIndex) == 1) {
				numberButtonList.getNumberButton(positions.get(pIndex)).setValue(0);
				marked.set(pIndex, 2);
				if (checkEquality() && checkNeighbours()) {
					pIndex = pIndex + 1;
				} else {
					numberButtonList.getNumberButton(positions.get(pIndex)).setValue(2);
					marked.set(pIndex, 0);
					pIndex = pIndex - 1;
				}
			} else if (marked.get(pIndex) == 2) {
				numberButtonList.getNumberButton(positions.get(pIndex)).setValue(2);
				marked.set(pIndex, 0);
				pIndex = pIndex - 1;
			}
			count = count + 1;
		}
		int val = numberButtonList.getNumberButton(hintIndex).getValue();
		for (int index = 0; index < positions.size(); index++) {
			if (index != hintIndex) {
				numberButtonList.getNumberButton(positions.get(index)).setValue(2);
			}
		}
		return val;
	}

	/**
	 * The method check the equality for each row and column.
	 * 
	 * @return Boolean, true for equal false for not.
	 */
	public boolean checkEquality() {
		// check each row's number of 1 and 0
		for (int row = 0; row < gameSize; row++) {
			int countZero = 0, countOne = 0;
			for (int numberIndex = row * gameSize; numberIndex < row * gameSize + gameSize; numberIndex++) {
				if (numberButtonList.getNumberButton(numberIndex).getValue() == 0) {
					countZero = countZero + 1;
				} else if (numberButtonList.getNumberButton(numberIndex).getValue() == 1) {
					countOne = countOne + 1;
				}
			}
			if (countZero > gameSize / 2 || countOne > gameSize / 2) {
				return false;
			}
		}
		// check each column's number of 1 and 0
		for (int col = 0; col < gameSize; col++) {
			int countZero = 0, countOne = 0;
			for (int numberIndex = col; numberIndex <= col + gameSize * (gameSize - 1); numberIndex = numberIndex
					+ gameSize) {
				if (numberButtonList.getNumberButton(numberIndex).getValue() == 0) {
					countZero = countZero + 1;
				} else if (numberButtonList.getNumberButton(numberIndex).getValue() == 1) {
					countOne = countOne + 1;
				}
			}
			if (countZero > gameSize / 2 || countOne > gameSize / 2) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Check if there are 2 same number for each vertical and horizontal
	 * neighbours.
	 * 
	 * @return Boolean
	 */
	public boolean checkNeighbours() {
		// Check every horizontal neighbours
		for (int row = 0; row < gameSize; row++) {
			for (int numberIndex = row * gameSize; numberIndex < row * gameSize + gameSize - 2; numberIndex++) {
				int value1 = numberButtonList.getNumberButton(numberIndex).getValue();
				int value2 = numberButtonList.getNumberButton(numberIndex + 1).getValue();
				int value3 = numberButtonList.getNumberButton(numberIndex + 2).getValue();
				if (value1 != 2 || value2 != 2 || value3 != 2) {
					if (value1 == value2 && value2 == value3) {
						return false;
					}
				}
			}
		}
		// Check every vertical neighbours
		for (int col = 0; col < gameSize; col++) {
			for (int numberIndex = col; numberIndex <= col + (gameSize - 3); numberIndex = numberIndex + gameSize) {
				int value1 = numberButtonList.getNumberButton(numberIndex).getValue();
				int value2 = numberButtonList.getNumberButton(numberIndex + gameSize).getValue();
				int value3 = numberButtonList.getNumberButton(numberIndex + gameSize + gameSize).getValue();
				if (value1 != 2 || value2 != 2 || value3 != 2) {
					if (value1 == value2 && value2 == value3) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
