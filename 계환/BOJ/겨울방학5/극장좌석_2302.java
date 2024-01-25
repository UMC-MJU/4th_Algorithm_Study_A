package BOJ.겨울방학5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 극장좌석_2302 {

    static long answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 좌석의 개수
        int M = Integer.parseInt(br.readLine()); // 고정석의 개수
        long[] dp = new long[N + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 고정석을 기준으로 리스트를 쪼개서 각자 계산한 후에 곱하기 연산
        int compare = 0;
        for (int i = 0; i < M; i++) {
            int vip = Integer.parseInt(br.readLine());
            int count = vip - compare - 1;
            answer *= dp[count];
            compare = vip;
        }

        answer *= dp[N - compare];

        System.out.println(answer);
    }
}
