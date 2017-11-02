package parsetreenodes;

public class ExpressionMinus extends Expression {

	Expression exp;
	Factor fac;
	
	public ExpressionMinus(Expression expr, Factor factor){
		this.exp = expr;
		this.fac = factor;
		
	}
	
	@Override
	public void printExpression() {
		fac.printFactor();
		System.out.println(" - ");
		exp.printExpression();
	}

	@Override
	public int execExpression() {
		return fac.execFactor() - exp.execExpression();
	}
}
