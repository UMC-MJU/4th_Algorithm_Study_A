# 연구소 https://www.acmicpc.net/problem/14502

from collections import deque
import sys
input = sys.stdin.readline
# 연구소의 크기 N x M ; N = 세로, M = 가로
N, M = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]

# 상,하,좌,우 방향 정보
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 세울 수 있는 벽은 3개. 많이 퍼질 수 있는 바이러스를 우선적으로 막아야한다.
# 벽 세우기 전에 바이러스 파워 파악하기 (BFS, 인접한 곳 상하좌우 확산)
