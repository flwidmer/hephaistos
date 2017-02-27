package org.spick.hephaistos.condition;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.spick.hephaistos.util.StringUtil;

public abstract class AbstractListBasedCondition implements Condition {
	private List<String> conditions = new ArrayList<>();

	public AbstractListBasedCondition(String string) {
		Objects.requireNonNull(string);
		conditions.add(string);
	}

	protected abstract String getJoinKeyword();

	@Override
	public String print() {
		//Size is alwaysa at least one because of constructor
		return StringUtil.wrapListAndJoin(getConditions(), getJoinKeyword());
	}

	protected List<String> getConditions() {
		return conditions;
	}
}
