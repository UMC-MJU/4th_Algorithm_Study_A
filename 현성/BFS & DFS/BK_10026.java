package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BK_10026 {
    static int[] dx = { -1 , 0 , 1 , 0 };
    static int[] dy = { 0 , -1 , 0 , 1 };
    static int size; // 그림의 사이즈

    static char RGB[][]; //보여지는 그림(일반인 관점)
    static char SRGB[][]; //보여지는 그림(적록색약 관점)
    static boolean visit[][]; //방문 하였는지 표시 하기 위해 만든 2차원 배열(일반인)
    static boolean sVisit[][]; //방문 하였는지 표시 하기 위해 만든 2차원 배열(적록색약)

    static void dfs(int x , int y , boolean check [][],char map[][],char color){
        check[x][y] = true;
        for(int k=0; k<4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx >=0 && ny >=0 && nx<size && ny<size && !check[nx][ny] &&(map[nx][ny] == color)){
                dfs(nx , ny , check, map , color);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        RGB = new char[size][size];
        SRGB = new char[size][size];
        visit = new boolean[size][size];
        sVisit = new boolean[size][size];
        for(int i=0; i<size; i++){// 각 그림에 주어진 색깔에 따라 입력을 하는데 적록색약의 경우 어차피 G와 R이 같은 색으로 인지하기에
                                    //if문을 이용하여 적록색약의 그림에만 G를 입력받으면 R로 바꿔서 같은 색이 되도록 생각하였습니다.
            String str = br.readLine();
            for(int j=0; j<size; j++){
                char ch = str.charAt(j);
                RGB[i][j] = ch;
                if(ch =='G')
                    SRGB[i][j] = 'R';
                else
                    SRGB[i][j] = ch;
            }
        }
        int area=0;//일반이 입장에서 보는 그림 색의 수
        int sArea =0; //적록색약 입장에서 보는 그림 색의 수
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(!visit[i][j]){
                    dfs(i , j , visit , RGB ,RGB[i][j]);
                    area++;
                }
                if(!sVisit[i][j]){
                    dfs(i , j , sVisit, SRGB , SRGB[i][j]);
                    sArea++;
                }
            }
        }
        System.out.println(area + " " + sArea);
    }
}
