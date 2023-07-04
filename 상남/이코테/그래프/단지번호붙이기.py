from collections import deque
n = int(input())

data = [input() for _ in range(n)]

dx = [0,0,-1,1]
dy = [-1,1,0,0]
visited = [[0]*n for _ in range(n)] #방문처리를 위한 변수
cnt = 0 # 단진수를 세는 변수
answer = []
q = deque()
for i in range(n):
    for j in range(n):
        if data[i][j] == "1" and visited[i][j] == 0:
            q.append([i,j])
            tmp = 0 #단지내 집의 수를 세는 변수
            while q:
                x,y = q.popleft()
                visited[x][y] = 1

                for t in range(4): #상하좌우 검색
                    nx = x + dx[t]
                    ny = y + dy[t]

                    if nx < 0 or nx >= n or ny < 0 or ny >= n: #범위
                        continue
                    if data[nx][ny] == "0" or visited[nx][ny] == 1: # 미리방문했거나 집이 없는 경우
                        continue

                    visited[nx][ny] = 1
                    tmp += 1
                    q.append([nx,ny])
            cnt += 1
            answer.append(tmp+1) 

print(cnt)
answer.sort() # 오름차순 정렬
for i in answer: # 출력
    print(i)