package BOJ.week24_4;

import java.io.*;
import java.util.*;

public class 줄_세우기_2252 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] degree = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            graph.get(one).add(two);
            degree[two]++; // 진입차수 구하기
        }

        topologicalSort(graph, degree, N);
    }
    public static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int[] indegree, int N) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // 위상 정렬 수행
        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");
            for (int next : graph.get(now)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}
