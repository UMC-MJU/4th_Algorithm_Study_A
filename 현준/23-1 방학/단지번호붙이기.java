// 스터디 1주차
import java.io.*;
import java.util.*;
public class Main {

    static ArrayList<Integer> dict = new ArrayList<>(); // 전체 결과를 담을 ArrayList (가변적이기에)
    static int temp = 0; // 각 단지 당의 수를 저장할 임시 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 지도의 크기
        int[][] map = new int[N][N]; // 지도 설정
        int[][] visited = new int[N][N]; // 방문 여부 사이즈 설정

        // 지도 정보를 배열에 저장, Arrays.stream(String[]).mapToInt(Integer::parseInt).toArray() 중요
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0 && map[i][j] == 1) { // 해당 좌표값이 1이고 아직 만나지 않은 상태라면
                    dfs(map, N, N, i, j, visited); // dfs 로직 실행하고
                    dict.add(temp); // 실행되어 저장된 temp를 dict에 추가
                    temp = 0; // 이후 다시 temp는 0으로 설정
                }
            }
        }

        bw.write(dict.size() + "\n"); // 총 단지 수

        // 각 단지내 집의 수를 오름차순 정렬해야 함, ArrayList<Integer>를 int[]로 변환
        int[] result = dict.stream().mapToInt(i -> i).toArray();
        Arrays.sort(result); // 오름차순 정렬

        // 순환하며 출력
        for (int i = 0; i < dict.size(); i++) {
            bw.write(result[i] + "\n");
        }

        bw.close();
        br.close();
    }

    public static void dfs(int[][] map, int MAX_Y, int MAX_X, int y, int x, int[][] visited) {
        // 좌표가 잘못됐거나 해당 좌표값이 0이라면 종료됨
        if (y < 0 || y >= MAX_Y || x < 0 || x >= MAX_X || visited[y][x] == 1 || map[y][x] == 0)
            return;
        // 이후로는 방문 처리를 하고 temp를 1 증가시킴
        visited[y][x] = 1;
        temp++;
        // 상
        dfs(map, MAX_Y, MAX_X, y - 1, x, visited);
        // 하
        dfs(map, MAX_Y, MAX_X, y + 1, x, visited);
        // 좌
        dfs(map, MAX_Y, MAX_X, y, x - 1, visited);
        // 우
        dfs(map, MAX_Y, MAX_X, y, x + 1, visited);
    }
}