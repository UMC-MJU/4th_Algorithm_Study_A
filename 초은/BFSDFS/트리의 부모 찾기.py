# https://www.acmicpc.net/problem/11725
import sys
sys.setrecursionlimit(15000)


def dfs(node):
    for n in graph[node]:
        if parent[n] == 0:
            parent[n] = node
            dfs(n)


N = int(input())
graph = [[] for _ in range(N + 1)]
for _ in range(N - 1):
    u, v = map(int, sys.stdin.readline().split())
    # 양방향 그래프
    graph[u].append(v)
    graph[v].append(u)
parent = [0] * (N + 1)

dfs(1)
print(*parent[2:N + 1], sep='\n')
