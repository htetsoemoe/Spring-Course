package demo.custom.expression;

public class MinusExpressionEvaluator implements ExpressionEvaluator{
    @Override
    public int evaluate(int a, int b) {
        return a - b;
    }
}
