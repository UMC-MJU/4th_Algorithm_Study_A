import java.io.*;
import java.util.*;
public class Main {

    private static class Node {
        int index; // 해당 노드의 index를 의미
        int cost; // 자신의 비용

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    private static int[] dist; // 최종 결괏값 정의
    private static boolean[] visit; // 1 ~ N번 노드 방문 여부 판단
    private static ArrayList<Node>[] adjList; // 1번 노드가 가지는 ArrayList, 2번 노드가 가지는 ArrayList..

    private static final int INF = 20000 * 10 + 1;

    public static void main(String[] args) throws IOException {
        // 입출력 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // Vertex 갯수
        int E = Integer.parseInt(st.nextToken()); // Edge 갯수

        int start = Integer.parseInt(br.readLine()); // 시작 노드 정의

        dist = new int[V + 1]; // dist 선언
        visit = new boolean[V + 1]; // visit 선언
        adjList = new ArrayList[V + 1]; // adjList 선언

        // 초기화
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 입력값 저장
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // start
            int v = Integer.parseInt(st.nextToken()); // next
            int w = Integer.parseInt(st.nextToken()); // cost

            adjList[u].add(new Node(v, w)); // start에서 next로 갈 때 cost가 든다
        }

        dijkstra(start); // 다익스트라 로직 실행

        // 결과 출력
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                bw.write("INF\n");
                continue;
            }
            bw.write(dist[i] + "\n");
        }
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {
        Arrays.fill(visit, false); // 방문 여부 초기화
        Arrays.fill(dist, INF); // 결괏값 배열 초기화

        // 새로 알게 된 코드: 우선순위 큐 설정 시 정렬 기준을 커스텀하게 만들 때 쓰는 방식의 예
        // 헷갈리는 부분
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        dist[start] = 0; // start 지점의 결과는 0
        pq.add(new Node(start, 0)); // start 지점부터 시작해봄 - start 지점의 cost는 0

        while (!pq.isEmpty()) {
            Node now = pq.poll(); // 현재 노드 꺼내봐서

            if (visit[now.index]) // 방문했었으면 스킵
                continue;

            visit[now.index] = true; // 방문 처리
            for (Node next : adjList[now.index]) { // 해당 노드가 가지고 있던 ArrayList for문
                if (dist[next.index] > now.cost + next.cost) { // 각 노드가 가지고 있던 비용보다 적은 값을 발견했다면
                    dist[next.index] = now.cost + next.cost; // 새롭게 비용을 등록해주고
                    pq.add(new Node(next.index, dist[next.index])); // 해당 인덱스, 해당 인덱스의 비용을 가진 노드를 pq에 등록
                }
            }
        }
    }
}