package calculator;

public class DivideStrategy implements Strategy {

    @Override
    public double execute(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    @Override
    public String getOperationName() {
        return "DIVIDE";
    }
}
