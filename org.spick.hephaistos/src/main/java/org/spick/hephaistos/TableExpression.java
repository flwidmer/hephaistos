package org.spick.hephaistos;

public class TableExpression extends StringExpression implements FromExpression {

	public TableExpression(String value) {
		super(value);
	}
	
	public TableExpression(String table, String alias) {
		super(table + " " + alias);
	}

	public static TableExpression table(String value) {
		return new TableExpression(value);
	}
	
	public static TableExpression table(String table, String alias) {
		return new TableExpression(table, alias);
	}
}
