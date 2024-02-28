import java.util.Scanner;

public class Zoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n + 1][3];             //3으로 한 이유는 가로 한 줄에 아무 사자도 넣지 않는 경우도 생각을 했을때, 3가지이다.

        for (int i = 0; i < 3; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i][0] = ((dp[i - 1][0] + dp[i - 1][1]) % 9901 + dp[i - 1][2]) % 9901;        //전 칸에는 사자가 아무것도 안들어갔으니 전에 있던 모든 경우의 수를 다 더하기
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;                                //문제 조건에 맞게 전 칸에 사자가 있으면 연속으로 있을 수가 없다.
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }
        System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % 9901);
    }
}


