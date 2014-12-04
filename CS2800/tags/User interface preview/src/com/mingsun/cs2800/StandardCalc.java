package com.mingsun.cs2800;
import java.util.Stack;

public class StandardCalc {
	//private OpStack values;
	private RevPolishCalc rpCalc;
	public final float evaluate(String what) throws MyException{
		if(what == null){
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

	    for (int i = 0; i < in.length; i++)
	        switch (in[i]) {
	        case '+':
	        case '-':
	            while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/')) {
	                out.append(' ');
	                out.append(stack.pop());
	            }
	            out.append(' ');
	            stack.push(in[i]);
	            break;
	        case '*':
	        case '/':
	            out.append(' ');
	            stack.push(in[i]);
	            break;
	        case '(':
	            stack.push(in[i]);
	            break;
	        case ')':
	            while (!stack.empty() && stack.peek() != '(') {
	                out.append(' ');
	                out.append(stack.pop());
	            }
	            stack.pop();
	            break;
	        default:
	            out.append(in[i]);
	            break;
	        }

	    while (!stack.isEmpty()){
	    	out.append(' ').append(stack.pop());
	    }
		return rpCalc.evaluate(out.toString());
	}
	public final String symbolToString(Symbol symbol){
		if(symbol == Symbol.DIVIDE){
			return "/";
		}
		else if(symbol == Symbol.LEFTBRACKET){
			return "(";
		}
		else if(symbol == Symbol.MINUS){
			return "-";
		}
		else if(symbol == Symbol.PLUS){
			return "+";
		}
		else if(symbol == Symbol.RIGHTBRACKET){
			return "(";
		}
		else if(symbol == Symbol.TIMES){
			return "*";
		}
		else{
			return "";
		}
	}
}
