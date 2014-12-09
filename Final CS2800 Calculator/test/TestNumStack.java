import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.mingsun.cs2800.MyException;
import com.mingsun.cs2800.NumStack;

/**
 * This class test class NumStack.
 * @author Ming
 *
 */
public class TestNumStack {
	/**
	 * @param numstack NumStack
	 */
	private NumStack numstack;
	/**
	 * @param floatNumber float
	 */
	private float floatNumber;

	/**
	 * this method set up all elements needed.
	 * @throws Exception java.lang.Exception
	 */
	@Before
	public final void setUp() throws Exception {
		numstack = new NumStack();
		floatNumber = 0;
	}
	/*
	@Test
	public final void testPushthenPop() throws MyException{
		numstack.push(floatValue);
		assertEquals("TEST1: Push then Pop", 1, 1);
	}
	*/
	/**
	 * This method test push and pop method.
	 * @throws MyException Empty Stack
	 */
	@Test
	public final void testPushthenPop() throws MyException {
		numstack.push(floatNumber);
		assertEquals("TEST1: Push then Pop", floatNumber, numstack.pop(), 0f);
	}
	/**
	 * This method test isEmpty method.
	 */
	@Test
	public final void testIsEmpty() {
		assertEquals("TEST: Is Emtpy", true, numstack.isEmpty());
	}
}
