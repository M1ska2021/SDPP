package calculator;

public interface Strategy {
    double execute(double a, double b);
    String getOperationName();
}