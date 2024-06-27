import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SimpleDiary {
    // 기본 일기 저장 디렉토리 설정
    private static final String DEFAULT_DIARY_DIR = "diary_entries";
    // 날짜 형식 지정 (년-월-일)
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        SimpleDiary diary = new SimpleDiary();
        diary.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 메뉴 출력
            System.out.println("\n1. 일기 쓰기");
            System.out.println("2. 일기 읽기");
            System.out.println("3. 종료");
            System.out.print("선택하세요: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기 (엔터 제거)

            switch (choice) {
                case 1:
                    writeDiary(scanner);
                    break;
                case 2:
                    readDiary(scanner);
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }

    private void writeDiary(Scanner scanner) {
        // 현재 날짜 가져오기 (Java 8의 LocalDate 사용)
        LocalDate date = LocalDate.now();
        // 파일 이름 생성 (예: 2024-06-25.txt)
        String fileName = date.format(DATE_FORMATTER) + ".txt";

        System.out.println("오늘의 일기를 작성하세요. 작성을 마치려면 빈 줄을 입력하세요:");
        StringBuilder content = new StringBuilder();
        String line;
        // 빈 줄이 입력될 때까지 계속 입력 받기
        while (!(line = scanner.nextLine()).isEmpty()) {
            content.append(line).append("\n");
        }

        BufferedWriter writer = null;
        try {
            // 일기 저장 경로 가져오기
            String diaryPath = getDiaryPath();
            File diaryDir = new File(diaryPath);
            // 디렉토리가 없으면 생성
            if (!diaryDir.exists() && !diaryDir.mkdirs()) {
                throw new IOException("디렉토리 생성 실패: " + diaryPath);
            }

            // 일기 파일 생성 및 내용 쓰기
            File diaryFile = new File(diaryDir, fileName);
            writer = new BufferedWriter(new FileWriter(diaryFile));
            writer.write(content.toString());
            System.out.println("일기가 저장되었습니다.");
        } catch (IOException e) {
            System.err.println("일기 저장 중 오류 발생: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println("자원 해제 중 오류 발생: " + e.getMessage());
                }
            }
        }
    }

    private void readDiary(Scanner scanner) {
        System.out.print("읽고 싶은 일기의 날짜를 입력하세요 (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();

        BufferedReader reader = null;
        try {
            // 입력받은 문자열을 LocalDate 객체로 변환
            LocalDate date = LocalDate.parse(dateStr, DATE_FORMATTER);
            // 파일 이름 생성
            String fileName = date.format(DATE_FORMATTER) + ".txt";
            String diaryPath = getDiaryPath();
            File diaryFile = new File(diaryPath, fileName);

            // 파일이 존재하지 않으면 메시지 출력 후 종료
            if (!diaryFile.exists()) {
                System.out.println("해당 날짜의 일기가 없습니다.");
                return;
            }

            // 파일에서 일기 내용 읽기
            reader = new BufferedReader(new FileReader(diaryFile));
            String line;
            System.out.println("\n" + dateStr + "의 일기:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("일기 읽기 중 오류 발생: " + e.getMessage());
        } catch (Exception e) {
            // 날짜 형식이 잘못된 경우 예외 처리
            System.err.println("잘못된 날짜 형식입니다. yyyy-MM-dd 형식으로 입력해주세요.");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("자원 해제 중 오류 발생: " + e.getMessage());
                }
            }
        }
    }

    private String getDiaryPath() {
        // 환경 변수에서 일기 저장 경로 가져오기
        String diaryPath = System.getenv("DIARY_DIR");
        // 환경 변수가 설정되지 않았으면 기본 경로 사용
        return (diaryPath != null && !diaryPath.isEmpty()) ? diaryPath : DEFAULT_DIARY_DIR;
    }
}
