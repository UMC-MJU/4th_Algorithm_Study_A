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
print(len(hs)-1)