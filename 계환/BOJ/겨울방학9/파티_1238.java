package BOJ.겨울방학9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int index;
    int time;

    public Node(int index, int time) {
        this.index = index;
        this.time = time;
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(this.time, node.time);
    }
}

public class 파티_1238 {

    private static int N; // 마을과 학생의 개수
    private static int M; // 도로의 개수
    private static int X; // 파티 장소
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    private static boolean[] isVisited;
    private static int[] dist;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        answer = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) { // 도로 정보 입력
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            Node road = new Node(end, time);
            graph.get(start).add(road);
        }

        // 시작점 -> 목적지 / 목적지 -> 시작점 따로 구해서 더해준다.
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            sum += Dijkstra(i, X);
            sum += Dijkstra(X, i);
            answer[i] = sum;
        }
        // 정답 출력
        System.out.println(Arrays.stream(answer).max().getAsInt());
    }

    public static int Dijkstra(int start, int end) {
        isVisited = new boolean[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {

            int nowVertex = pq.poll().index;
            if (isVisited[nowVertex]) {
                continue;
            }
            isVisited[nowVertex] = true;

            for (Node node : graph.get(nowVertex)) {
                if (dist[node.index] > dist[nowVertex] + node.time) {
                    dist[node.index] = dist[nowVertex] + node.time;
                    pq.offer(new Node(node.index, dist[node.index]));
                }
            }
        }
        return dist[end];
    }
}
