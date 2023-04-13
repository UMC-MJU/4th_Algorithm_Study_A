import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        HashMap<Integer, ArrayDeque<Integer>> graph = new HashMap<>();
        
        // 그래프 생성 로직
        for (int i = 0; i < computers.length; i++) {
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            graph.put(i, deque);
            // 1부터 computers의 길이만큼 반복문 돌림
            for (int j = 0; j < computers.length; j++) {
                if (i != j && computers[i][j] == 1) {
                    ArrayDeque<Integer> prev = graph.get(i);
                    prev.addLast(j);
                    graph.put(i, prev);
                }
            }
        }
        
        int[] visited = new int[computers.length]; // 방문 처리 위한 배열
        int result = 0;
        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == 0) { // 방문하지 않았을 경우에만 bfs 수행
                result += bfs(graph, i, visited);
            }
        }
        return result;
    }
    public int bfs(HashMap<Integer, ArrayDeque<Integer>> graph, int computer, int[] visited) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(computer);
        visited[computer] = 1; // 시작점 방문 처리
        while (!queue.isEmpty()) { // queue가 비어있지 않다면 로직 수행
            int target = queue.pollFirst();
            ArrayDeque<Integer> nodes = graph.get(target);
            for (Integer node : nodes) { // 각 노드들에 있는 컴퓨터들에 대한 로직 수행
                if (visited[node] == 1) { // 방문 처리 한 노드 (컴퓨터)라면 삭제
                    nodes.pollFirst();
                } else {
                    queue.addLast(nodes.pollFirst()); // 방문하지 않았던 노드 (컴퓨터)라면 삭제한 뒤 그 값을 queue에 넣기
                    visited[node] = 1; // 방문 처리
                }
            }
        }
        return 1; // 체크된 컴퓨터들은 모두 하나의 선이므로 1 리턴
    }
}