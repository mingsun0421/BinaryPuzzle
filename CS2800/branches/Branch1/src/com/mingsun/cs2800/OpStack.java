package com.mingsun.cs2800;
/**
 * This class represent a stack which takes operator arguments.
 * @author Ming Sun email<zaac003@live.rhul.ac.uk>
 * @since 28/11/2014
 */
public class OpStack {
	/**
	 * @param opstack Stack
	 */
	private Stack opstack;
	/**
	 * @param entry Entry
	 */
	private Entry entry;
	/**
	 * Constructor of OpStack.
	 */
	public OpStack() {
		opstack = new Stack();
	}
	/**
	 * This method push a symbol into stack.
	 * @param value	Symbol
	 */
	public final void push(final Symbol value) {
		entry = new Entry(value);
		opstack.push(entry);
	}
	/**
	 * This method remove a symbol from stack.
	 * @return Symbol
	 * @throws MyException empty stack
	 */
	public final Symbol pop() throws MyException {
		if (opstack.size() == 0) {
			throw new MyException("Empty Stack");
		} else {
			return opstack.pop().getSymbol();
		}
	}
	/**
	 * This method return a top element from stack without removing it.
	 * @return	Symbol
	 * @throws MyException Empty stack
	 */
	public final Symbol top() throws MyException {
		if (opstack.size() == 0) {
			throw new MyException("Empty Stack");
		} else {
			return opstack.top().getSymbol();
		}
	}
	/**
	 * This method return true if stack is empty, false if not.
	 * @return	boolean
	 */
	public final boolean isEmpty() {
		return opstack.size() == 0;
	}
}
