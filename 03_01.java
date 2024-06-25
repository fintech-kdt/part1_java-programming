import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CalculatorWithExceptions {
    // 계산 로그를 저장할 리스트
    private List<String> log = new ArrayList<>();

    public static void main(String[] args) {
        // 계산기 객체 생성 및 실행
        CalculatorWithExceptions calculator = new CalculatorWithExceptions();
        calculator.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                // 첫 번째 숫자 입력 받기
                System.out.print("첫 번째 숫자를 입력하세요 (종료하려면 'q' 입력): ");
                String input = scanner.nextLine();
                if ("q".equalsIgnoreCase(input)) {
                    break;  // 'q' 입력 시 프로그램 종료
                }
                double num1 = parseDouble(input);  // 문자열을 double로 변환

                // 연산자 입력 받기
                System.out.print("연산자를 입력하세요 (+, -, *, /): ");
                char operator = getOperator(scanner.nextLine());

                // 두 번째 숫자 입력 받기
                System.out.print("두 번째 숫자를 입력하세요: ");
                double num2 = parseDouble(scanner.nextLine());

                // 계산 수행
                double result = calculate(num1, num2, operator);
                System.out.println("결과: " + result);
                
                // 계산 결과를 로그에 추가
                log.add(String.format("연산: %.2f %c %.2f = %.2f", num1, operator, num2, result));
            } catch (CalculatorException e) {
                // 계산기 관련 예외 처리
                System.out.println("계산 오류: " + e.getMessage());
                log.add("오류: " + e.getMessage());
            } catch (Exception e) {
                // 기타 예상치 못한 예외 처리
                System.out.println("예상치 못한 오류 발생: " + e.getMessage());
                log.add("예상치 못한 오류: " + e.getMessage());
            } finally {
                // 항상 실행되는 블록
                System.out.println("로그 기록 중...");
                // 실제 애플리케이션에서는 여기서 파일이나 데이터베이스에 로그를 기록할 수 있습니다.
                System.out.println("현재 로그 항목 수: " + log.size());
            }
        }
        // 프로그램 종료 시 전체 로그 출력
        System.out.println("프로그램을 종료합니다. 전체 로그:");
        for (String entry : log) {
            System.out.println(entry);
        }
    }

    // 문자열을 double로 변환하는 메서드
    private double parseDouble(String input) throws CalculatorException {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            // 숫자로 변환할 수 없는 경우 예외 발생
            throw new CalculatorException("유효한 숫자가 아닙니다: " + input);
        }
    }

    // 입력받은 문자열에서 유효한 연산자를 추출하는 메서드
    private char getOperator(String input) throws CalculatorException {
        if (input.length() != 1) {
            // 입력된 문자열의 길이가 1이 아닌 경우 예외 발생
            throw new CalculatorException("연산자는 한 글자여야 합니다.");
        }
        char op = input.charAt(0);
        if (op != '+' && op != '-' && op != '*' && op != '/') {
            // 유효한 연산자가 아닌 경우 예외 발생
            throw new CalculatorException("유효한 연산자가 아닙니다: " + op);
        }
        return op;
    }

    // 실제 계산을 수행하는 메서드
    private double calculate(double num1, double num2, char operator) throws CalculatorException {
        switch (operator) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/':
                if (num2 == 0) {
                    // 0으로 나누려는 경우 예외 발생
                    throw new CalculatorException("0으로 나눌 수 없습니다.");
                }
                return num1 / num2;
            default:
                // 알 수 없는 연산자인 경우 예외 발생
                throw new CalculatorException("알 수 없는 연산자: " + operator);
        }
    }
}

// 계산기 관련 사용자 정의 예외 클래스
class CalculatorException extends Exception {
    public CalculatorException(String message) {
        super(message);
    }
}