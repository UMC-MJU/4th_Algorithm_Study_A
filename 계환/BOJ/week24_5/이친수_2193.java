package BOJ.week24_5;

import java.io.*;
import java.util.*;

public class 이친수_2193 {
    public static void main(String[] args) throws IOException{
        int N;
        long[] dp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1];
        dp[1] = 1;
        if (N >= 2) {
            dp[2] = 1;
            for (int i = 3; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        System.out.println(dp[N]);
    }
}
