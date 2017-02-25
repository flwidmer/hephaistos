package org.spick.hephaistos.column;

import org.spick.hephaistos.internal.StringExpression;
import org.spick.hephaistos.select.SelectColumn;

/**
 * A Column
 * @author Florian
 *
 */
public class Column extends StringExpression implements SelectColumn{

	public Column(String column) {
		super(column);
	}

	public static Column column(String value) {
		return new Column(value);
	}

}
