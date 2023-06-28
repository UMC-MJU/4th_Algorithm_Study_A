package Implem;

import java.util.Scanner;

public class upDownLeftRight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();// 포인트가 움직이는 횟수
        String input[] = new String[N];
        for(int i=0; i<N; i++){
            input[i] = sc.next();
        }
        String move[] = {"U","D","L","R"};
//        for(String str : input){
//            System.out.println(str);
//        }
        int x = 0;
        int y = 0;
        int dy[] = {-1,1,0,0};// up , down
        int dx[] = {0,0,-1,1};// left , right

        for(int i=0; i<N; i++){
            for(int j=0; j<4; j++){
                if(input[i].equals(move[j])){
                    x = x + dx[j];
                    y = y + dy[j];
//                    System.out.println("dx[j]="+ dx[j]);
//                    System.out.println("x = " + x);
                    System.out.println("dy[j]="+ dy[j]);
                    System.out.println("y = " + y);
                }
            }
            if (x<1 || y<1 || x>N || y>N){
                continue;
            }
        }
        System.out.println(x + " " + y);

    }

}
