# https://www.acmicpc.net/problem/4963
import sys
sys.setrecursionlimit(10**7)    # 재귀 한도

input = sys.stdin.readline
# 이동할 네가지 방향 정의(상,하,좌,우)
dx = [-1, -1, -1, 0, 1, 0, 1, 1]
dy = [-1, 0, 1, 1, 1, -1, 0, -1]

#DFS 사용
def dfs(y, x):

    visited[y][x] = True        # visited 배열에 해당 위치에 방문한 적이 있음 표시
    for dIdx in range(8):       # 상, 하, 좌, 우 모두 확인
        newY = y + dx[dIdx]     # 임시 변수에 이동한 값 저장
        newX = x + dy[dIdx]
        if 0 <= newX < W and 0 <= newY < H:
            if myMap[newY][newX] and not visited[newY][newX]:   # 섬이 존재하고, 방문한 적이 없을 때
                dfs(newY, newX) # 깊이 우선 탐색으로 재귀 호출

while 1:
    W, H = map(int, input().split())
    if W == 0 and H == 0:
        break;
    myMap = [list(map(int, input().split())) for _ in range(H)]

    answer = 0
    visited = [[False] * W for _ in range(H)]  # MxM 크기의 방문한 배추 확인 False 배열 생성
    # 0부터가 아니라 1부터 저장하는 이유는 x나 y가 0일 때 -1로 범위를 벗어나는 경우 방지 목적
    for i in range(H):  # 가로 길이만큼 반복(y)
        for j in range(W):  # 세로 길이만큼 반복(x)
            if myMap[i][j] and not visited[i][j]:
                dfs(i, j)
                answer += 1  # 섬 개수 증가

    print(answer)
