package parsetreenodes;

public class ExpressionProd extends Expression {

	Expression exp;
	Factor fac;
	
	public ExpressionProd(Expression expr, Factor factor){
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
