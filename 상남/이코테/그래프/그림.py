from collections import deque
n,m = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(n)]

dx = [1,-1,0,0]
dy = [0,0,-1,1]


rst = 0
q = deque()

def bfs(tx,ty):
    global rst
    cnt = 1
    q.append((tx,ty))
    while q:
        x,y = q.popleft()
        data[x][y] = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue

            if data[nx][ny] == 1:
                cnt += 1
                data[nx][ny] = 0
                q.append((nx,ny))
    if cnt > rst:
        rst = cnt

areac = 0
for i in range(n):
    for j in range(m):
        if data[i][j] == 1:
            areac += 1
            bfs(i,j)
print(areac,rst)