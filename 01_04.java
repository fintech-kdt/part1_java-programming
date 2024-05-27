public class OperatorExample {
    public static void main(String[] args) {
        // 산술 연산자
        int sum = 10 + 5;
        int difference = 10 - 5;
        int product = 10 * 5;
        int quotient = 10 / 5;
        int remainder = 10 % 3;

        System.out.println("합계: " + sum);
        System.out.println("차이: " + difference);
        System.out.println("곱: " + product);
        System.out.println("몫: " + quotient);
        System.out.println("나머지: " + remainder);

        // 문자열 연결 연산자
        String greeting = "안녕하세요, " + "세계!";
        System.out.println(greeting);

        // 비교 연산자
        boolean isEqual = (10 == 10);
        boolean isNotEqual = (10 != 5);
        boolean isGreater = (10 > 5);
        boolean isLesser = (5 < 10);
        boolean isGreaterOrEqual = (10 >= 5);
        boolean isLesserOrEqual = (5 <= 10);

        System.out.println("같다: " + isEqual);
        System.out.println("같지 않다: " + isNotEqual);
        System.out.println("크다: " + isGreater);
        System.out.println("작다: " + isLesser);
        System.out.println("크거나 같다: " + isGreaterOrEqual);
        System.out.println("작거나 같다: " + isLesserOrEqual);

        // 논리 연산자
        boolean andResult = (10 > 5) && (5 < 10);
        boolean orResult = (10 > 5) || (5 > 10);
        boolean notResult = !(10 > 5);

        System.out.println("논리 AND 결과: " + andResult);
        System.out.println("논리 OR 결과: " + orResult);
        System.out.println("논리 NOT 결과: " + notResult);

        // 단축 평가 예제
        int x = 10;
        int y = 0;

        // 논리 AND 단축 평가: y가 0이므로 두 번째 조건은 평가되지 않습니다.
        boolean shortCircuitAnd = (y != 0) && (x / y > 1);
        System.out.println("논리 AND 단축 평가 결과: " + shortCircuitAnd); // false

        // 논리 OR 단축 평가: 첫 번째 조건이 true이므로 두 번째 조건은 평가되지 않습니다.
        boolean shortCircuitOr = (y == 0) || (x / y > 1);
        System.out.println("논리 OR 단축 평가 결과: " + shortCircuitOr); // true

        // 문자열 비교
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        boolean isEqualReference = (str1 == str2); // true
        boolean isEqualReference2 = (str1 == str3); // false
        boolean isEqualContent = str1.equals(str3); // true

        System.out.println("참조 비교 (str1 == str2): " + isEqualReference);
        System.out.println("참조 비교 (str1 == str3): " + isEqualReference2);
        System.out.println("내용 비교 (str1.equals(str3)): " + isEqualContent);
    }
}