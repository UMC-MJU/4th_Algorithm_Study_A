

n = int(input()) #포도잔의 개수
wine = []  # 주어진 와인의 양을 나타내는 배열

for i in range(n):
    wine.append(int(input()))

dp = [0] * n  #

dp[0] = wine[0]

if n > 1:
    dp[1] = wine[0] + wine[1]
if n > 2:
    dp[2] = max(wine[0]+wine[2], wine[1]+wine[2], dp[1])

for i in range(3, n):
    dp[i] = max(wine[i]+wine[i-1]+dp[i-3], wine[i]+dp[i-2], dp[i-1])

# 1. 현재 포도주를 마시고, 이전 포도주를 마시는 경우
# 2. 현재 포도주를 마시고, 이전전 포두주를 마시는 경우
# 3. 현재 포도주를 마시지 않는경우. = 이전전, 이전


print(dp[n-1])