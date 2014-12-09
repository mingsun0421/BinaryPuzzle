import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mingsun.cs2800.MyException;
import com.mingsun.cs2800.OpStack;
import com.mingsun.cs2800.Symbol;

/**
 * This unit test OpStack class.
 * @author Ming Sun email<zaac003@live.rhul.ac.uk>
 *
 */
public class TestOpStack {
	/**
	 * @param opstack OpStack
	 */
	private OpStack opstack;

	/**
	 * This method set all necessary arguments.
	 * @throws Exception java.lang.Exception
	 */
	@Before
	public final void setUp() throws Exception {
		opstack = new OpStack();
	}
	/*
	@Test
	public final void testPushthenPop() throws MyException{
		numstack.push(floatValue);
		assertEquals("TEST1: Push then Pop", 1, 1);
	}
	*/
	/**
	 * Test of push and pop methods.
	 * @throws MyException Empty Stack
	 */
	@Test
	public final void testPushThenPop() throws MyException {
		opstack.push(Symbol.PLUS);
		assertEquals("TEST1: Push then Pop", Symbol.PLUS, opstack.pop());
	}
	/**
	 * Test isEmpty method.
	 */
	@Test
	public final void testIsEmpty() {
		assertEquals("TEST2: Is Emtpy", true, opstack.isEmpty());
	}
	/**
	 * This test tests psuh and top methods.
	 * @throws MyException Empty stack
	 */
	@Test
	public final void testPushThenTop() throws MyException {
		opstack.push(Symbol.PLUS);
		assertEquals("TEST3: Is Emtpy", Symbol.PLUS, opstack.top());
	}
}
