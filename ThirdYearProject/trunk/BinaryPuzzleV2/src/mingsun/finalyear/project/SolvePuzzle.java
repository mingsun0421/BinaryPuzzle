package mingsun.finalyear.project;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * the class is designed to support solving method which can be applied
 * different size of puzzles.
 * 
 * @author Ming Sun
 * @param numberButtonList
 *            list of number buttons.
 * @param gameSize
 *            integer size of grid.
 * @param index
 *            integer index in the list.
 * @param value
 *            integer value to set number.
 */
public class SolvePuzzle {
	private NumberButtonList numberButtonList;
	private int gameSize;

	/**
	 * Constructor.
	 * 
	 * @param numberButtonList
	 *            list of number buttons
	 * @param gameSize
	 *            Size of puzzle grid.
	 */
	public SolvePuzzle(NumberButtonList numberButtonList, int gameSize) {
		this.numberButtonList = numberButtonList;
		this.gameSize = gameSize;
	}

	/**
	 * Backtracking solving algorithm.
	 */

	public void solverIt() {
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
		numberButtonList.setAllIcon();
	}

	/**
	 * Brute force solving algorithm
	 */
	public void solveItBF() {
		int count = 0;
		ArrayList<Integer> combinations = new ArrayList<Integer>();
		ArrayList<Integer> positions = new ArrayList<Integer>();
		for (int index = 0; index < gameSize * gameSize; index++) {
			if (numberButtonList.getNumberButton(index).getValue() == 2) {
				count = count + 1;
				positions.add(index);
			}
		}
		// Find all possible combinations
		for (int index = 0; index < Math.pow(2, count); index++) {
			String s = Integer.toBinaryString(index);
			for (int length = s.length(); length < count; length++) {
				s = "0" + s;
			}
			for (int i = 0; i < s.length(); i++) {
				combinations.add(Character.getNumericValue(s.charAt(i)));
			}
			for (int cindex = 0; cindex < combinations.size(); cindex++) {
				int pos = positions.get(cindex);
				int val = combinations.get(cindex);
				numberButtonList.getNumberButton(pos).setValue(val);
			}
			CheckResult checkResult = new CheckResult(numberButtonList, gameSize);
			CheckComplete checkComplete = new CheckComplete(numberButtonList, gameSize);
			if (checkComplete.ifComplete()) {
				if (checkResult.checkEquality() && checkResult.checkNeighbours()) {
					System.out.println("Yes");
					JOptionPane.showMessageDialog(null, "Puzzle solved");
					break;
				} else {
					System.out.println("No");
					System.out.println("Trying: " + index);
					combinations.clear();
					for (int cindex = 0; cindex < positions.size(); cindex++) {
						int pos = positions.get(cindex);
						numberButtonList.getNumberButton(pos).setValue(2);
					}
				}
			}
		}
		numberButtonList.setAllIcon();
	}

	/**
	 * Strategic Backtracking Algorithms
	 */
	public void solveSBT() {
		for (int row = 0; row < gameSize; row++) {
			for (int numberIndex = row * gameSize; numberIndex < row * gameSize + gameSize; numberIndex++) {
				int val1 = numberButtonList.getNumberButton(numberIndex).getValue();
				if (numberIndex != row * gameSize + gameSize - 1) {
					int val2 = numberButtonList.getNumberButton(numberIndex + 1).getValue();
					if (val1 != 2 && val1 == val2) {
						if (numberIndex - 1 >= row * gameSize) {
							int val3 = val1;
							numberButtonList.getNumberButton(numberIndex - 1).setValue(val3);
						}
						if (numberIndex + 2 < row * gameSize + gameSize) {
							int val4 = val1;
							numberButtonList.getNumberButton(numberIndex + 2).setValue(val4);
						}
					}
				}
			}
		}
		solverIt();
	}

	/**
	 * Check if the partially filled grid can pass the equality test.
	 * 
	 * @return Boolean True for yes, false for not.
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
	 * neighbours for partially filled grid.
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
