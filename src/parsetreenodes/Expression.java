package parsetreenodes;

import interpreter.Tokenizer;

public abstract class Expression {
	public static Expression parseExpression() {
		Factor fac = Factor.parseFactor();
		if(Tokenizer.getToken() == Tokenizer.tokenNumbers.get("+")){
			Tokenizer.skipToken();
			Expression exp = Expression.parseExpression();
			return new ExpressionSum(exp, fac);
			
		}else if(Tokenizer.getToken() == Tokenizer.tokenNumbers.get("-")){
			Tokenizer.skipToken();
			Expression exp = Expression.parseExpression();
			return new ExpressionMinus(exp, fac);
			
		}else{
			return new ExpressionInt(fac);
		}
    }

    public abstract void printExpression();

    public abstract int execExpression();
}
