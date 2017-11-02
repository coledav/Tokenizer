package parsetreenodes;

public class FactorOpFac extends Factor{
	
	Op op;
	Factor fac;
	
	public FactorOpFac(Op op, Factor fac){
		this.op = op;
		this.fac = fac;
	}
	
	public void printFactor(){
		this.op.printOp();
		System.out.print(" * ");
		this.fac.printFactor();
	}
	
	public int execFactor(){
		return this.op.execOp() * this.fac.execFactor();
	}

}
