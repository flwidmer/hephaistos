package org.spick.hephaistos.condition;

import static org.junit.Assert.*;

import org.junit.Test;
import org.spick.hephaistos.test.TestUtil;

public class AndTest {

	@Test
	public void testChaining() {
		And q1 = And.of(Equals.equals("x", "y")).and(Equals.equals("a", "b"));
		TestUtil.assertQueryEqual("((x = y) and (a = b))", q1.print());
		And q2 = And.of("x = y").and("a = b");
		TestUtil.assertQueryEqual("((x = y) and (a = b))", q2.print());
	}

	@Test(expected = NullPointerException.class)
	public void testException() {
		And.of((String) null);
	}

}
