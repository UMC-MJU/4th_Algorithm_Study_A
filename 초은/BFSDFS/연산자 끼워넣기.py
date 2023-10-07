# https://www.acmicpc.net/problem/14888
import sys

input = sys.stdin.readline

N = int(input())
list = list(map(int, input().split()))
add, sub, mul, div = (map(int, input().split()))
maximum = -1e9
minimum = 1e9

def dfs(count_n, total, add, sub, mul, div):
    global maximum, minimum
    
    # 연산 끝나면 최댓값, 최솟값 저장
    if count_n == N:
        maximum = max(total, maximum)
        minimum = min(total, minimum)
        return
    
    if add > 0: # + 연산자 존재하면 dfs 호출, + 연산자 하나 빼기
        dfs(count_n + 1, total + list[count_n], add - 1, sub, mul, div)
    if sub > 0: # - 연산자 존재하면 dfs 호출, - 연산자 하나 빼기
        dfs(count_n + 1, total - list[count_n], add, sub - 1, mul, div)
    if mul > 0: # x 연산자 존재하면 dfs 호출, x 연산자 하나 빼기
        dfs(count_n + 1, total * list[count_n], add, sub, mul - 1, div)
    if div > 0: # % 연산자 존재하면 dfs 호출, % 연산자 하나 빼기
        dfs(count_n + 1, int(total / list[count_n]), add, sub, mul, div - 1)


dfs(1, list[0], add, sub, mul, div)
print(maximum)
print(minimum)
