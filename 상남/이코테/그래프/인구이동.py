from collections import deque
n,l,r = map(int,input().split())
data = [list(map(int,input().split())) for _ in range(n)]
dx = [-1,1,0,0]
dy = [0,0,-1,1]
rst = 0
visited = [[False]*(n) for _ in range(n)]
def bfs(a,b):
    global rst
    q = deque()
    q.append((a,b))
    cnt = 1
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx< 0 or nx>=n or ny<0 or ny >= n:
                continue
            if visited[nx][ny] == False:
                if l<=abs(data[x][y]-data[nx][ny]) <= r:
                    cnt += 1
                    visited[nx][ny] = True
                    q.append((nx,ny))
    sum = 0
    check = 0
    for i in visited:
        print(i)

    # 국경선 불가능 한지 검사
    for i in range(n):
        for j in range(n):
            if visited[i][j] == True:
                sum += data[i][j]
            else:
                check += 1
    if check == n*n:
        return 0


    # for i in range(n):
    #     for j in range(n):
    #         if visited[i][j] == True:
    #             sum += data[i][j]
    print("zz",sum,check,cnt)
    totpp = sum//cnt
    print(totpp)
    rst += 1
    for i in range(n):
        for j in range(n):
            if visited[i][j] == True:
                data[i][j] = totpp
    for i in data:
        print(i)
    return 1

while True:
    c = 0
    visited = [[False] * (n) for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if visited[i][j] == False:
                visited[i][j] = True
                c+= bfs(i,j)
    print(c)

    if c == 0:
        break
print(c)

