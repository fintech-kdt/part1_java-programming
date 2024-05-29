public class ControlFlowExample {
    public static void main(String[] args) {
        // if 문
        int a = 10;
        int b = 20;
        if (a < b) {
            System.out.println("a는 b보다 작습니다.");
        } else if (a == b) {
            System.out.println("a와 b는 같습니다.");
        } else {
            System.out.println("a는 b보다 큽니다.");
        }

        // switch 문
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("월요일");
                break;
            case 2:
                System.out.println("화요일");
                break;
            case 3:
                System.out.println("수요일");
                break;
            case 4:
                System.out.println("목요일");
                break;
            case 5:
                System.out.println("금요일");
                break;
            case 6:
                System.out.println("토요일");
                break;
            case 7:
                System.out.println("일요일");
                break;
            default:
                System.out.println("유효하지 않은 요일");
                break;
        }

        // switch 문에서 break가 없는 경우
        switch (day) {
            case 1:
                System.out.println("월요일");
            case 2:
                System.out.println("화요일");
            case 3:
                System.out.println("수요일"); // 해당 case 이후의 모든 블록이 실행됨
            case 4:
                System.out.println("목요일");
            case 5:
                System.out.println("금요일");
            case 6:
                System.out.println("토요일");
            case 7:
                System.out.println("일요일");
            default:
                System.out.println("유효하지 않은 요일");
        }

        // for 문 - 앞으로 반복
        for (int i = 0; i < 5; i++) {
            System.out.println("앞으로 반복 i: " + i);
        }

        // for 문 - 뒤로 반복
        for (int i = 5; i > 0; i--) {
            System.out.println("뒤로 반복 i: " + i);
        }

        // for 문 - 무한 반복
        for (int i = 0; ; i++) {
            System.out.println("무한 반복 i: " + i);
            if (i == 10) {
                break; // 반복문을 종료하는 조건
            }
        }

        // while 문
        int i = 0;
        while (i < 5) {
            System.out.println("while 문 i: " + i);
            i++;
        }

        // do-while 문
        i = 0;
        do {
            System.out.println("do-while 문 i: " + i);
            i++;
        } while (i < 5);

        // 무한 반복 예제
        while (true) {
            System.out.println("무한 반복");
            if (i == 10) {
                break; // 반복문을 종료하는 조건
            }
            i++;
        }

        // break와 continue
        for (int j = 0; j < 10; j++) {
            if (j == 5) {
                break; // j가 5일 때 반복문 종료
            }
            System.out.println("break 예제 j: " + j);
        }

        for (int k = 0; k < 10; k++) {
            if (k % 2 == 0) {
                continue; // 짝수일 때는 다음 반복으로 건너뜀
            }
            System.out.println("continue 예제 k: " + k);
        }

        // 삼항 연산자
        String result = (a < b) ? "a는 b보다 작습니다." : "a는 b보다 크거나 같습니다.";
        System.out.println("삼항 연산자 결과: " + result);
    }
}