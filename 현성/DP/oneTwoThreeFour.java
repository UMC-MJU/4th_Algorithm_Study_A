import java.util.Scanner;

public class oneTwoThreeFour{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();// 숫자 입력 개수

        while (testCase-->0) {
            int n = sc.nextInt();
            int[][] dp = new int[10001][4];
            dp[1][1] = 1;
            dp[2][1] = 1;
            dp[2][2] = 1;
            dp[3][1] = 1;
            dp[3][2] = 1;
            dp[3][3] = 1;
            // 0  0  0  0  ... 0
            // 1  0  0  0  ... 0 --> 1 == 1
            // 1  1  0  0  ... 0 --> 2 == 1+1 , 2
            // 1  1  1  0  ... 0 --> 3 == 1+1+1 , 1+2 , 3
            for (int i = 4; i <= n; i++) {
                dp[i][1] = dp[i-1][1];
                dp[i][2] = dp[i-2][1] + dp[i-2][2];
                dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
            }
            System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
        }

    }
}