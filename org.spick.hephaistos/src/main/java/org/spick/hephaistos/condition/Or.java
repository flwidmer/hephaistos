package org.spick.hephaistos.condition;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.spick.hephaistos.util.StringUtil;

/**
 * Or condition
 * 
 * @author Florian
 *
 */
public class Or extends AbstractListBasedCondition {

	private static final String OR = "or";

	public Or(String string) {
		super(string);
	}

	public Or or(String string) {
		Objects.requireNonNull(string);
		getConditions().add(string);
		return this;
	}

	public Or or(Condition condition) {
		return or(condition.print());
	}

	public static Or of(String string) {
		return new Or(string);
	}

	public static Or of(Condition condition) {
		return new Or(condition.print());
	}

	protected String getJoinKeyword() {
		return OR;
	}

}
