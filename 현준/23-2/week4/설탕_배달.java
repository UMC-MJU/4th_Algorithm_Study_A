package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 설탕_배달 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int[] dp;
    private static int N;

    public static void main(String[] args) throws IOException {
        init();
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1]; // 편리하게 조회하기 위해 + 1
        Arrays.fill(dp, -1); // 정확하게 만들 수 없으면 -1을 출력하므로 기본적으로 -1 채움
        dp[3] = 1; // N의 최소는 3, 3을 만드려면 3 x 1
        if (N >= 5) { // N이 5보다 크거나 같을 때만 적용
            dp[5] = 1; // 5를 만드려면 5 x 1
        }

        /*
        진짜 운좋게 얻어진 점화식 같습니다.
        dp[3] = 1
        dp[4] = -1
        dp[5] = 1
        dp[6] = 3x2 = 2
        dp[7] = -1
        dp[8] = 5x1 + 3x1 = 2
        dp[9] = 3x3 = 3 -> 첫 번째 케이스
        dp[10] = 5x2 = 2 -> 두 번째 케이스
        dp[11] = 5x1 + 3x2 = 3
        dp[12] = 3x4 = 4
        dp[13] = 5x2 + 3x3 = 3 -> 마지막 케이스
        위와 같은 규칙을 봤을 때, 뭔가 3번째 이전의 값과 5번째 이전의 값을 알고 나면 점화식을 구할 수 있겠다는 생각이 들었습니다.
        dp[n]을 구할 때, dp[n - 3]이 -1이 아니고 dp[n - 5]가 -1이라면 dp[n]은 dp[n - 3] + 1이 됩니다.
        ex: dp[9]는 dp[6]이 -1이 아니고 dp[4]가 -1이기 때문에, dp[6] + 1 = 3을 하였습니다.

        그리고 만약 dp[n - 3]이 -1이고 dp[n - 5]가 -1이 아닐 경우에는, 반대로 dp[n] = dp[n - 5] + 1로 하였으며
        dp[n - 3], dp[n - 5]가 모두 -1이 아닐 경우에는 둘 중에 더 작은 값 + 1로 하는 식으로 하였습니다.
        */

        for (int i = 6; i <= N; i++) {
            if (dp[i - 3] != -1 && dp[i - 5] == -1) {
                dp[i] = dp[i - 3] + 1;
            } else if (dp[i - 3] == -1 && dp[i - 5] != -1){
                dp[i] = dp[i - 5] + 1;
            } else if (dp[i - 3] != -1 && dp[i - 5] != -1) {
                dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
            }
        }
        bw.write(dp[N] + "");
        close();
    }

    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void close() throws IOException {
        bw.close();
        br.close();
    }
}
