package org.spick.hephaistos;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.spick.hephaistos.column.Column;
import org.spick.hephaistos.insert.Insert;
import org.spick.hephaistos.select.Select;
import org.spick.hephaistos.select.SelectColumn;
import org.spick.hephaistos.table.TableExpression;

/**
 * Convenience class for starting a query
 * @author Florian
 *
 */
public final class SQL {

	public static Select select(SelectColumn ... selectList) {
		return new Select(selectList);
	}
	
	public static Select select(String ... selectList) {
		return new Select(Stream.of(selectList).map(Column::new).collect(Collectors.toList()));
	}
	
	public static Insert insertInto(TableExpression table) {
		return new Insert(table);
	}
}
