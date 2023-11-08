package graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 안전_영역 {

    private static final int DIRECTION = 4;

    private static int[] DY = {-1, 1, 0, 0};
    private static int[] DX = {0, 0, -1, 1};
    private static BufferedReader reader;
    private static BufferedWriter writer;
    private static int N;
    private static int[][] map;
    private static boolean[][] flooded;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        init(); // reader, writer 설정

        int maxCount = Integer.MIN_VALUE; // 최종 값
        int maxDepth = Integer.MIN_VALUE; // 실행할 최대 높이

        initStatus(); // N, map, flooded, visited 초기 설정
        maxDepth = saveMapStatusAndUpdateMaxDepth(maxDepth); // 지도 정보 설정 및 실행할 최대 높이 갱신

        for (int i = 0; i <= maxDepth; i++) {
            maxCount = eachFloodAndUpdateMaxCount(i, maxCount); // 각 높이에 따라 flood and 남은 것 계산 갱신
        }
        writer.write(maxCount + "");

        close();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    // N, map, flooded, visited 초기화
    private static void initStatus() throws IOException {
        N = Integer.parseInt(reader.readLine());
        map = new int[N][N];
        flooded = new boolean[N][N];
        visited = new boolean[N][N];
    }

    // map 정보 적용 및 maxDepth 갱산
    private static int saveMapStatusAndUpdateMaxDepth(int maxDepth) throws IOException {
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxDepth = Math.max(maxDepth, map[i][j]);
            }
        }
        return maxDepth;
    }

    // depth만큼 flood and maxCount 갱신
    private static int eachFloodAndUpdateMaxCount(final int depth, int maxCount) {
        flood(depth);
        int temp = 0;
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                if (!flooded[j][k] && !visited[j][k]) {
                    temp += dfs(j, k);
                }
            }
        }
        clearTwoDimensionArray(visited);
        maxCount = Math.max(maxCount, temp);
        return maxCount;
    }

    // flooded 되지 않고 visited 되지 않은 경우만 visited 처리
    private static int dfs(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < DIRECTION; i++) {
            int ny = y + DY[i];
            int nx = x + DX[i];
            if (ny >= N || nx >= N || ny < 0 || nx < 0 || flooded[ny][nx] || visited[ny][nx]) {
                continue;
            }
            visited[ny][nx] = true;
            dfs(ny, nx);
        }
        return 1;
    }

    // flooded, visited 초기화 함수
    private static void clearTwoDimensionArray(final boolean[][] visited) {
        for (int j = 0; j < N; j++) {
            Arrays.fill(visited[j], false);
        }
    }

    // depth만큼 flood
    private static void flood(int depth) {
        clearTwoDimensionArray(flooded);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] <= depth) {
                    flooded[i][j] = true;
                }
            }
        }
    }

    private static void close() throws IOException {
        reader.close();
        writer.close();
    }
}
