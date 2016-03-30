import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import mingsun.finalyear.project.NumberButton;
import mingsun.finalyear.project.NumberButtonList;

/**
 * This class tests NumberButtonList class.
 * 
 * @author Ming Sun
 *
 */
public class TestNumberButtonList {
	static NumberButtonList nbList;
	static NumberButton nb;

	/**
	 * Set up before the test methods are executed.
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		nb = new NumberButton(0);
		nbList = new NumberButtonList();
	}

	/**
	 * Test addNumberButton method.
	 */
	@Test
	public void testAddNumberButton() {
		nbList.add(nb);
		assertEquals(nb, nbList.getNumberButton(0));
	}

	/**
	 * Test getNumberButton method.
	 */
	@Test
	public void testGetNumberButton() {
		NumberButton temp = nbList.getNumberButton(0);
		assertEquals(nb, temp);
	}

	/**
	 * Test getSize method.
	 */
	@Test
	public void testGetSize() {
		assertEquals(1, nbList.getSize());
	}

}
