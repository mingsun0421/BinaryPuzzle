package com.mingsun.cs2800;

/**
 * This is the Enum class for all type we might use for calculator.
 * 
 * @author Ming Sun <email zaac003@live.rhul.ac.uk>
 * @since 2014-10-12
 */
public enum Type {
	/**
	 * @param NUMBER
	 *            Entry's value type is a number.
	 */
	NUMBER,
	/**
	 * @param SYMBOL
	 *            Entry's value type is symbol.
	 */
	SYMBOL,
	/**
	 * @param STRING
	 *            Entry's value type is string.
	 */
	STRING,
	/**
	 * @param INVALID
	 *            Entry's value type is none above.
	 */
	INVALID;
}
