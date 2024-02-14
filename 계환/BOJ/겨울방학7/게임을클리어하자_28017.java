package BOJ.겨울방학7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 게임을클리어하자_28017 {

    public static int N; // 게임 회차수
    public static int M; // 무기 종류
    public static int[][] dp; // 데이터 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N][M];
        // 데이터 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // dp
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int min = Integer.MAX_VALUE; // 10001로 했다가 틀림
                for (int k = 0; k < M; k++) {
                    if (j == k) continue; // 바로 이전과 같은 종류의 무기는 선택하지 않는다.
                    min = Math.min(min, dp[i - 1][k]); // 바로 윗줄에서 가장 효율이 효율이 좋은 무기를 선택해간다.
                }
                dp[i][j] += min;
            }
        }
        System.out.println(Arrays.stream(dp[N-1]).min().getAsInt());
    }
}
