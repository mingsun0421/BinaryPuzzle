import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import mingsun.finalyear.project.NumberButton;
import mingsun.finalyear.project.NumberButtonList;
/**
 * This class tests NumberButtonList class.
 * @author Ming
 *
 */
public class TestNumberButtonList {
	static NumberButtonList nbList;
	static NumberButton nb;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		nb = new NumberButton(0);
		nbList = new NumberButtonList();
	}

	@Test
	public void testAddNumberButton() {
		nbList.add(nb);
		assertEquals(nb,nbList.getNumberButton(0));
	}
	@Test
	public void testGetNumberButton() {
		NumberButton temp = nbList.getNumberButton(0);
		assertEquals(nb,temp);
	}
	@Test
	public void testGetSize() {
		assertEquals(1,nbList.getSize());
	}

}
