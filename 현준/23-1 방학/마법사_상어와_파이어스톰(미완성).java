import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int MAX_X;
    private static int MAX_Y;
    private static int[][] map;
    private static int largest;
    private static int temp;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        MAX_X = (int) Math.pow(2, N);
        MAX_Y = (int) Math.pow(2, N);
        largest = 0;
        visited = new boolean[MAX_Y][MAX_X];
        int Q = Integer.parseInt(st.nextToken());
        map = new int[MAX_Y][MAX_X];
        int[] level = new int[Q];

        // 얼음 정보 저장
        for (int i = 0; i < MAX_Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < MAX_X; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }

        // Q번 만큼 firestorm 진행
        for (int i = 0; i < Q; i++) {
            firestorm(level[i]);
        }

        // 남은 얼음의 총합 구하기
        bw.write(getSum() + "\n");

        // 가장 큰 덩어리 구하기
        for (int i = 0; i < MAX_Y; i++) {
            for (int j = 0; j < MAX_X; j++) {
                if (!visited[i][j]) {
                    temp = 0;
                    dfs(i, j);
                    largest = Math.max(temp, largest);
                }
            }
        }

        // 가장 큰 덩어리의 칸 갯수 출력
        bw.write(largest + "");
        bw.close();
        br.close();
    }

    private static void firestorm(int level) {
        // 처음에는 각 행과 열이 2^N으로 설정되어 있다.
        // 잘려진 부분 격자의 행과 열은 2^level 만큼
        int each_size = (int) Math.pow(2, level) * (int) Math.pow(2, level);
        // System.out.println("각 잘려진 격자의 크기 = " + each_size);

        // 잘려진 부분 격자의 갯수는 2^{2N} / 2^{2level} 만큼
        int squares = MAX_X * MAX_Y / ((int) Math.pow(2, level) * (int) Math.pow(2, level));
        // System.out.println("각 잘려진 격자의 총 갯수 = " + squares);

        // 감소해야 하는지 판단 -> reduce 함수 활용

        // 첫 격자를 보면
        // [0][0], [0][1], [1][0], [1][1]
        // 두 번째 격자를 보면
        // [0][2], [0][3], [1][2], [1][3]
    }

    // 얼음 감소 함수
    private static void reduce(int x, int y) {
        // 얼음이 아니면 패스
        if (map[y][x] == 0)
            return;
        int count = 0;
        // 상 검사
        if (y - 1 > 0 && map[y - 1][x] > 0)
            count++;
        // 하 검사
        if (y + 1 < MAX_Y && map[y + 1][x] > 0)
            count++;
        // 좌 검사
        if (x - 1 > 0 && map[y][x - 1] > 0)
            count++;
        // 우 검사
        if (x + 1 < MAX_X && map[y][x + 1] > 0)
            count++;

        // 얼음 감소 기준: 자신과 인접한 얼음 갯수가 3개 이하일 때 진행
        if (count <= 3)
            map[y][x] -= 1;
    }

    // map의 합 출력 함수
    private static int getSum() {
        int sum = 0;
        for (int i = 0; i < MAX_Y; i++) {
            for (int j = 0; j < MAX_X; j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }

    // 가장 큰 덩어리의 갯수를 파악하기 위한 DFS 로직
    private static void dfs(int y, int x) {
        if (y >= MAX_Y || y < 0 || x >= MAX_X || x < 0 || visited[y][x] || map[y][x] == 0)
            return;
        visited[y][x] = true;
        temp++;
        // 상
        dfs(y - 1, x);
        // 하
        dfs(y + 1, x);
        // 좌
        dfs(y, x - 1);
        // 우
        dfs(y, x + 1);
    }

    private static void devide(int level) {
    }
    private static void turnRight(int level) {
    }
}