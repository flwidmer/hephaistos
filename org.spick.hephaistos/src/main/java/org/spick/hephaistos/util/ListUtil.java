package org.spick.hephaistos.util;

import java.util.List;
import java.util.stream.Collectors;

import org.spick.hephaistos.internal.IPrintable;

public class ListUtil {

	public static String commaList(List<? extends IPrintable> list ) {
		return joinList(list, ", ");
	}

	public static String joinList(List<? extends IPrintable> list, String delimiter) {
		return list.stream().map(IPrintable::print).collect(Collectors.joining(delimiter)) + " ";
	}

	public static String joinStringList(List<String> list, String delimiter) {
		return list.stream().collect(Collectors.joining(delimiter)) + " ";
	}
}
