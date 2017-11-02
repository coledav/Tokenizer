package parsetreenodes;

public class OpId extends Op{

	Id id;
	
	public OpId(Id id){
		this.id = id;
	}
	
	public void printOp(){
		System.out.print(this.id.getIdName());
	}
	
	public int execOp(){
		if(this.id.isDeclared() && this.id.isInitialized()){
			return this.id.getValue();
		}else{
			throw new java.lang.Error("ID not declared or not initialized");
		}
	}
}
