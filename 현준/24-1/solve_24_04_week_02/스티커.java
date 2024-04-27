import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 스티커 {

    // 24.04.10 (수)
    // DP 문제임은 파악했으나, 점화식을 떠올리지 못했다.
    // https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-9465-%EC%8A%A4%ED%8B%B0%EC%BB%A4-JAVA를 참고했다.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(reader.readLine());
            int[][] numbers = new int[2][N + 1];
            int[][] dp = new int[2][N + 1]; // 처음에는 선택한 인덱스를 저장하려고 했다. 그러나 점화식 계산을 보면 구체적인 값을 넣는 경우가 더 많아 보인다.

            // 입력 처리
            for (int j = 0; j < 2; j++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int k = 1; k <= N; k++) {
                    numbers[j][k] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            // 초깃값
            dp[0][1] = numbers[0][1]; // 위의 값을 선택한 경우
            dp[1][1] = numbers[1][1]; // 아래의 값을 선택한 경우

            // 점화식
            for (int j = 2; j <= N; j++) {
                // 서로 다른 상, 하를 선택한 1 전의 dp와 같은 상, 하를 선택한 2 전의 dp를 비교한 뒤, 위치의 인덱스를 비교..
                /*
                50 10 100
                30 50 70
                (50 + 50 + 100) vs (30 + 10 + 70)
                 */
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + numbers[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + numbers[1][j];
            }

            writer.write(Math.max(dp[0][N], dp[1][N]) + "\n"); // 위에서부터 선택한 경우 vs 아래에서부터 선택한 경우의 최종 값 비교
        }

        writer.close();
        reader.close();
    }
}
