package org.spick.hephaistos;

public class AliasColumn implements SelectColumn{
	
	private String alias;
	private String column;
	
	public static AliasColumn aliasColumn(String column, String alias) {
		return new AliasColumn(column, alias);
	}
	
	public AliasColumn(String column, String alias) {
		this.column = column;
		this.alias = alias;
	}

	@Override
	public String print() {
		return column + " as " + alias;
	}
}
