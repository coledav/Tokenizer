package parsetreenodes;

import interpreter.Tokenizer;

public abstract class Condition {

	public static Condition parseCondition() {
    	int currentToken = Tokenizer.getToken();
    	if(currentToken == Tokenizer.tokenNumbers.get("(")){
    		Tokenizer.skipToken();
    		
    	}
        
    }

    public abstract void printCondition();

    public abstract void execCondition();
	
}
