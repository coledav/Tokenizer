package parsetreenodes;

import interpreter.Tokenizer;

public class ConditionComp extends Condition {

    private Op op1;
    private Op op2;
    private String compOp;

    public ConditionComp() {
        this.op1 = null;
        this.op2 = null;
        this.compOp = null;
    }

    public void parseComp() {
        Tokenizer.skipToken();
        this.op1 = Op.parseOp();
        int currentToken = Tokenizer.getToken();
        if (currentToken == Tokenizer.tokenNumbers.get("!=")) {
            this.compOp = "!=";
        } else if (currentToken == Tokenizer.tokenNumbers.get("==")) {
            this.compOp = "==";
        } else if (currentToken == Tokenizer.tokenNumbers.get("<")) {
            this.compOp = "<";
        } else if (currentToken == Tokenizer.tokenNumbers.get(">")) {
            this.compOp = ">";
        } else if (currentToken == Tokenizer.tokenNumbers.get("<=")) {
            this.compOp = "<=";
        } else if (currentToken == Tokenizer.tokenNumbers.get(">=")) {
            this.compOp = ">=";
        } else {
            throw new java.lang.Error(
                    "Expected a comparison operator, instead found: "
                            + currentToken);
        }
        Tokenizer.skipToken();
        this.op2 = Op.parseOp();

        currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get(")")) {
            throw new java.lang.Error(
                    "Expected ')', instead found: " + currentToken);
        }
        Tokenizer.skipToken();

    }

    @Override
    public void printCondition() {
        System.out.print("(");
        this.op1.printOp();
        System.out.print(" " + this.compOp + " ");
        this.op2.printOp();
        System.out.print(")");
    }

    @Override
    public boolean execCondition() {
        int op1Value = this.op1.execOp();
        int op2Value = this.op2.execOp();

        if (this.compOp.equals("!=")) {
            return op1Value != op2Value;
        } else if (this.compOp.equals("==")) {
            return op1Value == op2Value;
        } else if (this.compOp.equals("<")) {
            return op1Value < op2Value;
        } else if (this.compOp.equals(">")) {
            return op1Value > op2Value;
        } else if (this.compOp.equals("<=")) {
            return op1Value <= op2Value;
        } else if (this.compOp.equals(">=")) {
            return op1Value >= op2Value;
        } else {
            throw new java.lang.Error("Comparison operator not valid");
        }
    }

}
