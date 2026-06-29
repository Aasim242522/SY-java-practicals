
class Calculator {
    int value;

    // 1. Constructor Overloading
    // Default constructor
    Calculator() {
        this.value = 0;
    }

    // Parameterized constructor
    Calculator(int val) {
        this.value = val;
    }

    // 2. Method Overloading
    // Method to add two integers
    int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add three integers
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // 3. Static Method
    static void printInfo() {
        System.out.println("This is a Calculator utility class.");
    }
}

public class MainA {
    public static void main(String[] args) {
        Calculator calc1 = new Calculator();      // Uses default constructor
        Calculator calc2 = new Calculator(10);    // Uses parameterized constructor

        System.out.println("Sum (2 args): " + calc2.add(5, 5));
        System.out.println("Sum (3 args): " + calc2.add(1, 2, 3));
        
        // Static method is called using the class name
        Calculator.printInfo();
    }
}






