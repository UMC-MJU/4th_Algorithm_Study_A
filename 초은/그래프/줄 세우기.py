# https://www.acmicpc.net/problem/2252

import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]
inDegree = [0] * (N + 1)

# 데이터 저장
for _ in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)
    inDegree[B] += 1

q = deque()

# 진입차수가 0이라면 인접노드를 큐에 넣기
for s in range(1, N + 1):
    if inDegree[s] == 0:
        q.append(s)

ans = []

while q:
    s = q.popleft()
    ans.append(s)

    for adj_s in graph[s]:
        inDegree[adj_s] -= 1
        if inDegree[adj_s] == 0:
            q.append(adj_s)

print(*ans, sep=" ")
