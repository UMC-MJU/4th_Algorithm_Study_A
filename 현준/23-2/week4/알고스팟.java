package graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 알고스팟 {

    // 내부 클래스 선언
    private static class Node {
        private int y;
        private int x;
        private int cost;

        public Node(final int y, final int x, final int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(final int cost) {
            this.cost = cost;
        }
    }

    private static final int DIRECTION = 4;

    private static final int WALL = 1;
    private static final int ROAD = 0;
    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int MAX_Y;
    private static int MAX_X;
    private static int[][] map;
    private static int[][] answer;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        MAX_X = Integer.parseInt(st.nextToken());
        MAX_Y = Integer.parseInt(st.nextToken());
        map = new int[MAX_Y][MAX_X];
        answer = new int[MAX_Y][MAX_X];
        // 정보 저장
        for (int i = 0; i < MAX_Y; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < MAX_X; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }
        for (int i = 0; i < MAX_Y; i++) {
            Arrays.fill(answer[i], 123456789); // 임의의 큰 수를 answer에 각각 저장해둡니다
        }
        answer[0][0] = map[0][0]; // 기본 시작값은 map[0][0]을 따르도록 합니다
        bfs(0, 0); // BFS 실행
        bw.write(answer[MAX_Y - 1][MAX_X - 1] + ""); // 답 출력
        close();
    }

    public static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    // BFS 실행
    // 주의할 점은, 미로 탐색과 비슷한 유형이지만 visited를 쓰면 안 된다는 점입니다. 값이 갱신될 경우가 있기 때문입니다.
    private static void bfs(int y, int x) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(y, x, 0));
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            for (int direction = 0; direction < DIRECTION; direction++) {
                int ny = node.getY() + dy[direction];
                int nx = node.getX() + dx[direction];
                if (ny < 0 || ny >= MAX_Y || nx < 0 || nx >= MAX_X) {
                    continue;
                }
                int cost = map[ny][nx] + node.getCost();
                if (cost < answer[ny][nx]) {
                    // 따라서 스택오버플로우를 막기 위해, 값이 갱신될 때만 큐에 넣는 식으로 하였습니다.
                    answer[ny][nx] = cost;
                    queue.addLast(new Node(ny, nx, cost));
                }
            }
        }
    }

    public static void close() throws IOException {
        bw.close();
        br.close();
    }
}
