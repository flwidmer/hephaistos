package org.spick.hephaistos;

public class Where implements IPrintable{

	private Condition whereCondition;
	private From from;

	public Where(From from, Condition whereCondition) {
		this.from = from;
		this.whereCondition = whereCondition;
	}

	@Override
	public String print() {
		return from.print() + " where " + whereCondition.print();
	}

}
