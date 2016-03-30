import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import mingsun.finalyear.project.Hint;
import mingsun.finalyear.project.NumberButton;
import mingsun.finalyear.project.NumberButtonList;

public class TestHint {

	static NumberButtonList nbList;
	static NumberButton nb, nb2, nb3, nb4;
	static Hint hint;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		nb = new NumberButton(1);
		nb2 = new NumberButton(2);
		nb3 = new NumberButton(0);
		nb4 = new NumberButton(1);
		nb.setValue(1);
		nb2.setValue(2);
		nb3.setValue(0);
		nb4.setValue(1);
		nbList = new NumberButtonList();
		nbList.add(nb);
		nbList.add(nb2);
		nbList.add(nb3);
		nbList.add(nb4);
		hint = new Hint(nbList,2);
		hint.giveHint();
	}

	@Test
	public void test1() {
		int value = nbList.getNumberButton(2).getValue();
		assertEquals("Test if cell is filled by correct answer: ",value,0);
	}

}
