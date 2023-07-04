from collections import deque
n,m = map(int,input().split())
data = [input() for _ in range(m)]
tmp = [[0]*n for _ in range(m)]

dx = [0,0,-1,1]
dy = [-1,1,0,0]


q = deque()
answer = 0

rst = []
for i in range(m):
    for j in range(n):
        if data[i][j] == "W":
            cnt = 1
            if tmp[i][j] == 1:
                continue
            else:
                q.append([i,j])
                while q:
                    x,y = q.popleft()
                    tmp[i][j] = 1 # 방문처리
                    
                    for t in range(4):
                        nx = x + dx[t]
                        ny = y + dy[t]

                        if nx < 0 or nx >= m or ny < 0 or ny >= n:
                            continue
                        
                        if data[nx][ny] == "B":
                            continue

                        if tmp[nx][ny] == 1:
                            continue

                        tmp[nx][ny] = 1 # 방문처리
                        q.append([nx,ny])
                        cnt += 1
                answer += cnt*cnt
rst.append(answer)

answer = 0                
tmp = [[0]*n for _ in range(m)]

for i in range(m):
    for j in range(n):
        if data[i][j] == "B":
            cnt = 1
            if tmp[i][j] == 1:
                continue
            else:
                q.append([i,j])
                while q:
                    x,y = q.popleft()
                    tmp[i][j] = 1 # 방문처리
                    
                    for t in range(4):
                        nx = x + dx[t]
                        ny = y + dy[t]

                        if nx < 0 or nx >= m or ny < 0 or ny >= n:
                            continue
                        if data[nx][ny] == "W":
                            continue

                        if tmp[nx][ny] == 1:
                            continue

                        tmp[nx][ny] = 1 # 방문처리
                        q.append([nx,ny])
                        cnt += 1
                answer += cnt*cnt
rst.append(answer)

for i in rst:
    print(i, end = " ")