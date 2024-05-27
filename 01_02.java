public class VariableAndConstantExample {
    public static void main(String[] args) {
        // 변수 선언
        int age;
        double price;

        // 값 대입(할당)
        age = 25;
        price = 19.99;

        // 변수 값 출력
        System.out.println("나이: " + age);
        System.out.println("가격: " + price);

        // 변수 초기화
        int height = 175;
        boolean isJavaFun = true;

        // 초기화된 변수 값 출력
        System.out.println("키: " + height);
        System.out.println("자바는 재미있다: " + isJavaFun);

        // 상수 선언 및 초기화
        final int DAYS_IN_WEEK = 7;
        final double PI = 3.14159;

        // 상수 값 출력
        System.out.println("일주일의 일수: " + DAYS_IN_WEEK);
        System.out.println("파이 값: " + PI);

        // 변수 값 변경
        age = 30;
        price = 29.99;

        // 변경된 변수 값 출력
        System.out.println("변경된 나이: " + age);
        System.out.println("변경된 가격: " + price);

        // 상수 값은 변경 불가 (다음 코드는 컴파일 오류 발생)
        // DAYS_IN_WEEK = 8;
    }
}