import java.util.*;

public class q1446_지름길 {

    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Edge>[] graph; // 그래프
    static int[] dist; // 다익스트라 거리 배열
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
            return edge.w - this.w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        D = sc.nextInt();
        graph = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) {
            graph[i] = new ArrayList<>();
            if(i < D) graph[i].add(new Edge(1, i + 1)); // 고속도로의 모든 부분을 점으로 바꿔 다음 그래프 추가
        }
        dist = new int[D + 1];
        Arrays.fill(dist, INF);
        for (int i = 0; i < N; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            if(v <= D) graph[u].add(new Edge(w, v));
        }

        // 밑은 다익스트라 알고리즘
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
        System.out.println(dist[D]);
    }
}