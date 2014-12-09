package com.mingsun.cs2800;
/**
 * This class represent a stack contain only string arguments.
 * @author Ming Sun <email: zaac003@live.rhul.ac.uk>
 * @since 28/11/2014
 */
public class StrStack {
	/**
	 * @param strstack	The stack contain strings.
	 */
	private static Stack strstack;
	/**
	 * @param entry	The kind of entry.
	 */
	private static Entry entry;
	/**
	 * The is constructor which initialise strstack to a new Stack.
	 */
	public StrStack() {
		strstack = new Stack();
	}
	/**
	 * This method will add a string element into a stack.
	 * @param value	String argument.
	 */
	public final void push(final String value) {
		entry = new Entry(value);
		strstack.push(entry);
	}
	/**
	 * This method will remove a string element from a stack.
	 * @return	String
	 * @throws MyException	If stack is empty.
	 */
	public final String pop() throws MyException {
		if (strstack.size() == 0) {
			throw new MyException("Empty Stack");
		} else {
			return strstack.pop().getString();
		}
	}
	/**
	 * This method will return true if it is empty, false if it is not.
	 * @return	Boolean
	 */
	public final boolean isEmpty() {
		return strstack.size() == 0;
	}
}
