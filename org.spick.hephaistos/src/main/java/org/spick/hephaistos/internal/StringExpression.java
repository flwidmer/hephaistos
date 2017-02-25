package org.spick.hephaistos.internal;

import java.util.Objects;

/**
 * A String expression
 * @author Florian
 *
 */
public class StringExpression implements IPrintable{

	private String value;

	public StringExpression(String value) {
		Objects.requireNonNull(value);
		this.value = value;
	}

	@Override
	public String print() {
		return value ;
	}

}