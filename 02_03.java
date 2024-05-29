import java.util.Scanner;

interface Animal {
    void sound();
}

class Dog implements Animal {
    public void sound() {
        System.out.println("멍멍");
    }
}

class Cat implements Animal {
    public void sound() {
        System.out.println("야옹");
    }
}

class AnimalUtils {
    public static void makeSound(Animal animal) {
        animal.sound();
    }
}

public class Example {
    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 사용자 입력 받기
        System.out.print("동물 종류를 입력하세요 (dog/cat): ");
        String animalType = scanner.nextLine();

        Animal animal;

        if (animalType.equals("dog")) {
            animal = new Dog();
        } else {
            animal = new Cat();
        }

        // 다형성 예제
        AnimalUtils.makeSound(animal);

        // 제네릭 예제
        Box<String> stringBox = new Box<>();
        stringBox.setItem("Hello, World!");
        System.out.println("Box contains: " + stringBox.getItem());

        Box<Integer> intBox = new Box<>();
        intBox.setItem(123);
        System.out.println("Box contains: " + intBox.getItem());

        scanner.close();
    }
}

class Box<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
