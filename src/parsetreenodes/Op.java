package parsetreenodes;

import interpreter.Tokenizer;

public abstract class Op {

    public static Op parseOp() {
        if (Tokenizer.getToken() == Tokenizer.tokenNumbers.get("integer")) {
            Int integer = new Int(Tokenizer.intVal());
            return new OpInt(integer);

        } else if (Tokenizer.getToken() == Tokenizer.tokenNumbers.get("id")) {
            Id id = Id.parseId(Tokenizer.idName());
            return new OpId(id);

        } else if (Tokenizer.getToken() == Tokenizer.tokenNumbers.get("(")) {
            Tokenizer.skipToken();
            Expression exp = Expression.parseExpression();
            Tokenizer.skipToken();
            return new OpExp(exp);
        } else {
            throw new java.lang.Error("Expected an op");
        }

    }

    public abstract void printOp();

    public abstract int execOp();

}
