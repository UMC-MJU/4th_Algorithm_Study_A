# https://www.acmicpc.net/problem/9372
import sys


def dfs(node, cnt):
    visited[node] = True
    for n in graph[node]:
        if not visited[n]:
            cnt = dfs(n, cnt + 1)
    return cnt


for _ in range(int(sys.stdin.readline())):
    N, M = map(int, sys.stdin.readline().split())
    graph = [[] for _ in range(N + 1)]

    for _ in range(M): # 그래프 저장
        u, v = map(int, sys.stdin.readline().split())
        # 양방향 그래프
        graph[u].append(v)
        graph[v].append(u)

    visited = [False] * (N + 1)
    cnt = dfs(1, 0)
    print(cnt)
