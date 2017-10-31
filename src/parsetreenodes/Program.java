package parsetreenodes;

import interpreter.Tokenizer;

public class Program {
    private DeclSeq ds;
    private StatementSeq ss;

    public Program() {
        this.ds = null;
        this.ss = null;
    }

    public void parseProgram() {
        int currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get("program")) {
            throw new java.lang.Error(
                    "Expected string 'program', instead found: "
                            + currentToken);
        }
        Tokenizer.skipToken();
        this.ds = new DeclSeq();
        this.ds.parseDeclSeq();

        currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get("begin")) {
            throw new java.lang.Error(
                    "Expected string 'begin', instead found: " + currentToken);
        }
        Tokenizer.skipToken();
        this.ss = new StatementSeq();
        this.ss.parseStatementSeq();

        currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get("end")) {
            throw new java.lang.Error(
                    "Expected string 'end', instead found: " + currentToken);
        }
        Tokenizer.skipToken();

        currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get("EOF")) {
            throw new java.lang.Error(
                    "Expected EOF, instead found: " + currentToken);
        }
    }

    public void printProgram() {
    	System.out.println("program\n");
    	ds.printDeclSeq();
    	System.out.println("begin\n");
    	ss.printStatementSeq();
    	System.out.println("end\n");
    }

    public void execProgram() {
    	ds.execDeclSeq();
    	ss.execStatementSeq();
    }
}
