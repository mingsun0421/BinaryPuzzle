package com.mingsun.cs2800;
/**
 * This method is the model of calculator, include all evaluations.
 * @author Ming Sun email<zaac003@live.rhul.ac.uk>
 */
public class CalcModel {
	/**
	 * @param revPolish RevPolishCalc
	 */
	private RevPolishCalc revPolish;
	/**
	 * @param standard StandarCalc
	 */
	private StandardCalc standard;
	/**
	 * Constructor which initialise two calculation methods. 
	 */
	public CalcModel() {
		revPolish = new RevPolishCalc();
		standard = new StandardCalc();
	}
	/**
	 * This method calculates result if Infix.
	 * @param string String
	 * @return float
	 * @throws MyException Empty stack
	 */
	public final float evaluateRP(final String string) throws MyException {
		return revPolish.evaluate(string);
	}
	/**
	 * This method calculates result if not Infix.
	 * @param string String
	 * @return float
	 * @throws MyException Empty stack
	 */
	public final float evaluateSD(final String string) throws MyException {
		return standard.evaluate(string);
	}

}
