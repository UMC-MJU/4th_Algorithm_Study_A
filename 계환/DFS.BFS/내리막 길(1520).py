# 내리막 길 https://www.acmicpc.net/problem/1520

import sys

input = sys.stdin.readline

# 지도의 세로 크기 M, 가로 크기 N
M, N = map(int, input().split())
# 지도의 높이 정보 입력 받기
graph = [list(map(int, input().split())) for _ in range(M)]
# dp를 이용하기 위한 테이블
dp = [[-1] * N for _ in range(M)]
# 상하좌우 이동용
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def dfs(x, y):
    # 도착 지점에 도달하면 1 반환
    if x == M - 1 and y == N - 1:
        return 1
    # 이미 방문한 적이 있다면 또 계산하지 않고 저장되어있는 길의 개수 리턴
    if dp[x][y] != -1:
        return dp[x][y]

    ways = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < M and 0 <= ny < N and graph[nx][ny] < graph[x][y]:
            ways += dfs(nx, ny)

    dp[x][y] = ways
    return dp[x][y]


print(dfs(0, 0))
