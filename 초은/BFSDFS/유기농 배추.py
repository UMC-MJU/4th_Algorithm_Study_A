# https://www.acmicpc.net/problem/1012

import sys
# 파이썬에서 재귀를 사용해 문제를 풀 때 필수로 넣어줘야 함(기본 재귀 깊이 제한은 1000으로 매우 얕은 편)
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
MAX = 50 + 10   # 이동 시 영역 확인하지 않기 위해 50보다 넉넉하게 설정

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def dfs(y, x):
    global visited
    visited[y][x] = True        # visited 배열에 해당 배추에 방문한 적이 있음 표시
    for dIdx in range(4):       # 상, 하, 좌, 우 모두 확인
        newY = y + dx[dIdx]     # 임시 변수에 이동한 값 저장
        newX = x + dy[dIdx]
        if graph[newY][newX] and not visited[newY][newX]:   # 배추가 존재하고, 방문한 적이 없을 때
            dfs(newY, newX) # 깊이 우선 탐색으로 재귀 호출

T = int(input())    # 테스트 횟수 입력받고 그만큼 반복
for _ in range(T):
    M, N, K = map(int, input().split())             # 배추밭 가로, 세로 길이와 배추 갯수 저장
    graph = [[False] * MAX for _ in range(MAX)]     # MxM 크기의 배추 존재 확인 False 배열 생성
    visited = [[False] * MAX for _ in range(MAX)]   # MxM 크기의 방문한 배추 확인 False 배열 생성

    # 배추 수만큼 반복하며 graph 배열에 배추 위치 저장
    for _ in range(K):  
        x, y = map(int, input().split())
        graph[y + 1][x + 1] = True

    answer = 0
    # 0부터가 아니라 1부터 저장하는 이유는 x나 y가 0일 때 -1로 범위를 벗어나는 경우 방지 목적
    for i in range(1, N + 1):   # 가로 길이만큼 반복(y)
        for j in range(1, M + 1):   # 세로 길이만큼 반복(x)
            if graph[i][j] and not visited[i][j]:   # 배추가 존재하고 방문한 적이 없을 때 dfs함수 호출
                dfs(i, j)
                answer += 1     # 벌레 1개 추가

    print(answer)