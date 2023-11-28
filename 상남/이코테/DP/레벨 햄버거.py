import sys
input = sys.stdin.readline
n,x = map(int,input().split())

# dp = [""]*(n+1)
# dp[1] = "P"
# dp[2] = "B"+dp[1]+"P"+dp[1]+"B"
# for i in range(3,n+1):
#     dp[i] = "B"+dp[i-1]+"P"+dp[i-1]+"B"
# print(dp)

# 이상한 오류뜸 실행도 엄청오래길림
#================================================================
dp = [0]*(n+1)
dp[1] = 1
dp[2] = 2+dp[1]+1+dp[1]+2
for i in range(3,n+1):
    dp[i] = 2+dp[1]+1+dp[1]+2
print(dp)

# ================================================================