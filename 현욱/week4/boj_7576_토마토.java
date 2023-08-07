package PS.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_7576_토마토 {
    static class Node{
        public Node(int r, int c,int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }

        int r;
        int c;
        int depth;
    }
    static int M;
    static int N;
    static boolean[][] visited;
    static int[][] map;
    static ArrayDeque<Node> q;
    static int ans;
    static int []dx = {0,0,-1,1};
    static int []dy = {-1,1,0,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        q=new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==1){
                    visited[i][j] = true;

                    //평범한 bfs 문제지만, 토마토는 여러개일 수 있고, 하루 단위로 전파가 진행되기 때문에 , 한번에 관리해줘야 하는 어려움이 있음
                    //따라서 q 에 추가할 때 depth 를 지정해서, 같은 depth 끼리 계산하도록 진행
                    q.add(new Node(i,j,1));
                }
            }
        }


        bfs(ans);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    ans = -1;
                    break;
                }
            }
        }
        System.out.println(ans);
    }

    public static void bfs(int cnt) {

        while(!q.isEmpty()){
            Node now = q.pollLast();

            if(map[now.r][now.c]==0){

                map[now.r][now.c] = 1;

            }

            for (int i = 0; i < 4; i++) {
                int nx = now.c + dx[i];
                int ny = now.r + dy[i];

                if(nx<0 || ny <0 || nx >=M || ny >=N)
                    continue;
                if(visited[ny][nx] || map[ny][nx]==-1)
                    continue;
                if(map[ny][nx]==0) {
                    visited[ny][nx]=true;
                    //depth 최대값 -> 가장 오래 걸린 날
                    ans = Math.max(now.depth, ans);
                    q.addFirst(new Node(ny, nx,now.depth+1));

                }
            }
        }

    }
}
