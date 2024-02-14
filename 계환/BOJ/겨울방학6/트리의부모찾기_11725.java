package BOJ.겨울방학6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의부모찾기_11725 {
    public static ArrayList<ArrayList<Integer>> list;
    public static boolean[] visited;
    public static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드의 개수
        list = new ArrayList<>();
        visited = new boolean[N + 1];
        answer = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            list.get(one).add(two);
            list.get(two).add(one);
        }
        dfs(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void dfs(int curVertex) {
        visited[curVertex] = true;
        for (int nextVertex : list.get(curVertex)) {
            if (!visited[nextVertex]) {
                answer[nextVertex] = curVertex;
                dfs(nextVertex);
            }
        }
    }
}
