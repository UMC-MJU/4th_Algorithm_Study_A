import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수 {

    // 24.04.02 (화)

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine()); // 1 <= N <= 90

        long[] numbers = new long[90 + 1]; // 범위 때문에 틀렸었다. (int로 하면 범위 초과)
        numbers[1] = 1;
        numbers[2] = 1;
        for (int i = 3; i <= 90; i++) { // 피보나치 구조인 것은 쉽게 파악하였다. 다만, 카테고리가 DP였던 것은 미리 보면 안 될것 같다.
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }

        System.out.print(numbers[N]);
        reader.close();
    }
}
