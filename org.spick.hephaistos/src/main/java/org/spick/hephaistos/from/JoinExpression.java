package org.spick.hephaistos.from;

import java.util.Objects;

import org.spick.hephaistos.condition.Condition;
import org.spick.hephaistos.condition.Equals;
import org.spick.hephaistos.table.TableExpression;

/**
 * Join Expression, joining two tables with x join y on
 * Typically an inner join
 * @author Florian
 *
 */
public class JoinExpression implements FromExpression {

	private TableExpression left;
	private TableExpression right;
	private Condition condition;

	public JoinExpression(TableExpression left, TableExpression right) {
		Objects.requireNonNull(left);
		Objects.requireNonNull(right);
		this.left = left;
		this.right = right;
	}

	@Override
	public String print() {
		return " " + left.print() + " join " + right.print() + " on " + condition.print();
	}

	public FromExpression on(String leftColumn, String rightColumn) {
		condition = Equals.equals(leftColumn, rightColumn);
		return this;
	}

	public FromExpression on(String sameColumn) {
		condition = Equals.equals(left.getAlias() + "." + sameColumn, right.getAlias() + "." + sameColumn);
		return this;
	}

	public FromExpression on(Condition condition) {
		this.condition = condition;
		return this;
	}

}
