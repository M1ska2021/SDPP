package calculator;

public class Main {

    public static void main(String[] args) {
        runDemo();
    }

    public static void runDemo() {
        int passed = 0;
        int total = 5;

        Calculator calculator = new Calculator(new AddStrategy());
        double res1 = calculator.calculate(10, 5);
        if (res1 == 15.0) {
            System.out.println("T1 PASS | Calculator + AddStrategy | 10 + 5 = " + res1);
            passed++;
        } else {
            System.out.println("T1 FAIL | Calculator + AddStrategy");
        }

        calculator.setStrategy(new SubtractStrategy());
        double res2 = calculator.calculate(10, 5);
        if (res2 == 5.0) {
            System.out.println("T2 PASS | Calculator + SubtractStrategy | 10 - 5 = " + res2);
            passed++;
        } else {
            System.out.println("T2 FAIL | Calculator + SubtractStrategy");
        }

        calculator.setStrategy(new MultiplyStrategy());
        double res3 = calculator.calculate(10, 5);
        if (res3 == 50.0) {
            System.out.println("T3 PASS | Calculator + MultiplyStrategy | 10 * 5 = " + res3);
            passed++;
        } else {
            System.out.println("T3 FAIL | Calculator + MultiplyStrategy");
        }

        Calculator switchCalc = new Calculator(new AddStrategy());
        Calculator refBefore = switchCalc;
        double beforeVal = switchCalc.calculate(20, 4);

        switchCalc.setStrategy(new MultiplyStrategy());
        Calculator refAfter = switchCalc;
        double afterVal = switchCalc.calculate(20, 4);

        boolean sameInstance = (refBefore == refAfter);
        boolean valueSwitched = (beforeVal == 24.0 && afterVal == 80.0);

        if (sameInstance && valueSwitched) {
            System.out.println("T4 PASS | Runtime Strategy Switch on Same Context Instance | sameInstance=" + sameInstance + " | Add(24.0) -> Multiply(80.0)");
            passed++;
        } else {
            System.out.println("T4 FAIL | Runtime Strategy Switch");
        }

        boolean nullStrategyCaught = false;
        try {
            new Calculator(null);
        } catch (NullPointerException e) {
            nullStrategyCaught = true;
        }

        boolean nullSwitchCaught = false;
        try {
            calculator.setStrategy(null);
        } catch (NullPointerException e) {
            nullSwitchCaught = true;
        }

        if (nullStrategyCaught && nullSwitchCaught) {
            System.out.println("T5 PASS | Invariant Defense | Null Strategy Rejection verified");
            passed++;
        } else {
            System.out.println("T5 FAIL | Invariant Defense | Null Strategy Rejection failed");
        }

        System.out.println("SUMMARY: " + passed + "/" + total + " PASS");
    }
}