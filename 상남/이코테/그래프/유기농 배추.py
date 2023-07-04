from collections import deque
t = int(input())


for i in range(t):
    m,n,k = map(int, input().split())
    data = [list(map(int,input().split())) for _ in range(k)]
    mp = [[0] * m for _ in range(n)]
    for i,j in data:    # 배추 있는 곳 표시하기
        mp[j][i] = 1
    cnt = 0

    dx = [0,0,-1,1] # 상하좌우
    dy = [-1,1,0,0]
    q = deque()

    for l in range(n):
        for t in range(m):

            if mp[l][t] == 1:
                q.append([l,t])
                while q:
                    tx,ty = q.popleft()
                    mp[tx][ty] = 0
                    for i in range(4):
                        nx = tx + dx[i]
                        ny = ty + dy[i]

                        if nx < 0 or nx >= n or ny < 0 or ny >= m :
                            continue
                        if mp[nx][ny] == 1:
                            mp[nx][ny] = 0  # 방문처리하기
                            q.append([nx,ny])
                cnt += 1
    print(cnt)