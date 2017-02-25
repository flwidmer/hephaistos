package org.spick.hephaistos;

import static org.junit.Assert.assertEquals;

/**
 * Test utility. 
 * @author Florian
 *
 */
public final class TestUtil {

	private TestUtil() {
	}
	
	/**
	 * Replace double Spaces to facilitate equality testing of generated queries
	 * @param in
	 * @return
	 */
	public static final String removeDoubleSpace(String in) {
		return in.replaceAll("\\s(\\s)+", " ");
	}
	
	public static final void assertQueryEqual(String expected, String actual) {
		assertEquals(stripQuery(expected), stripQuery(actual));
	}

	private static String stripQuery(String query) {
		return removeDoubleSpace(query).trim().toLowerCase();
	}
}
