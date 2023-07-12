from collections import deque
cn = int(input())
n = int(input())

graph = [[] for i in range(cn+1)]
for _ in range(n):
    a,b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [0] * (cn+1)
q = deque()
q.append(1)
cnt = 0
while q:
    t = q.popleft()
    visited[t] += 1
    for i in graph[t]:
        if visited[i] == 0:
            visited[i] += 1
            cnt += 1
            q.append(i)
print(cnt)

#이코드도 가능
# your code goes here
from collections import deque
computer = int(input())
n = int(input())
data = [list(map(int,input().split())) for _ in range(n)]
graph = [ [] for _ in range(computer+1)]
for a,b in data:
    graph[a].append(b)
    graph[b].append(a)
 
q = deque()
q.append(graph[1])
hs = []
 
while q:
    tmp = q.popleft()
 
    for i in tmp:
        if i in hs:
            continue
        else:
            hs.append(i)
            q.append(graph[i])
print(hs)
print(len(hs)-1)
