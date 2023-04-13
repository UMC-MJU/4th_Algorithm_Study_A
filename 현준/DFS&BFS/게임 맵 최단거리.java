import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps[0].length; // 가로
        int m = maps.length; // 세로
        int[][] visited = new int[m][n]; // 방문 및 걸린 위치 계산 테이블
        visited[0][0] = 1;
        // 최단 경로 구하는 것은 BFS가 더 일찍 노드들을 탐색하므로 BFS가 유리하다고 할 수 있음
        // 2차원 맵에서의 경로 구하는 것은 상하좌우 로직과 위치 체크 및 방문 여부 필요
        return bfs(maps, n, m, visited, 0);
    }
    public int bfs(int[][] graph, int MAX_X, int MAX_Y, int[][] visited, int sum) {
        ArrayDeque<Integer> queue_x = new ArrayDeque<>();
        ArrayDeque<Integer> queue_y = new ArrayDeque<>();
        // 처음 위치는 (0, 0)부터 시작
        queue_x.addLast(0);
        queue_y.addLast(0);
        while (!queue_x.isEmpty() && !queue_y.isEmpty()) {
            int x = queue_x.pollFirst();
            int y = queue_y.pollFirst();
            // 상
            if (y > 0 && graph[y - 1][x] != 0 && visited[y - 1][x] == 0) {
                queue_x.addLast(x);
                queue_y.addLast(y - 1);
                visited[y - 1][x] = visited[y][x] + 1;
            }
            // 하
            if (y < MAX_Y - 1 && graph[y + 1][x] != 0 && visited[y + 1][x] == 0) {
                queue_x.addLast(x);
                queue_y.addLast(y + 1);
                visited[y + 1][x] = visited[y][x] + 1;
            }
            // 좌
            if (x > 0 && graph[y][x - 1] != 0 && visited[y][x - 1] == 0) {
                queue_x.addLast(x - 1);
                queue_y.addLast(y);
                visited[y][x - 1] = visited[y][x] + 1;
            }
            // 우
            if (x < MAX_X - 1 && graph[y][x + 1] != 0 && visited[y][x + 1] == 0) {
                queue_x.addLast(x + 1);
                queue_y.addLast(y);
                visited[y][x + 1] = visited[y][x] + 1;
            }
        }
        // 접근을 못 할 경우에는 -1 리턴
        return visited[MAX_Y - 1][MAX_X - 1] == 0 ? -1 : visited[MAX_Y - 1][MAX_X - 1];
    }
}