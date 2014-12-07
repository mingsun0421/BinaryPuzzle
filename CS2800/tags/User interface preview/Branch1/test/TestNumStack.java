import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mingsun.cs2800.MyException;
import com.mingsun.cs2800.NumStack;

/**
 * 
 */

/**
 * @author Ming
 *
 */
public class TestNumStack {
	private NumStack numstack;
	private float floatNumber;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
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
	@Test
	public final void testPushthenPop() throws MyException{
		numstack.push(floatNumber);
		assertEquals("TEST1: Push then Pop", floatNumber, numstack.pop(), 0f);
	}
	
	@Test
	public final void testIsEmpty(){
		assertEquals("TEST: Is Emtpy", true, numstack.isEmpty());
	}
}
