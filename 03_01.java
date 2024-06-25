import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CalculatorWithExceptions {
    private List<String> log = new ArrayList<>();

    public static void main(String[] args) {
        CalculatorWithExceptions calculator = new CalculatorWithExceptions();
        calculator.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요 (종료하려면 'q' 입력): ");
                String input = scanner.nextLine();
                if ("q".equalsIgnoreCase(input)) {
                    break;
                }
                double num1 = parseDouble(input);

                System.out.print("연산자를 입력하세요 (+, -, *, /): ");
                char operator = getOperator(scanner.nextLine());

                System.out.print("두 번째 숫자를 입력하세요: ");
                double num2 = parseDouble(scanner.nextLine());

                double result = calculate(num1, num2, operator);
                System.out.println("결과: " + result);
                
                log.add(String.format("연산: %.2f %c %.2f = %.2f", num1, operator, num2, result));
            } catch (CalculatorException e) {
                System.out.println("계산 오류: " + e.getMessage());
                log.add("오류: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("예상치 못한 오류 발생: " + e.getMessage());
                log.add("예상치 못한 오류: " + e.getMessage());
            } finally {
                System.out.println("로그 기록 중...");
                // 실제 애플리케이션에서는 여기서 파일이나 데이터베이스에 로그를 기록할 수 있습니다.
                System.out.println("현재 로그 항목 수: " + log.size());
            }
        }
        System.out.println("프로그램을 종료합니다. 전체 로그:");
        for (String entry : log) {
            System.out.println(entry);
        }
    }

    private double parseDouble(String input) throws CalculatorException {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new CalculatorException("유효한 숫자가 아닙니다: " + input);
        }
    }

    private char getOperator(String input) throws CalculatorException {
        if (input.length() != 1) {
            throw new CalculatorException("연산자는 한 글자여야 합니다.");
        }
        char op = input.charAt(0);
        if (op != '+' && op != '-' && op != '*' && op != '/') {
            throw new CalculatorException("유효한 연산자가 아닙니다: " + op);
        }
        return op;
    }

    private double calculate(double num1, double num2, char operator) throws CalculatorException {
        switch (operator) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new CalculatorException("0으로 나눌 수 없습니다.");
                }
                return num1 / num2;
            default:
                throw new CalculatorException("알 수 없는 연산자: " + operator);
        }
    }
}

class CalculatorException extends Exception {
    public CalculatorException(String message) {
        super(message);
    }
}