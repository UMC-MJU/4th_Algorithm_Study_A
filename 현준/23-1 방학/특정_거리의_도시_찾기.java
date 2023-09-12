import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static class Node {
        private int index;
        private int value;

        public Node(int index) {
            this.index = index;
            this.value = 1;
        }
        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    private static boolean[] visited;
    private static final int INF = 999_999_999;
    private static int[] nodes;
    private static ArrayList<Node>[] info;

    // 전형적인 다익스트라 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 도시의 갯수 N
        // 도로의 갯수 M
        // 거리 정보 K
        // 출발 도시의 번호 X
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        // 연결 정보 초기화
        info = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            info[i] = new ArrayList<>();
        }

        // 첫 값들은 모두 INF로 설정
        nodes = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = INF;
        }

        // 연결 정보 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            info[start].add(new Node(end));
        }

        dijkstra(X);

        boolean find = false;
        for (int i = 1; i <= N; i++) {
            if (nodes[i] == K) { // 결괏값이 K인 것들을 출력
                if (!find)
                    find = true;
                bw.write(i + "\n");
            }
        }
        // 찾은 게 없으면 -1 출력
        if (!find) {
            bw.write("-1");
        }
        bw.close();
        br.close();
    }
    // 다익스트라 로직
    private static void dijkstra(int init) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.value, o2.value));
        pq.add(new Node(init, 0));
        nodes[init] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.index]) // 최종 처리된거면 스킵
                continue;
            visited[node.index] = true; // 방문 처리
            // 더 작은 값 만나면 업데이트 후 큐에 삽입
            for (Node n : info[node.index]) {
                if (nodes[n.index] > n.value + node.value) {
                    nodes[n.index] = n.value + node.value;
                    pq.add(new Node(n.index, nodes[n.index]));
                }
            }
        }
    }
}