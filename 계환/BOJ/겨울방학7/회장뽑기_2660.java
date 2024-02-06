package BOJ.겨울방학7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Chairman {
    int data;
    int depth;

    public Chairman(int data, int depth) {
        this.data = data;
        this.depth = depth;
    }
}

public class 회장뽑기_2660 {

    public static int peopleNum; //회원의 수
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //인접리스트 구현
    public static boolean[] visited; //방문여부
    public static int[] answer; //각 인덱스에는 노드값, 값에는 깊이를 넣어준다.
    public static ArrayList<Integer> nominated = new ArrayList<>(); //회장 후보 리스트
    public static int minPoint = 50; //회원의 수는 50명을 넘지 않는다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        peopleNum = Integer.parseInt(br.readLine());
        answer = new int[peopleNum + 1];

        for (int i = 0; i <= peopleNum; i++) {
            graph.add(new ArrayList<>());
        }
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            if (one == -1 && two == -1) { // 마지막 줄에는 -1이 두 개 들어있다.
                break;
            }
            graph.get(one).add(two);
            graph.get(two).add(one);
        }

        for (int i = 1; i <= peopleNum; i++) {
            bfs(i);
        }

        int chairmanNum = 0;

        for (int i = 1; i <= peopleNum; i++) {
            if (answer[i] == minPoint) {
                chairmanNum++;
                nominated.add(i);
            }
        }

        // 정답 출력
        System.out.print(minPoint + " ");
        System.out.println(chairmanNum);
        for (Integer i : nominated) {
            System.out.print(i + " ");
        }
    }

    public static void bfs(int startNode) {
        Queue<Chairman> queue = new LinkedList<>();
        visited = new boolean[peopleNum + 1];
        int maxDepth = 0;

        queue.offer(new Chairman(startNode, 0));
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            Chairman now = queue.poll();
            maxDepth = Math.max(maxDepth, now.depth);

            for (int currentNode : graph.get(now.data)) {
                if (!visited[currentNode]) { //방문하지 않았으면
                    queue.offer(new Chairman(currentNode, now.depth + 1));
                    visited[currentNode] = true; //방문처리
                }
            }
        }
        answer[startNode] = maxDepth;
        minPoint = Math.min(minPoint, maxDepth);
    }
}
