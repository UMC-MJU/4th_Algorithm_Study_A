import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 나이트의_이동 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            int size = Integer.parseInt(reader.readLine());
            int[][] map = new int[size][size];
            int[][] cost = new int[size][size];
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int y = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());
            tokenizer = new StringTokenizer(reader.readLine());
            int targetY = Integer.parseInt(tokenizer.nextToken());
            int targetX = Integer.parseInt(tokenizer.nextToken());
            map[targetY][targetX] = 1;
            bfs(map, cost, y, x);
            writer.write(cost[targetY][targetX] + "\n");
        }
        writer.close();
        reader.close();
    }

    private static void bfs(int[][] map, int[][] cost, int y, int x) {
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};

        ArrayDeque<Integer> xQueue = new ArrayDeque<>();
        ArrayDeque<Integer> yQueue = new ArrayDeque<>();
        yQueue.addLast(y);
        xQueue.addLast(x);

        while (!yQueue.isEmpty() && !xQueue.isEmpty()) {
            int currY = yQueue.pollFirst();
            int currX = xQueue.pollFirst();
            if (map[currY][currX] == 1) {
                break;
            }
            for (int i = 0; i < 8; i++) {
                int ny = currY + dy[i];
                int nx = currX + dx[i];
                if (ny < 0 || nx < 0 || ny >= map.length || nx >= map.length || cost[ny][nx] != 0) {
                    continue;
                }
                cost[ny][nx] = cost[currY][currX] + 1;
                yQueue.addLast(ny);
                xQueue.addLast(nx);
            }
        }
    }
}
