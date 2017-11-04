package parsetreenodes;

public class ConditionOr extends Condition {

    private Condition cond1;
    private Condition cond2;

    public ConditionOr(Condition cond1, Condition cond2) {
        this.cond1 = cond1;
        this.cond2 = cond2;
    }

    @Override
    public void printCondition() {
        System.out.print("[");
        this.cond1.printCondition();
        System.out.print(" || ");
        this.cond2.printCondition();
        System.out.print("]");
    }

    @Override
    public boolean execCondition() {
        return this.cond1.execCondition() || this.cond2.execCondition();
    }
}
