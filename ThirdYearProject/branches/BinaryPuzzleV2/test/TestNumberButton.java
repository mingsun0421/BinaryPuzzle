import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import mingsun.finalyear.project.NumberButton;

/**
 * 
 */

/**
 * This is unit test of NumberButton class
 * @author Ming Sun
 *
 */
public class TestNumberButton {
	static NumberButton nb;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		nb = new NumberButton(0);
	}

	@Test
	public void testGetID() {
		int value = nb.getID();
		assertEquals(value,0);
	}
	@Test
	public void testGetValue(){
		int value = nb.getValue();
		assertEquals(value,2);
	}
	@Test
	public void testSetValue() {
		int value = 1;
		nb.setValue(value);
		assertEquals(value,nb.getValue());
	}
	@Test
	public void testSetEditable(){
		nb.setEditable(false);
		assertEquals(false, nb.getEditable());
	}
	@Test
	public void testGetEditable(){
		assertEquals(false, nb.getEditable());
	}

}
