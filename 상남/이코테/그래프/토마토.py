from collections import deque
m,n = map(int, input().split())
data = [list(map(int,input().split())) for _ in range(n)]
dx = [0,0,-1,1] # 상하좌우
dy = [-1,1,0,0]
q = deque()

for i in range(n):
    for j in range(m):
        if data[i][j] == 1: # 1인곳 q에 넣어줌
            q.append((i,j))
t = []
while q:

    x,y = q.popleft()
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx >= n or nx < 0 or ny >= m or ny < 0: # 범위확인
            continue

        if data[nx][ny] == -1:  # 토마토 없는 곳 확인
            continue

        if data[nx][ny] == 1: # 이미 방문한 곳 확인  
            continue

        if data[nx][ny] == 0:
            data[nx][ny] = data[x][y] + 1 # 이 식이 핵심인데 안떠올라서 답을 봤습니다;; 답을 보고나니깐 왜 이생각을 못했는지 후회가 되네요
            q.append((nx,ny))
tmp = 0
for i in data:
    tmp = max(max(i),tmp) # 한 행에서의 최댓값과 tmp값을 비교하여 최댓값을 구한다.
    for j in i:
        if j == 0:
            print(-1)
            exit()
print(tmp-1)

# 사실 이 두 코드는 0일때만 방문하면 되므로 없어도 되는 코드이다.    
# if data[nx][ny] == -1:  # 토마토 없는 곳 확인
#     continue

# if data[nx][ny] == 1: # 이미 방문한 곳 확인  
#     continue