package BOJ.week24_5;

import java.io.*;
import java.util.*;

public class 차이를_최대로_10819 {
    static int N;
    static int maxSum = Integer.MIN_VALUE;
    static int[] A, numbers;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        numbers = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        //1. 주어진 수를 배열에 넣는다.
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        recursion(0);
        System.out.print(maxSum);
    }

    // 재귀로 순열을 구하는 메서드
    public static void recursion(int depth) {
        // 탈출조건: depth == N
        if (depth == N) {
            int sum = calculate();
            maxSum = Math.max(maxSum, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                numbers[depth] = A[i];
                recursion(depth + 1);
                visited[i] = false;
            }
        }
    }
    // 주어진 식을 계산하는 메서드
    public static int calculate(){
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(numbers[i] - numbers[i+1]);
        }
        return sum;
    }
}
