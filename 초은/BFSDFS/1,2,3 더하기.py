# https://www.acmicpc.net/problem/9095

T = int(input())

def dfs(n):
    if n in memo:   # 했던 계산이면 pass
        return memo[n]
    else:
        temp = dfs(n - 1) + dfs(n - 2) + dfs(n - 3)     # 피보나치 수열 이용
        memo[n] = temp
        return temp

for _ in range(T):
    n = int(input())
    memo = {1: 1, 2: 2, 3: 4}   # 계산 반복 방지 memo
    print(dfs(n))