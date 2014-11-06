import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.mingsun.cs2800.Entry;
import com.mingsun.cs2800.MyException;
import com.mingsun.cs2800.Symbol;

/**
 * @author Ming Sun <email zaac003@live.rhul.ac.uk>
 * @since 2014-10-12
 */
public class TestEntry {
	/**
	 * @param entryValue
	 *            It is an entry with value argument.
	 */
	private Entry entryValue;
	/**
	 * @param entrySymbol
	 *            It is an entry with symbol argument.
	 */
	private Entry entrySymbol;
	/**
	 * @param entryString
	 *            It is an entry with string argument.
	 */
	private Entry entryString;
	/**
	 * @param flo
	 *            It is an float number.
	 */
	private float flo;

	/**
	 * Initialise three Entry Type elements.
	 * 
	 * @throws Exception
	 *             java.lang.Exception
	 */
	@Before
	public final void setUp() throws Exception {
		entryString = new Entry("3");
		entryValue = new Entry(flo);
		entrySymbol = new Entry(Symbol.PLUS);
	}

	/**
	 * Test getTpye() method.
	 * 
	 * @throws MyException
	 *             If type Invalid.
	 */
	@Test
	public final void testGetType() throws MyException {
		assertEquals("TEST1: Get Type method", null, entryValue.getType());
	}

	/**
	 * Test getString() method.
	 * 
	 * @throws MyException
	 *             If String is null.
	 */
	@Test
	public final void testGetString() throws MyException {
		assertEquals("TEST2: Get String method", "3", entryString.getString());
	}

	/**
	 * Test getSymbol() method.
	 * 
	 * @throws MyException
	 *             If Symbol is Invalid.
	 */
	@Test
	public final void testGetSymbol() throws MyException {
		assertEquals("TEST3: Get Symbol method", Symbol.PLUS,
				entrySymbol.getSymbol());
	}

	/**
	 * Test getValue() method.
	 * 
	 * @throws MyException
	 *             If Symbol or Type is Invalid.
	 */
	@Test
	public final void testGetValue() throws MyException {
		assertEquals("TEST4: Get Value method", flo, entryValue.getValue(), 0f);
	}

}
