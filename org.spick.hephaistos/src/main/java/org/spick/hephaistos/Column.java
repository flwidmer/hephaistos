package org.spick.hephaistos;

public class Column extends StringExpression implements SelectColumn{

	public Column(String column) {
		super(column);
	}

	public static Column column(String value) {
		return new Column(value);
	}

}
