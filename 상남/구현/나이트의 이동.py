from collections import deque
t = int(input())
dx = [-2,-1,1,2,2,1,-1,-2]
dy = [1,2,2,1,-1,-2,-2,-1]

for i in range(t):
    l = int(input())
    sx,sy = map(int,input().split())
    ex,ey = map(int,input().split())
    visited = [[0]*l for _ in range(l)]

    q = deque()
    q.append((sx,sy))
    
    while q:
        x,y = q.popleft()

        if x == ex and y == ey:
            print(visited[x][y])
            break

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= l or ny < 0 or ny >= l:
                continue

            if visited[nx][ny] == 0:
                visited[nx][ny] = visited[x][y] + 1
                q.append((nx,ny))