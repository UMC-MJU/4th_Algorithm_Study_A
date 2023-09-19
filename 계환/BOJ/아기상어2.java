package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어2 {

    static int N, M, sea[][], answer;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 한 줄 읽고 하나씩 저장.
        st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 그래프 2차원 배열
        sea = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int tmp = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(sea[i][j] == 1){
                    continue;
                }
                tmp = BFS(i, j);
                answer = Math.max(tmp, answer);
            }
        }
        System.out.println(answer);
    }

    static int BFS(int x, int y) {
        boolean visit[][] = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<int[]>();

        queue.add(new int[]{x, y, 0});
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            int now[] = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int val = now[2];

                // 그래프 밖으로 나가는 경우 제외
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                // 이미 방문한 경우 제외
                if (visit[nx][ny]) continue;
                if (sea[nx][ny] == 1) {
                    return val + 1;
                }
                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny, val + 1});
            }
        }
        return 0;
    }
}
