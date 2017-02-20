package org.spick.hephaistos;

import java.util.ArrayList;
import java.util.List;

import org.spick.hephaistos.util.ListUtil;

public class And implements Condition, IPrintable {

	private List<String> stringConditions = new ArrayList<>();

	public And(String string) {
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

	@Override
	public String print() {
		return ListUtil.joinStringList(stringConditions, " and ");
	}

}
