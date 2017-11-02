package parsetreenodes;

import interpreter.Tokenizer;

public class ReadStatement extends Statement {
private IdList idList;
	
	public ReadStatement(){
		this.idList = null;
	}
	
    public void parseRead() {
    	int currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get("read")) {
            throw new java.lang.Error(
                    "Expected string 'read', instead found: "
                            + currentToken);
        }
        Tokenizer.skipToken();
        this.idList = new IdList();
        this.idList.parseIdList();
    }

    @Override
    public void printStatement() {
    	System.out.print("read ");
    	this.idList.printIdList();
    	System.out.print(";\n");
    }

    @Override
    public void execStatement() {
    	
    }
}
