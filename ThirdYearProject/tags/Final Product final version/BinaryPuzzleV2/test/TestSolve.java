import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import mingsun.finalyear.project.NumberButton;
import mingsun.finalyear.project.NumberButtonList;
import mingsun.finalyear.project.SolvePuzzle;

/**
 * This JUnit test SolvePuzzle class.
 * 
 * @author Ming Sun
 *
 */
public class TestSolve {
	static NumberButtonList nbList;
	static NumberButton nb, nb2, nb3, nb4;
	static SolvePuzzle solvePuzzle;

	/**
	 * Set up before the test methods are executed.
	 * 
	 * @throws Exception
	 */
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
		solvePuzzle = new SolvePuzzle(nbList, 2);
	}

	/**
	 * Test backtracking algorithm.
	 */
	@Test
	public void testBacktracking() {
		solvePuzzle.solverIt();
		int value = nbList.getNumberButton(2).getValue();
		assertEquals("Test if cell is filled by correct answer: ", value, 0);
	}

	/**
	 * Test brute force algorithm.
	 */
	@Test
	public void testBruteForce() {
		solvePuzzle.solveItBF();
		int value = nbList.getNumberButton(2).getValue();
		assertEquals("Test if cell is filled by correct answer: ", value, 0);
	}

}
