package mingsun.finalyear.project;

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Hint {
	private NumberButtonList numberButtonList;
	private int gameSize;
	public Hint(NumberButtonList numberButtonList, int gameSize) {
		this.numberButtonList = numberButtonList;
		this.gameSize = gameSize;
	}
	
	public void giveHint() {
		int hintIndex = 0;
		for(int index=0; index<numberButtonList.getSize(); index++) {
			if(numberButtonList.getNumberButton(index).getValue()==2) {
				hintIndex = index;
				break;
			}
		}
		int hintValue = solverIt(hintIndex);
		numberButtonList.getNumberButton(hintIndex).setValue(hintValue);
		numberButtonList.setAllIcon();
		JOptionPane.showMessageDialog(null, "Hint is given");
	}
	
	public int solveItBF(int hintIndex){
		int count = 0;
		ArrayList<Integer> combinations = new ArrayList<Integer>();
		ArrayList<Integer> positions = new ArrayList<Integer>();
		for(int index=0; index<gameSize*gameSize; index++) {
			if(numberButtonList.getNumberButton(index).getValue()==2) {
				count = count + 1;
				positions.add(index);
			}
		}
		//Find all possible combinations
		for(int index=0; index < Math.pow(2, count); index++) {
			String s = Integer.toBinaryString(index);
			for(int length = s.length(); length<count; length++) {
				s = "0"+s;
			}
			for( int i=0; i< s.length(); i++) {
				combinations.add(Character.getNumericValue(s.charAt(i)));
			}
			for(int cindex=0; cindex<combinations.size();cindex++) {
				int pos = positions.get(cindex);
				int val = combinations.get(cindex);
				numberButtonList.getNumberButton(pos).setValue(val);
			}
			CheckResult checkResult = new CheckResult(numberButtonList, gameSize);
			CheckComplete checkComplete = new CheckComplete(numberButtonList, gameSize);
			if (checkComplete.ifComplete()) {
				if (checkResult.checkEquality() && checkResult.checkNeighbours()) {
					break;
				} else {
					combinations.clear();
					for(int cindex=0; cindex<positions.size();cindex++) {
						int pos = positions.get(cindex);
						numberButtonList.getNumberButton(pos).setValue(2);
					}
				}
			}
		}
		int val = numberButtonList.getNumberButton(hintIndex).getValue();
		for(int index=0; index< positions.size(); index++) {
			if(index!= hintIndex){
			    numberButtonList.getNumberButton(positions.get(index)).setValue(2);
			}
		}
		return val;
	}
	
	public int solverIt(int hintIndex) {
		ArrayList<Integer> positions = new ArrayList<Integer>();
		ArrayList<Integer> marked = new ArrayList<Integer>();
		for(int index=0; index<numberButtonList.getSize(); index++) {
			if(numberButtonList.getNumberButton(index).getValue()==2) {
				positions.add(index);
				marked.add(0);
			}
		}
		System.out.println("Positons size: "+positions.size());
		int pIndex=0;
		int count = 0;
		while(pIndex < positions.size()){
			System.out.println("TYR: "+count);
			System.out.println("INDEX:  "+pIndex);
			System.out.println(" MARKED: "+marked.get(pIndex));
			if(marked.get(pIndex) == 0) {
				numberButtonList.getNumberButton(positions.get(pIndex)).setValue(1);
				marked.set(pIndex, 1);
				if(checkEquality() && checkNeighbours()){
					pIndex = pIndex + 1;
				} else {
					numberButtonList.getNumberButton(positions.get(pIndex)).setValue(0);
					marked.set(pIndex, 2);
					if(checkEquality() && checkNeighbours()) {
						pIndex = pIndex + 1;
					} else {
						marked.set(pIndex, 0);
						numberButtonList.getNumberButton(positions.get(pIndex)).setValue(2);
						pIndex = pIndex - 1;
					}
				}
			} else if(marked.get(pIndex) == 1){
				numberButtonList.getNumberButton(positions.get(pIndex)).setValue(0);
				marked.set(pIndex, 2);
				if(checkEquality() && checkNeighbours()) {
					pIndex = pIndex + 1;
				} else {
					numberButtonList.getNumberButton(positions.get(pIndex)).setValue(2);
					marked.set(pIndex, 0);
					pIndex = pIndex - 1;
				}
			} else if(marked.get(pIndex) == 2){
				numberButtonList.getNumberButton(positions.get(pIndex)).setValue(2);
				marked.set(pIndex, 0);
				pIndex = pIndex - 1;
			}
			count = count + 1;
		}
		int val = numberButtonList.getNumberButton(hintIndex).getValue();
		for(int index=0; index< positions.size(); index++) {
			if(index!= hintIndex){
			    numberButtonList.getNumberButton(positions.get(index)).setValue(2);
			}
		}
		return val;
	}
	
	public boolean checkEquality(){
		//check each row's number of 1 and 0
		for(int row=0; row<gameSize; row++) {
			int countZero = 0, countOne = 0;
			for(int numberIndex=row*gameSize; numberIndex<row*gameSize+gameSize; numberIndex++) {
				if(numberButtonList.getNumberButton(numberIndex).getValue()==0) {
					countZero = countZero + 1;
				} else if(numberButtonList.getNumberButton(numberIndex).getValue()==1) {
					countOne = countOne + 1;
				}
			}
			if(countZero > gameSize/2 || countOne > gameSize/2) {
				return false;
			}
		}
		//check each column's number of 1 and 0
		for(int col=0; col<gameSize; col++) {
			int countZero = 0, countOne = 0;
			for(int numberIndex=col; numberIndex <= col+gameSize*(gameSize-1); numberIndex = numberIndex + gameSize) {
				if(numberButtonList.getNumberButton(numberIndex).getValue()==0) {
					countZero = countZero + 1;
				} else if(numberButtonList.getNumberButton(numberIndex).getValue()==1) {
					countOne = countOne + 1;
				} 
			}
			if(countZero > gameSize/2 || countOne > gameSize/2) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Check if there are 2 same number for each vertical and horizontal neighbours.
	 * @return Boolean 
	 */
	public boolean checkNeighbours(){
		//Check every horizontal neighbours
		for(int row=0; row<gameSize; row++) {
			for(int numberIndex=row*gameSize; numberIndex<row*gameSize+gameSize-2; numberIndex++) {
				int value1 = numberButtonList.getNumberButton(numberIndex).getValue();
				int value2 = numberButtonList.getNumberButton(numberIndex+1).getValue();
				int value3 = numberButtonList.getNumberButton(numberIndex+2).getValue();
				if(value1 != 2 || value2 != 2 || value3 !=2){
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
				if(value1 != 2 || value2 != 2 || value3 !=2){
					if(value1 == value2 && value2 == value3) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
