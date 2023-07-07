package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_2667_단지번호붙이기 {
    static int size;
    static int [][]apt ;
    static int cnt = 0;
    static boolean [][] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        apt = new int[size][size];
        visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < size; j++) {
                apt[i][j]=Character.getNumericValue(line.charAt(j));
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if(!visited[i][j]&&apt[i][j]==1){
                    cnt =1;
                    dfs(i,j);
                    list.add(cnt);
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
    public static void dfs(int x , int y){
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int xn = x + dx[i];
            int yn = y + dy[i];
            if(xn>=0 && xn<size && yn>=0 && yn<size ) {
                if(!visited[xn][yn] && apt[xn][yn]==1){
                    cnt+=1;
                    dfs(xn,yn);
                }
            }
        }
    }

}
