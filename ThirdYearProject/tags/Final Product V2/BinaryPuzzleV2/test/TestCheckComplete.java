import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import mingsun.finalyear.project.CheckComplete;
import mingsun.finalyear.project.NumberButton;
import mingsun.finalyear.project.NumberButtonList;

/**
 * This class test CheckComplete class.
 * 
 * @author Ming Sun
 *
 */
public class TestCheckComplete {
	static NumberButtonList nbList, nbList2;
	static NumberButton nb, nb2;
	static CheckComplete cc, cc2;

	/**
	 * Set up before the test methods are executed.
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		nb = new NumberButton(0);
		nb.setValue(1);
		nb2.setValue(2);
		nb2 = new NumberButton(0);
		nbList = new NumberButtonList();
		nbList2 = new NumberButtonList();
		nbList.add(nb);
		nbList2.add(nb2);
		cc = new CheckComplete(nbList, 1);
		cc2 = new CheckComplete(nbList2, 1);
	}

	/**
	 * Test a complete puzzle grid.
	 */
	@Test
	public void test1() {
		assertEquals(true, cc.ifComplete());
	}

	/**
	 * Test a incomplete puzzle grid.
	 */
	@Test
	public void test2() {
		assertEquals(false, cc2.ifComplete());
	}

}
