from collections import deque
n,m = map(int, input().split())

data = [list(map(int, input())) for _ in range(m)]
dx = [1,-1,0,0]
dy = [0,0,1,-1]

q = deque()
q.append((0,0))
visited = [[False]*n for _ in range(m)]
cnt = 0

while q:
    x,y = q.popleft()
    if x == m-1 and y == n-1:
        print("도착")
        break

    check = 0
    tx,ty = 0,0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx< 0 or nx>=m or ny<0 or ny>=n:
            check += 1
        elif data[nx][ny] != 0:
            tx = nx
            ty = ny
            check += 1
        else:
            break

    if check == 4:
        cnt += 1
        print(tx,ty)
        data[tx][ty] = 0

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx < 0 or nx >= m or ny < 0 or ny >= n:
            continue

        if data[nx][ny] == 0:
            # visited[nx][ny] = True
            q.append((nx,ny))


print(cnt)

