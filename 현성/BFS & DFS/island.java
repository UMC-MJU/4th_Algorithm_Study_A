import java.util.Scanner;

public class island {
    private static int width;
    private static int height;
    private static int land[][];
    private static boolean visit[][];
    private static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            width = sc.nextInt(); //가로
            height = sc.nextInt();//세로
            count=0;
            if(width ==0 && height ==0)//0 0 을 입력받으면 테스트케이스 종료
                break;
            land = new int [width][height];
            visit = new boolean[width][height];
            for(int row=0; row<width; row++) {
                for (int col = 0; col < height; col++) {
                    int number = sc.nextInt();
                    land[row][col] =number;
                }
            }
            for(int row=0; row<width; row++) {
                for (int col = 0; col < height; col++) {
                    if(land[row][col] == 1 && !visit[row][col]) {
                        dfs(row, col);
                        System.out.println("row = " + row+" , col = " + col);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int x , int y ) {
        visit[x][y] = true;
        //오른쪽 왼쪽 위 아래 오른쪽위 왼쪽위 왼쪽아래 오른쪽 아래
        int[] dx = {1, -1, 0, 0 , 1, -1 , -1, 1};
        int[] dy = {0, 0 , 1, -1, 1, 1 , -1, -1};
        for(int i=0; i<8; i++){//대각선까지 8방향으로 가야하니 8번 반복해줍니다.
            int neighborX = x + dx[i];
            int neighborY = y + dy[i];
            if(neighborX >=0 && neighborY>=0 && neighborX<width && neighborY<height){
                if(land[neighborX][neighborY] ==1 & !visit[neighborX][neighborY]){
                    dfs(neighborX, neighborY);
                }
            }
        }
    }
}
