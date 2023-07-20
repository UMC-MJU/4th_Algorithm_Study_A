import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        private int index;
        private int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
    private static boolean[] visited;
    private static int[] result;
    private static ArrayList<Node>[] arrayList;
    private static int INF = Integer.MAX_VALUE;
    private static StringTokenizer st;

    // 전형적인 다익스트라 문제이다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 도시
        int M = Integer.parseInt(br.readLine()); // 버스

        // 도시 간 이어져있는 연결 정보
        arrayList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arrayList[i] = new ArrayList<>();
        }

        // 방문 여부 초기화
        visited = new boolean[N + 1];
        Arrays.fill(visited, false);

        // 결괏값 초기화
        result = new int[N + 1];
        Arrays.fill(result, INF);

        // 정보 입력받고 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arrayList[start].add(new Node(end, cost));
        }

        // 시작점과 종료지점 입력
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int want = Integer.parseInt(st.nextToken());

        // 다익스트라 로직 실행
        dijkstra(from);

        bw.write(result[want] + "");
        bw.close();
        br.close();
    }

    // 다익스트라 로직
    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost)); // cost가 더 작은 것을 우선으로
        pq.add(new Node(start, 0)); // start 지점은 0
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.index]) // 방문된 (처리된) 버스면 스킵
                continue;
            visited[node.index] = true;
            // 더 적은 버스를 만났을 시 업데이트 및 우선순위 큐에 삽입
            for (Node neighbor : arrayList[node.index]) {
                if (result[neighbor.index] > node.cost + neighbor.cost) {
                    result[neighbor.index] = node.cost + neighbor.cost;
                    pq.add(new Node(neighbor.index, result[neighbor.index]));
                }
            }
        }
    }
}