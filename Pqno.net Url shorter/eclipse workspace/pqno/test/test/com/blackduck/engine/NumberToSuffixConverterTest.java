/**
 * 
 */
package test.com.blackduck.engine;

import static org.junit.Assert.*;

import net.pqno.engine.NumberToSuffixConverter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author dudu
 * 
 */
public class NumberToSuffixConverterTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link net.pqno.engine.NumberToSuffixConverter#convert(long, java.lang.String[])}
	 * .
	 */
	@Test
	public void testConvertLongStringArray1() {
		NumberToSuffixConverter con = new NumberToSuffixConverter();
		assertEquals("0", con.convert(0));
	}

	@Test
	public void testConvertLongStringArray2() {
		NumberToSuffixConverter con = new NumberToSuffixConverter();
		assertEquals("a", con.convert(10));
	}

	@Test
	public void testConvertLongStringArray3() {
		NumberToSuffixConverter con = new NumberToSuffixConverter();
		assertEquals("k", con.convert(20));
	}

	@Test
	public void testConvertLongStringArray4() {
		NumberToSuffixConverter con = new NumberToSuffixConverter();
		assertEquals("11", con.convert(63));
	}

	
	@Test
	public void testConvertLongStringArray6() {
		NumberToSuffixConverter con = new NumberToSuffixConverter();
		assertEquals("z", con.convert(35));
	}

	@Test
	public void testConvertLongStringArray7() {
		NumberToSuffixConverter con = new NumberToSuffixConverter();
		assertEquals("1a", con.convert(72));
	}

	/**
	 * Test method for
	 * {@link net.pqno.engine.NumberToSuffixConverter#convert(long)}.
	 */
	@Test
	public void testConvertLong() {
		NumberToSuffixConverter con = new NumberToSuffixConverter();
		String base[] = new String[] { "a", "b", "c" };
		assertEquals("a", con.convert(0, base));
		assertEquals("b", con.convert(1, base));
		assertEquals("c", con.convert(2, base));
		assertEquals("ba", con.convert(3, base));
	}

}
