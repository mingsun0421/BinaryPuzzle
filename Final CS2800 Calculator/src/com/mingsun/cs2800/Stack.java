package com.mingsun.cs2800;

import java.util.LinkedList;

/**
 * @author Ming Sun <email zaac003@live.rhul.ac.uk>
 * @since 2014-10-12
 */
public class Stack {
	/**
	 * @param size
	 *            The length of the Entry list.
	 */
	private int size;
	/**
	 * @param entries
	 *            The entry list.
	 */
	private LinkedList<Entry> entries;

	/**
	 * Constructs and initialise a type Entry LinkedList with size 0.
	 */
	public Stack() {
		size = 0;
		entries = new LinkedList<Entry>();
	}

	/**
	 * Pushes an Entry type element on to the top of the stack.
	 * 
	 * @param entry
	 *            The Entry type element to be pushed
	 */
	public final void push(final Entry entry) {
		entries.add(entry);
		size += 1;
	}

	/**
	 * Get the newest Entry type element on the stack.
	 * 
	 * @return An Entry element
	 * @throws MyException
	 *             If Empty Stack
	 */
	public final Entry top() throws MyException {
		if (entries.size() == 0) {
			throw new MyException("Empty Stack");
		} else {
			return entries.get(size - 1);
		}
	}

	/**
	 * Get the size of the Stack.
	 * 
	 * @return Integer size
	 */
	public final int size() {
		return size;
	}

	/**
	 * Get the newest Entry type element of the Stack.
	 * 
	 * @return An Entry element
	 * @throws MyException
	 *             If Empty Stack
	 */
	public final Entry pop() throws MyException {
		Entry temp;
		if (size == 0) {
			throw new MyException("Empty Stack");
		} else {
			temp = entries.get(size - 1);
			entries.remove(size - 1);
			size -= 1;
			return temp;
		}
	}

}
