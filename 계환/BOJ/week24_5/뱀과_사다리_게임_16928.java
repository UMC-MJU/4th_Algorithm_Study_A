package BOJ.week24_5;

import java.io.*;
import java.util.*;

public class 뱀과_사다리_게임_16928 {
    static int minCount;
    static int N, M;
    static Map<Integer, Integer> map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        visited = new boolean[101];
        // 1. 뱀, 사다리 정보를 해시맵에 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.put(x, y);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.put(x, y);
        }

        // 2. bfs
        bfs();
        System.out.print(minCount);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            minCount++;
            for (int i = 0, qSize= queue.size(); i < qSize; i++) {
                int now = queue.poll();
                for (int j = 1; j <= 6; j++) { // 주사위 계산
                    int move = now + j;
                    if (move == 100) return;
                    if (move > 100) continue;
                    if (visited[move]) continue;

                    visited[move] = true;
                    if (map.containsKey(move)) { // 뱀, 사다리를 만남
                        move = map.get(move);
                    }
                    queue.offer(move);
                }
            }
        }
    }
}
