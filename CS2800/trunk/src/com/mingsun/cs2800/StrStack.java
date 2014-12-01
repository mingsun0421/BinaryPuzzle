package com.mingsun.cs2800;

public class StrStack {
	static Stack strstack;
	static Entry entry;

	public StrStack() {
		strstack = new Stack();
	}

	public final void push(final String value) {
		entry = new Entry(value);
		strstack.push(entry);
	}

	public final String pop() throws MyException {
		if (strstack.size() == 0) {
			throw new MyException("Empty Stack");
		} else {
			return strstack.pop().getString();
		}
	}
	
	public final boolean isEmpty(){
		return strstack.size() == 0;
	}
}
