package prePractice;

import java.io.*;
import java.util.*;

// 그림이 그려진 좌표를 위한 class
class Node {
    int i;
    int j;

    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Picture {
    static int n, m, cnt, maxSize;
    static int[][] image;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        image = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i<n; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++) {
                image[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                // 그림이 그려져있는데 방문하지 않았다면 BFS 탐색 시작
                if(image[i][j] == 1 && !visited[i][j]) {
                    BFS(i, j);
                }
            }
        }


        System.out.println(cnt);

        System.out.println(maxSize);
    }


    public static void BFS(int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));
        int count = 0;

        int[] di = {1, 0, -1, 0};//상우 하좌
        int[] dj = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            count++;

            for(int d = 0; d<4; d++) {
                int ni = node.i + di[d];
                int nj = node.j + dj[d];

                if(ni < 0 || ni >= n || nj < 0 || nj >= m) continue;
                if(visited[ni][nj] || image[ni][nj] == 0) continue;
                visited[ni][nj] = true;
                queue.add(new Node(ni, nj));
            }
        }

        cnt++;
        if(count > 1) count--;
        maxSize = Math.max(maxSize, count);
    }
}