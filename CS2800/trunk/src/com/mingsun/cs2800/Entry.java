package com.mingsun.cs2800;

/**
 * @author Ming Sun <email zaac003@live.rhul.ac.uk>
 * @since 2014-10-12
 */
public class Entry {
	/**
	 * @param number
	 *            This is number of entry.
	 */
	private float number;
	/**
	 * @param other
	 *            This is the symbol of entry.
	 */
	private Symbol other;
	/**
	 * @param str
	 *            This is the input string of entry
	 */
	private String str;
	/**
	 * @param type
	 *            This is type of entry.
	 */
	private Type type;

	/**
	 * Constructor which initialise A Entry.
	 * 
	 * @param value
	 *            Float number as the value of the Entry
	 */
	public Entry(final float value) {
		number = value;
	}

	/**
	 * Constructor which initialise A Entry.
	 * 
	 * @param which
	 *            Symbol of the Entry
	 */
	public Entry(final Symbol which) {
		other = which;
	}

	/**
	 * Constructor which initialise A Entry.
	 * 
	 * @param string
	 *            The string argument of the entry
	 */
	public Entry(final String string) {
		str = string;
	}

	/**
	 * Constructor which initialise A Entry.
	 * 
	 * @param thetype
	 *            The type argument of the entry
	 */
	public Entry(final Type thetype) {
		type = thetype;
	}

	/**
	 * Get the Type of the Entry element.
	 * 
	 * @return Type The type of element.
	 * @throws MyException
	 *             Type is Invalid
	 */
	public final Type getType() throws MyException {

		if (type == Type.INVALID) {
			throw new MyException("Invalid Type");
		} else {
			return type;
		}
	}

	/**
	 * Get the String of the Entry Element.
	 * 
	 * @return String The string of element.
	 * @throws MyException
	 *             If String is empty
	 */
	public final String getString() throws MyException {
		if (str == "" || str == null) {
			throw new MyException("Invalid Input");
		} else {
			return str;
		}
	}

	/**
	 * Get the Symbol of the Entry Element.
	 * 
	 * @return Symbol The symbol of element.
	 * @throws MyException
	 *             If Symbol is Invalid
	 */
	public final Symbol getSymbol() throws MyException {

		if (other == Symbol.INVALID) {
			throw new MyException("Invalid Symbol");
		} else {
			return other;
		}
	}

	/**
	 * Get the Value of the Entry Element.
	 * 
	 * @return float The number of element.
	 * @throws MyException
	 *             If type or symbol is invalid
	 */
	public final float getValue() throws MyException {

		if (type == Type.INVALID || other == Symbol.INVALID) {
			throw new MyException("Invalid Input");
		} else {
			return number;
		}
	}

}
