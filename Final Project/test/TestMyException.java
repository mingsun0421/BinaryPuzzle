import org.junit.Before;
import org.junit.Test;
import com.mingsun.cs2800.Entry;
import com.mingsun.cs2800.MyException;
import com.mingsun.cs2800.Stack;
import com.mingsun.cs2800.Symbol;
import com.mingsun.cs2800.Type;

/**
 * @author Ming Sun <email zaac003@live.rhul.ac.uk>
 * @since 2014-10-12
 */
public class TestMyException {
	/**
	 * @param mystac
	 *            The name of stack in test.
	 */
	private Stack mystac;
	/**
	 * @param entryString
	 *            The name of entry in test with string argument.
	 */
	private Entry entryString;
	/**
	 * @param entrySymbol
	 *            The name of entry in test with symbol argument.
	 */
	private Entry entrySymbol;
	/**
	 * @param entryType
	 *            The name of entry in test with type argument.
	 */
	private Entry entryType;

	/**
	 * Initialise 3 new Entry elements.
	 * 
	 * @throws Exception
	 *             java.lang.Exception
	 */
	@Before
	public final void setUp() throws Exception {
		entrySymbol = new Entry(Symbol.INVALID);
		entryType = new Entry(Type.INVALID);
		entryString = new Entry("");

		mystac = new Stack();
	}

	/**
	 * Test MyException if symbol is invalid.
	 * 
	 * @throws MyException
	 *             If symbol is invalid.
	 */
	@Test(expected = MyException.class)
	public final void testEntryMyException1() throws MyException {
		entrySymbol.getSymbol();
	}

	/**
	 * Test MyException if type is invalid.
	 * 
	 * @throws MyException
	 *             If type is invalid.
	 */
	@Test(expected = MyException.class)
	public final void testEntryMyException2() throws MyException {
		entryType.getType();
	}

	/**
	 * Test MyException if string is empty.
	 * 
	 * @throws MyException
	 *             If string is empty.
	 */
	@Test(expected = MyException.class)
	public final void testEntryMyException3() throws MyException {
		entryString.getString();
	}

	/**
	 * Test MyException if stack is empty.
	 * 
	 * @throws MyException
	 *             If stack is empty.
	 */
	@Test(expected = MyException.class)
	public final void testStackMyException() throws MyException {
		mystac.top();
	}

}
