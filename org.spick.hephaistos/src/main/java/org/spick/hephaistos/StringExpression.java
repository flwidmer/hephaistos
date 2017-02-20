package org.spick.hephaistos;

public class StringExpression implements IPrintable{

	private String value;

	public StringExpression(String value) {
		this.value = value;
	}

	@Override
	public String print() {
		return value ;
	}

}