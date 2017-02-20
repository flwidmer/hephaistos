package org.spick.hephaistos;

import static org.spick.hephaistos.Column.column;
import static org.spick.hephaistos.TableExpression.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestSQL {

	@Test
	public void testSelect() {
		String print = SQL.select("asd","adsasd").from(table("Tttt", "as"), table("asd","assadad")).where(And.of("asd = b")).print();
		System.out.println(print);
	}
	
	@Test
	public void testSelectLambda() {
		List<String> stringList = Arrays.asList("Test1", "Test2");
		List<IPrintable> result = new ArrayList<>();
		for (String test : stringList) {
			result.add(SQL.select(column(test)).from(table(test)).where(And.of(Equals.equals(test,test))));
		}
		result.stream().map(IPrintable::print).forEach(System.out::println);
	}
}
