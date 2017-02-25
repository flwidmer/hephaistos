package org.spick.hephaistos;

import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	
}
