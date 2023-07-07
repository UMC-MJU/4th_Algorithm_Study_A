package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BK_1012 {
    static int M;
    static int N;
    static int K;
    static int cabbage[][];
    static boolean visit[][] ;

    static void check(int x , int y){
        visit[x][y] = true;

        int dx[] = {-1 , 0 , 1 , 0};
        int dy[] = {0 , -1 , 0 , 1};

        for(int i=0; i<4; i++){
            int sx = x + dx[i];
            int sy = y + dy[i];
            if(sx >=0 && sy>=0&&  sx<M && sy<N){
                if(cabbage[sx][sy] ==1 && !visit[sx][sy]){
                    check(sx , sy);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());  //T는 테스트 케이스
        for(int i=0; i<T; i++){

            int worm = 0; //필요한 지렁이 수

            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());//M은 가로길이
            N = Integer.parseInt(st.nextToken());//N은 세로길이
            K = Integer.parseInt(st.nextToken());//K는 배추가 심어져 있는 위치의 개수

            cabbage = new int[M][N];
            visit = new boolean[M][N];

            for(int j=0; j<K; j++){//배추 밭을 2차원 행렬로 생각하고
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 배추가 심어져있는 위치의 (x , y) 포인트
                int y = Integer.parseInt(st.nextToken());

                cabbage[x][y] =1 ;
            }
            for(int a=0; a<M; a++){
                for(int k=0; k<N; k++){
                    if(cabbage[a][k] ==1 && !visit[a][k]){
                        check(a , k);
                        worm++;
                    }
                }
            }
            System.out.println(worm);
        }



    }
}
