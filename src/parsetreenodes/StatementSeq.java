package parsetreenodes;

import interpreter.Tokenizer;

public class StatementSeq {
    private Statement statement;
    private StatementSeq ss;

    public StatementSeq() {
        this.statement = null;
        this.ss = null;
    }

    public void parseStatementSeq() {
    	statement = Statement.parseStatement();
    	
    	int currentToken = Tokenizer.getToken();
        if (currentToken == Tokenizer.tokenNumbers.get("id") || 
        		currentToken == Tokenizer.tokenNumbers.get("if") || 
        		currentToken == Tokenizer.tokenNumbers.get("while") || 
        		currentToken == Tokenizer.tokenNumbers.get("read") || 
        		currentToken == Tokenizer.tokenNumbers.get("write")) {
        	this.ss = new StatementSeq();
        	this.ss.parseStatementSeq();;
        }
    }

    public void printStatementSeq() {
    	this.statement.printStatement();
    	if(this.ss != null){
    		this.ss.printStatementSeq();
    	}
    }

    public void execStatementSeq() {
    	this.statement.execStatement();
    	if(this.ss != null){
    		this.ss.execStatementSeq();
    	}
    }
}
