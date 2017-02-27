package org.spick.hephaistos.condition;

import java.util.Objects;

import org.spick.hephaistos.util.StringUtil;

/**
 * Equals condition
 * 
 * @author Florian
 *
 */
public class Equals implements Condition {

	private String left;
	private String right;

	public Equals(String left, String right) {
		Objects.requireNonNull(left);
		Objects.requireNonNull(right);
		this.left = left;
		this.right = right;
	}

	public static Equals equals(String left, String right) {
		return new Equals(left, right);
	}

	@Override
	public String print() {
		return StringUtil.wrapInSpaces(left + " = " + right);
	}

}
