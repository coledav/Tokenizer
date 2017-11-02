package parsetreenodes;

public class ExpressionInt extends Expression {

	Factor fac;
	
	public ExpressionInt(Factor factor){
		this.fac = factor;
		
	}
	
	@Override
	public void printExpression() {
		fac.printFactor();
	}

	@Override
	public int execExpression() {
		return fac.execFactor();
	}
}