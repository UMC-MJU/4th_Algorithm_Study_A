from collections import deque
w,h = map(int, input().split())
dx = [1,-1,0,0,-1,-1,1,1] # 대각선 + 상하좌우
dy = [0,0,1,-1,1,-1,1,-1]

def bfs(i,j):   # bfs 진행
    q = deque()
    q.append((i,j))
    visited[i][j] = True
    while q:
        x,y = q.popleft()

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= h or ny < 0 or ny >= w:
                continue

            if data[nx][ny] == 1 and visited[nx][ny] == False:
                visited[nx][ny] = True
                q.append((nx,ny))

while w != 0 and h != 0:
    data = [list(map(int, input().split())) for _ in range(h)]
    visited = [[False]*w for _ in range(h)]
    cnt = 0
    for i in range(h):
        for j in range(w):
            if data[i][j] == 1 and visited[i][j] == False: # 1이면서 방문을 안했으면
                bfs(i,j)
                cnt += 1
    print(cnt)
    w,h = map(int, input().split())
