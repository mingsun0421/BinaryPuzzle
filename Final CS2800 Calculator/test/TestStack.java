import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.mingsun.cs2800.Entry;
import com.mingsun.cs2800.MyException;
import com.mingsun.cs2800.Stack;

/**
 * @author Ming Sun <email zaac003@live.rhul.ac.uk>
 * @since 2014-10-12
 */
public class TestStack {
	/**
	 * @param stack
	 *            The name of stack in test.
	 */
	private Stack stack;
	/**
	 * @param entry
	 *            The name of entry in test.
	 */
	private Entry entry;
	/**
	 * @param floatValue
	 *            The value of entry take in test.
	 */
	private float floatValue;

	/**
	 * Initialise an Empty Entry Type Stack and an Entry element.
	 * 
	 * @throws Exception
	 *             java.lang.Exception
	 */
	@Before
	public final void setUp() throws Exception {
		stack = new Stack();
		entry = new Entry(floatValue);
	}

	/**
	 * It is previous test
	 * 
	 * @Test public void pushThenTop() { stack.push(3);
	 *       assertEquals("TEST1: Push then Top", 3, stack.top()); }
	 */
	/**
	 * Test 1 test Stack push and then top.
	 * 
	 * @throws MyException
	 *             If Empty Stack
	 */
	@Test
	public final void pushThenTop() throws MyException {
		stack.push(entry);
		assertEquals("TEST1: Push then Top", entry, stack.top());
	}

	/**
	 * It is previous test
	 * 
	 * @Test public void pushThenSize() { stack.push(5);
	 *       assertEquals("TEST2: Push then Size", 1, stack.size()); }
	 */
	/**
	 * Test 2 test Stack push and then size.
	 */
	@Test
	public final void pushThenSize() {
		stack.push(entry);
		assertEquals("TEST2: Push then Size", 1, stack.size());
	}

	/**
	 * It is previous test
	 * 
	 * @Test public void pushThenPop() { stack.push(3);
	 *       assertEquals("TEST1: Push then Pop", 3, stack.pop()); }
	 */
	/**
	 * Test 3 test Stack push and then pop.
	 * 
	 * @throws MyException
	 *             If Empty Stack
	 */
	@Test
	public final void pushThenPop() throws MyException {
		stack.push(entry);
		assertEquals("TEST3: Push then Pop", entry, stack.pop());
	}

}
