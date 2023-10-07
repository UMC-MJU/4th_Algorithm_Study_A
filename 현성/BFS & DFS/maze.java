import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class maze {
    static boolean maze[][];
    static int road[][];
    static int row ;
    static int col;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        row  = sc.nextInt();
        col = sc.nextInt();
        road = new int[row+1][col+1];

        maze = new boolean[row][col];
        for(int i=0; i<row; i++){
            String str = sc.next();
            for(int j=0; j<col; j++){
//                road[i][j] = sc.nextInt();
//                이렇게 입력을 받으려 하니 무한입력 때문에 이유를 찾아보니
//                Scanner에 next()는 다음토큰(공백이전의 문자열)을 가져오는 메서드로 공백이 입력되지 않는101111 이것은 사용하기 어렵습니다.
                road[i][j] = str.charAt(j) - '0';//'0'을 하는 이유는 str.charAt(j)가 char형태로 road2차원 배열에 아스키코드 숫자가 들어가기 때문에
            }
        }
        bfs();
        System.out.print(road[row-1][col-1]);
    }
    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        int x =0;
        int y =0;
        maze[x][y] = true;
        queue.add(new int[]{x , y});
        while (!queue.isEmpty()){
            int arr[] =queue.poll();
            for(int i=0 ; i<4; i++){
                x = arr[0] + dx[i];
                y = arr[1] + dy[i];
                if(x<0 || y<0 || x>=row ||y>=col|| maze[x][y] ||road[x][y]==0){//범위를 벗어나면 다음 반복문 돌리기
                    continue;
                }
                maze[x][y]=true;
                queue.add(new int[]{x, y});//while문에서 다시 체크 할 수 있도록 해당하는 좌표 넣기
                road[x][y] = road[arr[0]][arr[1]]+1;
            }

        }
    }
}
