import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {
        // 빈 배열 선언
        int[] emptyArray = new int[5];
        String[] emptyStringArray = new String[3];

        // 배열 초기화
        int[] numbers = {1, 2, 3, 4, 5};
        String[] names = {"Alice", "Bob", "Charlie"};

        // 메서드 안에서 배열 선언과 동시에 초기화
        int[] moreNumbers = new int[]{6, 7, 8, 9, 10};
        String[] moreNames = new String[]{"Dave", "Eve", "Frank"};

        // 2차원 배열 선언 및 초기화
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // 배열 요소 호출
        System.out.println("첫 번째 숫자: " + numbers[0]);
        System.out.println("세 번째 이름: " + names[2]);

        // 인덱스 에러 예시 (주석 처리된 코드)
        // System.out.println(numbers[5]); // ArrayIndexOutOfBoundsException 발생

        // 배열 toString 문제
        System.out.println("배열의 참조 주소: " + numbers);
        System.out.println("배열의 요소: " + Arrays.toString(numbers));

        // 2차원 배열 toString 문제
        System.out.println("2차원 배열의 참조 주소: " + matrix);
        System.out.println("2차원 배열의 요소: " + Arrays.deepToString(matrix));

        // 배열 순회 (for 문 사용)
        System.out.println("배열 순회 (for 문):");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "]: " + numbers[i]);
        }

        // 향상된 for 문 사용
        System.out.println("배열 순회 (향상된 for 문):");
        for (int number : numbers) {
            System.out.println("number: " + number);
        }

        // 2차원 배열 순회 (for 문 사용)
        System.out.println("2차원 배열 순회 (for 문):");


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("matrix[" + i + "][" + j + "]: " + matrix[i][j]);
            }
        }

        // 2차원 배열 순회 (향상된 for 문 사용)
        System.out.println("2차원 배열 순회 (향상된 for 문):");
        for (int[] row : matrix) {
            for (int number : row) {
                System.out.println("number: " + number);
            }
        }
    }
}
