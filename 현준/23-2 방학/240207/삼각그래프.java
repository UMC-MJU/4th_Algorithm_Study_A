import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 삼각그래프 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int WIDTH = 3;
        int BREAK_NUMBER = 0;
        int MID = 1;
        int level = 1;
        while (true) {
            int N = Integer.parseInt(reader.readLine()); // 2 <= N <= 100,000
            if (N == BREAK_NUMBER) {
                break;
            }
            long[][] map = new long[N][WIDTH];
            long[][] cost = new long[N][WIDTH];
            for (int i = 0; i < N; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < WIDTH; j++) {
                    map[i][j] = Integer.parseInt(tokenizer.nextToken());
                    cost[i][j] = map[i][j];
                }
            }
            cost[0][0] = Integer.MAX_VALUE;
            cost[0][2] = Integer.MAX_VALUE;
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    if (j == 0) {
                        cost[i][j] += Math.min(cost[i - 1][j], Math.min(cost[i - 1][j + 1], cost[i - 1][j] + cost[i - 1][j + 1]));
                    } else if (j == 1) {
                        cost[i][j] += Math.min(cost[i - 1][j - 1],
                                Math.min(cost[i - 1][j - 1] + cost[i - 1][j],
                                        Math.min(cost[i - 1][j],
                                                Math.min(cost[i - 1][j - 1] + cost[i - 1][j] + cost[i - 1][j + 1],
                                                        Math.min(cost[i - 1][j] + cost[i - 1][j + 1], cost[i - 1][j + 1])))));
                        cost[i][j] = Math.min(cost[i][j], cost[i][j - 1] + map[i][j]);
                    } else {
                        cost[i][j] += Math.min(cost[i - 1][j - 2] + cost[i - 1][j - 1],
                                Math.min(cost[i - 1][j - 2] + cost[i - 1][j - 1] + cost[i - 1][j],
                                        Math.min(cost[i - 1][j - 1],
                                                Math.min(cost[i - 1][j], cost[i - 1][j - 1] + cost[i - 1][j]))));
                        cost[i][j] = Math.min(cost[i][j],
                                Math.min(cost[i][j - 2] + cost[i][j - 1] + map[i][j], cost[i][j - 1] + map[i][j]));
                    }
                }
            }
            writer.write(level + ". " + cost[N - 1][MID] + "\n");
            level++;
        }
        writer.close();
        reader.close();
    }
}
