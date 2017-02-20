package org.spick.hephaistos;

public class TableExpression extends StringExpression implements FromExpression {

	private String alias;

	public TableExpression(String value) {
		super(value);
		alias = value;
	}
	
	public TableExpression(String table, String alias) {
		super(table + " " + alias);
		this.alias  = alias;
	}

	public static TableExpression table(String value) {
		return new TableExpression(value);
	}
	
	public static TableExpression table(String table, String alias) {
		return new TableExpression(table, alias);
	}

	public JoinExpression join(TableExpression table) {
		return new JoinExpression(this, table);
	}

	public String getAlias() {
		return alias ;
	}
}
