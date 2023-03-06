package demo.custom.printer;

public class DecoratedValuePrinter implements ValuePrinter{
    @Override
    public void print(int value) {
        System.out.println(String
                .format("Value = [%d]", value));
    }
}
