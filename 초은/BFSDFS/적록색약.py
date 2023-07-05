# https://www.acmicpc.net/problem/10026

import sys
# 파이썬에서 재귀를 사용해 문제를 풀 때 필수로 넣어줘야 함(기본 재귀 깊이 제한은 1000으로 매우 얕은 편)
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
N = int(input())
MAX = N + 10   # 이동 시 영역 확인하지 않기 위해 N보다 넉넉하게 설정

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def dfs(y, x, color):
    global visited
    visited[y][x] = True        # visited 배열에 해당 노드에 방문한 적이 있음 표시
    for dIdx in range(4):       # 상, 하, 좌, 우 모두 확인
        newY = y + dx[dIdx]     # 임시 변수에 이동한 값 저장
        newX = x + dy[dIdx]
        if graph[newY][newX] == color and not visited[newY][newX]:   # 해당 색깔이고, 방문한 적이 없을 때
            dfs(newY, newX, color) # 깊이 우선 탐색으로 재귀 호출


graph = [[0] * MAX for _ in range(MAX)]     # MAX x MAX 크기의 0으로 이루어진 3색 저장 배열 생성
visited = [[False] * MAX for _ in range(MAX)]   #  MAX x MAX 크기의 방문한 위치 확인 False 배열 생성

# 길이만큼 반복하며 graph 배열에 색 저장
for n in range(1, N+1):
    str = list(input())
    for m in range(1, N+1):
        if str[m-1] == 'R':         # 빨강 Red는 1
            graph[n][m] = 1
        elif str[m-1] == 'B':    # 파랑 Blue는 2
            graph[n][m] = 2
        else:                       # 초록 Green은 3
            graph[n][m] = 3

# 1. 정상인 계산
answer = 0  # 구역 수 초기화
for color in range(1, 4):
    # 0부터가 아니라 1부터 저장하는 이유는 x나 y가 0일 때 -1로 범위를 벗어나는 경우 방지 목적
    for i in range(1, N + 1):   # 가로 길이만큼 반복(y)
        for j in range(1, N + 1):   # 세로 길이만큼 반복(x)
            if graph[i][j] == color and not visited[i][j]:   # 해당 색깔이고 방문한 적이 없을 때 dfs함수 호출
                dfs(i, j, color)
                answer += 1     # 발견한 구역만큼 1 더하기

print(answer)   # 구역 수 출력

# 2. 적록색약인 사람을 위해 빨간색과 초록색 합치기
for n in range(1, N+1):
    for m in range(1, N+1):
        if graph[n][m] == 3:
            graph[n][m] = 1
visited = [[False] * MAX for _ in range(MAX)]   # 방문했던 노드 모두 초기화

# 3. 적록색약인 사람 계산
answer = 0  # 구역 수 초기화
for color in range(1, 3):   # 색 한가지를 뺏으므로 1~2만 반복
    # 0부터가 아니라 1부터 저장하는 이유는 x나 y가 0일 때 -1로 범위를 벗어나는 경우 방지 목적
    for i in range(1, N + 1):   # 가로 길이만큼 반복(y)
        for j in range(1, N + 1):   # 세로 길이만큼 반복(x)
            if (graph[i][j] == color) and not visited[i][j]:   #해당 색깔이고 방문한 적이 없을 때 dfs함수 호출
                dfs(i, j, color)
                answer += 1     # 발견한 구역만큼 1 더하기

print(answer)   # 구역 수 출력