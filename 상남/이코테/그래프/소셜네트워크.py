from collections import deque
n,m = map(int, input().split())
data = [[] for _ in range(n+1)]
for i in range(m):
    a,b = map(int, input().split())
    data[a].append(b)
    data[b].append(a)
visited = [0] * (n+1)
print(data)
q = deque()
q.append(1)
# visited[1] = 1
while q:
    tmp = q.popleft()

    for i in data[tmp]:
        if visited[i] == 0:
            visited[i] = visited[tmp] + 1
            q.append(i)
print(visited)