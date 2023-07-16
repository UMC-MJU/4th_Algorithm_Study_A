# https://www.acmicpc.net/problem/10026
# 일반인/적록색약이 보는 구역의 수 구하기 - 따로
# 일반인 = R / G / B
# 적록색약 = R=G / B

from collections import deque
import copy

N = int(input())  # 그리드 칸 개수


def transfrom(x):  # 적록색약 용 리스트로 바꿔주는 메소드
    for i in range(N):
        if x[i] == 'G':
            x[i] = 'R'
    return x


graphA = [list(input()) for _ in range(N)]  # 일반인 용 색상 정보
temp = copy.deepcopy(graphA)  # 깊은 복사를 위한 임시 리스트
graphB = list(map(transfrom, temp))  # 적록색약 용 색상 정보

# 상하좌우 좌표 이동 정보
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 방문 정보 2차원 배열
visited = [[False] * N for _ in range(N)]

answer = []  # 답을 저장할 리스트


# 큐 구현
def bfs(x, y, mode):
    # mode: 0 = 일반인 / 1 = 적록색약
    global count
    queue = deque([(x, y)])
    visited[x][y] = True  # 방문 처리

    # 모드에 따라서 색상 리스트를 갈아 끼워준다.
    comp = [[]]
    if mode == 0: comp = graphA
    if mode == 1: comp = graphB

    while queue:
        a, b = queue.popleft()

        for i in range(4):
            nx = a + dx[i]
            ny = b + dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= N:  # 그래프 밖으로 나가는 경우 제외
                continue

            if not visited[nx][ny] and comp[a][b] == comp[nx][ny]:  # 방문하지 않았고 인접한 경우
                queue.append((nx, ny))
                visited[nx][ny] = True  # 방문 처리
    count += 1  # 구역 카운트+1


for mode in range(2):  # 모드에 따라서 두 번 실행해준다.
    count = 0
    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                bfs(i, j, mode)

    visited = [[False] * N for _ in range(N)]  # 방문 정보 초기화
    answer.append(count)

for i in range(2):
    print(answer[i])
