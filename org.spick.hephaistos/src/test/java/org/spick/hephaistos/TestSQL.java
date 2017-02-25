package org.spick.hephaistos;

import static org.spick.hephaistos.Column.column;
import static org.spick.hephaistos.TableExpression.table;
import static org.spick.hephaistos.TestUtil.assertQueryEqual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestSQL {

	@Test
	public void testSelect() {
		String print = SQL.select("asd", "adsasd").from(table("Tttt", "as"), table("asd", "assadad"))
				.where(And.of("asd = b")).print();
		assertQueryEqual("select asd, adsasd from Tttt as, asd assadad where asd = b", print);
	}

	@Test
	public void testSelectWithListinput() {
		List<String> stringList = Arrays.asList("Test1", "Test2");
		List<IPrintable> result = new ArrayList<>();
		for (String test : stringList) {
			result.add(SQL.select(column(test)).from(table(test)).where(And.of(Equals.equals(test, test))));
		}
		assertQueryEqual("select Test1 from Test1 where Test1 = Test1", result.get(0).print());
		assertQueryEqual("select Test2 from Test2 where Test2 = Test2", result.get(1).print());
	}

	@Test
	public void testSelectWithJoin() {
		String q1 = SQL.select(column("TEST")).from(table("test1", "t1"), table("test2", "t2"))
				.where(And.of(Equals.equals("t1.t", "t2.t"))).print();
		assertQueryEqual("select TEST from test1 t1, test2 t2 where t1.t = t2.t", q1);
		
		String q2 = SQL.select(column("TEST")).from(table("test1", "t1").join(table("test2", "t2")).on("t1.tt", "t2.ttt")).print();
		assertQueryEqual("select TEST from test1 t1 join test2 t2 on t1.tt = t2.ttt", q2);
		
		String q3 = SQL.select(column("TEST")).from(table("test1").join(table("test2", "t2")).on("ttt")).print();
		assertQueryEqual("select TEST from test1 join test2 t2 on test1.ttt = t2.ttt", q3);
	}
}
