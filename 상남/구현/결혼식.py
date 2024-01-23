from collections import deque
n = int(input())
m = int(input())
data = [[] for _ in range(n+1)]
visited = [0 for _ in range(n+1)]
for i in range(m):
    a,b = map(int, input().split())
    data[a].append(b)
    data[b].append(a)

def bfs(v):
    q = deque()
    visited[v] = 1
    q.append(v)

    while q:
        tmp = q.popleft()

        for i in data[tmp]:
            if visited[i] == 0:
                visited[i] = visited[tmp] + 1
                q.append(i)


bfs(1)


cnt = 0
for i in visited:
    if i>= 2 and i<= 3:
        cnt += 1
print(cnt)
