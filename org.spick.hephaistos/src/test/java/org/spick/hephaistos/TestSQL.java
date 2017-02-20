package org.spick.hephaistos;

import static org.spick.hephaistos.Column.column;
import static org.spick.hephaistos.Equals.equals;
import static org.spick.hephaistos.TableExpression.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestSQL {

	@Test
	public void testSelect() {
		String print = SQL.select("asd", "adsasd").from(table("Tttt", "as"), table("asd", "assadad"))
				.where(And.of("asd = b")).print();
		System.out.println(print);
	}

	@Test
	public void testSelectWithListinput() {
		List<String> stringList = Arrays.asList("Test1", "Test2");
		List<IPrintable> result = new ArrayList<>();
		for (String test : stringList) {
			result.add(SQL.select(column(test)).from(table(test)).where(And.of(Equals.equals(test, test))));
		}
		result.stream().map(IPrintable::print).forEach(System.out::println);
	}

	@Test
	public void testSelectWithJoin() {
		System.out.println(SQL.select(column("TEST")).from(table("test1", "t1"), table("test2", "t2"))
				.where(And.of(Equals.equals("t1.t", "t2.t"))).print());
		
		System.out.println(SQL.select(column("TEST")).from(table("test1", "t1").join(table("test2", "t2")).on("t1.tt", "t2.ttt")).print());
		
		System.out.println(SQL.select(column("TEST")).from(table("test1").join(table("test2", "t2")).on("ttt")).print());
		
	}
}
