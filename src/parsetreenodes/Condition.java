package parsetreenodes;

import interpreter.Tokenizer;

public abstract class Condition {

    public static Condition parseCondition() {
        int currentToken = Tokenizer.getToken();
        if (currentToken == Tokenizer.tokenNumbers.get("(")) {
            ConditionComp comp = new ConditionComp();
            comp.parseComp();
            return comp;
        } else if (currentToken == Tokenizer.tokenNumbers.get("!")) {
            ConditionNot not = new ConditionNot();
            not.parseConditionNot();
            return not;
        } else if (currentToken == Tokenizer.tokenNumbers.get("[")) {
            Tokenizer.skipToken();
            Condition cond1 = Condition.parseCondition();
            if (Tokenizer.getToken() == Tokenizer.tokenNumbers.get("&&")) {
                Tokenizer.skipToken();
                Condition cond2 = Condition.parseCondition();
                if (Tokenizer.getToken() == Tokenizer.tokenNumbers.get("]")) {
                    Tokenizer.skipToken();
                } else {
                    throw new java.lang.Error(
                            "Expected ']' at end of condition");
                }
                return new ConditionAnd(cond1, cond2);
            } else if (Tokenizer.getToken() == Tokenizer.tokenNumbers
                    .get("||")) {
                Tokenizer.skipToken();
                Condition cond2 = Condition.parseCondition();
                if (Tokenizer.getToken() == Tokenizer.tokenNumbers.get("]")) {
                    Tokenizer.skipToken();
                } else {
                    throw new java.lang.Error(
                            "Expected ']' at end of condition");
                }
                return new ConditionOr(cond1, cond2);
            } else {
                throw new java.lang.Error("Expected '&&' or '||'");
            }
        } else {
            throw new java.lang.Error("Expected '(' at beginning of condition");
        }

    }

    public abstract void printCondition();

    public abstract boolean execCondition();

}
