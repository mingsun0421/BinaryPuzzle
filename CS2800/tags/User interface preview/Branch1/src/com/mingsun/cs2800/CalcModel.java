package com.mingsun.cs2800;

public class CalcModel {
	private RevPolishCalc revPolish;
	private StandardCalc standard;
	
	public CalcModel(){
		revPolish = new RevPolishCalc();
		standard = new StandardCalc();
	}
	
	
	public float evaluateRP(String string) throws MyException{
		return revPolish.evaluate(string);
	}
	
	public float evaluateSD(String string) throws MyException{
		return standard.evaluate(string);
	}

}
