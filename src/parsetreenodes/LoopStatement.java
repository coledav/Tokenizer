package parsetreenodes;

import interpreter.Tokenizer;

public class LoopStatement extends Statement {

    private Condition cond;
    private StatementSeq ss;

    public LoopStatement() {
        this.cond = null;
        this.ss = null;
    }

    public void parseLoop() {
        Tokenizer.skipToken();

        int currentToken = Tokenizer.getToken();
        if (currentToken == Tokenizer.tokenNumbers.get("(")
                || currentToken == Tokenizer.tokenNumbers.get("!")
                || currentToken == Tokenizer.tokenNumbers.get("[")) {
            this.cond = Condition.parseCondition();
        } else {
            throw new java.lang.Error("Expected condition");
        }

        currentToken = Tokenizer.getToken();
        if (currentToken == Tokenizer.tokenNumbers.get("loop")) {
            Tokenizer.skipToken();
        } else {
            throw new java.lang.Error(
                    "Expected 'loop', instead found: " + currentToken);
        }

        currentToken = Tokenizer.getToken();
        if (currentToken == Tokenizer.tokenNumbers.get("id")
                || currentToken == Tokenizer.tokenNumbers.get("if")
                || currentToken == Tokenizer.tokenNumbers.get("while")
                || currentToken == Tokenizer.tokenNumbers.get("read")
                || currentToken == Tokenizer.tokenNumbers.get("write")) {
            this.ss = new StatementSeq();
            this.ss.parseStatementSeq();
        } else {
            throw new java.lang.Error("Expected statement sequence");
        }

        currentToken = Tokenizer.getToken();
        if (currentToken == Tokenizer.tokenNumbers.get("end")) {
            Tokenizer.skipToken();
        } else {
            throw new java.lang.Error("Expected 'end'");
        }

        currentToken = Tokenizer.getToken();
        if (currentToken == Tokenizer.tokenNumbers.get(";")) {
            Tokenizer.skipToken();
        } else {
            throw new java.lang.Error("Expected smei-colon");
        }
    }

    @Override
    public void printStatement() {
        System.out.print("while ");
        this.cond.printCondition();
        System.out.print(" loop\n");
        this.ss.printStatementSeq();
        System.out.print("\t");
        System.out.print("end;\n");

    }

    @Override
    public void execStatement() {
        while (this.cond.execCondition()) {
            this.ss.execStatementSeq();
        }
    }
}
