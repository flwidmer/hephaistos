package org.spick.hephaistos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.spick.hephaistos.util.ListUtil;

/**
 * Or condition
 * @author Florian
 *
 */
public class Or implements Condition{

	private List<String> stringConditions = new ArrayList<>();
	
	public Or(String string) {
		Objects.requireNonNull(string);
		stringConditions.add(string);
	}

	public void or(String string) {
		stringConditions.add(string);
	}
	
	public void or(Condition condition) {
		stringConditions.add(condition.print());
	}

	public static Or of(String string) {
		return new Or(string);
	}
	
	public static Or of(Condition condition) {
		return new Or(condition.print());
	}

	@Override
	public String print() {
		return ListUtil.joinStringList(stringConditions, " or ");
	}
}
