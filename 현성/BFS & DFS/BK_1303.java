package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BK_1303 {
    static char map[][];
    static boolean visit[][];
    static int N;
    static int M;
    static int power; // 각 진영의 위력

    static int Dfs(int x , int y){
        visit[x][y] = true;
        power++;

        int[] dx = {-1, 0 , 1, 0};
        int[] dy = {0, -1 , 0, 1};

        for(int k=0; k<4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx >=0 && ny >=0 && nx < N && ny < M){
                if(map[nx][ny] =='W' && !visit[nx][ny]){
                    Dfs(nx , ny);
                }
            }
        }
        return power;
    }
//    static int blueDfs(int x , int y){
//        visit[x][y] = true;
//        power++;
//
//        int[] dx = {-1, 0 , 1, 0};
//        int[] dy = {0, -1 , 0, 1};
//
//        for(int k=0; k<4; k++){
//            int nx = x + dx[k];
//            int ny = y + dy[k];
//
//            if(nx >=0 && ny >=0 && nx < N && ny < M){
//                if(map[nx][ny] =='B' && !visit[nx][ny]){
//                    blueDfs(nx , ny);
//                }
//            }
//        }
//        return power;
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //가로의 크기
        M = Integer.parseInt(st.nextToken()); //세로의 크기

        map = new char[N][M]; //각 팀의 진영 색깔을 나타내주는 map
        visit = new boolean[N][M]; //방문 하였는지 체크할 수 있게 해주는 visit

        for(int i=0; i<M; i++){
            String line = br.readLine();//한줄씩 진영의 색깔 읽기
            for(int j=0; j<N; j++){
                map[i][j] = line.charAt(j);
            }
        }
        int w_sum =0; //화이트 진영의 위력 합산
        int b_sum =0; //블루 진영의 위력 합산

        for(int a=0; a<M; a++){
            for(int b=0; b<N; b++){
                if(map[a][b] == 'W' && !visit[a][b]){
                    power =0;
                    w_sum+= Math.pow(Dfs(a, b),2);
                }else if(map[a][b] == 'B' && !visit[a][b]){
                    power =0;
                    b_sum+= Math.pow(Dfs(a, b),2);
                }
            }
        }
        System.out.println(w_sum + " " + b_sum);
    }
}
