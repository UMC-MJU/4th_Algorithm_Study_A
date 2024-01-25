n = int(input())
data = [int(input()) for _ in range(n)]

dp = [0]*(101)
dp[1] = 1
dp[2] = 1
dp[3] = 1
dp[4] = 2
dp[5] = 2

for i in data:
    for j in range(6,i+1):
        dp[j] = dp[j-1] + dp[j-5]
    print(dp[i])