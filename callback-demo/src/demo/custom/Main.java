package demo.custom;

import demo.custom.evaluator.NumbersEvaluator;
import demo.custom.expression.AddExpressionEvaluator;
import demo.custom.expression.ExpressionEvaluator;
import demo.custom.expression.MinusExpressionEvaluator;
import demo.custom.printer.DecoratedValuePrinter;
import demo.custom.printer.StandardValuePrinter;
import demo.custom.printer.ValuePrinter;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }


    private void run() {
        //ExpressionEvaluator expressionEvaluator = new MinusExpressionEvaluator();
       /* ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator() {
            @Override
            public int evaluate(int a, int b) {
                return a * b;
            }
        };
        */

        //ExpressionEvaluator expressionEvaluator = (a, b) -> powEvaluator(a,b);

        //ExpressionEvaluator expressionEvaluator = this::powEvaluator;

        ExpressionEvaluator expressionEvaluator = Integer::sum;
        ValuePrinter valuePrinter = new DecoratedValuePrinter();
        NumbersEvaluator numbersEvaluator = new NumbersEvaluator();

        numbersEvaluator.evaluate(4, expressionEvaluator, valuePrinter);
    }

    private int powEvaluator(int a, int b) {
        return (int)Math.pow(a, b);
    }
}
