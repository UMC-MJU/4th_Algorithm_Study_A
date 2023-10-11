package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 섬의개수 {

    private static BufferedReader reader;
    private static BufferedWriter writer;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] graph;
    static int w, h = 0;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(reader.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        while (w != 0 && h != 0) {
            graph = new int[h][w];
            int islandCount = 0;
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(reader.readLine());
                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (graph[i][j] == 1) {
                        BFS(i, j);
                        islandCount++;  // 섬 개수 count
                    }
                }
            }

            writer.write(islandCount + "\n");
            writer.flush();

            st = new StringTokenizer(reader.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }
        close();
    }

    static void BFS(int x, int y) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        graph[x][y] = 0;  // 값을 0으로 바꿔서(섬을 지운다) 방문 처리를 한다.

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;

                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = 0;  // 값을 0으로 바꿔서(섬을 지운다) 방문 처리를 한다.
                    queue.offer(new Node(nx, ny));
                }
            }
        }
    }

    public static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        reader.close();
        writer.close();
    }
}
