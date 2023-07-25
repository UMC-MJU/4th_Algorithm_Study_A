# 토마토 https://www.acmicpc.net/problem/7576

import sys
import copy
from collections import deque
input = sys.stdin.readline

# 상자의 가로 M, 세로 N
M, N = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
visited = [[False] * M for _ in range(N)]

def bfs():

    queue = deque()
    global days
    test_graph = copy.deepcopy(graph)
    count = 0
    for i in range(N):
        for j in range(M):
            if test_graph[i][j] == 1:
                queue.append((i,j))
            if test_graph[i][j] == 0:
                count += 1

    if count == 0:  # 이미 다 익어있다
        return 0

    while queue:
        a, b = queue.popleft()
        for i in range(4):
            nx = a + dx[i]
            ny = b + dy[i]

            if 0 <= nx < N and 0 <= ny < M:
                if test_graph[nx][ny] == 0:
                    test_graph[nx][ny] = 1
                    queue.append((nx, ny))
        days += 1

    for i in range(N):
        for j in range(M):
            if test_graph[i][j] == 0:  # 다 익지 못한 경우
                return -1

    return days


days = 0
print(bfs())

