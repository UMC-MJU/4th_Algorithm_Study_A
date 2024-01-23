import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 파도반수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] numbers = new long[101];
        numbers[1] = 1L;
        numbers[2] = 1L;
        numbers[3] = 1L;

        int N;
        for(N = 4; N <= 100; ++N) {
            numbers[N] = numbers[N - 2] + numbers[N - 3];
        }

        N = Integer.parseInt(reader.readLine());

        for(int i = 0; i < N; ++i) {
            int number = Integer.parseInt(reader.readLine());
            writer.write(numbers[number] + "\n");
        }

        writer.close();
        reader.close();
    }
}
