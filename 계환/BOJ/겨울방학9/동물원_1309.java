package BOJ.겨울방학9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동물원_1309 {

    private static int N; //세로 칸 개수
    private static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new long[N + 1];
        dp[1] = 3;

        if (N >= 2) {
            dp[2] = 7;
            for (int i = 3; i <= N; i++) {
                // 왜 dp 에 넣을 때마다 9901로 나머지 연산을 해야하는지? 마지막에 하면 왜 오답?
                dp[i] = ((2 * dp[i - 1]) + dp[i - 2]) % 9901;
            }
        }

        System.out.println(dp[N]);
    }
}
