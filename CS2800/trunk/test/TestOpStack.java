import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mingsun.cs2800.MyException;
import com.mingsun.cs2800.NumStack;
import com.mingsun.cs2800.OpStack;
import com.mingsun.cs2800.Symbol;


public class TestOpStack {
	private OpStack opstack;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		opstack = new OpStack();
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
		opstack.push(Symbol.PLUS);
		assertEquals("TEST1: Push then Pop", Symbol.PLUS, opstack.pop());
	}
	
	@Test
	public final void testIsEmpty(){
		assertEquals("TEST: Is Emtpy", true, opstack.isEmpty());
	}

}
