package parsetreenodes;

import interpreter.Tokenizer;

public abstract class Op {

    public static Op parseOp() {
        int currentToken = Tokenizer.getToken();
        if (currentToken == Tokenizer.tokenNumbers.get("integer")) {
            Int integer = new Int(Tokenizer.intVal());
            Tokenizer.skipToken();
            return new OpInt(integer);

        } else if (currentToken == Tokenizer.tokenNumbers.get("id")) {
            Id id = Id.parseId(Tokenizer.idName());
            return new OpId(id);

        } else if (currentToken == Tokenizer.tokenNumbers.get("(")) {
            Tokenizer.skipToken();
            Expression exp = Expression.parseExpression();
            Tokenizer.skipToken();
            return new OpExp(exp);
        } else {
            throw new java.lang.Error(
                    "Expected an op, instead found: " + currentToken);
        }

    }

    public abstract void printOp();

    public abstract int execOp();

}
