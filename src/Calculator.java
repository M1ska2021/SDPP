package calculator;

import java.util.Objects;

public class Calculator {

    private Strategy strategy;

    public Calculator(Strategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "Strategy cannot be null");
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "Strategy cannot be null");
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public double calculate(double a, double b) {
        return strategy.execute(a, b);
    }
}