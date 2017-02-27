package org.spick.hephaistos.condition;

import org.junit.Test;
import org.spick.hephaistos.test.TestUtil;

public class OrTest {

	@Test
	public void testChaining() {
		Or q1 = Or.of(Equals.equals("x", "y")).or(Equals.equals("a", "b"));
		TestUtil.assertQueryEqual("((x = y) or (a = b))", q1.print());
		Or q2 = Or.of("x = y").or("a = b");
		TestUtil.assertQueryEqual("((x = y) or (a = b))", q2.print());
	}

	@Test(expected = NullPointerException.class)
	public void testException() {
		Or.of((String) null);
	}

}
