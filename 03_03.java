import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 학생 정보를 저장하는 클래스
class Student {
    private String name;
    private int age;
    private String major;
    private double gpa;

    // 생성자: 학생 객체 초기화
    public Student(String name, int age, String major, double gpa) {
        this.name = name;
        this.age = age;
        this.major = major;
        this.gpa = gpa;
    }

    // Getter 메서드들
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getMajor() { return major; }
    public double getGpa() { return gpa; }

    // toString 메서드 오버라이드: 학생 정보를 문자열로 반환
    @Override
    public String toString() {
        return name + " (나이: " + age + ", 전공: " + major + ", 평점: " + gpa + ")";
    }
}

public class StudentManagementSystem {
    // 학생 목록을 저장하는 ArrayList
    private List<Student> students = new ArrayList<>();

    // 새로운 학생을 목록에 추가하는 메서드
    public void addStudent(String name, int age, String major, double gpa) {
        students.add(new Student(name, age, major, gpa));
    }

    // 모든 학생 정보를 출력하는 메서드
    public void printAllStudents() {
        // forEach와 메서드 참조를 사용하여 각 학생 정보 출력
        // 메서드 참조 (System.out::println)는 각 학생 객체의 toString() 메서드를 호출하여 출력합니다.
        students.forEach(System.out::println);
    }

    // 특정 전공의 학생들을 반환하는 메서드
    public List<Student> getStudentsByMajor(String major) {
        // stream()을 사용하여 학생 리스트를 스트림으로 변환합니다.
        // filter()를 사용하여 주어진 전공과 일치하는 학생만 선택합니다.
        // collect()를 사용하여 필터링된 학생들을 새 리스트로 수집합니다.
        return students.stream()
                       .filter(s -> s.getMajor().equals(major))
                       .collect(Collectors.toList());
    }

    // 전체 학생의 평균 평점을 계산하는 메서드
    public double getAverageGpa() {
        // mapToDouble()을 사용하여 각 학생의 GPA를 double 스트림으로 변환합니다.
        // average()로 평균을 계산하고, orElse()로 학생이 없는 경우 0.0을 반환합니다.
        return students.stream()
                       .mapToDouble(Student::getGpa)
                       .average()
                       .orElse(0.0);
    }

    // 전공별 학생 수를 계산하는 메서드
    public Map<String, Long> getStudentCountByMajor() {
        // groupingBy()를 사용하여 학생들을 전공별로 그룹화합니다.
        // counting()을 사용하여 각 그룹(전공)의 학생 수를 계산합니다.
        // 결과는 전공을 키로, 학생 수를 값으로 하는 Map으로 반환됩니다.
        return students.stream()
                       .collect(Collectors.groupingBy(Student::getMajor, Collectors.counting()));
    }

    // 상위 n명의 학생 이름을 반환하는 메서드
    public List<String> getTopStudentNames(int n) {
        // sorted()를 사용하여 학생들을 GPA 기준으로 내림차순 정렬합니다.
        // limit()으로 상위 n명만 선택합니다.
        // map()을 사용하여 Student 객체에서 이름만 추출합니다.
        // collect()로 결과를 리스트로 수집합니다.
        return students.stream()
                       .sorted((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()))
                       .limit(n)
                       .map(Student::getName)
                       .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();

        // 학생 정보 추가
        system.addStudent("김철수", 20, "컴퓨터공학", 3.8);
        system.addStudent("이영희", 22, "수학", 3.9);
        system.addStudent("박지성", 21, "물리학", 3.7);
        system.addStudent("최민지", 23, "컴퓨터공학", 3.6);
        system.addStudent("정수민", 20, "수학", 4.0);

        System.out.println("전체 학생 목록:");
        system.printAllStudents();

        System.out.println("\n컴퓨터공학 전공 학생들:");
        // 컴퓨터공학 전공 학생들을 조회하고 출력
        system.getStudentsByMajor("컴퓨터공학").forEach(System.out::println);

        System.out.println("\n전체 학생 평균 평점: " + system.getAverageGpa());

        System.out.println("\n전공별 학생 수:");
        // 전공별 학생 수를 계산하고 출력
        // forEach를 사용하여 Map의 각 엔트리(전공과 학생 수)를 순회하며 출력합니다.
        system.getStudentCountByMajor().forEach((major, count) -> 
            System.out.println(major + ": " + count + "명"));

        System.out.println("\n상위 3명의 학생:");
        // 상위 3명의 학생 이름을 조회하고 출력
        system.getTopStudentNames(3).forEach(System.out::println);
    }
}