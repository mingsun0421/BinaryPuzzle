package com.mingsun.cs2800;
import java.util.Stack;
/**
 * This class provides way to calculate if it is Infix.
 * @author Ming Sun email<zaac003@live.rhul.ac.uk>
 * @since 02/12/2014
 */
public class StandardCalc {
	/**
	 * @param rpCalc It is a RevPolishCalc.
	 */
	private RevPolishCalc rpCalc;
	/**
	 * This method will take a string expression and return the answer.
	 * @param what	String expression
	 * @return	float answer
	 * @throws MyException	Empty stack
	 */
	public final float evaluate(final String what) throws MyException {
		if (what == null) {
			return 0;
		}
		//char[] input = what.toCharArray();
		//Stack<Character> values = new Stack<Character>();
		//values = new OpStack();
		rpCalc = new RevPolishCalc();
		//String[] tokens = what.split("\\s+");
		//StringBuilder output = new StringBuilder();
	    char[] in = what.toCharArray();
	    Stack<Character> stack = new Stack<Character>();
	    StringBuilder out = new StringBuilder();

	    for (int index = 0; index < in.length; index++) {
			switch (in[index]) {
	        case '+':
	        case '-':
	            while (!stack.empty() && (stack.peek() == '*' 
	            || stack.peek() == '/')) {
	                out.append(' ');
	                out.append(stack.pop());
	            }
	            out.append(' ');
	            stack.push(in[index]);
	            break;
	        case '*':
	        case '/':
	            out.append(' ');
	            stack.push(in[index]);
	            break;
	        case '(':
	            stack.push(in[index]);
	            break;
	        case ')':
	            while (!stack.empty() && stack.peek() != '(') {
	                out.append(' ');
	                out.append(stack.pop());
	            }
	            stack.pop();
	            break;
	        default:
	            out.append(in[index]);
	            break;
	        }
		}

	    while (!stack.isEmpty()) {
	    	out.append(' ').append(stack.pop());
	    }
		return rpCalc.evaluate(out.toString());
	}
	/**
	 * This method will transfer symbol into string.
	 * @param symbol	Symbol
	 * @return	String
	 */
	public final String symbolToString(final Symbol symbol) {
		if (symbol == Symbol.DIVIDE) {
			return "/";
		} else if (symbol == Symbol.LEFTBRACKET) {
			return "(";
		} else if (symbol == Symbol.MINUS) {
			return "-";
		} else if (symbol == Symbol.PLUS) {
			return "+";
		} else if (symbol == Symbol.RIGHTBRACKET) {
			return "(";
		} else if (symbol == Symbol.TIMES) {
			return "*";
		} else {
			return "";
		}
	}
}
