// Parent Class
class Animal {
    void sound() {
        System.out.println("The animal makes a generic sound.");
    }
}

// Child Class (Inherits from Animal)
class Dog extends Animal {
    // Method Overriding: Changing the behavior of the parent's sound method
    @Override
    void sound() {
        System.out.println("The dog barks: Woof! Woof!");
    }
}

public class MainB {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Animal myDog = new Dog(); // Polymorphism: An Animal reference can hold a Dog object

        myAnimal.sound();
        myDog.sound(); // This will execute the Dog's version of sound()
    }
}