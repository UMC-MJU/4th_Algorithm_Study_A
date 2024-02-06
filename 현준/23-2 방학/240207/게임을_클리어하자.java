import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 게임을_클리어하자 {

    private static int[][] weapons;
    private static int[][] dp;
    private static int result;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        weapons = new int[N][M];
        dp = new int[N][M];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                weapons[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            dp[0][i] = weapons[0][i];
        }

        // dp[i][j] = weapons[i][j] + min(dp[i - 1][0], dp[i - 1][1], ..., dp[i - 1][M])

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < M; k++) {
                    if (j == k) {
                        continue;
                    }
                    min = Math.min(min, dp[i - 1][k]);
                }
                dp[i][j] = weapons[i][j] + min;
            }
        }

        for (int i = 0; i < M; i++) {
            result = Math.min(result, dp[N - 1][i]);
        }

        writer.write(result + "");
        writer.close();
        reader.close();
    }
}
