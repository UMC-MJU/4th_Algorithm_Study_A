from collections import deque
n = int(input())

data = [list(input()) for _ in range(n)]
tmp = [[0]*n for _ in range(n)]

dx = [0,0,-1,1]
dy = [-1,1,0,0]
q = deque()
cnt = 0
def bfs(i,j):
    q.append([i,j])
    while q:
        tmp[i][j] =1
        x,y = q.popleft()
        for t in range(4):

            nx = x + dx[t]
            ny = y + dy[t]

            if nx < 0 or nx >= n or ny < 0 or ny >= n: #상하좌우 검색
                continue

            if data[nx][ny] != data[x][y]:  # 색깔이 다르면 넘긴다
                continue

            if tmp[nx][ny] == 1:    # 방문한 곳은 넘긴다
                continue

            q.append([nx,ny])
            tmp[nx][ny] = 1

for i in range(n): # 적록색약이 아닌 사람
        for j in range(n):
             if tmp[i][j] == 0:
                cnt += 1
                bfs(i,j)

print(cnt, end = " ")

for i in range(n):  # 적록색약 만들기
    for j in range(n):
        if data[i][j] == "R":
            data[i][j] = "G"
            
cnt = 0 # 적록색약인 사람의 구역을 찾기 위해 초기화
tmp = [[0]*n for _ in range(n)] # 적록색약인 사람의 방문처리를 하기 위해 초기화

for i in range(n):  # 적록색약인 사람
        for j in range(n):
             if tmp[i][j] == 0:
                cnt += 1
                bfs(i,j)
print(cnt, end = " ")