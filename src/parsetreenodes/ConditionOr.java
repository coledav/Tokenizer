package parsetreenodes;

public class ConditionOr extends Condition{

	private Condition cond1;
	private Condition cond2;
	
	public ConditionOr(Condition cond1, Condition cond2){
		this.cond1 = cond1;
		this.cond2 = cond2;
	}
	
	@Override
	public void printCondition() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execCondition() {
		// TODO Auto-generated method stub
		
	}
}
