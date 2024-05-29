import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 사용자 입력 받기
        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();

        System.out.print("나이를 입력하세요: ");
        int age = scanner.nextInt();

        // Person 객체 생성
        Person person1 = new Person(name, age);
        person1.introduce();

        // 클래스 변수 사용
        System.out.println("현재 인구수: " + Person.population);

        // 클래스 메서드 호출
        Person.showPopulation();

        // getter와 setter 사용
        System.out.print("새 이름을 입력하세요: ");
        scanner.nextLine(); // 버퍼 비우기
        String newName = scanner.nextLine();

        System.out.print("새 나이를 입력하세요: ");
        int newAge = scanner.nextInt();

        person1.setName(newName);
        person1.setAge(newAge);

        System.out.println("이름: " + person1.getName());
        System.out.println("나이: " + person1.getAge());

        scanner.close();
    }
}

class Person {
    private String name;
    private int age;
    public static int population = 0;

    // 기본 생성자
    public Person() {
        this.name = "이름 없음";
        this.age = 0;
        population++;
    }

    // 매개변수가 있는 생성자
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        population++;
    }

    // Getter 메서드
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setter 메서드
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) { // 유효성 검사 추가 가능
            this.age = age;
        }
    }

    // 인스턴스 메서드
    public void introduce() {
        System.out.println("안녕하세요, 제 이름은 " + this.name + "이고, 나이는 " + this.age + "살입니다.");
    }

    // 클래스 메서드
    public static void showPopulation() {
        System.out.println("현재 인구수: " + population);
    }
}
