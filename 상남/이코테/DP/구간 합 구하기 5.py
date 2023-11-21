# 시간초과 코드

# import sys
# input = sys.stdin.readline
# n,m = map(int, input().split())
# data = [list(map(int,input().split())) for _ in range(n)]
# ran = [list(map(int,input().split())) for _ in range(m)]
# for x1,y1,x2,y2 in ran:
#     total = 0
#     for i in range(x1-1,x2):
#         for j in range(y1-1,y2):
#             total += data[i][j]
#     print(total)

import sys

input = sys.stdin.readline

n, m = map(int, input().split())

arr = []
for i in range(n):
    a = list(map(int, input().split()))
    arr.append(a)

dp = [[0] * (n + 1) for i in range(n + 1)]

for i in range(1, n + 1):
    for j in range(1, n + 1):
        dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + arr[i - 1][j - 1]

for k in range(m):
    x1, y1, x2, y2 = map(int, input().split())

    result = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]
    print(result)

# 배낌 모르겠어용 ㅠ