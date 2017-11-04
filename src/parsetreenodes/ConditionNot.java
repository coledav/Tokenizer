package parsetreenodes;

import interpreter.Tokenizer;

public class ConditionNot extends Condition {

    private Condition cond;

    public void parseConditionNot() {
        int currentToken = Tokenizer.getToken();
        if (currentToken == Tokenizer.tokenNumbers.get("!")) {
            Tokenizer.skipToken();
            this.cond = Condition.parseCondition();
        } else {
            throw new java.lang.Error(
                    "Expected '!' at beginning  of condition");
        }
    }

    @Override
    public void printCondition() {
        System.out.print("!");
        this.printCondition();
    }

    @Override
    public boolean execCondition() {
        return !this.cond.execCondition();

    }
}
