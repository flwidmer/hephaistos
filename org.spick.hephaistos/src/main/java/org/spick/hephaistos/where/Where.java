package org.spick.hephaistos.where;

import java.util.Objects;

import org.spick.hephaistos.condition.Condition;
import org.spick.hephaistos.from.From;
import org.spick.hephaistos.internal.IPrintable;

/**
 * Where condition
 * @author Florian
 *
 */
public class Where implements IPrintable{

	private Condition whereCondition;
	private From from;

	public Where(From from, Condition whereCondition) {
		Objects.requireNonNull(from);
		Objects.requireNonNull(whereCondition);
		this.from = from;
		this.whereCondition = whereCondition;
	}

	@Override
	public String print() {
		return from.print() + " where " + whereCondition.print();
	}

}
