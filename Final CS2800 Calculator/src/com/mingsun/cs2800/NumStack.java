package com.mingsun.cs2800;
/**
 * This class represents stack which takes number elements.
 * @author Ming Sun email<zaac003@live.rhul.ac.uk>
 *
 */
public class NumStack {
	/**
	 * @param numstack Stack
	 */
	private Stack numstack;
	/**
	 * @param entry Entry
	 */
	private Entry entry;
	/**
	 * Constructor which takes no argument.
	 */
	public NumStack() {
		numstack = new Stack();
	}
	/**
	 * Add a object into the stack.
	 * @param object float
	 */
	public final void push(final float object) {
		entry = new Entry(object);
		numstack.push(entry);
	}
	/**
	 * This method remove a float object.
	 * @return	float
	 * @throws MyException Empty stack
	 */
	public final float pop() throws MyException {
		if (numstack.size() == 0) {
			throw new MyException("Empty Stack");
		} else {
			return numstack.pop().getValue();
		}
	}
	/**
	 * return true if stack is empty, false if not.
	 * @return boolean
	 */
	public final boolean isEmpty() {
		return numstack.size() == 0;
	}
}
