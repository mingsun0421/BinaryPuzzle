package com.mingsun.cs2800;

/**
 * This class provides way to calculate if it is not Infix.
 * @author Ming Sun email<zaac003@live.rhul.ac.uk>
 * @since 01/12/2014
 */
public class RevPolishCalc implements Calculator {
	/**
	 * @param values NumStack
	 */
	private NumStack values;
	/**
	 * This method will take a string expression and return the answer.
	 * @param what	String expression
	 * @return	float answer
	 * @throws MyException	Empty stack
	 */
	public final float evaluate(final String what) throws MyException {
		values = new NumStack();
		String[] tokens = what.split("\\s+");
		String operators = "+-*/";
        for (String str : tokens) {
            if (!operators.contains(str)) {
                values.push(Float.valueOf(str));
            } else {
                float first = values.pop();
                float second = values.pop();
                int index = operators.indexOf(str);
                switch (index) {
                    case 0:
                        values.push(first + second);
                        break;
                    case 1:
                        values.push(second - first);
                        break;
                    case 2:
                        values.push(first * second);
                        break;
                    case 3:
                        values.push(second / first);
                        break;
				default:
					break;
                }
            }
        }
		return values.pop();
	}
}
