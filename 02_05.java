import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ComprehensiveExample {

    public static void main(String[] args) {
        ComprehensiveExample example = new ComprehensiveExample();
        String filename = "example.txt";

        try {
            example.writeFile(filename, "Hello, World!");
            example.readFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("프로그램 종료");
        }

        // 환경변수 읽기
        String path = System.getenv("PATH");
        System.out.println("PATH: " + path);
    }

    public void readFile(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // 파일 읽기 중 발생한 예외 처리
            System.err.println("파일 읽기 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public void writeFile(String filename, String content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(content);
        } catch (IOException e) {
            // 파일 쓰기 중 발생한 예외 처리
            System.err.println("파일 쓰기 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}