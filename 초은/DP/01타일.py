# https://www.acmicpc.net/problem/1904

import sys
input = sys.stdin.readline

n = int(input())
dp = [0] * 1000001
dp[1] = 1   # 1
dp[2] = 2   # 00, 11
# dp[3]일 때는 001, 111, 100
# dp[4]일 때는 0000, 0011, 1001, 1100, 1111
for k in range(3, n + 1):
    dp[k] = (dp[k - 1] + dp[k - 2]) % 15746 # 피보나치 수열
print(dp[n])