import java.util.*;

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("이름: " + name + ", 나이: " + age);
    }
}

public class NullConceptExample {
    public static void main(String[] args) {
        // null 초기화 예제
        String nullString = null;
        Integer nullInteger = null;
        Person nullPerson = null;

        System.out.println("null String: " + nullString);
        System.out.println("null Integer: " + nullInteger);
        System.out.println("null Person: " + nullPerson);

        // null 체크 예제
        if (nullString == null) {
            System.out.println("nullString은 null입니다.");
        }

        // NullPointerException 예제
        try {
            nullString.length(); // NullPointerException 발생
        } catch (NullPointerException e) {
            System.out.println("NullPointerException 발생: " + e.getMessage());
        }

        // Wrapper 클래스와 null
        Integer wrapperInt = null;
        System.out.println("Wrapper Integer: " + wrapperInt);

        // 원시 타입과 null
        int primitiveInt = 0; // null을 할당할 수 없음
        System.out.println("Primitive int: " + primitiveInt);

        // null을 활용한 조건부 로직
        String[] names = {"Alice", null, "Bob", null, "Charlie"};
        List<String> validNames = new ArrayList<>();

        for (String name : names) {
            if (name != null) {
                validNames.add(name);
            }
        }
        System.out.println("유효한 이름 목록: " + validNames);

        // Person 객체와 null
        Person person1 = new Person("John", 30);
        Person person2 = null;

        displayPersonInfo(person1);
        displayPersonInfo(person2);

        // null 값을 포함한 리스트 처리
        List<Integer> numbers = Arrays.asList(1, null, 2, null, 3, 4, null);
        int sum = calculateSum(numbers);
        System.out.println("null을 제외한 숫자의 합: " + sum);
    }

    public static void displayPersonInfo(Person person) {
        if (person != null) {
            person.introduce();
        } else {
            System.out.println("Person 객체가 null입니다.");
        }
    }

    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer num : numbers) {
            if (num != null) {
                sum += num;
            }
        }
        return sum;
    }
}