public class Person {
    String name;
    int age;

    // 기본 생성자
    public Person() {
        this.name = "이름 없음";
        this.age = 0;
    }

    // 매개변수가 있는 생성자
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 메서드
    void introduce() {
        System.out.println("안녕하세요, 제 이름은 " + name + "이고, 나이는 " + age + "살입니다.");
    }

    public static void main(String[] args) {
        // 기본 생성자를 사용한 객체 생성
        Person person1 = new Person();
        person1.introduce();

        // 매개변수가 있는 생성자를 사용한 객체 생성
        Person person2 = new Person("홍길동", 30);
        person2.introduce();
    }
}