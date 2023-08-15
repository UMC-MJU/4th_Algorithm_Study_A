import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static int[][] dp; // DP 배열

    public static void main(String[] args) throws IOException {

        init(); // 입출력 설정

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 갯수
        int maxWeight = Integer.parseInt(st.nextToken()); // 최대 무게

        dp = new int[N + 1][maxWeight + 1]; // N번째 maxWeight까지 저장될 수 있도록 DP 배열 생성

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken()); // 무게
            int value = Integer.parseInt(st.nextToken()); // 가치
            for (int j = 1; j <= maxWeight; j++) { // 무게가 1일 때 부터 maxWeight일 때 까지 최고 가치를 계산해서 저장합니다.
                if (weight > j) { // 만약 현재 시험해 볼 무게가 입력받은 무게보다 작다면 dp[i번째][무게 j]는 0입니다.
                    // 최대 무게가 예시로 3일 때 입력받은 무게가 5라면 담을 수 없기 때문입니다.
                    dp[i][j] = 0;
                    if (dp[i - 1][j] != 0) // 그러나 바로 자신 전 단계에 있는 해당 무게가 0이 아니라면, 그 값을 활용할 수 있습니다.
                        // 예시로 첫 번째에서는 무게가 3이고 가치가 6, 두 번째에서는 무게가 4고 가치가 8이라고 가정해보면
                        // arr[2][3]은 무게가 3일 때 값인데, 0이 아니라 최소한 6은 활용할 수 있기 때문입니다.
                        dp[i][j] = dp[i - 1][j];
                } else { // 만약 현재 시험해 볼 무게가 입력받은 무게보다 같거나 크다면 점화식을 이용해야 합니다.
                    // 첫 번째로, 이전에 저장된 값을 활용할 수 있을 것입니다. (dp[i - 1][j])
                    // 두 번째로는, 현재 무게를 더한 값과 해당 무게에서 본인의 무게를 뺀 이전 단계에서의 값을 더한 값을 활용할 수 있을 것입니다.
                    // 예시로, 첫 번째 무게가 3이고 가치가 6이며 두 번째 무게가 4이고 가치가 8일 때
                    // 최대 무게가 7이면 단순히 8이 아니라, 6 + 8 = 14가 될 것입니다.
                    // 즉, dp[i - 1]의 j - weight 번째는 무게가 3일 때 값인 6이 되며, value는 8이 되니 14가 되는 것입니다.
                    dp[i][j] = Math.max(dp[i - 1][j],   dp[i - 1][j - weight] + value);
                }
            }
        }

        bw.write(dp[N][maxWeight] + ""); // 결과적으로 N번째 maxWeight일 때의 값을 출력합니다.
        bw.close();
        br.close();
    }

    public static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
}