package Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class q4963_섬의개수 {
    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}; // 대각선 요소 추가
    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    static class Point{
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) return;

            int[][] board = new int[h][w];
            boolean[][] vis = new boolean[h][w];

            for(boolean[] row : vis) Arrays.fill(row, false); // vis false로 채우기

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //BFS
            Queue<Point> q = new ArrayDeque<>();
            int res = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(vis[i][j]) continue;
                    if(board[i][j] == 1 && !vis[i][j]) {
                        q.add(new Point(j, i));
                        vis[i][j] = true;
                        res++; // 새로운 원소를 추가한다는 것은 새로운 영역을 탐지한 것이므로 res++
                    }
                    while (!q.isEmpty()) {
                        Point cur = q.poll();
                        for (int nxt = 0; nxt < 8; nxt++) {
                            int nx = cur.x + dx[nxt];
                            int ny = cur.y + dy[nxt];
                            if(nx < 0 || nx >= w || ny < 0 || ny >= h) continue;
                            if(vis[ny][nx] || board[ny][nx] == 0) continue;
                            q.add(new Point(nx, ny));
                            vis[ny][nx] = true;
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }
}