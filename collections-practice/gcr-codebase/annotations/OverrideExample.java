package annotations;
class Animal {
    void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}

public class OverrideExample {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.makeSound();
    }
}
