# 01타일 https://www.acmicpc.net/problem/1904

import sys

input = sys.stdin.readline

N = int(input())

# dp = [0] * (N+1)   // N+1 사이즈로 선언하면 IndexError
dp = [0] * 1000001
dp[1] = 1
dp[2] = 2

for i in range(3, N + 1):
    dp[i] = (dp[i - 1] + dp[i - 2]) % 15746

print(dp[N])

# 시간초과 풀이 (조합)
# answer = 0
# div = N // 2
#
# for i in range(div+1):
#     answer += math.comb(N-i, i)
#
# answer %= 15746
