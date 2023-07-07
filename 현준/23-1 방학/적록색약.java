// 스터디 1주차
import java.io.*;
import java.util.*;
public class Main {

    static HashMap<String, Integer> dict = new HashMap<>(); // 결과값을 담을 Map 형태 (R의 갯수, G의 갯수, B의 갯수, RG의 갯수)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // N 입력
        String[][] map = new String[N][N]; // 지도 사이즈는 N x N
        int[][] visited = new int[N][N]; // 방문 여부 사이즈도 N x N

        // 입력받은 값을 지도에 반영
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }

        // dict 초기 설정
        dict.put("R", 0);
        dict.put("G", 0);
        dict.put("B", 0);
        dict.put("RG", 0);

        // 적록색약이 아닌 사람의 경우에는 R, G, B에 따라 모여있는 갯수를 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    dfs(map, map[i][j], N, N, i, j, visited);
                    dict.put(map[i][j], dict.get(map[i][j]) + 1);
                }
            }
        }

        visited = new int[N][N];

        // 적록색약 환자 (이미 B의 갯수는 구했으므로 패스)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0 && !map[i][j].equals("B")) {
                    odd_dfs(map, N, N, i, j, visited);
                    dict.put("RG", dict.get("RG") + 1);
                }
            }
        }

        // 적록색약이 아닌 사람과 적록색약인 사람에 따라 값 출력
        bw.write(dict.get("R") + dict.get("G") + dict.get("B") + " " + (dict.get("RG") + dict.get("B")));
        bw.close();
        br.close();
    }
    // 적록색약이 아닌 사람의 경우 현재 좌표값과 마주친 좌표값의 문자열이 서로 일치하지 않는지 검사해야 함
    public static void dfs(String[][] map, String target, int MAX_Y, int MAX_X, int y, int x, int[][] visited) {
        if (x < 0 || x >= MAX_X || y < 0 || y >= MAX_Y || !map[y][x].equals(target) || visited[y][x] == 1)
            return;
        visited[y][x] = 1;
        // 상
        dfs(map, target, MAX_Y, MAX_X, y - 1, x, visited);
        // 하
        dfs(map, target, MAX_Y, MAX_X, y + 1, x, visited);
        // 좌
        dfs(map, target, MAX_Y, MAX_X, y, x - 1, visited);
        // 우
        dfs(map, target, MAX_Y, MAX_X, y, x + 1, visited);
    }
    // 적록색약인 사람은 R과 G를 같게 인식하기 때문에 B와 같은지에 따라만 구분하면 됨
    public static void odd_dfs(String[][] map, int MAX_Y, int MAX_X, int y, int x, int[][] visited) {
        if (x < 0 || x >= MAX_X || y < 0 || y >= MAX_Y || visited[y][x] == 1 || map[y][x].equals("B"))
            return;
        visited[y][x] = 1;
        // 상
        odd_dfs(map, MAX_Y, MAX_X, y - 1, x, visited);
        // 하
        odd_dfs(map, MAX_Y, MAX_X, y + 1, x, visited);
        // 좌
        odd_dfs(map, MAX_Y, MAX_X, y, x - 1, visited);
        // 우
        odd_dfs(map, MAX_Y, MAX_X, y, x + 1, visited);
    }
}