package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11724{
    //정점의 개수
    static int number;
    static int node[][];
    static boolean visited[];
    static void dfs(int index){
        visited[index] = true;

        for(int i=0; i<number; i++){
            if(!visited[i]&&node[index][i]==1){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        //정점의 개수
        number = Integer.parseInt(st.nextToken());
        //간선의 개수
        int line = Integer.parseInt(st.nextToken());

        node = new int [number+1][number+1];

        //연결된 노드끼리 2차원 행렬로 표현하기
        for(int i=0; i<line; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            node[row][col] =1;
            node[col][row] =1;
        }
        visited=new boolean[number+1];
        int result=0;

        for(int i=1; i<number; i++){
            if(!visited[i]){
                dfs(i);
                result++;
            }
        }



        System.out.println(result);
        }
    }
