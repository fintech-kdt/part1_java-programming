public class DataTypeExample {
    public static void main(String[] args) {
        // 원시 타입
        byte b = 100;
        short s = 10000;
        int i = 100000;
        long l = 10000000000L;

        float f = 3.14f;
        double d = 3.141592653589793;

        char c = 'A';
        boolean isTrue = true;

        // 객체 타입
        String greeting = "Hello, World!";

        int[] numbers = {1, 2, 3, 4, 5};

        Person person = new Person();
        person.name = "John";
        person.age = 30;

        // 출력
        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + isTrue);
        System.out.println("String: " + greeting);
        System.out.println("Array: " + numbers[0] + ", " + numbers[1]);
        System.out.println("Person: " + person.name + ", " + person.age);
    }
}

class Person {
    String name;
    int age;
}