package org.spick.hephaistos.insert;

import static org.spick.hephaistos.util.ListUtil.joinStringList;
import static org.spick.hephaistos.util.StringUtil.wrapInParentheses;

import java.util.Arrays;
import java.util.List;

import org.spick.hephaistos.internal.IPrintable;

/**
 * Model of an insert values dml statement
 * @author Florian
 *
 */
public class InsertValuesStatement implements IPrintable{

	private InsertColumnStatement insertColumnStatement;
	private List<String> values;

	public InsertValuesStatement(InsertColumnStatement insertColumnStatement, String... values) {
		this.insertColumnStatement = insertColumnStatement;
		this.values = Arrays.asList(values);
	}

	@Override
	public String print() {
		return insertColumnStatement.print() + " values " + wrapInParentheses(joinStringList(values, ", "));
	}

}
