import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SimpleDiary {
    private static final String DEFAULT_DIARY_DIR = "diary_entries";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        SimpleDiary diary = new SimpleDiary();
        diary.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. 일기 쓰기");
            System.out.println("2. 일기 읽기");
            System.out.println("3. 종료");
            System.out.print("선택하세요: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    writeDiary(scanner);
                    break;
                case 2:
                    readDiary(scanner);
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }

    private void writeDiary(Scanner scanner) {
        LocalDate date = LocalDate.now();
        String fileName = date.format(DATE_FORMATTER) + ".txt";

        System.out.println("오늘의 일기를 작성하세요. 작성을 마치려면 빈 줄을 입력하세요:");
        StringBuilder content = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            content.append(line).append("\n");
        }

        try {
            String diaryPath = getDiaryPath();
            File diaryDir = new File(diaryPath);
            if (!diaryDir.exists() && !diaryDir.mkdirs()) {
                throw new IOException("디렉토리 생성 실패: " + diaryPath);
            }

            File diaryFile = new File(diaryDir, fileName);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(diaryFile))) {
                writer.write(content.toString());
            }
            System.out.println("일기가 저장되었습니다.");
        } catch (IOException e) {
            System.err.println("일기 저장 중 오류 발생: " + e.getMessage());
        }
    }

    private void readDiary(Scanner scanner) {
        System.out.print("읽고 싶은 일기의 날짜를 입력하세요 (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();

        try {
            LocalDate date = LocalDate.parse(dateStr, DATE_FORMATTER);
            String fileName = date.format(DATE_FORMATTER) + ".txt";
            String diaryPath = getDiaryPath();
            File diaryFile = new File(diaryPath, fileName);

            if (!diaryFile.exists()) {
                System.out.println("해당 날짜의 일기가 없습니다.");
                return;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(diaryFile))) {
                String line;
                System.out.println("\n" + dateStr + "의 일기:");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("일기 읽기 중 오류 발생: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("잘못된 날짜 형식입니다. yyyy-MM-dd 형식으로 입력해주세요.");
        }
    }

    private String getDiaryPath() {
        String diaryPath = System.getenv("DIARY_DIR");
        return (diaryPath != null && !diaryPath.isEmpty()) ? diaryPath : DEFAULT_DIARY_DIR;
    }
}