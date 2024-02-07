package BOJ.겨울방학7;

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

public class 나이트의이동_7562 {

    public static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int T; // 테스트 케이스
    public static int I; // 체스판 한 변의 길이
    public static Node start;
    public static Node end;
    public static boolean[][] visited;
    public static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) { // 케이스 수만큼
            I = Integer.parseInt(br.readLine());
            graph = new int[I][I];
            visited = new boolean[I][I];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int currentX = Integer.parseInt(st.nextToken());
            int currentY = Integer.parseInt(st.nextToken());
            start = new Node(currentX, currentY);

            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());
            end = new Node(targetX, targetY);

            bfs();
            System.out.println(graph[end.x][end.y]);
        }
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) { // 큐가 빌 때까지
            Node current = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && nx < I && ny >= 0 && ny < I) {
                    if (!visited[nx][ny]) { // 방문하지 않았으면
                        visited[nx][ny] = true; // 방문처리
                        graph[nx][ny] = graph[current.x][current.y] + 1;
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
        }
    }
}
