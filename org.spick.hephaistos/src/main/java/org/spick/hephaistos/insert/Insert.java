package org.spick.hephaistos.insert;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Objects;

import org.spick.hephaistos.column.Column;
import org.spick.hephaistos.internal.IPrintable;
import org.spick.hephaistos.table.TableExpression;

/**
 * This models an insert ddl statmeent
 * 
 * @author Florian
 *
 */
public class Insert implements IPrintable {

	private TableExpression table;

	

	public Insert(TableExpression table) {
		Objects.nonNull(table);
		this.table = table;
	}

	public InsertColumnStatement columns(Column... columns) {
		return new InsertColumnStatement(this, Arrays.asList(columns));
	}

	@Override
	public String print() {
		return "insert into " + table.print();
	}
	public InsertColumnStatement columns(String... columns) {
		return new InsertColumnStatement(this, Arrays.stream(columns).map(Column::new).collect(toList()));
	}
}
