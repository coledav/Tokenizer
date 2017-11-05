package parsetreenodes;

public class ExpressionSum extends Expression {

    Expression exp;
    Factor fac;

    public ExpressionSum(Expression expr, Factor factor) {
        this.exp = expr;
        this.fac = factor;

    }

    @Override
    public void printExpression() {
        this.fac.printFactor();
        System.out.print(" + ");
        this.exp.printExpression();
    }

    @Override
    public int execExpression() {
        return this.fac.execFactor() + this.exp.execExpression();
    }
}
