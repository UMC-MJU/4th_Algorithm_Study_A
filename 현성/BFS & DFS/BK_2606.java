package DFS_BFS;

import java.util.Scanner;

public class BK_2606 {
    static boolean visit[];
    static int network[][];
    static int com;
    static int link;
    static int count;
    static int dfs(int x){

        visit[x] =true;

        for(int j=0; j<=com; j++){
            if(network[x][j] ==1 && !visit[j]){
                count++;
                dfs(j);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        com = sc.nextInt();     //컴퓨터의 수
        link = sc.nextInt();    //연결된 컴퓨터 쌍의 수

        visit = new boolean[com+1];     // 각 컴퓨터끼리 연결되었는지를 나타내주는 배열
        network = new int[com+1][com+1];    // 인접행렬로 나타내기

        for(int i=0; i<link; i++){
            int row = sc.nextInt();
            int col = sc.nextInt();

            network[col][row] = network[row][col] = 1;
        }

        System.out.println(dfs(1));
    }
}
