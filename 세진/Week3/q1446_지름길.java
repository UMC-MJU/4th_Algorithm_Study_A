package Week3;

import java.util.*;

public class q1446_지름길 {
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Edge>[] graph;
    static int[] dist;
    static int N, D;
    static class Edge implements Comparable<Edge> {
        private final int w; // 비용
        private final int v; // 정점
        public Edge(int w, int v) {
            this.w = w;
            this.v = v;
        }
        @Override
        public int compareTo(Edge edge) {
            return this.w - edge.w;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        graph = new ArrayList[D];
        for (int i = 0; i < D; i++) {
            graph[i] = new ArrayList<>();
        }
        dist = new int[D];
        Arrays.fill(dist, INF);
        N = sc.nextInt();
        D = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Edge(w, v));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>(Edge::compareTo);
        dist[0] = 0;
        pq.add(new Edge(dist[0], 0));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(dist[cur.v] != cur.w) continue;
            for (Edge nxt : graph[cur.v]) {
                if(dist[nxt.v] <= dist[cur.v] + nxt.w) continue;
                dist[nxt.v] = dist[cur.v] + nxt.w;
                pq.add(new Edge(dist[nxt.v], nxt.v));
            }
        }
        System.out.println(dist[D - 1]);
    }
}
