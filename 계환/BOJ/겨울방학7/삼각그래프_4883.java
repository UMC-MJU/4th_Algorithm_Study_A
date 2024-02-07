package BOJ.겨울방학7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삼각그래프_4883 {

    public static int N; //그래프 행의 개수
    public static int testId; // 테스트 케이스 번호 넘버링
    public static int[][] dp; // memoization

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (!(str = br.readLine()).equals("0")) { //입력의 마지막 줄에는 0이 하나 주어진다.
            N = Integer.parseInt(str);
            dp = new int[N][3];
            testId++; //테스트 케이스 번호 넘버링 +
            // 데이터 입력
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 1번 행 데이터 입력
            dp[1][0] += dp[0][1];
            dp[1][1] += Math.min(dp[1][0], Math.min(dp[0][1], (dp[0][1] + dp[0][2])));
            dp[1][2] += Math.min(dp[1][1], Math.min(dp[0][1], (dp[0][1] + dp[0][2])));
            // 2번 행부터 데이터 입력은 점화식 작성 가능
            for (int i = 2; i < N; i++) {
                dp[i][0] += Math.min(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] += Math.min(dp[i][0], Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])));
                dp[i][2] += Math.min(dp[i][1], Math.min(dp[i - 1][1], dp[i - 1][2]));
            }
            System.out.println(testId + ". " + dp[N - 1][1]);
        }
    }
}
