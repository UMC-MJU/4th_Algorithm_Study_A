// 스터디 1주차
import java.io.*;
import java.util.*;
public class Main {

    static int result = 0; // 각 사이클 마다 활용될 결괏값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 사이클 반복 횟수 입력
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄 받아서

            int MAX_X = Integer.parseInt(st.nextToken()); // 가로
            int MAX_Y = Integer.parseInt(st.nextToken()); // 세로
            int K = Integer.parseInt(st.nextToken()); // 배추의 갯수 입력받음

            int[][] map = new int[MAX_Y][MAX_X]; // 지도 크기
            int[][] visited = new int[MAX_Y][MAX_X]; // 방문 여부 배열

            for (int j = 0; j < K; j++) { // 배추 위치 설정
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            for (int j = 0; j < MAX_Y; j++) {
                for (int k = 0; k < MAX_X; k++) {
                    if (map[j][k] == 0 || visited[j][k] != 0) // 배추가 아니거나 방문한 값이라면 스킵
                        continue;
                    dfs(map, visited, MAX_Y, MAX_X, j, k); // DFS 로직 수행
                    result++; // 배추 구역 확인했으므로 1씩 증가
                }
            }
            bw.write(result + "\n"); // 결과 출력
            result = 0;
        }
        bw.close();
        br.close();
    }

    public static void dfs(int[][] map, int[][] visited, int MAX_Y, int MAX_X, int y, int x) {
        // 좌표가 이상하거나 배추가 아니거나 방문했다면 종료
        if (x < 0 || x >= MAX_X || y < 0 || y >= MAX_Y || map[y][x] == 0 || visited[y][x] == 1)
            return;
        visited[y][x] = 1; // 방문 처리
        // 상
        dfs(map, visited, MAX_Y, MAX_X, y - 1, x);
        // 하
        dfs(map, visited, MAX_Y, MAX_X, y + 1, x);
        // 좌
        dfs(map, visited, MAX_Y, MAX_X, y, x - 1);
        // 우
        dfs(map, visited, MAX_Y, MAX_X, y, x + 1);
    }
}