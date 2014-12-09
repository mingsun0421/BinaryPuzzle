import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mingsun.cs2800.MyException;
import com.mingsun.cs2800.RevPolishCalc;

/**
 * This test tests RevPolishCalc class.
 * @author Ming Sun email<zaac003@live.rhul.ac.uk>
 *
 */
public class TestRevPolishCalc {
	/**
	 * @param rpc RevPolishCalc
	 */
	private RevPolishCalc rpc;
	/**
	 * @param string String
	 */
	private String string;
	/**
	 * This method set all necessary arguments.
	 * @throws Exception java.lang.Exception
	 */
	@Before
	public final void setUp() throws Exception {
		rpc = new RevPolishCalc();
		string = "5 6 7 + * 2 -";
	}
	/**
	 * This test tests evaluate method.
	 * @throws MyException Emtpy stack
	 */
	@Test
	public final void test() throws MyException {
		assertEquals("TEST1: test evaluate method", 
				63.0, rpc.evaluate(string), 0f);
	}

}
