# 토마토 https://www.acmicpc.net/problem/7576

import sys
from collections import deque
input = sys.stdin.readline

# 상자의 가로 M, 세로 N
M, N = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs():
    queue = deque()
    global days

    # 익은 토마토 좌표를 큐에 넣어준다.
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1:
                queue.append((i, j))

    while queue:
        a, b = queue.popleft()

        for i in range(4):
            nx = a + dx[i]
            ny = b + dy[i]

            if 0 <= nx < N and 0 <= ny < M:
                # 아직 익지 않았다면 +1 해서 저장 -> 정답 도출에 활용
                if graph[nx][ny] == 0:
                    graph[nx][ny] = graph[a][b] + 1
                    queue.append((nx, ny))

    for line in graph:
        for data in line:
            # 익지 않은 토마토가 있다면 -1 반환
            if data == 0:
                return -1
        # graph 값 중 가장 큰 값이 토마토가 익는데 걸리는 최소 날짜이다.
        days = max(days, max(line))
    # 처음을 1부터 시작했기 때문에 -1 해서 반환한다.
    return days - 1

days = 0
print(bfs())