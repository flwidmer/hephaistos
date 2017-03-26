package org.spick.hephaistos.insert;

import static org.spick.hephaistos.util.ListUtil.commaList;
import static org.spick.hephaistos.util.ListUtil.joinList;
import static org.spick.hephaistos.util.StringUtil.COMMA;
import static org.spick.hephaistos.util.StringUtil.wrapInParentheses;

import java.util.ArrayList;
import java.util.List;

import org.spick.hephaistos.column.Column;
import org.spick.hephaistos.internal.IPrintable;
import org.spick.hephaistos.util.ListUtil;
import org.spick.hephaistos.util.StringUtil;

/**
 * Model of an insert statement after the table expression
 * @author Florian
 *
 */
public class InsertColumnStatement implements IPrintable {

	private List<Column> columns = new ArrayList<>();
	private Insert insert;
	
	public InsertColumnStatement(Insert insert, List<Column> columns) {
		this.insert = insert;
		this.columns = columns;
	}
	

	@Override
	public String print() {
		return insert.print() + " "  + wrapInParentheses(commaList(columns));
	}


	public InsertValuesStatement values(String ...values) {
		return new InsertValuesStatement(this, values);
	}

}
