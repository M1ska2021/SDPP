package calculator;

public class AddStrategy implements Strategy {

    @Override
    public double execute(double a, double b) {
        return a + b;
    }

    @Override
    public String getOperationName() {
        return "ADD";
    }
}