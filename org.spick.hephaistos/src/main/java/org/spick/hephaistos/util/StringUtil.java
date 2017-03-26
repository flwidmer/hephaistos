package org.spick.hephaistos.util;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.spick.hephaistos.internal.IPrintable;

/**
 * String based util functions
 * 
 * @author Florian
 *
 */
public final class StringUtil {
	
	public static final String COMMA = ",";
	
	private StringUtil() {
	}

	public static String wrapInParentheses(String in) {
		return wrap("(", ")", in);
	}

	public static String wrapInSpaces(String in) {
		return wrap(" ", in);
	}

	private static String wrap(String both, String in) {
		return wrap(both, both, in);
	}

	private static String wrap(String left, String right, String in) {
		return left + in + right;
	}

	public static String wrapListAndJoin(List<String> list, String delimiter) {
		Function<? super String, ? extends String> mappingFunction = Function.identity();
		if(list.size() > 1) {
			mappingFunction = StringUtil::wrapInParentheses;
		}
		return wrapInParentheses(ListUtil.joinStringList(
				list.stream().map(mappingFunction).collect(Collectors.toList()), wrapInSpaces(delimiter)));
	}

	public static String wrapPrintableListAndJoin(List<? extends IPrintable> columns, String delimiter) {
		return wrapListAndJoin(columns.stream().map(IPrintable::print).collect(toList()), delimiter);
	}
}
