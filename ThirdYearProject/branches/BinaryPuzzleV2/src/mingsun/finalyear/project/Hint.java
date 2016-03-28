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
		int hintValue = solveItBF(hintIndex);
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
}
