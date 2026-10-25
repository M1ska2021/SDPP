# Assignment 5 | Strategy Pattern

- **Student:** Alibi Maksut
- **Group:** SE-2523
- **Topic:** Option B (Calculator)

---

## 1. Role Map

| Role | Name | Source Path | Description |
|---|---|---|---|
| **Strategy Interface** | `Strategy` | `src/Strategy.java` | Declares arithmetic execution method `execute(double a, double b)` common to all strategies |
| **Concrete Strategy 1** | `AddStrategy` | `src/AddStrategy.java` | Implements addition algorithm (`a + b`) |
| **Concrete Strategy 2** | `SubtractStrategy` | `src/SubtractStrategy.java` | Implements subtraction algorithm (`a - b`) |
| **Concrete Strategy 3** | `MultiplyStrategy` | `src/MultiplyStrategy.java` | Implements multiplication algorithm (`a * b`) |
| **Concrete Strategy 4 (Extension)** | `DivideStrategy` | `src/DivideStrategy.java` | Extension implementing division (`a / b`) with zero-division validation |
| **Context** | `Calculator` | `src/Calculator.java` | Holds strategy reference, delegates execution, and supports runtime strategy switching |
| **Client** | `Main` | `src/Main.java` | Demonstration test harness executing verification checks T1–T7 |

---

## 2. Key Code Pointers

- **Strategy Interface:** `Strategy.java` (`double execute(double a, double b)`)
- **Context Delegation:** `Calculator.java` (`calculate(a, b) -> strategy.execute(a, b)`)
- **Runtime Strategy Switcher:** `Calculator.java` (`public void setStrategy(Strategy strategy)`)
- **Runtime Switching Verification (T4):** `Main.java` proves reference identity (`refBefore == refAfter`), strategy swap (`Add -> Multiply`), and polymorphic recalculation on the exact same context instance.
- **Extensibility Demonstration (T5):** `DivideStrategy.java` added independently without modifying `Calculator` or existing strategies.

---

## 3. How to Build and Run

```bash
javac --release 17 -encoding UTF-8 -d out @sources.txt
java -cp out calculator.Main
```

---

## 4. How to Add a New Strategy

1. Implement `Strategy`:
```java
package calculator;

public class PowerStrategy implements Strategy {
    @Override
    public double execute(double a, double b) {
        return Math.pow(a, b);
    }

    @Override
    public String getOperationName() {
        return "POWER";
    }
}
```
2. Pass the new strategy to `Calculator`:
```java
Calculator calculator = new Calculator(new PowerStrategy());
double result = calculator.calculate(2, 3); // 8.0
```
No existing classes need to be modified.

---

## 5. Expected Demonstration Outcomes (T1–T7)

```text
T1 PASS | Calculator + AddStrategy | 10 + 5 = 15.0
T2 PASS | Calculator + SubtractStrategy | 10 - 5 = 5.0
T3 PASS | Calculator + MultiplyStrategy | 10 * 5 = 50.0
T4 PASS | Runtime Strategy Switch on Same Context Instance | sameInstance=true | Add(24.0) -> Multiply(80.0)
T5 PASS | Calculator + DivideStrategy (Extension) | 10 / 5 = 2.0
T6 PASS | Invariant Defense | Null Strategy Rejection verified
T7 PASS | Input Validation | Division by zero rejected safely
SUMMARY: 7/7 PASS
```
