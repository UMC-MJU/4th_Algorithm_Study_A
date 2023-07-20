import java.io.*;
import java.util.*;

public class Main {
    private static int[][] original;
    private static int N;
    private static int M;
    private static int result;
    private static class Node { // 큐에 보관할 목적
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로 (y) 길이
        M = Integer.parseInt(st.nextToken()); // 가로 (x) 길이
        original = new int[N][M]; // 원본 배열

        // 그래프 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                original[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = 0; // 결과

        dfs(0); // 0개의 벽 설정 후 탐색 시작

        bw.write(result + "");
        bw.close();
        br.close();
    }

    // 구현 방법을 생각하지 못했던 부분
    // 조합을 활용해야겠다고 (완전탐색) 생각이 들긴 했으나, 그것을 코드로 올리는 과정을 못 했었음
    private static void dfs(int use) {
        if (use == 3) { // 모든 벽을 설치 완료했으면 BFS 시작
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (original[i][j] == 0) {
                    original[i][j] = 1; // 벽으로 세워보고 DFS 재귀 호출
                    dfs(use + 1);
                    original[i][j] = 0; // 재귀 끝나면 다시 되돌려놔야 함
                }
            }
        }
    }

    // 여기 부분은 구현 생각에 크게 문제 없었음
    private static void bfs() {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        // 임시 배열 생성 (원본 변경되지 않아야 함)
        int[][] change = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                change[i][j] = original[i][j];
                if (change[i][j] == 2) // 바이러스일 경우 큐에 삽입해둠 (상하좌우 움직일 수 있도록)
                    queue.add(new Node(j, i));
            }
        }

        // 상하좌우
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                // 범위 문제 없으면서 0이면 침투 가능한 것 -> 2로 변경 및 해당 바이러스 큐에 삽입
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && change[ny][nx] == 0) {
                    change[ny][nx] = 2;
                    queue.add(new Node(nx, ny));
                }
            }
        }

        // 0 카운트
        int temp = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (change[i][j] == 0)
                    temp++;
            }
        }
        // 0 갯수 최댓값 갱신
        result = Math.max(result, temp);
    }
}