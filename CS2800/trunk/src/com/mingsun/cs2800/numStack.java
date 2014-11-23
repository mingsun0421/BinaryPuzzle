package com.mingsun.cs2800;

public class numStack {
	static Stack numstack;
	static Entry entry;
	
	public numStack(){
		numstack = new Stack();
	}
	public static void push(float value) {
		// TODO Auto-generated method stub
		entry = new Entry(value);
		numstack.push(entry);
	}
	public Object pop() throws MyException {
		// TODO Auto-generated method stub
		if(numstack.size()==0){
			throw new MyException("Empty Stack");
		}
		else
			return numstack.pop();
	}
}
