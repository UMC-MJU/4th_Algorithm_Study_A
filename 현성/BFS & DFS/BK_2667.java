package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BK_2667 {
    static int N; // 지도의 크기
    static int map[][]; //지도를 나타내는 2차원 배열
    static boolean visit[][]; // 방문을 하였는지 표시해놓기 위해 만들어 놓은 boolean형 2차원 배열
    static int count; // 단지의 수
    static ArrayList<Integer> list; //단지 내에 있는 집의 수를 담을 배열

    static void dfs(int x, int y) {
        visit[x][y] = true;
        count++;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visit[nx][ny] && map[nx][ny] == 1) {
                    count = 0;
                    dfs(nx, ny);
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //지도의 크기
        map = new int[N][N];
        visit = new boolean[N][N];
        list = new ArrayList<>();

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));

            }
        }

        for(int a=0; a<N; a++){
            for(int b=0; b<N; b++){
                    dfs(a,b);
                list.add(count);
            }
        }
        Collections.sort(list);
        for(int num : list){
            System.out.print(num+"    ");
        }

    }
}
