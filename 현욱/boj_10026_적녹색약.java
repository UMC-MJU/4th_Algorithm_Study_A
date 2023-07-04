package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_10026_적녹색약 {
    static int N;
    static char[][]general;
    static ArrayList<Integer> generalArray= new ArrayList<>();
    static ArrayList<Integer> blindArray= new ArrayList<>();
    static boolean[][]visited;
    static boolean[][]blindVisited;
    static int blind;
    static int []dx = {-1,1,0,0};
    static int []dy = {0,0,-1,1};
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        general = new char[N][N];
        visited = new boolean[N][N];
        blindVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < N; j++) {
                general[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cnt = 1;
                char color = general[i][j];
                if(!visited[i][j]){
                    if(color == 'R') {
                        dfs(i, j, color);
                        generalArray.add(cnt);
                    }else if (color =='G'){
                        dfs(i, j, color);
                        generalArray.add(cnt);
                    }else if (color =='B'){
                        dfs(i, j, color);
                        generalArray.add(cnt);
                    }
                }
            }
        }
        
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(general[i][j]=='G'){
                    general[i][j]='R';
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cnt = 1;
                char color =general[i][j];
                if(!visited[i][j]){
                    if(color =='R' ){
                        dfs(i,j,color);
                        blindArray.add(cnt);
                    } else if (color =='B') {
                        dfs(i,j,color);
                        blindArray.add(cnt);
                    }
                }
            }
        }
        System.out.println(generalArray.size()+" "+blindArray.size());
    }
    private static void dfs(int x, int y, char c) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int xn = x + dx[i];
            int yn = y + dy[i];

            if(xn >=0 && xn<N && yn>=0 && yn<N && !visited[xn][yn] && general[xn][yn]==c ){
                cnt+=1;
                dfs(xn,yn,general[xn][yn]);


            }
        }
    }
}
