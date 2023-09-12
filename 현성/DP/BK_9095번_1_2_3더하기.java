package DP;


import java.util.Scanner;
public class BK_9095번_1_2_3더하기 {
    static int[] dp; // 메모이제이션 배열
    public static void main(String[] args) {
        //입력값 받기
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            // N까지의 값을 저장하기 위한 메모이제이션 배열 생성
            dp = new int[N + 1];

            System.out.println(countWays(N));
        }
    }

    private static int countWays(int N) {
        System.out.println("현재 N의 값은 "+N);
        if (N == 0) {
            System.out.println("N == 0일때 , N = " + N);
            return 1; // 0을 만드는 방법은 아무 수도 선택하지 않는 경우 1가지
        }

        if (dp[N] != 0) {
            return dp[N]; // 이미 계산된 값이라면 메모이제이션 값을 반환
        }

        int ways = 0;
        if (N >= 1) {
//                System.out.println("N >= 1일때 , N = " + N);
//                System.out.println("countWays ("+(N-1)+")");
            ways += countWays(N - 1); // 1을 선택한 경우
        }
        if (N >= 2) {
//                System.out.println("N >= 2일때 , N = " + N);
//                System.out.println("countWays ("+(N-2)+")");
            ways += countWays(N - 2); // 2를 선택한 경우
        }
        if (N >= 3) {
//                System.out.println("N >= 3일때 , N = " + N);
//                System.out.println("countWays ("+(N-3)+")");
            ways += countWays(N - 3); // 3을 선택한 경우
        }

        dp[N] = ways; // 계산된 값 저장 (메모이제이션)

        return ways;
    }
}



