package org.spick.hephaistos;

import java.util.Arrays;
import java.util.List;

import org.spick.hephaistos.util.ListUtil;

public class From implements IPrintable{

	private List<? extends FromExpression> fromList;
	private Select select;

	public From(Select select, FromExpression... fromList) {
		this.select = select;
		this.fromList = Arrays.asList(fromList);
	}
	
	public From(Select select, List<? extends FromExpression> fromList) {
		this.select = select;
		this.fromList = fromList;
	}

	
	@Override
	public String print() {
		return select.print() + " from " + ListUtil.commaList(fromList);
	}

	public Where where(Condition whereCondition) {
		return new Where(this, whereCondition);
	}
}