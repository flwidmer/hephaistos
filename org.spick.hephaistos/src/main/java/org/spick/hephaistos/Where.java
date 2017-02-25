package org.spick.hephaistos;

import java.util.Objects;

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
