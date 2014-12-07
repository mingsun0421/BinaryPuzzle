package com.mingsun.cs2800;

public class CalcModel {
	private RevPolishCalc revPolish;
	private StandardCalc standard;
	
	public CalcModel(){
		revPolish = new RevPolishCalc();
		standard = new StandardCalc();
	}

}
