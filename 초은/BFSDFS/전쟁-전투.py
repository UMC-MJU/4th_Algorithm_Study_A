# https://www.acmicpc.net/problem/1303

import sys
# 파이썬에서 재귀를 사용해 문제를 풀 때 필수로 넣어줘야 함(기본 재귀 깊이 제한은 1000으로 매우 얕은 편)
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
M, N = map(int, input().split())    # 가로, 세로 길이
MAX = 100 + 10   # 이동 시 영역 확인하지 않기 위해 100보다 넉넉하게 설정

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def dfs(y, x, team):
    global visited
    global count
    visited[y][x] = True        # visited 배열에 해당 노드에 방문한 적이 있음 표시
    count += 1
    for dIdx in range(4):       # 상, 하, 좌, 우 모두 확인
        newY = y + dx[dIdx]     # 임시 변수에 이동한 값 저장
        newX = x + dy[dIdx]
        if graph[newY][newX] == team and not visited[newY][newX]:   # 해당 팀의 병사이고, 방문한 적이 없을 때
            dfs(newY, newX, team) # 깊이 우선 탐색으로 재귀 호출


graph = [[0] * MAX for _ in range(MAX)]     # MAX x MAX 크기의 0으로 이루어진 병사 저장 배열 생성
visited = [[False] * MAX for _ in range(MAX)]   #  MAX x MAX 크기의 방문한 위치 확인 False 배열 생성

# 세로 길이만큼 반복하며 graph 배열에 병사 저장
for n in range(1, N+1):
    str = list(input())
    for m in range(1, M+1):
        if str[m-1] == 'W':     # 우리팀 white
            graph[n][m] = 1
        else:                   # 반대팀 blue
            graph[n][m] = 2


for team in range(1, 3):    # 우리팀, 반대팀 순서로 계산
    answer = 0
    # 0부터가 아니라 1부터 저장하는 이유는 x나 y가 0일 때 -1로 범위를 벗어나는 경우 방지 목적
    for i in range(1, N + 1):   # 가로 길이만큼 반복(y)
        for j in range(1, M + 1):   # 세로 길이만큼 반복(x)
            if graph[i][j] == team and not visited[i][j]:   # 해당 팀의 병사이고 방문한 적이 없을 때 dfs함수 호출
                count = 0               # 뭉쳐있는 병사 수 초기화
                dfs(i, j, team)
                answer += (count**2)     # 병사 수의 제곱만큼 계산해서 더하기

    print(answer)