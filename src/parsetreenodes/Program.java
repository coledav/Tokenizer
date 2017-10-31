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
        int currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get("program")) {
            throw new java.lang.Error(
                    "Expected string 'program', instead found: "
                            + currentToken);
        }
        System.out.print("program\n");
        Tokenizer.skipToken();
        this.ds = new DeclSeq();
        this.ds.printDeclSeq();

        currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get("begin")) {
            throw new java.lang.Error(
                    "Expected string 'begin', instead found: " + currentToken);
        }
        System.out.print("begin\n");
        Tokenizer.skipToken();
        this.ss = new StatementSeq();
        this.ss.printStatementSeq();

        currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get("end")) {
            throw new java.lang.Error(
                    "Expected string 'end', instead found: " + currentToken);
        }
        System.out.print("end\n");
        Tokenizer.skipToken();

        currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get("EOF")) {
            throw new java.lang.Error(
                    "Expected EOF, instead found: " + currentToken);
        }
    }

    public void execProgram() {
        int currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get("program")) {
            throw new java.lang.Error(
                    "Expected string 'program', instead found: "
                            + currentToken);
        }
        Tokenizer.skipToken();
        this.ds = new DeclSeq();
        this.ds.execDeclSeq();

        currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get("begin")) {
            throw new java.lang.Error(
                    "Expected string 'begin', instead found: " + currentToken);
        }
        Tokenizer.skipToken();
        this.ss = new StatementSeq();
        this.ss.execStatementSeq();

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
}
