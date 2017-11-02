package parsetreenodes;

import interpreter.Tokenizer;

public class WriteStatement extends Statement {

	private IdList idList;
	
	public WriteStatement(){
		this.idList = null;
	}
	
    public void parseWrite() {
    	int currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get("write")) {
            throw new java.lang.Error(
                    "Expected string 'write', instead found: "
                            + currentToken);
        }
        Tokenizer.skipToken();
        this.idList = new IdList();
        this.idList.parseIdList();
    }

    @Override
    public void printStatement() {
    	System.out.print("write ");
    	this.idList.printIdList();
    	System.out.print(";\n");
    }

    @Override
    public void execStatement() {
    	
    }

}
