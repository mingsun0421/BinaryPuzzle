package mingsun.finalyear.project;

import java.util.ArrayList;

/**
 * The class designed to represent list of all single number buttons to form a
 * whole puzzle.
 * 
 * @author Ming Sun
 * @param list
 *            ArrayList<NumberButton> the list of number buttons.
 */
public class NumberButtonList {
	private ArrayList<NumberButton> list;

	/**
	 * Constructor.
	 */
	public NumberButtonList() {
		list = new ArrayList<NumberButton>();
	}

	/**
	 * To add new number button to the list.
	 * 
	 * @param numberButton
	 *            Number button element.
	 */
	public void add(NumberButton numberButton) {
		list.add(numberButton);
	}

	/**
	 * Get method to get number at certain index.
	 * 
	 * @param index
	 *            integer, index of list.
	 * @return NumberButton
	 */
	public NumberButton getNumberButton(int index) {
		return list.get(index);
	}

	/**
	 * Get method to get the size of list.
	 * 
	 * @return integer
	 */
	public int getSize() {
		return list.size();
	}

	/**
	 * Set all icon in the list.
	 */
	public void setAllIcon() {
		for (NumberButton nb : list) {
			nb.setIcon();
		}
	}
}
