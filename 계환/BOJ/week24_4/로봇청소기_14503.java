package BOJ.week24_4;

import java.io.*;
import java.util.*;

public class 로봇청소기_14503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 값 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] room = new int[N][M];
        boolean isStop = false;
        boolean backToOne = false;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 현재 위치를 청소한다.
        room[r][c] = 2;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!isStop) {
            backToOne = false;
            for (int i = 0; i < 4; i++) {
                int nx = r + dx[i];
                int ny = c + dy[i];
                // 상하좌우 청소되지 않은 빈칸이 있으면
                if (room[nx][ny] == 0) {
                    // 반시계 방향으로 90도 회전
                    d -= 1;
                    if (d == -1) {
                        d = 3;
                    }
                    // 전진 방향이 청소되지 않았으면 전진
                    nx = r + dx[d];
                    ny = c + dy[d];
                    if (room[nx][ny] == 0) {
                        r = nx;
                        c = ny;
                        room[r][c] = 2;
                    }
                    backToOne = true;
                    break;
                }
            }
            if (!backToOne) {
                // 상하좌우 모두 청소되었거나 벽이면
                // 후진할 수 있으면 후진
                // 일단 후진 방향 구해야함. 후진 방향으로 차를 돌리는 것이 아님! 임시 좌표로 구해야함.
                int tempBackDirection = d;
                if (d < 2) {
                    tempBackDirection += 2;
                } else {
                    tempBackDirection -= 2;
                }
                int nx = r + dx[tempBackDirection];
                int ny = c + dy[tempBackDirection];
                if (room[nx][ny] != 1) {
                    r = nx;
                    c = ny;
                    room[r][c] = 2;
                } else { // 후진할 수 없으면 작동을 멈춘다.
                    isStop = true;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (room[i][j] == 2) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
