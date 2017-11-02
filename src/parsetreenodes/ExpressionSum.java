package parsetreenodes;

public class ExpressionSum extends Expression {

	Expression exp;
	Factor fac;
	
	public ExpressionSum(Expression expr, Factor factor){
		this.exp = expr;
		this.fac = factor;
		
	}
	
	@Override
	public void printExpression() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execExpression() {
		// TODO Auto-generated method stub
		
	}
}
