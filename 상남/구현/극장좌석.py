n = int(input())
m = int(input())
data = [int(input()) for _ in range(m)]

dp = [0]*41
dp[0] = 1
dp[1] = 1
dp[2] = 2
dp[3] = 3
for i in range(4,n+1):
    dp[i] = dp[i-1] + dp[i-2]

tmp = 0
answer = 1
# for i in range(1,n+1):
#     if i in data:
#        dp[i] = dp[i-1]
#        tmp = dp[i]
#        cnt = 0
#     elif cnt >= 2:
#         dp[i] = dp[i-1] * tmp
#         cnt += 1
#
if m > 0:
    for i in range(m):
        answer *= dp[data[i]-1-tmp]
        tmp = data[i]
    answer *= dp[n-data[-1]]
else:
    answer = dp[n]
print(answer)