import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 로프 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine()); // 1 <= N <= 100,000
        int[] ropes = new int[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(ropes);
        int result = 0;
        for (int i = N - 1; i >= 0; i--) {
            int select = N - i;
            result = Math.max(result, ropes[i] * select);
        }
        writer.write(result + "");
        writer.close();
        reader.close();
    }
}
