import java.util.*;

public class DataStructuresExample {
    public static void main(String[] args) {
        // ArrayList 예제
        List<String> fruits = new ArrayList<>();
        fruits.add("사과");
        fruits.add("바나나");
        fruits.add("체리");
        System.out.println("ArrayList: " + fruits);

        // HashSet 예제
        Set<String> colors = new HashSet<>();
        colors.add("빨강");
        colors.add("초록");
        colors.add("파랑");
        colors.add("빨강"); // 중복된 요소는 추가되지 않음
        System.out.println("HashSet: " + colors);

        // HashMap 예제
        Map<String, Integer> map = new HashMap<>();
        map.put("사과", 3);
        map.put("바나나", 2);
        map.put("체리", 5);
        System.out.println("HashMap: " + map);

        // String 클래스 예제
        String str = " Hello, World! ";
        System.out.println("문자열 길이: " + str.length());
        System.out.println("인덱스 1의 문자: " + str.charAt(1));
        System.out.println("부분 문자열 (0-5): " + str.substring(0, 5));
        System.out.println("대문자 변환: " + str.toUpperCase());
        System.out.println("공백 제거: " + str.trim());

        // Math 클래스 예제
        System.out.println("절대값 -5: " + Math.abs(-5));
        System.out.println("5와 10 중 큰 값: " + Math.max(5, 10));
        System.out.println("16의 제곱근: " + Math.sqrt(16));
        System.out.println("난수: " + Math.random());

        // Wrapper 클래스 예제
        Integer intObj = Integer.valueOf(100);
        Double doubleObj = Double.valueOf(3.14);
        int intValue = intObj.intValue();
        double doubleValue = doubleObj.doubleValue();
        System.out.println("Integer 값: " + intValue);
        System.out.println("Double 값: " + doubleValue);

        int parsedInt = Integer.parseInt("123");
        double parsedDouble = Double.parseDouble("3.14");
        System.out.println("문자열을 변환한 int 값: " + parsedInt);
        System.out.println("문자열을 변환한 double 값: " + parsedDouble);

        // Arrays 클래스 예제
        int[] array = {5, 3, 8, 2};
        Arrays.sort(array); // 오름차순 정렬
        System.out.println("오름차순 정렬: " + Arrays.toString(array));

        Integer[] arrayDesc = {5, 3, 8, 2};
        Arrays.sort(arrayDesc, Collections.reverseOrder()); // 내림차순 정렬
        System.out.println("내림차순 정렬: " + Arrays.toString(arrayDesc));

        // ArrayList 정렬 예제
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("orange");
        list.add("banana");
        list.add("grape");

        Collections.sort(list); // 오름차순 정렬
        System.out.println("오름차순 정렬: " + list);

        Collections.sort(list, Collections.reverseOrder()); // 내림차순 정렬
        System.out.println("내림차순 정렬: " + list);
    }
}