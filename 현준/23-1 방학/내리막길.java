import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int[] rx = new int[] {0, 0, -1, 1}; // 방향
    private static int[] ry = new int[] {-1, 1, 0, 0}; // 방향
    private static class Node { // 다익스트라에서 쓰이는 노드 클래스
        int row;
        int column;

        public Node(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    private static StringTokenizer st;
    private static int[][] map;
    private static int[][] cnt;
    private static int MAX_X;
    private static int MAX_Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        cnt = new int[M][N];
        MAX_Y = M;
        MAX_X = N;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                cnt[i][j] = -1;
            }
        }
        cnt[MAX_Y - 1][MAX_X - 1] = 1;
        dfs(new Node(0, 0));
        bw.write(cnt[0][0] + "");
        bw.close();
        br.close();
    }

    private static int dfs(Node now) {
        if (cnt[now.row][now.column] > -1)
            return cnt[now.row][now.column];

        cnt[now.row][now.column] = 0;

        for (int i = 0; i < 4; i++) {
            int nr = now.row + ry[i];
            int nc = now.column + rx[i];
            if (nr < 0 || nc < 0 || nr >= MAX_Y || nc >= MAX_X)
                continue;
            if (map[now.row][now.column] > map[nr][nc])
                cnt[now.row][now.column] += dfs(new Node(nr, nc));
        }
        return cnt[now.row][now.column];
    }
}