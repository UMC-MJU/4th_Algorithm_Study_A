from collections import deque

n,m = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(n)]
dx = [0,0,-1,1,-1,-1,1,1] #상,하,좌,우,왼쪽위,왼쪽아래,오른쪽위,오른쪽아래
dy = [-1,1,0,0,-1,1,-1,1]
q = deque()
for i in range(n):
    for j in range(m):
        if data[i][j] == 1:
            q.append([i,j])

while q:
    x,y = q.popleft()

    for i in range(8):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx < 0 or nx >= n or ny < 0 or ny >= m:
            continue

        if data[nx][ny] == 0:
            data[nx][ny] = data[x][y] + 1
            q.append((nx,ny))

tmp = 0
for i in data:
    tmp = max(max(i),tmp)
print(tmp-1)
