from collections import deque
n,m = map(int, input().split())
r,c,d = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(n)]
visited = [[0 for _ in range(m)] for _ in range(n)]
# 0 북, 1 동, 2 남, 3 서
dx = [-1,0,1,0]
dy = [0,1,0,-1]


q = deque()
q.append((r,c))
data[r][c] = 1
cnt = 1

while q:
    isclean = True
    x,y = q.popleft()
    # cnt += 1


    for _ in range(4):
        d = (d+3)%4
        nx = x + dx[d]
        ny = y + dy[d]

        if 0 <= nx < n and 0 <= ny < m and data[nx][ny] == 0:
            # if not visited[nx][ny]:
            data[nx][ny] = 1
            q.append((nx,ny))
            isclean = False
            cnt += 1
            break

    if isclean == True:
        if data[x-dx[d]][y-dy[d]] != 1:
            q.append((x-dx[d],y-dy[d]))
        else:
            print(cnt)
            break

