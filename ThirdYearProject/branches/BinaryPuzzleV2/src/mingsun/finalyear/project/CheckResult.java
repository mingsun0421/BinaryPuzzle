package mingsun.finalyear.project;

public class CheckResult {
	private NumberButtonList numberButtonList;
	private int gameSize;
	
	public CheckResult(NumberButtonList numberButtonList, int gameSize) {
		this.numberButtonList = numberButtonList;
		this.gameSize = gameSize;
	}
	
	public boolean checkEquality(){
		//check each row's number of 1 and 0
		System.out.println("GameSize: "+gameSize);
		for(int row=0; row<gameSize; row++) {
			System.out.println("herererer");
			int countZero = 0, countOne = 0;
			for(int numberIndex=row*gameSize; numberIndex<row*gameSize+gameSize; numberIndex++) {
				if(numberButtonList.getNumberButton(numberIndex).getValue()==0) {
					countZero = countZero + 1;
				} else if(numberButtonList.getNumberButton(numberIndex).getValue()==1) {
					countOne = countOne + 1;
				} else {
					return false;
				}
			}
			System.out.println("count result are:"+countZero+" "+countOne);
			if(countZero != countOne) {
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
				} else {
					return false;
				}
			}
			if(countZero != countOne) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkNeighbours(){
		//Check every horizontal neighbours
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
		return true;
	}
	
	public boolean checkUniqueness() {
		String[] rowOrder = new String[gameSize];
		String[] columnOrder = new String[gameSize];
		//Check every rows
		for(int row=0; row<gameSize; row++) {
			String temp = "";
			for(int numberIndex=row*gameSize; numberIndex<row*gameSize+gameSize; numberIndex++) {
				temp = temp + Integer.toString(numberButtonList.getNumberButton(numberIndex).getValue());
			}
			rowOrder[row] = temp;
		}
		for(int index=0; index<gameSize; index++) {
			for(int index2=0; index2<gameSize; index2++) {
				if(index!=index2) {
					if(rowOrder[index].equals(rowOrder[index2])) {
						return false;
					}
				}
			}
		}
		//Check every columns
		for(int col=0; col<gameSize; col++) {
			String temp = "";
			for(int numberIndex=col; numberIndex <= col+gameSize*(gameSize-1); numberIndex = numberIndex + gameSize) {
				temp = temp + Integer.toString(numberButtonList.getNumberButton(numberIndex).getValue());
			}
			rowOrder[col] = temp;
		}
		for(int index=0; index<gameSize; index++) {
			for(int index2=0; index2<gameSize; index2++) {
				if(index!=index2) {
					if(columnOrder[index].equals(columnOrder[index2])) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
