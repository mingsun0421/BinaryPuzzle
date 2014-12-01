package com.mingsun.cs2800;

public class NumStack {
	static Stack numstack;
	static Entry entry;

	public NumStack() {
		numstack = new Stack();
	}

	public final void push(final float value) {
		entry = new Entry(value);
		numstack.push(entry);
	}

	public final float pop() throws MyException {
		if (numstack.size() == 0) {
			throw new MyException("Empty Stack");
		} else {
			return numstack.pop().getValue();
		}
	}
	
	public final boolean isEmpty(){
		return numstack.size() == 0;
	}
}
