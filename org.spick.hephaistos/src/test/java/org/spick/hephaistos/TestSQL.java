package org.spick.hephaistos;

import static org.spick.hephaistos.TableExpression.table;

import org.junit.Test;

public class TestSQL {

	@Test
	public void testSelect() {
		String print = SQL.select("asd","adsasd").from(table("Tttt", "as"), table("asd","assadad")).where(And.of("asd = b")).print();
		System.out.println(print);
	}
}
