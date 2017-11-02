package parsetreenodes;

import interpreter.Tokenizer;

public abstract class Statement {

    public static Statement parseStatement() {
    	int currentToken = Tokenizer.getToken();
        if (currentToken == Tokenizer.tokenNumbers.get("id")) {
        	AssignStatement assign = new AssignStatement();
        	assign.parseAssign();
        	return assign;
        	
        }else if (currentToken == Tokenizer.tokenNumbers.get("if")) {
        	IfStatement ifStatement = new IfStatement();
        	ifStatement.parseIf();
        	return ifStatement;
        	
        }else if (currentToken == Tokenizer.tokenNumbers.get("while")) {
        	LoopStatement loop = new LoopStatement();
        	loop.parseLoop();
        	return loop;
        	
        }else if (currentToken == Tokenizer.tokenNumbers.get("read")) {
        	ReadStatement read = new ReadStatement();
        	read.parseRead();
        	return read;
        	
        }else if (currentToken == Tokenizer.tokenNumbers.get("write")) {
        	WriteStatement write = new WriteStatement();
        	write.parseWrite();
        	return write;
        }
        
        //the parser should never reach this point
		return null;
    }

    public abstract void printStatement();

    public abstract void execStatement();
}
