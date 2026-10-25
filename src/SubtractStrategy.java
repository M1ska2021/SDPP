package calculator;

public class SubtractStrategy implements Strategy {

    @Override
    public double execute(double a, double b) {
        return a - b;
    }

    @Override
    public String getOperationName() {
        return "SUBTRACT";
    }
}