package BOJ.week24_4;

import java.io.*;
import java.util.*;

public class 계단_오르기_2579 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stairCount = Integer.parseInt(br.readLine());
        int[] stairPoints = new int[stairCount + 1];
        int[] dp = new int[stairCount + 1];
        for (int i = 1; i <= stairCount; i++) {
            stairPoints[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stairPoints[1];
        if (stairCount >= 2) {
            dp[2] = stairPoints[1] + stairPoints[2];
        }

        for (int i = 3; i <= stairCount; i++) {
            // 현재 계단을 밟는 경우의 수는 두 가지다.
            // 1. 두 칸 이전 계단을 밟고 현재 계단 밟기
            // 2. 세 칸 이전 계단을 밟고 한 칸 이전 계단을 밟고 현재 계단 밟기
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairPoints[i - 1]) + stairPoints[i];
        }

        System.out.print(dp[stairCount]);
    }
}
