import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mingsun.cs2800.MyException;
import com.mingsun.cs2800.RevPolishCalc;


public class TestRevPolishCalc {
	private RevPolishCalc rpc;
	private String string;
	@Before
	public void setUp() throws Exception {
		rpc = new RevPolishCalc();
		string = "5 6 7 + * 2 -";
	}

	@Test
	public void test() throws MyException {
		assertEquals("TEST1: test evaluate method", 63.0, rpc.evaluate(string), 0f);
	}

}
