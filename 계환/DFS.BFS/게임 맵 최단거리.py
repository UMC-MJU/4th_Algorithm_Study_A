from collections import deque

def bfs(maps, x, y):
    queue = deque()
    queue.append((x, y))

    #상,하,좌,우 네 가지 방향 정의
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    #지도의 세로, 가로 길이 구하기
    row = len(maps)
    column = len(maps[0])

    #큐가 빌 때까지 반복
    while queue:
        #현재 위치 x, y
        x, y = queue.popleft()
        #현재 위치로부터 상,하,좌,우 네 가지 방향
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            #지도 밖으로 벗어난 경우
            if nx < 0 or nx >= row or ny < 0 or ny >= column:
                continue
            #벽에 가로막힌 경우
            if maps[nx][ny] == 0:
                continue
            #최초 방문 시에만 최단거리 기록, 1이면 최초 방문임.
            if maps[nx][ny] == 1:
                maps[nx][ny] = maps[x][y] + 1
                queue.append((nx,ny))

    # 상대팀 진영에 도달할 방법이 없는 경우는 -1을 return
    if maps[row-1][column-1] == 1:
        return -1
    return maps[row-1][column-1]

def solution(maps):
    return bfs(maps, 0, 0)
