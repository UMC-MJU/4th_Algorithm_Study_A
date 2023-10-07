# https://www.acmicpc.net/problem/2178

#미로 탐색
from collections import deque

#첫번째 문자열에서 행, 열 저장
N, M = map(int, input().split())

graph = []
for i in range(N):
    graph.append(list(map(int, input())))

def bfs(x, y):
    #이동할 네가지 방향 정의(상,하,좌,우)
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    #deque 생성
    queue = deque()
    queue.append((x, y))

    #큐에 하나라도 존재할 때 반복문 실행
    while queue:
        # 선입선출. 가장 먼저 들어온 큐를 pop하고 출력
        x, y = queue.popleft()

        # 4가지 방향으로 위치 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            #범위에서 벗어나면 반복문 건너뛰기
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue

            #지나갈 수 없는 길이므로 반복문 건너뛰기
            if graph[nx][ny] == 0:
                continue

            #지나간 적 없는 길이 존재할 때
            if graph[nx][ny] == 1:
                graph[nx][ny] += graph[x][y]
                queue.append((nx, ny))
    return graph[N-1][M-1]

print(bfs(0, 0))