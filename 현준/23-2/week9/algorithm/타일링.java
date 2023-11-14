import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static BufferedReader reader;
    private static BufferedWriter writer;

    public static void main(String[] args) throws IOException {
        /*
        1 -> 2 -> 3 -> ... -> 55인 것을 보며
        1 -> 2 -> 3 -> (2 + 3 = 5) -> (3 + 5 = 8) -> (5 + 8 = 13) -> (8 + 13 = 21) -> (13 + 21 = 34) -> (21 + 34 = 55)
        라는 규칙을 찾아낼 수 있었습니다.
         */
        init();
        int N = Integer.parseInt(reader.readLine());
        int[] numbers = new int[N + 1];
        numbers[1] = 1;
        if (N >= 2) {
            numbers[2] = 2;
        }
        for (int i = 3; i <= N; i++) {
            numbers[i] = (numbers[i - 1] + numbers[i - 2]) % 10_007;
        }
        writer.write(numbers[N] + "");
        close();
    }

    public static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        reader.close();
        writer.close();
    }
}
