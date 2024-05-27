import java.util.Scanner;

public class InputOutputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // print와 println 예제
        System.out.print("이것은 print입니다.");
        System.out.print(" 여전히 같은 줄에 있습니다.");
        System.out.println(" 이것은 println입니다.");
        System.out.println("이제 새로운 줄입니다.");

        // next() 예제
        System.out.print("단어를 입력하세요: ");
        String word = scanner.next();
        System.out.println("입력한 단어: " + word);

        // nextLine() 예제
        scanner.nextLine(); // 버퍼를 비웁니다
        System.out.print("문장을 입력하세요: ");
        String line = scanner.nextLine();
        System.out.println("입력한 문장: " + line);

        // nextInt() 예제
        System.out.print("정수를 입력하세요: ");
        int number = scanner.nextInt();
        System.out.println("입력한 정수: " + number);
    }
}