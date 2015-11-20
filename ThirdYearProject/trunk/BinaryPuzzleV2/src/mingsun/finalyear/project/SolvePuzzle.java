package mingsun.finalyear.project;

public class SolvePuzzle {
	private NumberButtonList numberButtonList;
	private int gameSize;
	private int index;
	private int value;
	
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
	public void solverIt() {
		while(index < gameSize*gameSize){
			numberButtonList.getNumberButton(index).setIcon();
			System.out.println("LOOP.. INDEX "+index);
			if(numberButtonList.getNumberButton(index).getValue() == 2){
				numberButtonList.getNumberButton(index).setValue(value);
				if(checkPartialResult()){
					index = index + 1;
				} else {
					if(index!=0){
						numberButtonList.getNumberButton(index).setValue(2);
						index = index -1;
						value = Math.abs(value - 1);
					}
				}
			} else {
				index = index + 1;
			}
		}
	}
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
				if(value1 == value2 && value2 == value3) {
					return false;
				}
			}
		}
		//Check every vertical neighbours
		for(int col=0; col<gameSize; col++) {
			for(int numberIndex=col; numberIndex <= col+(gameSize-3); numberIndex = numberIndex + gameSize) {
				int value1 = numberButtonList.getNumberButton(numberIndex).getValue();
				int value2 = numberButtonList.getNumberButton(numberIndex+gameSize).getValue();
				int value3 = numberButtonList.getNumberButton(numberIndex+gameSize+gameSize).getValue();
				if(value1 == value2 && value2 == value3) {
					return false;
				}
			}
		}
		System.out.println("CHECKING SECCUESS");
		return true;
	}
	
	
}
