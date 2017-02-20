package org.spick.hephaistos;

public class Equals implements Condition{

	
	private String left;
	private String right;

	public Equals(String left, String right) {
		this.left = left;
		this.right = right;
	}

	public static Equals equals(String left, String right) {
		return new Equals(left, right);
	}
	
	@Override
	public String print() {
		return " " + left + " = " + right + " ";
	}

}
