package com.mingsun.cs2800;

public class OpStack {
	static Stack opstack;
	static Entry entry;

	public OpStack() {
		opstack = new Stack();
	}

	public final void push(final Symbol value) {
		entry = new Entry(value);
		opstack.push(entry);
	}

	public final Symbol pop() throws MyException {
		if (opstack.size() == 0) {
			throw new MyException("Empty Stack");
		} else {
			return opstack.pop().getSymbol();
		}
	}
	
	public final boolean isEmpty(){
		return opstack.size() == 0;
	}
}
