import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mingsun.cs2800.Entry;
import com.mingsun.cs2800.MyException;
import com.mingsun.cs2800.numStack;

/**
 * 
 */

/**
 * @author Ming
 *
 */
public class TestNumStack {
	private numStack numstack;
	private float floatValue;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		numstack = new numStack();
	}

	@Test
	public final void testPushthenTop() throws MyException{
		numstack.push(floatValue);
		assertEquals("TEST1: Push then Top", floatValue, numstack.pop());
	}

}
