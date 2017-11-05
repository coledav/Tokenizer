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

        currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get("int")) {
            throw new java.lang.Error(
                    "Expected 'int', instead found: " + currentToken);
        }

        this.ds = new DeclSeq();
        this.ds.parseDeclSeq();

        currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get("begin")) {
            throw new java.lang.Error(
                    "Expected string 'begin', instead found: " + currentToken);
        }
        Tokenizer.skipToken();

        currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get("id")
                && currentToken != Tokenizer.tokenNumbers.get("if")
                && currentToken != Tokenizer.tokenNumbers.get("while")
                && currentToken != Tokenizer.tokenNumbers.get("read")
                && currentToken != Tokenizer.tokenNumbers.get("write")) {
            throw new java.lang.Error(
                    "Expected a statement, instead found: " + currentToken);
        }
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
        System.out.print("program\n");
        this.ds.printDeclSeq();
        System.out.print("begin\n");
        this.ss.printStatementSeq();
        System.out.print("end\n");
    }

    public void execProgram() {
        this.ds.execDeclSeq();
        this.ss.execStatementSeq();
    }
}
