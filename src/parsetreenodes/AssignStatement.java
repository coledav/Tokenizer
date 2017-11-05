package parsetreenodes;

import interpreter.Tokenizer;

public class AssignStatement extends Statement {

    private Id id;
    private Expression exp;

    public AssignStatement() {
        this.id = null;
        this.exp = null;
    }

    public void parseAssign() {
        String idName = Tokenizer.idName();
        this.id = Id.parseId(idName);
//        if (!id.isDeclared()) {
//            throw new java.lang.Error(
//                    "Variable '" + idName + "' is not delcared");
//        }

        int currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get("=")) {
            throw new java.lang.Error(
                    "Expected '=', instead found: " + currentToken);
        }
        Tokenizer.skipToken();

        currentToken = Tokenizer.getToken();
        if (currentToken == Tokenizer.tokenNumbers.get("id")
                || currentToken == Tokenizer.tokenNumbers.get("integer")
                || currentToken == Tokenizer.tokenNumbers.get("(")) {
            this.exp = Expression.parseExpression();
        } else {
            throw new java.lang.Error("Expected expression");
        }

        currentToken = Tokenizer.getToken();
        if (currentToken != Tokenizer.tokenNumbers.get(";")) {
            throw new java.lang.Error(
                    "Expected semi-colon, instead found: " + currentToken);
        }
        Tokenizer.skipToken();
    }

    @Override
    public void printStatement() {
        this.id.printId();
        System.out.print(" = ");
        this.exp.printExpression();
        System.out.print(";\n");
    }

    @Override
    public void execStatement() {
        this.id.setValue(this.exp.execExpression());
        this.id.setInitialized(true);
    }
}
