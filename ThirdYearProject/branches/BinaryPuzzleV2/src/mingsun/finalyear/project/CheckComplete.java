package mingsun.finalyear.project;
/**
 * the class designed to check if all position in the grid is filled or not. 
 * @author Ming Sun
 *
 */
public class CheckComplete {
	/**
	 * @param numberButtonList NumberButtonList list of all number buttons for 1s and 0s.
	 * @param gameSize Integer, size of grid.
	 */
	private NumberButtonList numberButtonList;
	/**
	 * Constructor.
	 * @param numberButtonList NumberButtonList list of all number buttons for 1s and 0s.
	 * @param gameSize Integer, size of grid.
	 */
	public CheckComplete(NumberButtonList numberButtonList, int gameSize) {
		this.numberButtonList = numberButtonList;
	}
	/**
	 * Check if grid is completed.
	 * @return Boolean, true for false false for no.
	 */
	public boolean ifComplete() {
		for(int index=0; index<numberButtonList.getSize(); index++){
			if(numberButtonList.getNumberButton(index).getValue()==2){
				return false;
			}
		}
		return true;
	}
}
