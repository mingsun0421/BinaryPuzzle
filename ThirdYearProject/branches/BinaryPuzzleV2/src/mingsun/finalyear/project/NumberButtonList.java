package mingsun.finalyear.project;

import java.util.ArrayList;
/**
 * The class designed to represent list of all single number buttons to form a whole puzzle.
 * @author Ming Sun
 *
 */
public class NumberButtonList {
	private ArrayList<NumberButton> list;
	
	public NumberButtonList() {
		list = new ArrayList<NumberButton>();
	}
	
	public void add(NumberButton numberButton) {
		list.add(numberButton);
	}
	
	public NumberButton getNumberButton(int index) {
		return list.get(index);
	}
	
	public int getSize(){
		return list.size();
	}
	public void setAllIcon() {
		for(NumberButton nb : list) {
			nb.setIcon();
		}
	}
}
