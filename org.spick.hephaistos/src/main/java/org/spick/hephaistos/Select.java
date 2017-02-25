package org.spick.hephaistos;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.spick.hephaistos.util.ListUtil;
/**
 * select expresison starting a select statement
 * @author Florian
 *
 */
public class Select implements IPrintable {

	private List<? extends SelectColumn> selectList;

	public Select(SelectColumn[] selectList) {
		this(Arrays.asList(selectList));
	}

	public Select(List<? extends SelectColumn> selectList) {
		Objects.requireNonNull(selectList);
		this.selectList = selectList;
	}

	public From from(FromExpression... fromList) {
		return new From(this, fromList);
	}

	public From from(String... fromList) {
		return new From(this, Stream.of(fromList).map(TableExpression::new).collect(Collectors.toList()));
	}

	@Override
	public String print() {
		return "select " + ListUtil.commaList(selectList);
	}

}
