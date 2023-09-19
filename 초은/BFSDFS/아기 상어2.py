# https://www.acmicpc.net/problem/17086

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
shark = []

for i in range(N):
    for t in range(M):
        if arr[i][t] == 1:
            shark.append((i, t))

# 대각선까지 총 8방향
mx = [-1, -1, -1, 0, 1, 0, 1, 1]
my = [-1, 0, 1, 1, 1, -1, 0, -1]

while shark:
    x, y = shark.pop(0)
    # 8방향 모두 실행
    for k in range(8):
        dx = x + mx[k]
        dy = y + my[k]
        # 범위에 포함될 때
        if 0 <= dx < N and 0 <= dy < M:
            # 상어가 아니고, 조회한 적 없을 때
            if arr[dx][dy] == 0:
                shark.append((dx, dy))
                arr[dx][dy] = arr[x][y] + 1

safe_dist = 0
# 2차 배열 중 가장 큰 값 저장
for i in range(N):
    for j in range(M):
        safe_dist = max(safe_dist, arr[i][j])

print(safe_dist - 1)