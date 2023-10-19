n = int(input())
data = list(map(int,input().split()))

dp = [0] * 100001
dp[0] = data[0]
dp[1] = max(data[0],data[0]+data[1],data[1])

for i in range(2,n):
    dp[i] = max(data[i], dp[i-1]+data[i])
print((dp[:n]))



#
# # 10
# # 10 -4 3 1 5 6 -35 12 21 -1
#
#
# # dp[0] = data[0]
# # dp[1] = max(data[0]+data[1],dp[0],data[1])
# # dp[2] = max(data[0]+data[1]+data[2],data[0]+data[1],data[1]+data[2],data[0],data[1],data[2])
#
# dp[0] = data[0]
# dp[1] = dp[i-1]
# dp[2] = dp[i-2]