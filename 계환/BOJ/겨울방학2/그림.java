package BOJ.겨울방학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 그림 {
    public static int N;
    public static int M;
    public static int cnt, maxSize;
    public static int[][] graph;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    BFS(i, j);
                }
            }
        }
        System.out.println(cnt);
        System.out.println(maxSize);
    }

    public static void BFS(int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));
        int count = 0;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            count++;
            for (int d = 0; d < 4; d++) {
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (visited[nx][ny] || graph[nx][ny] == 0) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.add(new Node(nx, ny));
            }
        }
        cnt++;
        if (count > 1) count--;
        maxSize = Math.max(maxSize, count);
    }
}
