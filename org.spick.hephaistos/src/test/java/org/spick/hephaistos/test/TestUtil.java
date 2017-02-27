package org.spick.hephaistos.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * Test utility. 
 * @author Florian
 *
 */
public final class TestUtil {

	private static class Replacement {
		
		private String pattern;
		private String replacement;

		public Replacement(String pattern, String replacement) {
			this.pattern = pattern;
			this.replacement = replacement;
		}
		
		String replace(String in) {
			return in.replaceAll(pattern, replacement);
		}
	}
	
	private static final List<Replacement> replacements; 
	static {
		replacements = new ArrayList<>();
		replacements.add(new Replacement("\\s(\\s)+", " "));
		replacements.add(new Replacement("\\(\\s", "("));
		replacements.add(new Replacement("\\s\\)", ")"));
	}
	
	private TestUtil() {
	}
	
	/**
	 * Replace double Spaces to facilitate equality testing of generated queries
	 * @param in
	 * @return
	 */
	public static final String removeDoubleSpace(String in) {
		String result = in;
		for (Replacement replacement : replacements) {
			result = replacement.replace(result);
		}
		return result;
	}
	
	public static final void assertQueryEqual(String expected, String actual) {
		assertEquals(stripQuery(expected), stripQuery(actual));
	}

	private static String stripQuery(String query) {
		return removeDoubleSpace(query).trim().toLowerCase();
	}
	
	
}
