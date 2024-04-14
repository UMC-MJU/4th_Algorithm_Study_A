from collections import deque
n,m = map(int,input().split())
graph = [[] for _ in range(n+1)]
inde = [0] *(n+1)
for i in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    inde[b] += 1

print(inde)
q = deque()
for i in range(1,n+1):
    if inde[i] == 0:
        q.append(i)
rst = []
while q:
    tmp = q.popleft()
    rst.append(tmp)

    for i in graph[tmp]:
        inde[i] -= 1
        if inde[i] == 0:
            q.append(i)
print(rst)