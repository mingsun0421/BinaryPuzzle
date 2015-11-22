package mingsun.finalyear.project;

public class CheckComplete {
	private NumberButtonList numberButtonList;
	private int gameSize;
	
	public CheckComplete(NumberButtonList numberButtonList, int gameSize) {
		this.numberButtonList = numberButtonList;
		this.gameSize = gameSize;
	}
	
	public boolean ifComplete() {
		for(int index=0; index<numberButtonList.getSize(); index++){
			if(numberButtonList.getNumberButton(index).getValue()==2){
				return false;
			}
		}
		return true;
	}
}
