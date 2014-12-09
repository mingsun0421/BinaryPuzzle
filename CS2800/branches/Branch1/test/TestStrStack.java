import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.mingsun.cs2800.MyException;
import com.mingsun.cs2800.StrStack;

/**
 * This class test StrStack class.
 * @author Ming Sun email<zaac003@live.rhul.ac.uk>
 */
public class TestStrStack {
	/**
	 * @param strstack StrStack
	 */
	private StrStack strstack;
	/**
	 * @param string String
	 */
	private String string;
	/**
	 * This method set up all elements needed.
	 * @throws Exception java.lang.Exception
	 */
	@Before
	public final void setUp() throws Exception {
		strstack = new StrStack();
		string = " ";
	}
	/*
	@Test
	public final void testPushthenPop() throws MyException{
		numstack.push(floatValue);
		assertEquals("TEST1: Push then Pop", 1, 1);
	}
	*/
	/**
	 * Test push and pop methods.
	 * @throws MyException Empty stack
	 */
	@Test
	public final void testPushthenPop() throws MyException {
		strstack.push(string);
		assertEquals("TEST1: Push then Pop", string, strstack.pop());
	}
	/**
	 * Test isEmpty method.
	 */
	@Test
	public final void testIsEmpty() {
		assertEquals("TEST: Is Emtpy", true, strstack.isEmpty());
	}

}
