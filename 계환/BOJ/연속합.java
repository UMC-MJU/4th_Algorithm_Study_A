package BOJ.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());  // 정수의 개수
        int arr[] = new int[n];  // n 크기의 정수 배열 생성
        int dp[] = new int[n];   // dp 배열 생성 ex) dp[3] = arr[0] ~ arr[3]에서의 연속합 최댓값

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];  // dp[0]값은 이전 값과 비교할 수 없으므로 arr[0] 값으로 초기화한다.
        int max = dp[0]; // 최대값
        for (int i = 1; i < n; i++) {
            // (이전 dp값 + 현재값)과 현재값을 비교해서 큰 값을 dp배열에 넣는다.
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            // 최대값으로 최신화해준다.
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
