import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.mingsun.cs2800.MyException;
import com.mingsun.cs2800.StrStack;


public class TestStrStack {

	private StrStack strstack;
	private String string;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
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
	@Test
	public final void testPushthenPop() throws MyException{
		strstack.push(string);
		assertEquals("TEST1: Push then Pop", string, strstack.pop());
	}
	
	@Test
	public final void testIsEmpty(){
		assertEquals("TEST: Is Emtpy", true, strstack.isEmpty());
	}

}
