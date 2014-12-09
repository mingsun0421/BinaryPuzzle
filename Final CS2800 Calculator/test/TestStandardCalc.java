import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mingsun.cs2800.MyException;
import com.mingsun.cs2800.StandardCalc;

/**
 * This test tests StandardCalc class.
 * @author Ming Sun email<zaac003@live.rhul.ac.uk>
 *
 */
public class TestStandardCalc {
	/**
	 * @param sdc StandardCalc
	 */
	private StandardCalc sdc;
	/**
	 * @param string String
	 */
	private String string;
	/**
	 * Set up all necessary arguments needed.
	 * @throws Exception java.lang.Exception
	 */
	@Before
	public final void setUp() throws Exception {
		sdc = new StandardCalc();
		string = "(5 * (6 + 7)) - 2";
	}
	/**
	 * This test tests evaluate method.
	 * @throws MyException Empty stack
	 */
	@Test
	public final void test() throws MyException {
		assertEquals("TEST1: test evaluate method", 
				63.0, sdc.evaluate(string), 0f);
	}

}
