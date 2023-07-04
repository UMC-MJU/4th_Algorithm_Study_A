// 스터디 1주차
import java.io.*;
import java.util.*;
public class Main {

    static HashMap<String, Integer> dict = new HashMap<>(); // 결과값을 담을 Map 형태 (W의 갯수, B의 갯수)
    static int temp = 0; // 모여진 집합의 원소를 셀 때 필요한 임시 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // dict 초기 설정
        dict.put("W", 0);
        dict.put("B", 0);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int MAX_X = Integer.parseInt(st.nextToken()); // 가로
        int MAX_Y = Integer.parseInt(st.nextToken()); // 세로
        String[][] map = new String[MAX_Y][MAX_X]; // 지도 크기
        int[][] checked = new int[MAX_Y][MAX_X]; // 확인 여부 배열

        // 입력값을 지도에 반영
        for (int i = 0; i < MAX_Y; i++) {
            map[i] = br.readLine().split("");
        }

        for (int i = 0; i < MAX_Y; i++) {
            for (int j = 0; j < MAX_X; j++) {
                if (checked[i][j] == 0) { // 확인되지 않았을 경우에만 DFS
                    dfs(map, checked, MAX_X, MAX_Y, j, i, map[i][j]);
                    dict.put(map[i][j], dict.get(map[i][j]) + (temp * temp)); // 각 값 (W, B)에는 temp의 제곱씩 추가됨
                    temp = 0; // temp 재활용하기 위해 다시 0으로
                }
            }
        }

        bw.write(dict.get("W") + " " + dict.get("B")); // 자신의 팀 (W)의 값과 적군 (B)의 값을 출력
        bw.close();
        br.close();
    }

    public static void dfs(String[][] map, int[][] checked, int MAX_X, int MAX_Y,
                           int x, int y, String person) {
        // W인데 B를 만나거나 B인데 W를 만나면 종료
        if (x < 0 || x >= MAX_X || y < 0 || y >= MAX_Y || checked[y][x] == 1 || !map[y][x].equals(person))
            return;
        checked[y][x] = 1; // 확인
        temp += 1; // 카운트
        // 상
        dfs(map, checked, MAX_X, MAX_Y, x, y - 1, person);
        // 하
        dfs(map, checked, MAX_X, MAX_Y, x, y + 1, person);
        // 좌
        dfs(map, checked, MAX_X, MAX_Y, x - 1, y, person);
        // 우
        dfs(map, checked, MAX_X, MAX_Y, x + 1, y, person);
    }
}