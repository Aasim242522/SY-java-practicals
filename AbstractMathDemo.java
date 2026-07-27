// Abstract class and method
abstract class MathOperation {
    // Abstract method
    abstract double calculate(double a, double b);

    // Concrete method
    void displayResult(String operation, double result) {
        System.out.println(operation + " Result: " + result);
    }
}

// Subclass for Addition
class Addition extends MathOperation {
    @Override
    double calculate(double a, double b) {
        return a + b;
    }
}

// Subclass for Subtraction
class Subtraction extends MathOperation {
    @Override
    double calculate(double a, double b) {
        return a - b;
    }
}

// Subclass for Multiplication
class Multiplication extends MathOperation {
    @Override
    double calculate(double a, double b) {
        return a * b;
    }
}

// Subclass for Division
class Division extends MathOperation {
    @Override
    double calculate(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}

// Main class
public class AbstractMathDemo {
    public static void main(String[] args) {
        MathOperation add = new Addition();
        MathOperation subtract = new Subtraction();
        MathOperation multiply = new Multiplication();
        MathOperation divide = new Division();

        double a = 20, b = 10;

        // Perform operations
        add.displayResult("Addition", add.calculate(a, b));
        subtract.displayResult("Subtraction", subtract.calculate(a, b));
        multiply.displayResult("Multiplication", multiply.calculate(a, b));
        divide.displayResult("Division", divide.calculate(a, b));
    }
}