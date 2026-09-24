package com.mycompany.test1;

// Define a custom exception class
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

// Create a class that uses the custom exception
class ExceptionDemo {
    public void performTask(int value) throws CustomException {
        if (value < 0) {
            throw new CustomException("Value cannot be negative");
        } else if (value > 100) {
            throw new CustomException("Value cannot exceed 100");
        } else {
            System.out.println("Task performed successfully for value: " + value);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ExceptionDemo demo = new ExceptionDemo();

        try {
            demo.performTask(50);   // Valid, no exception
            demo.performTask(-10);  // Throws CustomException
            demo.performTask(120);  // Won't be reached because previous line threw an exception
        } catch (CustomException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
        }
    }
}