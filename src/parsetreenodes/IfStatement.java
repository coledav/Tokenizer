package parsetreenodes;

import interpreter.Tokenizer;

public class IfStatement extends Statement {

    private int alternative;
    private Condition cond1;
    private StatementSeq ss1;
    private StatementSeq ss2;

    public IfStatement() {
        this.cond1 = null;
        this.ss1 = null;
        this.ss2 = null;
    }

    public void parseIf() {
        Tokenizer.skipToken();
        int currentToken = Tokenizer.getToken();
        if (currentToken == Tokenizer.tokenNumbers.get("(")
                || currentToken == Tokenizer.tokenNumbers.get("!")
                || currentToken == Tokenizer.tokenNumbers.get("[")) {
            this.cond1 = Condition.parseCondition();
        } else {
            throw new java.lang.Error("Expected condition");
        }

        currentToken = Tokenizer.getToken();
        if (currentToken == Tokenizer.tokenNumbers.get("then")) {
            Tokenizer.skipToken();
        } else {
            throw new java.lang.Error("Expected 'then'");
        }

        currentToken = Tokenizer.getToken();
        if (currentToken == Tokenizer.tokenNumbers.get("id")
                || currentToken == Tokenizer.tokenNumbers.get("if")
                || currentToken == Tokenizer.tokenNumbers.get("while")
                || currentToken == Tokenizer.tokenNumbers.get("read")
                || currentToken == Tokenizer.tokenNumbers.get("write")) {
            this.ss1 = new StatementSeq();
            this.ss1.parseStatementSeq();
        } else {
            throw new java.lang.Error("Expected statement sequence");
        }

        currentToken = Tokenizer.getToken();
        if (currentToken == Tokenizer.tokenNumbers.get("end")) {
            this.alternative = 1;
            Tokenizer.skipToken();
            currentToken = Tokenizer.getToken();
            if (currentToken == Tokenizer.tokenNumbers.get(";")) {
                Tokenizer.skipToken();
            } else {
                throw new java.lang.Error("Expected semi-colon");
            }

        } else if (currentToken == Tokenizer.tokenNumbers.get("else")) {
            this.alternative = 2;
            Tokenizer.skipToken();
            currentToken = Tokenizer.getToken();
            if (currentToken == Tokenizer.tokenNumbers.get("id")
                    || currentToken == Tokenizer.tokenNumbers.get("if")
                    || currentToken == Tokenizer.tokenNumbers.get("while")
                    || currentToken == Tokenizer.tokenNumbers.get("read")
                    || currentToken == Tokenizer.tokenNumbers.get("write")) {
                this.ss2 = new StatementSeq();
                this.ss2.parseStatementSeq();
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
                throw new java.lang.Error("Expected semi-colon");
            }
        }
    }

    @Override
    public void printStatement() {
        System.out.print("if ");
        this.cond1.printCondition();
        System.out.print(" then\n");
        this.ss1.printStatementSeq();
        if (this.alternative == 1) {
            System.out.print("end;\n");
        } else if (this.alternative == 2) {
            System.out.print("else\n");
            this.ss2.printStatementSeq();
            System.out.print("end;\n");
        }
    }

    @Override
    public void execStatement() {
        if (this.alternative == 1) {
            if (this.cond1.execCondition()) {
                this.ss1.execStatementSeq();
            }
        } else if (this.alternative == 2) {
            if (this.cond1.execCondition()) {
                this.ss1.execStatementSeq();
            } else {
                this.ss2.execStatementSeq();
            }
        }
    }
}
