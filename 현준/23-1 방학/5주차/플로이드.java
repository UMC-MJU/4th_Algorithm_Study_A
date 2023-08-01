import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[][] graph; // 그래프
    private static int INF = 99999999; // INF
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];

        // 그래프 초기 설정
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) { // 시작 도시와 도착 도시가 같은 경우는 없음 - 0으로 둠
                    graph[i][j] = 0;
                    continue;
                }
                graph[i][j] = INF; // 그 이외의 경우에는 INF로 초기 설정
            }
        }

        // 그래프 값 세팅
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start][end] = Math.min(graph[start][end], cost); // 가장 작은 비용으로 저장되도록 함 (같은 경우 나올 수 있기 때문)
        }

        floyd(N); // 플로이드 로직

        // 최종 출력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] == INF)
                    bw.write(0 + " ");
                else
                    bw.write(graph[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.close();
        br.close();
    }

    // 플로이드 로직
    private static void floyd(int size) {
        // 플로이드는 3중 for문이 거의 기본
        // 중간에 한 번 거쳐가는 정점이 꼭 맨 바깥쪽 for문에 있어야 한다.
        // 각 노드를 중간 노드로 가정했을 경우 모든 케이스들을 계산해보는 과정이기 때문이다.
        for (int m = 1; m <= size; m++) {
            for (int i = 1; i <= size; i++) {
                for (int j = 1; j <= size; j++) {
                    // 만약 i에서 j로 가는 비용이 i -> m -> j보다 큰가 - 그렇다면 graph[i][m] + graph[m][i]로 갱신한다.
                    if (graph[i][j] > graph[i][m] + graph[m][j])
                        graph[i][j] = graph[i][m] + graph[m][j];
                }
            }
        }
    }
}