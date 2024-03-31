package BOJ;

import java.io.*;
import java.util.*;

public class 외판원순회2_10971 {
    static int N;
    static int[][] graph;
    static int leastCost = Integer.MAX_VALUE;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            isVisited = new boolean[N];
            isVisited[i] = true;
            dfs(i, 0);
        }
        System.out.println(leastCost);
    }

    public static void dfs(int now, int cost) {
        // 시작 위치는 0번으로 고정한다. 어차피 순회하기 때문에 상관없음.
        // 모두 방문했으면 리턴
        if (allVisited()) {
            if (graph[now][0] != 0) {
                cost += graph[now][0];
                leastCost = Math.min(cost, leastCost);
            }
            return;
        }

        for (int i = 1; i < N; i++) {
            if (!isVisited[i] && graph[now][i] != 0) {
                isVisited[i] = true;
                dfs(i, cost + graph[now][i]);
                isVisited[i] = false;
            }
        }

    }

    public static boolean allVisited() {
        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                return false;
            }
        }
        return true;
    }
}
