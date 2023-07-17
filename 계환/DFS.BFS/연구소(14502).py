# 연구소 https://www.acmicpc.net/problem/14502

from collections import deque
import copy
import sys
input = sys.stdin.readline
# 연구소의 크기 N x M ; N = 세로, M = 가로
N, M = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]

# 상,하,좌,우 방향 정보  좌, 우, 상, 하
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 벽 3개를 세울 수 있는 모든 경우의 수 체크 후 바이러스 퍼뜨리고 안전영역 크기 재기

def bfs():
    queue = deque()
    test_graph = copy.deepcopy(graph)

    for i in range(N):
        for j in range(M):
            if test_graph[i][j] == 2:  # 바이러스 큐 넣기
                queue.append((i,j))

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if (0 <= nx < N) and (0 <= ny < M):
                # 바이러스 퍼뜨리기
                if test_graph[nx][ny] == 0:
                    test_graph[nx][ny] = 2
                    queue.append((nx,ny))
    safezone_count = 0
    # 바이러스가 퍼진 후 안전영역 크기 재기

    for row in test_graph:
        safezone_count += row.count(0)
    global answer
    answer = max(answer, safezone_count)

def make_wall(count):
    if count == 3:
        bfs()
        return
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 0:
                graph[i][j] = 1
                make_wall(count+1)
                graph[i][j] = 0  # 백트래킹

answer = 0
make_wall(0)
print(answer)