package parsetreenodes;

import interpreter.Tokenizer;

public abstract class Expression {
	public static Expression parseExpression() {
		
		return null;
    }

    public abstract void printExpression();

    public abstract void execExpression();
}
