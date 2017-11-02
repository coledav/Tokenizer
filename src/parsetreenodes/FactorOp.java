package parsetreenodes;

public class FactorOp extends Factor{

	Op op;
	
	public FactorOp(Op op){
		this.op = op;
	}
	
	public void printFactor(){
		this.op.printOp();
	}
	
	public int execFactor(){
		return this.op.execOp();
	}
}
