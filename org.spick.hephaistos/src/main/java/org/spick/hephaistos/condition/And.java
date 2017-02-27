package org.spick.hephaistos.condition;

/**
 * A list of AND conditions 
 * @author Florian
 *
 */
public class And extends AbstractListBasedCondition {

	private static final String AND = "and";

	public And(String string) {
		super(string);
	}

	public And and(String string) {
		getConditions().add(string);
		return this;
	}
	
	public And and(Condition condition) {
		return and(condition.print());
	}

	public static And of(String string) {
		return new And(string);
	}
	
	public static And of(Condition condition) {
		return new And(condition.print());
	}

	@Override
	protected String getJoinKeyword() {
		return AND;
	}

}
