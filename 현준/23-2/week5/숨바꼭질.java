import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.List;
import java.util.StringTokenizer;

public class 숨바꼭질 {

     // 내부 클래스
    private static class Node {

        private int index;
        private int cost;

        public Node(final int index, final int cost) {
            this.index = index;
            this.cost = cost;
        }
        // 이전과 다르게 getter는 제외했습니다
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static boolean[] visited;
    private static int start;
    private static int target;

    public static void main(String[] args) throws IOException {
        init(); // BufferedReader, BufferedWriter
        StringTokenizer st = new StringTokenizer(br.readLine());
        saveInput(st); // start, target 저장 (각각 출발지, 목표지)
        initVisited(); // visited 초기화
        bfs(start); // BFS 시작 - start부터
        close();
    }

    private static void initVisited() {
        visited = new boolean[100001]; // 처음에는 크기를 target + 1만큼만 했는데, 더 많이 계산할 여지가 있음을 알고 수정하였습니다.
    }

    private static void saveInput(final StringTokenizer st) {
        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
    }

    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void bfs(int start) throws IOException {
        visited[start] = true;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(start, 0)); // 처음 시작은 위치를 start, 비용을 0으로 한 Node
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            if (isWantNode(node)) { // 목표 지점이면 출력 (이후 종료시켜도 됐을 것 같습니다.)
                bw.write(node.cost + "\n");
            }

            // 위치 - 1, 위치 + 1, 위치 * 2를 가진 Node들을 만들고 이들을 반복
            Node prevNode = new Node(node.index - 1, node.cost + 1);
            Node nextNode = new Node(node.index + 1, node.cost + 1);
            Node doubleNode = new Node(node.index * 2, node.cost + 1);
            List<Node> nodes = List.of(prevNode, nextNode, doubleNode);

            for (Node test : nodes) {
                // 만났거나 위치 이상하면 패스
                if (isNotValidNodeLocation(test) || visited[test.index]) {
                    continue;
                }
                queue.addLast(test);
                visited[test.index] = true;
            }
            // BFS 구조이기 때문에 이미 만났던 Node들을 또 만날 경우에는 그 이전의 Node의 cost가 더 쌀 수 밖에 없습니다.
            // EX: start가 5일 경우 [4], [6], [10]을 만나며, [4]의 경우 다시 [3]과 [5], [8]을 만나게 되는데
            // 이때 5의 비용은 0이 최소입니다. 따라서 이 문제는 BFS가 알맞습니다.
        }
    }

    // 위치 판단
    private static boolean isNotValidNodeLocation(final Node test) {
        return test.index < 0 || test.index >= 100001;
    }

    // 목표 지점의 Node인지
    private static boolean isWantNode(final Node node) {
        return node.index == target;
    }

    private static void close() throws IOException {
        bw.close();
        br.close();
    }
}
