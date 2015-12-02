package mingsun.finalyear.project;

import java.util.ArrayList;
/**
 * the class is designed to support solving method which can be applied different size of puzzles.
 * @author Ming Sun
 * @param numberButtonList list of number buttons.
 * @param gameSize integer size of grid.
 * @param index integer index in the list.
 * @param value integer value to set number.
 */
public class SolvePuzzle {
	private NumberButtonList numberButtonList;
	private int gameSize;
	private int index;
	private int value;
	/**
	 * Constructor.
	 * @param numberButtonList list of number buttons
	 * @param gameSize Size of puzzle grid.
	 */
	public SolvePuzzle(NumberButtonList numberButtonList, int gameSize) {
		this.numberButtonList = numberButtonList;
		this.gameSize = gameSize;
		this.index = 0;
		this.value = 1;
	}
	
	/**
	public boolean solveIt(int index, int value) {
		if(index == gameSize*gameSize){
			return true;
		}
		System.out.println("Round: "+index+" Value:"+value);
		numberButtonList.getNumberButton(index).setIcon();
		if(numberButtonList.getNumberButton(index).getValue()==2){
			numberButtonList.getNumberButton(index).setValue(value);
			if(checkPartialResult()){
				index = index + 1;
				return solveIt(index,0);
			} else {
				index = index - 1;
				return solveIt(index,Math.abs(value-1));
			}
		}
		else{
			index = index + 1;
			return solveIt(index,0);
		}
	}
	**/
	/**
	 * Backtracking solving algorithm.
	 */
	public void solverIt() {
		ArrayList<Integer> marked = new ArrayList<Integer>();
		int markedIndex = 0;
		while(index < gameSize*gameSize){
			numberButtonList.getNumberButton(index).setIcon();
			System.out.println("LOOP.. INDEX "+index);
			if(numberButtonList.getNumberButton(index).getValue() == 2){
				marked.add(index);
				markedIndex = markedIndex + 1;
				numberButtonList.getNumberButton(index).setValue(value);
				if(checkPartialResult()){
					index = index + 1;
				} else {
					if(markedIndex!=0 && index!=0){
						numberButtonList.getNumberButton(index).setValue(2);
						markedIndex = markedIndex - 1;
						index = marked.get(markedIndex);
						value = Math.abs(value - 1);
					} else {
						index = marked.get(0);
						markedIndex = 0;
					}
				}
			} else {
				index = index + 1;
			}
		}
		numberButtonList.setAllIcon();
	}
	/**
	 * To check if grid follows the rules.
	 * @return boolean
	 */
	public boolean checkPartialResult(){
		System.out.println("Enter checking");
		//Check every row, if the number of 0 or 1 is more than it should be.
		for(int row=0; row<gameSize; row++) {
			int countZero = 0, countOne = 0;
			for(int numberIndex=row*gameSize; numberIndex<row*gameSize+gameSize; numberIndex++) {
				if(numberButtonList.getNumberButton(numberIndex).getValue()==0) {
					countZero = countZero + 1;
				} 
				if(numberButtonList.getNumberButton(numberIndex).getValue()==1) {
					countOne = countOne + 1;
				}
			}
			if(countZero>gameSize/2 || countOne>gameSize/2){
				return false;
			}
		}
		//Check every column, if the number of 0 or 1 is more than it should be.
		for(int col=0; col<gameSize; col++) {
			int countZero = 0, countOne = 0;
			for(int numberIndex=col; numberIndex <= col+gameSize*(gameSize-1); numberIndex = numberIndex + gameSize) {
				if(numberButtonList.getNumberButton(numberIndex).getValue()==0) {
					countZero = countZero + 1;
				}
				if(numberButtonList.getNumberButton(numberIndex).getValue()==1) {
					countOne = countOne + 1;
				} 
			}
			if(countZero>gameSize/2 || countOne>gameSize/2) {
				return false;
			}
		}
		for(int row=0; row<gameSize; row++) {
			for(int numberIndex=row*gameSize; numberIndex<row*gameSize+gameSize-2; numberIndex++) {
				int value1 = numberButtonList.getNumberButton(numberIndex).getValue();
				int value2 = numberButtonList.getNumberButton(numberIndex+1).getValue();
				int value3 = numberButtonList.getNumberButton(numberIndex+2).getValue();
				if(value2 != 2 && value3 != 2){
					if(value1 == value2 && value2 == value3) {
						return false;
					}
				}
			}
		}
		//Check every vertical neighbours
		for(int col=0; col<gameSize; col++) {
			for(int numberIndex=col; numberIndex <= col+(gameSize-3); numberIndex = numberIndex + gameSize) {
				int value1 = numberButtonList.getNumberButton(numberIndex).getValue();
				int value2 = numberButtonList.getNumberButton(numberIndex+gameSize).getValue();
				int value3 = numberButtonList.getNumberButton(numberIndex+gameSize+gameSize).getValue();
				if(value2 != 2 && value3 != 2){
					if(value1 == value2 && value2 == value3) {
						return false;
					}
				}
			}
		}
		System.out.println("CHECKING SECCUESS");
		return true;
	}
	
	
}
