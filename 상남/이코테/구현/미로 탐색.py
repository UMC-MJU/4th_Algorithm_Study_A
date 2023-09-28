import sys
from collections import deque
input = sys.stdin.readline
n,m = map(int, input().split())
data = [input() for _ in range(n)]

graph = [[] for _ in range(n)]

dx = [-1,1,0,0]
dy = [0,0,1,-1]

cnt = 0
for i in data: # input을 하려고 이렇게 했는데 안해도됨
    for j in i:
        for t in j:
            graph[cnt].append(int(t))
    cnt+=1  

q = deque()
q.append((0,0))

while q:
    x,y = q.popleft()

    if x == n-1 and y == m - 1:
        print(graph[x][y]) # 목표지점이면 출력하고 멈춘다
        break
    
    for i in range(4): #bfs 진행
        nx = x + dx[i]
        ny = y + dy[i]

        if nx<0 or nx>=n or ny<0 or ny>=m:
            continue
        # if graph[nx][ny] == 0:
        #     continue
        if graph[nx][ny] ==1:
            graph[nx][ny] = graph[x][y] + 1 #이전좌표의 값에 +1
            q.append((nx,ny))