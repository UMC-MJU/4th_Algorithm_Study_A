package BOJ.week24_6;

import java.io.*;
import java.util.*;

public class 스티커_9465 {
    static int T, n;
    static int max;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[2][n];
            max = Integer.MIN_VALUE;
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // 재귀함수 호출
            recursion(0, 0, 0);
            recursion(0, 1, 0);
            recursion(0, 2, 0);
            System.out.println(max);
        }

    }
    // index: 몇 번을 뽑는 것인지, point: 누적 점수
    public static void recursion(int depth, int index, int point){
        if (index != 2) {
            point += arr[index][depth];
        }
        if (depth == n-1) { // 탈출조건
            max = Math.max(max, point);
            return;
        }
        if (index == 2){ // 저번에 뽑지 않았으면 둘 중에 하나는 꼭 뽑아야 한다.
            recursion(depth + 1, 0, point);
            recursion(depth + 1, 1, point);
        } else { // 뽑았었으면 다른 행에 있는 것을 뽑거나 뽑지 않는다.
            recursion(depth + 1, index == 0 ? 1 : 0, point); // 뽑는 경우
            recursion(depth + 1, 2, point); // 안 뽑는 경우
        }
    }
}
