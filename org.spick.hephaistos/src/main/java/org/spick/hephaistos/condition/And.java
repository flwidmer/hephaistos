package org.spick.hephaistos.condition;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.spick.hephaistos.util.ListUtil;

/**
 * A list of AND conditions 
 * @author Florian
 *
 */
public class And implements Condition {

	private List<String> stringConditions = new ArrayList<>();

	public And(String string) {
		Objects.requireNonNull(string);
		stringConditions.add(string);
	}

	public void and(String string) {
		stringConditions.add(string);
	}
	
	public void and(Condition condition) {
		stringConditions.add(condition.print());
	}

	public static And of(String string) {
		return new And(string);
	}
	
	public static And of(Condition condition) {
		return new And(condition.print());
	}

	@Override
	public String print() {
		return ListUtil.joinStringList(stringConditions, " and ");
	}

}
