from collections import deque
import sys
n,m = map(int, input().split())

data = [[] for _ in range(n+1)]

for i in range(m):
    a,b = map(int, input().split())
    data[a].append(b)
    data[b].append(a)

visited = [0] * (n+1)
def bfs(v):
    q = deque()
    q.append(v)

    while q:
        tmp = q.popleft()

        for i in data[tmp]:
            if visited[i] == 0:
                visited[i] = visited[tmp] + 1
                q.append(i)
bfs(1)



rst1 = 0 # 숨어야 하는 헛간 번호
rst2 = 0 # 헛간까지의 거리
for i in range(2,n+1):
    if rst2 < visited[i]:
        rst1 = i
        rst2 = visited[i]

rst3 = 0 # 헛간과 같은 거리
for i in range(2,n+1):
    if visited[i] == rst2:
        rst3 += 1



print(rst1,rst2,rst3)