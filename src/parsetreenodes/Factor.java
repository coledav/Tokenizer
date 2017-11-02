package parsetreenodes;

import interpreter.Tokenizer;

public abstract class Factor {

	public static Factor parseFactor(){
		Op op = Op.parseOp();
		
		int currentToken = Tokenizer.getToken();
		if(currentToken == Tokenizer.tokenNumbers.get("*")){
			Tokenizer.skipToken();
			Factor fac = Factor.parseFactor();
			return new FactorOpFac(op, fac);
		}else{
			return new FactorOp(op);
		}
		
	}
	
	public abstract void printFactor();
	
	public abstract int execFactor();
	
}
