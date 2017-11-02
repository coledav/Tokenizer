package parsetreenodes;

public class OpExp extends Op{

	Expression exp;
	
	public OpExp(Expression exp){
		this.exp = exp;
	}
	
	public void printOp(){
		this.exp.printExpression();
	}
	
	public int execOp(){
		return this.exp.execExpression();
	}
}
