package parsetreenodes;

public class OpInt extends Op{

	Int integer;
	
	public OpInt(Int integer){
		this.integer = integer;
	}

	@Override
	public void printOp() {
		System.out.print(this.integer.getValue());
	}

	@Override
	public int execOp() {
		return this.integer.getValue();
	}
}
