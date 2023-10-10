import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 섬의개수 {

    private static final int DIRECTION = 8; // 방향 가짓수 상수화
    private static final int[] DY = {-1, -1, 0, 1, 1, 1, 0, -1}; // dy 상수화
    private static final int[] DX = {0, 1, 1, 1, 0, -1, -1, -1}; // dx 상수화
    private static final int LAND = 1; // 섬 매직 넘버 상수화
    private static final int SEA = 0; // 바다 매직 넘버 상수화
    private static final int END = 0; // 종료 입력 매직 넘버 상수화

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int weight;
    private static int height;
    private static int result;

    public static void main(String[] args) throws IOException {
        init();
        while (true) {
            st = new StringTokenizer(br.readLine());
            saveWeightAndHeight(); // 입력값 저장
            if (isEndCommand()) { // 종료 조건이면 탈출
                close();
                return;
            }
            initArray(); // 매번 배열 초기화
            initVisited(); // 매번 visited 초기화
            initResult(); // 매번 result 초기화
            storeGraphInfo(); // 그래프 정보 저장
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < weight; x++) {
                    if (!visited[y][x] && isLand(y, x)) { // 만나지 않았고 섬이라면 dfs 수행 및 result++
                        dfs(y, x);
                        result++;
                    }
                }
            }
            System.out.println(result); // 매번 result 출력
        }
    }

    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void saveWeightAndHeight() {
        weight = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
    }

    private static void initArray() {
        graph = new int[height][weight];
    }

    private static void initVisited() {
        visited = new boolean[height][weight];
    }

    private static void initResult() {
        result = 0;
    }

    private static boolean isEndCommand() {
        return weight == END && height == END;
    }

    private static void storeGraphInfo() throws IOException {
        for (int y = 0; y < height; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < weight; x++) {
                graph[y][x] = Integer.parseInt(st.nextToken());
            }
        }
    }

    // DFS 로직
    private static void dfs(final int y, final int x) {
        if (!isValidLocation(y, x) || visited[y][x] && !isLand(y, x)) {
            return;
        }
        visited[y][x] = true;
        for (int direction = 0; direction < DIRECTION; direction++) {
            int ny = y + DY[direction];
            int nx = x + DX[direction];
            if (!isValidLocation(ny, nx) || visited[ny][nx] || !isLand(ny, nx)) {
                continue;
            }
            dfs(ny, nx);
        }
    }

    private static boolean isValidLocation(final int y, final int x) { // 위치 검증
        return y >= 0 && y < height && x >= 0 && x < weight;
    }

    private static boolean isLand(final int y, final int x) { // 섬인지 판단
        return graph[y][x] == LAND;
    }

    private static void close() throws IOException {
        bw.close();
        br.close();
    }
}
