import sys
from collections import deque
input = sys.stdin.readline
n,m = map(int, input().split())

data = [list(map(int, input().split())) for _ in range(n)]

dx = [0,0,-1,1] # 상하좌우
dy = [-1,1,0,0]

tmp = [[0]*m for _ in range(n)] # 복사를 하기위한 리스트
rst = []
def bfs():
    q = deque()
    for i in range(n):
        for j in range(m):
            if tmp[i][j] == 2:  # 바이러스가 있는 좌표를 큐에 넣어준다.
                q.append((i,j))

    while q:
        x,y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx >= n or nx < 0 or ny >= m or ny < 0: # 좌표 이탈
                continue
            if tmp[nx][ny] == 0: # 안전하면
                tmp[nx][ny] = 2 # 바이러스 침투
                q.append((nx,ny))

    num = 0
    for i in range(n):
        for j in range(m):
            if tmp[i][j] == 0: # 안전지대값을 탐색한다.
                num += 1
    rst.append(num) #rst에 값을 넣는다
    
        

#벽설치
def wall(cnt):
    if cnt == 3: # 벽이 3개 설치되었을 때
        for i in range(n):
            for j in range(m):
                tmp[i][j] = data[i][j] # data의 값을 복사해준다
        bfs()
        return
    for i in range(n):
        for j in range(m):
            if data[i][j] == 0:
                data[i][j] = 1
                wall(cnt+1)
                data[i][j] = 0 # 백트래킹, 다시 벽을 허문다.
wall(0)

print(max(rst)) # rst값중 가장 큰값